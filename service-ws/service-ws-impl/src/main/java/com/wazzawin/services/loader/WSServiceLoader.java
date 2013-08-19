package com.wazzawin.services.loader;

import com.wazzawin.persistence.loader.PersistenceLoaderConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Configuration
@Import(value = {PersistenceLoaderConfigurer.class})
public class WSServiceLoader {
}
