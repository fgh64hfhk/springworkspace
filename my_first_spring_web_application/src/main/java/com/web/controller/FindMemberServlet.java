package com.web.controller;

import java.io.IOException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.web.beans.Member;
import com.web.service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/findMembers")
public class FindMemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		int iid = Integer.parseInt(id);

		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		MemberService memberService = (MemberService) applicationContext.getBean("memberServiceInMemory");
		Member member = memberService.findById(iid);

		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}