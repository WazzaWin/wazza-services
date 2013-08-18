package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.ContestInfo;
import com.wazzawin.dao.interf.contest.IContestInfoDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaContestInfoDAO")
@Profile(value = "jpa")
public class ContestInfoDAOImpl extends AbstractJpaDAO<ContestInfo, Long> implements
        IContestInfoDAO {

    public ContestInfoDAOImpl() {
        super(ContestInfo.class);
    }
}
