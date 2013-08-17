package com.wazzawin.persistence.configuration.basic.strategy;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Component(value = "hibPropStrategyManager")
public class PropertiesStrategyManager
        implements InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    @Autowired
    private Properties hibernateProperties;
    //
    @Autowired(required = false)
    @Qualifier(value = "luceneHibProp")
    private PersistenceHibernateStrategy luceneHibProp;

    /**
     *
     * @return Properties Configuration
     */
    public Properties getProperties() {
        return luceneHibProp != null ? luceneHibProp.hibernateProperties()
                : hibernateProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("PropertiesStrategyManager Configuration ############"
                + "#######");
        builder.append("\n\n");
        builder.append("Strategy Used : ");
        builder.append(printStrategy());
        builder.append("\n\n");

        logger.info(builder.toString());
    }

    private String printStrategy() {
        return luceneHibProp != null
                ? "Hibernate annd Lucene Configuration : " + luceneHibProp
                : "Basic Hibernate Configuration. ";
    }
}
