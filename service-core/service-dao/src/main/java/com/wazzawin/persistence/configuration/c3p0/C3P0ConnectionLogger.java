package com.wazzawin.persistence.configuration.c3p0;

import com.mchange.v2.c3p0.ConnectionCustomizer;
import java.sql.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public class C3P0ConnectionLogger implements ConnectionCustomizer {

    private static final Logger logger = LoggerFactory.getLogger(
            C3P0ConnectionLogger.class);
    //
    private int activeConnections = 0;
    private int acquiredConnections = 0;

    @Override
    public void onAcquire(Connection c, String parentDataSourceIdentityToken)
            throws Exception {
        logger.debug("onAcquire: Connection acquired from database : " + c
                + " [" + parentDataSourceIdentityToken + "]");
        acquiredConnections++;
        logger.debug("onAcquire: Total Open Connections in Pool : "
                + acquiredConnections);
    }

    @Override
    public void onDestroy(Connection c, String parentDataSourceIdentityToken)
            throws Exception {
        logger.debug("onDestroy: Connection closed with database : " + c + " ["
                + parentDataSourceIdentityToken + "]");
        acquiredConnections--;
        logger.debug("onDestroy: Total Open Connections in Pool : "
                + acquiredConnections);
    }

    @Override
    public void onCheckOut(Connection c, String parentDataSourceIdentityToken)
            throws Exception {
        logger.debug(
                "onCheckOut: Connection from pool provide to application : "
                + c + " [" + parentDataSourceIdentityToken + "]");
        activeConnections++;
        logger.debug("onCheckOut: Total Active Connections in Pool : "
                + activeConnections);
    }

    @Override
    public void onCheckIn(Connection c, String parentDataSourceIdentityToken)
            throws Exception {
        logger.debug("onCheckIn: Connection returned to pool "
                + "from application : "
                + c + " [" + parentDataSourceIdentityToken + "]");
        activeConnections--;
        logger.debug("onCheckIn: Total Active Connections in Pool : "
                + activeConnections);
    }
}
