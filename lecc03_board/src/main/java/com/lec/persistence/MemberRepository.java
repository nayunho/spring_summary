package com.lec.persistence;

import com.lec.domain.Member;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,String>{

	
	
}
