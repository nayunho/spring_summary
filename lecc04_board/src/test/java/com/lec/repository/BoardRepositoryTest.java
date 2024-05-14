package com.lec.repository;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.domain.Board;
import com.lec.persistence.BoardRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	
     @Test
	public void boardInsertTest() {
		IntStream.rangeClosed(0, 101).forEach(i -> {
			Board board = Board.builder()
							   .title("title... " + i)
							   .content("content... " + i)
							   .writer("user_" + i +"@gmail.com")
							   .build();
			
			Board result = boardRepository.save(board);
			log.info("글번호 : " + result.getSeq());
		});
	}
}