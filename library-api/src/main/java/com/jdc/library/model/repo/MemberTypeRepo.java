package com.jdc.library.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.library.model.entity.MemberType;

public interface MemberTypeRepo extends JpaRepository<MemberType, Integer> {

}
