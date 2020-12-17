package com.jdc.library.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.library.model.entity.Member;
import com.jdc.library.model.entity.Page;
import com.jdc.library.model.service.MemberService;

@RestController
@RequestMapping("members")
public class MemberApi {

	@Autowired
	private MemberService service;
	
	@PostMapping
	public Member save(@RequestBody Member member) {
		return service.save(member);
	}
	
	@PutMapping
	public Member update(@RequestBody Member member) {
		return service.save(member);
	}
	
	@GetMapping(params = {"name", "memberTypeId", "page", "size"})
	public Page<Member> search(@RequestParam String name,@RequestParam int memberTypeId,@RequestParam int page, @RequestParam int size){
		return service.search(name, memberTypeId, page, size);
	}
}
