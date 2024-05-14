package com.lec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.domain.Board;
import com.lec.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;

	public BoardServiceImpl() {
		System.out.println("====> BoardServiceImpl 객체 자동생성!!");
	}
	
	@Override
	public List<Board> getBoardList(Board board) {
		return (List<Board>) boardRepo.findAll(); // select * from board;
	}

	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}

	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();  // select * from board where seq = 1
	}

	@Override
	public void updateBoard(Board board) {
		Board updateBoard = boardRepo.findById(board.getSeq()).get();
		
		updateBoard.setTitle(board.getTitle());
		updateBoard.setContent(board.getContent());
		
		boardRepo.save(updateBoard); // update board set title=xxxx, content=yyyy where seq = 1
	}

	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());// delete from board where seq = 1
	}
}
