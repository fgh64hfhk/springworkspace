package com.web.controller;

import java.io.IOException;
import java.util.Collection;

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

@WebServlet("/queryAllMembers")
public class QueryAllMembersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		
		MemberService memberService = (MemberService) context
				.getBean("memberServiceInMemory");
		Collection<Member> coll = memberService.findAll();
		request.setAttribute("AllMembers", coll);
		RequestDispatcher rd = request.getRequestDispatcher("showAllMembers.jsp");
		rd.forward(request, response);
		return;
	}
}
