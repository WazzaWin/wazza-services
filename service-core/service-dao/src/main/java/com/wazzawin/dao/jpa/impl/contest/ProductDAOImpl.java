package com.wazzawin.dao.jpa.impl.contest;

import com.wazzawin.core.model.contest.Product;
import com.wazzawin.dao.interf.contest.IProductDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaProductDAO")
@Profile(value = "jpa")
public class ProductDAOImpl extends AbstractJpaDAO<Product, Long> implements
        IProductDAO {

    public ProductDAOImpl() {
        super(Product.class);
    }
}
