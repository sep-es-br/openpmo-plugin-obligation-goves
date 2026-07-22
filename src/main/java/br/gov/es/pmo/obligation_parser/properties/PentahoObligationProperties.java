package br.gov.es.pmo.obligation_parser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pentaho-bi")
public class PentahoObligationProperties {
    private String baseUrl;
    private String userId;
    private String password;
    private String obligationYearsPath;
    private String obligationYearsDataAccessId;
    private String obligationManagementUnitsPath;
    private String obligationManagementUnitsDataAccessId;
    private String obligationProcessesPath;
    private String obligationProcessesDataAccessId;
    private String obligationDetailPath;
    private String obligationDetailDataAccessId;

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String value) { baseUrl = value; }
    public String getUserId() { return userId; }
    public void setUserId(String value) { userId = value; }
    public String getPassword() { return password; }
    public void setPassword(String value) { password = value; }
    public String getObligationYearsPath() { return obligationYearsPath; }
    public void setObligationYearsPath(String value) { obligationYearsPath = value; }
    public String getObligationYearsDataAccessId() { return obligationYearsDataAccessId; }
    public void setObligationYearsDataAccessId(String value) { obligationYearsDataAccessId = value; }
    public String getObligationManagementUnitsPath() { return obligationManagementUnitsPath; }
    public void setObligationManagementUnitsPath(String value) { obligationManagementUnitsPath = value; }
    public String getObligationManagementUnitsDataAccessId() { return obligationManagementUnitsDataAccessId; }
    public void setObligationManagementUnitsDataAccessId(String value) { obligationManagementUnitsDataAccessId = value; }
    public String getObligationProcessesPath() { return obligationProcessesPath; }
    public void setObligationProcessesPath(String value) { obligationProcessesPath = value; }
    public String getObligationProcessesDataAccessId() { return obligationProcessesDataAccessId; }
    public void setObligationProcessesDataAccessId(String value) { obligationProcessesDataAccessId = value; }
    public String getObligationDetailPath() { return obligationDetailPath; }
    public void setObligationDetailPath(String value) { obligationDetailPath = value; }
    public String getObligationDetailDataAccessId() { return obligationDetailDataAccessId; }
    public void setObligationDetailDataAccessId(String value) { obligationDetailDataAccessId = value; }
}
