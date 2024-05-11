package com.lec.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lec.domain.Board;
import com.lec.domain.BoardVO;

@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("====> BoardController 객체 자동 생성!!");
	}
	
	@GetMapping("/hello")
	public String hello1(String name) {
		return "Hello? " + name;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		for(int i=1;i<=10;i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("제목_" + i);
			board.setWriter("작성자_" + i);
			board.setContent("글내용(" + i + ") ......");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}	
		return boardList;
	}
	
	@GetMapping("/getBoardList1")
	public List<Board> getBoardList1() {
		
		List<Board> boardList = new ArrayList<>();
		
		for(int i=1;i<=10;i++) {
			Board board = new Board();
			board.setSeq(i);
			board.setTitle("제목_" + i);
			board.setWriter("작성자_" + i);
			board.setContent("글내용(" + i + ") ......");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}	
		return boardList;
	}
}
