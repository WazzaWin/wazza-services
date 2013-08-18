package com.wazzawin.dao.jpa;

import com.google.common.base.Preconditions;
import com.wazzawin.dao.IBaseDAO;
import com.wazzawin.exception.DAOException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Transactional
public abstract class AbstractJpaDAO<T extends Object, ID extends Serializable>
        implements IBaseDAO<T, ID> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    private final Class<T> persistentClass;
    //
    protected EntityManager entityManager;

    public AbstractJpaDAO(Class<T> thePersistentClass) {
        Preconditions.checkNotNull(thePersistentClass);
        this.persistentClass = thePersistentClass;
    }

    @PersistenceContext
    public void setEm(final EntityManager theEntityManager) {
        Preconditions.checkNotNull(theEntityManager);
        this.entityManager = theEntityManager;
    }

    @Override
    public T persist(T entity) {
        Preconditions.checkNotNull(entity);

        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        T entity = this.find(id);

        if (entity == null) {
            throw new DAOException(
                    "The Entity with ID : " + id + " has been already deleted.");
        }

        this.entityManager.remove(entity);
    }

    @Override
    public List<T> findByCriteria(Criterion... criterion) throws DAOException {
        try {
            Criteria criteria = getSession().createCriteria(persistentClass);
            for (Criterion c : criterion) {
                criteria.add(c);
            }
            return criteria.list();
        } catch (HibernateException ex) {
            logger.error("HibernateException : " + ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public T find(Long id) throws DAOException {
        Preconditions.checkArgument(id != null);

        try {
            Criteria crit = getSession().createCriteria(persistentClass);
            return (T) crit.add(Restrictions.idEq(id)).uniqueResult();
        } catch (HibernateException ex) {
            logger.error("HibernateException : " + ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public List<T> findAll() {
        return this.entityManager.createQuery(
                "from " + this.persistentClass.getName()).getResultList();
    }

    @Override
    public List<T> findAll(int start,
            int end) throws DAOException {
        try {
            Criteria crit = getSession().createCriteria(persistentClass);
            crit.setFirstResult(start);
            crit.setMaxResults(end);
            return crit.list();
        } catch (HibernateException ex) {
            logger.error("HibernateException : " + ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public List<T> findAll(int start,
            int end, Criterion... criterion) throws DAOException {
        Criteria crit = getSession().createCriteria(persistentClass);
        try {
            for (Criterion criterionElement : criterion) {
                crit.add(criterionElement);
            }
            crit.setFirstResult(start);
            crit.setMaxResults(end);
            return crit.list();
        } catch (HibernateException ex) {
            logger.error("HibernateException : " + ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public int removeAll() {
        Query q = this.entityManager.createNativeQuery("delete from "
                + persistentClass.getSimpleName(),
                persistentClass);

        return q.executeUpdate();
    }

    protected Class< T> getPersistentClass() {
        if (logger.isDebugEnabled()) {
            logger.debug("@@@@@@@@@@@@@@@@@@@@@ Persistent Class : "
                    + this.persistentClass);
        }
        return persistentClass;
    }

    protected Session getSession() {
        return (Session) this.entityManager.getDelegate();
    }
}
