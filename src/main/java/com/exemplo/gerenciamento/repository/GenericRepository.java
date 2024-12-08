package com.exemplo.gerenciamento.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import com.exemplo.gerenciamento.util.JPAUtil;

@Transactional
public class GenericRepository<T> implements Serializable {

	private static final long serialVersionUID = -7565584225038507486L;

	private JPAUtil jPAUtil;

    private Class<T> entityClass;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        try {
            JPAUtil.getEntityManager().persist(entity);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(Object id, Class<T> entity) {
        try {
            JPAUtil.getEntityManager().remove(JPAUtil.getEntityManager().getReference(entity, id));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public T update(T entity) {
        return JPAUtil.getEntityManager().merge(entity);
    }

    public T findById(int entityId) {
        return JPAUtil.getEntityManager().find(entityClass, entityId);
    }

    public T findReferenceOnly(int entityID) {
        return JPAUtil.getEntityManager().getReference(entityClass, entityID);
    }

    public List<T> findAll() {
        CriteriaQuery<T> cq = (CriteriaQuery<T>) JPAUtil.getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return JPAUtil.getEntityManager().createQuery(cq).getResultList();
    }

    public TypedQuery<T> createNamedQuery(String query) {
        return JPAUtil.getEntityManager().createNamedQuery(query, entityClass);
    }

    public Query createNativeQuery(String query) {
        return JPAUtil.getEntityManager().createNativeQuery(query, entityClass);
    }

}