package com.lec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lec.domain.Board;
import com.lec.domain.Member;
import com.lec.service.BoardService;

@Controller
@SessionAttributes("member") // session.setAttribute("member") 
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("====> BoardController 객체 자동생성!!");
	}
	
	// login정보 - request.setAttribute("member")
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}

	@RequestMapping("/getBoardList") 
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		
		if(member.getId() == null) {   // login을 하지 않았다.
			return "redirect:login";   // login.html
		} else {
			
		}
		List<Board> boardList = boardService.getBoardList(board); // select * from board
		model.addAttribute("boardList", boardList);   // request.setAttribute("boardList", boardList);
		return "getBoardList";                        // getBoardList.html
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member, Board board) {
		if(member.getId() == null) {   // login을 하지 않았다.
			return "redirect:login";   // login.html
		}
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		
		if(member.getId() == null) {   
			return "redirect:login"; 
		}		
		
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		
		if(member.getId() == null) {   
			return "redirect:login"; 
		}		

		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";  // getBoard.html
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		
		if(member.getId() == null) {   
			return "redirect:login"; 
		}		
		
		boardService.updateBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		
		if(member.getId() == null) {   
			return "redirect:login"; 
		}		
		
		boardService.deleteBoard(board);
		return "redirect:getBoardList";
	}
}
