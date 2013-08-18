package com.wazzawin.dao.jpa.impl.user;

import com.wazzawin.core.model.user.Activity;
import com.wazzawin.dao.interf.user.IActivityDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaActivityDAO")
@Profile(value = "jpa")
public class ActivityDAOImpl extends AbstractJpaDAO<Activity, Long> implements
        IActivityDAO {

    public ActivityDAOImpl() {
        super(Activity.class);
    }
}
