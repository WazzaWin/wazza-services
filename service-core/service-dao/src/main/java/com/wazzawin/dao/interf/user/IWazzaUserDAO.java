package com.wazzawin.dao.interf.user;

import com.wazzawin.core.model.user.WazzaUser;
import com.wazzawin.dao.IBaseDAO;
import com.wazzawin.exception.DAOException;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public interface IWazzaUserDAO extends IBaseDAO<WazzaUser, Long> {

    WazzaUser findByUserName(String userName) throws DAOException;
}
