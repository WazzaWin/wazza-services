package com.wazzawin.persistence.cache.api;

import java.util.Map;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public interface HibernateCacheProvider {

    /**
     * <p>Returns Basic Properties for Specific Cache Provider.</p>
     *
     * @param <P>
     * @return specific Cache Provider Properties
     */
    public <P extends Map> P getCacheProviderProperties();

}
