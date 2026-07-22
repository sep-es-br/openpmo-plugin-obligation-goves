package br.gov.es.pmo.obligation_parser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pentaho-bi")
public class PentahoObligationProperties {
    private String baseUrl;
    private String userId;
    private String password;
    private String yearsPath;
    private String yearsDataAccessId;
    private String managementUnitsPath;
    private String managementUnitsDataAccessId;
    private String processesPath;
    private String processesDataAccessId;
    private String obligationPath;
    private String obligationDataAccessId;

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String value) { baseUrl = value; }
    public String getUserId() { return userId; }
    public void setUserId(String value) { userId = value; }
    public String getPassword() { return password; }
    public void setPassword(String value) { password = value; }
    public String getYearsPath() { return yearsPath; }
    public void setYearsPath(String value) { yearsPath = value; }
    public String getYearsDataAccessId() { return yearsDataAccessId; }
    public void setYearsDataAccessId(String value) { yearsDataAccessId = value; }
    public String getManagementUnitsPath() { return managementUnitsPath; }
    public void setManagementUnitsPath(String value) { managementUnitsPath = value; }
    public String getManagementUnitsDataAccessId() { return managementUnitsDataAccessId; }
    public void setManagementUnitsDataAccessId(String value) { managementUnitsDataAccessId = value; }
    public String getProcessesPath() { return processesPath; }
    public void setProcessesPath(String value) { processesPath = value; }
    public String getProcessesDataAccessId() { return processesDataAccessId; }
    public void setProcessesDataAccessId(String value) { processesDataAccessId = value; }
    public String getObligationPath() { return obligationPath; }
    public void setObligationPath(String value) { obligationPath = value; }
    public String getObligationDataAccessId() { return obligationDataAccessId; }
    public void setObligationDataAccessId(String value) { obligationDataAccessId = value; }
}
