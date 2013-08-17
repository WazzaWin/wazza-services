package com.wazzawin.persistence.configuration.c3p0;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Component(value = "c3p0BasicProperties")
public class C3P0BasicProperties {

    @Value("persistence{c3p0_acquireIncrement}")
    private int acquireIncrement;
    @Value("persistence{c3p0_acquireRetryAttempts}")
    private int acquireRetryAttempts;
    @Value("persistence{c3p0_minPoolSize}")
    private int minPoolSize;
    @Value("persistence{c3p0_maxPoolSize}")
    private int maxPoolSize;
    @Value("persistence{c3p0_maxIdleTime}")
    private int maxIdleTime;
    @Value("persistence{c3p0_maxConnectionAge}")
    private int maxConnectionAge;
    @Value("persistence{c3p0_connectionCustomizerClassName}")
    private String connectionCustomizerClassName;

    /**
     * @return the acquireIncrement
     */
    public int getAcquireIncrement() {
        return acquireIncrement;
    }

    /**
     * @return the acquireRetryAttempts
     */
    public int getAcquireRetryAttempts() {
        return acquireRetryAttempts;
    }

    /**
     * @return the minPoolSize
     */
    public int getMinPoolSize() {
        return minPoolSize;
    }

    /**
     * @return the maxPoolSize
     */
    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    /**
     * @return the maxIdleTime
     */
    public int getMaxIdleTime() {
        return maxIdleTime;
    }

    /**
     * @return the maxConnectionAge
     */
    public int getMaxConnectionAge() {
        return maxConnectionAge;
    }

    /**
     * @return the connectionCustomizerClassName
     */
    public String getConnectionCustomizerClassName() {
        return connectionCustomizerClassName;
    }

    @Override
    public String toString() {
        return "C3P0BasicProperties{ " + "acquireIncrement = "
                + acquireIncrement + ", acquireRetryAttempts = "
                + acquireRetryAttempts + ", minPoolSize = "
                + minPoolSize + ", maxPoolSize = " + maxPoolSize
                + ", maxIdleTime = " + maxIdleTime + ", maxConnectionAge = "
                + maxConnectionAge + ", connectionCustomizerClassName = "
                + connectionCustomizerClassName + '}';
    }

}
