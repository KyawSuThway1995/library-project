package com.jdc.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.library.model.entity.MemberType;
import com.jdc.library.model.service.MemberTypeService;

@RestController
@RequestMapping("member-types")
public class MemberTypeApi {

	@Autowired
	private MemberTypeService service;
	
	@PostMapping
	public MemberType save(@RequestBody MemberType memberType) {
		return service.save(memberType);
	}
	
	@PutMapping
	public MemberType update(@RequestBody MemberType memberType) {
		return service.save(memberType);
	}
	
	@GetMapping
	public List<MemberType> findAll(){
		return service.findAll();
	}
}
