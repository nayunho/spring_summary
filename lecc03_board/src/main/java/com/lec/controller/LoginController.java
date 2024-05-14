package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lec.domain.Member;
import com.lec.service.MemberService;

@Controller
@SessionAttributes("member")
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	public LoginController() {
		System.out.println("====> LoginController 객체 자동생성!!");
	}
	
	@GetMapping("/login")
	public String loginView() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		
		Member findMember = memberService.getMember(member);
		
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			
			// request.setAttribute("member", findMember)
			model.addAttribute("member", findMember);
			return "redirect:getBoardList";
		} else {		
			return "redirect:login";
		}
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete();  // session.invalidSession 세센-초기화
		return "redirect:index.html";
	}
}
