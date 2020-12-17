package com.jdc.library.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.library.model.entity.Author;
import com.jdc.library.model.entity.Page;
import com.jdc.library.model.service.AuthorService;

@RestController
@RequestMapping("authors")
public class AuthorApi {

	@Autowired
	private AuthorService service;
	
	@PostMapping
	public Author save(@RequestBody Author author) {
		return service.save(author);
	}
	
	@PutMapping
	public Author update(@RequestBody Author author) {
		return service.save(author);
	}
	
	@GetMapping(params = {"name", "jobTitle", "page", "size"})
	public Page<Author> search(@RequestParam String name, @RequestParam String jobTitle, int page, int size){
		return service.serach(name, jobTitle, page, size);
	}
}
