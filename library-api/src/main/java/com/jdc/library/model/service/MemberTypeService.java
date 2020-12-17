package com.jdc.library.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.library.model.entity.MemberType;
import com.jdc.library.model.repo.MemberTypeRepo;

@Service
public class MemberTypeService {

	@Autowired
	private MemberTypeRepo repo;
	
	public MemberType save(MemberType memberType) {
		return repo.save(memberType);
	}
	
	public List<MemberType> findAll(){
		return repo.findAll();
	}
}
