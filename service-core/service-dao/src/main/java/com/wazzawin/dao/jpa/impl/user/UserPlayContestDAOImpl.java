package com.wazzawin.dao.jpa.impl.user;

import com.wazzawin.core.model.user.UserPlayContest;
import com.wazzawin.dao.interf.user.IUserPlayContestDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaUserPlayContestDAO")
@Profile(value = "jpa")
public class UserPlayContestDAOImpl extends AbstractJpaDAO<UserPlayContest, Long> implements
        IUserPlayContestDAO {

    public UserPlayContestDAOImpl() {
        super(UserPlayContest.class);
    }
}
