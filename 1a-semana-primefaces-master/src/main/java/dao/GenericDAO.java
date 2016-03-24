package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
 
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.algaworks.comercial.util.Transacional;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T>implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	 
//    public GenericDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
 
    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    @Transacional
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    @Transacional
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    @Transacional
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
    @Transacional
    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
    
 // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    @Transacional
    public List<T> findOneResult(String namedQuery, Map<String, Object> parameters) {
    	List<T> result = null;
        try {
            Query query = entityManager.createNamedQuery(namedQuery);
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            } 
            result = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
    	 
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
