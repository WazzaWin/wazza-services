package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Prize;
import com.wazzawin.dao.interf.contest.IPrizeDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaPrizeDAO")
@Profile(value = "jpa")
public class PrizeDAOImpl extends AbstractJpaDAO<Prize, Long> implements
        IPrizeDAO {

    public PrizeDAOImpl() {
        super(Prize.class);
    }
}
