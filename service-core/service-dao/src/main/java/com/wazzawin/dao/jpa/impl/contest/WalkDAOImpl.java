package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Walk;
import com.wazzawin.dao.interf.contest.IWalkDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaWalkDAO")
@Profile(value = "jpa")
public class WalkDAOImpl extends AbstractJpaDAO<Walk, Long> implements
        IWalkDAO {

    public WalkDAOImpl() {
        super(Walk.class);
    }
}
