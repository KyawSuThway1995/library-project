package com.jdc.library.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.library.model.entity.Author;
import com.jdc.library.model.entity.Page;
import com.jdc.library.model.repo.AuthorRepo;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepo repo;
	
	public Author save(Author author) {
		return repo.save(author);
	}

	public Page<Author> serach(String name, String jobTitle, int page, int size) {
		StringBuilder sb = new StringBuilder("select a from Author a where 1 = 1 ");
		Map<String, Object> params = new HashMap<>();
		
		if(name != null && !name.isEmpty()) {
			sb.append("and upper(a.name) like upper(:name) or upper(a.penName) like upper(:name) ");
			params.put("name", "%" + name.concat("%"));
		}
		
		if(jobTitle != null && !jobTitle.isEmpty()) {
			sb.append("and upper(a.title) like upper(:title) ");
			params.put("title", "%" + jobTitle.concat("%"));
		}
		
		return repo.findByQuery(sb.toString(), params, page, size);
	}

}
