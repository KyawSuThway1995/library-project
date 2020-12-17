package com.jdc.library.model.repo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.jdc.library.model.entity.Page;

public class BaseRepoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID> {
	
	private EntityManager em;
	
	public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public Page<T> findByQuery(String jpql, Map<String, Object> params, int page, int size) {
		TypedQuery<T> query = em.createQuery(jpql, getDomainClass());
		params.forEach(query::setParameter);
		
		Integer totalElements = query.getResultList().size();
		List<T> list = query.setFirstResult(page * size).setMaxResults(size).getResultList();
		
		Double totalPages = Math.ceil(totalElements.doubleValue() / size);
		
		return new Page<T>(list, totalPages.intValue());
	}

}
