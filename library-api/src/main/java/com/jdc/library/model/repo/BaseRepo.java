package com.jdc.library.model.repo;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jdc.library.model.entity.Page;

@NoRepositoryBean
public interface BaseRepo<T, ID> extends JpaRepository<T, ID> {
	Page<T> findByQuery(String jpql, Map<String, Object> params, int page, int size);
}
