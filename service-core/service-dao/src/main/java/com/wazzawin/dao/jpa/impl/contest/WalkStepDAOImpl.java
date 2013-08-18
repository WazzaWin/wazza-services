package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.WalkStep;
import com.wazzawin.dao.interf.contest.IWalkStepDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaWalkStepDAO")
@Profile(value = "jpa")
public class WalkStepDAOImpl extends AbstractJpaDAO<WalkStep, Long> implements
        IWalkStepDAO {

    public WalkStepDAOImpl() {
        super(WalkStep.class);
    }
}
