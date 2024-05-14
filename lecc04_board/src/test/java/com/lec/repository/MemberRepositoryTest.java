package com.lec.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.domain.Board;
import com.lec.domain.Member;
import com.lec.persistence.BoardRepository;
import com.lec.persistence.MemberRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void memberInsertTest() {
		IntStream.rangeClosed(1, 1001).forEach(i -> {
			Member member = Member.builder()
							      .id("user" + i + "@gmail.com")
							      .password("12345")
							      .name("사원_" + i)
							      .role("USER")
							      .build();
			
			Member result = memberRepository.save(member);	
	
		});
	}
}
