package com.wazzawin.persistence.configuration.properties;

import java.util.StringTokenizer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Component(value = "gpPersistenceConnector")
public class PersistenceConnector implements InitializingBean {

    @Value("persistence{db_driverClassName}")
    private String driverClassName;
    @Value("persistence{db_url}")
    private String url;
    @Value("persistence{db_username}")
    private String username;
    @Value("persistence{db_password}")
    private String password;
    @Value("persistence{db_packageToScan}")
    private String packageToScan;
    private String[] packagesToScan;

    /**
     * @return the driverClassName
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * @param driverClassName the driverClassName to set
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the packageToScan
     */
    public String getPackageToScan() {
        return packageToScan;
    }

    /**
     * @param packageToScan the packageToScan to set
     */
    public void setPackageToScan(String packageToScan) {
        this.packageToScan = packageToScan;
    }

    /**
     * @return the packagesToScan
     */
    public String[] getPackagesToScan() {
        return (this.packagesToScan != null
                ? this.packagesToScan : definePackagesToScan());
    }

    protected final String[] definePackagesToScan() {
        StringTokenizer st = new StringTokenizer(this.packageToScan, ":");
        int tokenCount = st.countTokens();
        this.packagesToScan = new String[tokenCount];

        for (int i = 0; i < tokenCount; i++) {
            this.packagesToScan[i] = st.nextToken();
        }

        return this.packagesToScan;
    }

    @Override
    public String toString() {
        return "GPPersistenceConnector{ " + "driverClassName = " + driverClassName
                + ", url = " + url + ", username = " + username
                + ", password = " + password
                + ", packagesToScan = " + packageToScan + '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if ((this.packageToScan == null) || (this.packageToScan.equals(""))) {
            throw new IllegalArgumentException("Parameter Package To Scan "
                    + "can not be Null or an Empty String.");
        }
    }
}
