package com.wazzawin.persistence.loader;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Configuration
@ComponentScan(
        basePackages = {"com.wazzawin.persistence.configuration"})
@ImportResource(value = {"classpath*:persistenceContext.xml"})
public class PersistenceAppConfig {
}
