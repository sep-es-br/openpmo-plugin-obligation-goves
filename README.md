# openpmo-plugin-obligation-goves

Plugin do OpenPMO para consultar Empenhos do GOVES por meio do Pentaho BI.

## Objetivo

Este projeto implementa `IObligationProvider`, definido em `openpmo-plugin-obligation-interface`, e isola autenticação, chamadas ao Pentaho CDA e mapeamento das respostas para os DTOs neutros do OpenPMO.

## Funcionalidades

- listar anos com Empenhos;
- listar unidades gestoras por ano;
- listar Empenhos por unidade gestora;
- consultar os detalhes de um Empenho;
- converter entidades HTML presentes no retorno;
- carregar automaticamente o provider pelo Spring Boot.

## Requisitos

- Java 11 ou superior;
- Spring Boot 2.2.12;
- acesso ao Pentaho BI da SEP;
- JitPack configurado no projeto consumidor.

## Instalação

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.sep-es-br:openpmo-plugin-obligation-interface:1.0.0'
    implementation 'com.github.sep-es-br:openpmo-plugin-obligation-goves:1.0.3'
}
```

## Uso no OpenPMO API

```properties
app.obligation.parser.repository=com.github.sep-es-br:openpmo-plugin-obligation-goves:1.0.3
```

## Configuração

| Propriedade | Padrão | Descrição |
| --- | --- | --- |
| `pentaho-bi.base-url` | `https://bi.sep.es.gov.br` | URL base do Pentaho. |
| `pentaho-bi.user-id` | `PENTAHO_BI_USER_ID` ou `pentahoBI.userId` | Usuário da autenticação Basic. |
| `pentaho-bi.password` | `PENTAHO_BI_PASSWORD` ou `pentahoBI.password` | Senha da autenticação Basic. |
| `pentaho-bi.max-in-memory-size` | `16777216` | Limite, em bytes, das respostas carregadas pelo `WebClient`. |

```powershell
$env:PENTAHO_BI_USER_ID='usuario'
$env:PENTAHO_BI_PASSWORD='senha'
```

Não grave credenciais reais no repositório.

### Consultas configuráveis

| Operação | Path | Data access ID |
| --- | --- | --- |
| Anos | `pentaho-bi.obligation-years-path` | `pentaho-bi.obligation-years-data-access-id` |
| Unidades gestoras | `pentaho-bi.obligation-management-units-path` | `pentaho-bi.obligation-management-units-data-access-id` |
| Processos | `pentaho-bi.obligation-processes-path` | `pentaho-bi.obligation-processes-data-access-id` |
| Detalhe | `pentaho-bi.obligation-detail-path` | `pentaho-bi.obligation-detail-data-access-id` |

Os valores padrão ficam em `obligation-parser.properties`.

## Auto-configuração Spring Boot

`META-INF/spring.factories` registra `ObligationParserAutoConfig`. O Spring Boot carrega as propriedades, executa component scan em `br.gov.es.pmo.obligation_parser` e disponibiliza `PentahoObligationProvider` como bean de `IObligationProvider`.

## Uso pelo contrato

```java
@Service
public class ObligationIntegrationService {

    private final IObligationProvider provider;

    public ObligationIntegrationService(final IObligationProvider provider) {
        this.provider = provider;
    }

    public List<ObligationDto> findAll(
        final Long year,
        final ObligationManagementUnitDto managementUnit
    ) {
        return provider.getObligations(year, managementUnit);
    }
}
```

## Chamadas ao Pentaho CDA

Todas as operações executam `GET /pentaho/plugin/cda/api/doQuery`.

| Operação | Parâmetros adicionais |
| --- | --- |
| Listar anos | nenhum |
| Listar unidades gestoras | `paramp_ano` |
| Listar Empenhos | `paramp_ano`, `paramp_cod_ug` |
| Detalhar Empenho | `paramcod_doc`, `paramcod_ug` |

Na listagem, o número do processo também é utilizado como protocolo. O valor do Empenho permanece como `String`, preservando o formato recebido.

Quando a consulta de detalhe não retorna linhas, o provider retorna `null`. Credenciais ausentes geram `IllegalStateException`; falhas HTTP são propagadas pelo `WebClient`.

## Build local

```powershell
.\gradlew.bat clean build publishToMavenLocal
```

```bash
./gradlew clean build publishToMavenLocal
```

Para testar uma versão ainda não publicada do contrato, publique primeiro `openpmo-plugin-obligation-interface` no Maven local.
