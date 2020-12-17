package com.jdc.library.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.library.model.entity.Member;
import com.jdc.library.model.entity.Page;
import com.jdc.library.model.repo.MemberRepo;

@Service
public class MemberService {

	@Autowired
	private MemberRepo repo;
	
	public Member save(Member member) {
		return repo.save(member);
	}
	
	public Page<Member> search(String name, int memberTypeId, int page, int size){
		StringBuilder sb = new StringBuilder("select m from Member m where 1 = 1 ");
		Map<String, Object> params = new HashMap<>();
		
		if(name != null && !name.isEmpty()) {
			sb.append("and upper(m.name) like upper(:name) ");
			params.put("name", "%" + name.concat("%"));
		}
		
		if(memberTypeId > 0) {
			sb.append("and m.memberType.id = :memberTypeId ");
			params.put("memberTypeId", memberTypeId);
		}
		
		return repo.findByQuery(sb.toString(), params, page, size);
	}
}
