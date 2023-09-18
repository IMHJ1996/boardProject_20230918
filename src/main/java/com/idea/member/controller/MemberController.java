package com.idea.member.controller;

import com.idea.member.dto.MemberDTO;
import com.idea.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/join")
    public String joinForm(){return "join";}
    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO){
        System.out.println(memberDTO + " post");
        boolean result = memberService.join(memberDTO);
        if(result){
            System.out.println("회원가입 성공");
            return "index";
        }else{
            System.out.println("회원가입 실패");
            return "join";
        }
    }
    @GetMapping("/list")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList",memberDTOList);
        return "list";
    }
    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "detail";
    }
    @GetMapping("/login")
    public String loginForm(){return "login";}

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        boolean loginResult = memberService.login(memberDTO);
        if (loginResult) {
            // 로그인 성공시 사용자의 이메일을 세션에 저장
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            // 모델에 이메일 저장
            model.addAttribute("email", memberDTO.getMemberEmail());
            System.out.println("로그인성공");
            return "index";
        } else {
            System.out.println("로그인실패");
            return "login";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }

}
