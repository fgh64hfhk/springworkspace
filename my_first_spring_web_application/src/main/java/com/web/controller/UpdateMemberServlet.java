package com.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.web.beans.Member;
import com.web.service.MemberService;
import com.web.ude.RecordNotFoundException;
import com.web.utils.SystemUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession httpSession = request.getSession();
		Map<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		String modify = request.getParameter("finalDecision");
		String id = request.getParameter("id");
		int iid = Integer.parseInt(id);
		
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService memberService = context
				.getBean("memberServiceInMemory", MemberService.class);
		
		if (modify.equalsIgnoreCase("DELETE")) {
			try {
				memberService.delete(iid);
				httpSession.setAttribute("modify", "刪除成功");
			} catch (RecordNotFoundException ex) {
				httpSession.setAttribute("error", "要刪除的紀錄不存在，鍵值: " + ex.getId());
			} catch (Exception ex) {
				httpSession.setAttribute("error", "刪除時發生異常: " + ex.getMessage());
			}
		} else if (modify.equalsIgnoreCase("UPDATE")) {
			String userId = request.getParameter("userId");
			String password = request.getParameter("pswd");
			String name = request.getParameter("name");
			String birthday = request.getParameter("birthday");
			String phoneNo = request.getParameter("phoneNo");
			String expericnceStr = request.getParameter("experience");

			// 2. 進行必要的資料轉換
			int experience = 0;
			try {
				experience = Integer.parseInt(expericnceStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("experience", "工作經驗欄格式錯誤，應該為整數");
			}
			// 3. 檢查使用者輸入資料
			if (userId == null || userId.trim().length() == 0) {
				errorMsg.put("userId", "會員代號欄必須輸入");
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("pswd", "密碼欄必須輸入");
			}
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("userName", "姓名欄必須輸入");
			}
			java.sql.Date date = null;
			if (birthday != null && birthday.trim().length() > 0) {
				try {
					date = SystemUtils.toSqlDate(birthday);
				} catch (Exception e) {
					errorMsg.put("birthday", "生日欄格式錯誤");
				}
			}
			if (phoneNo == null || phoneNo.trim().length() == 0) {
				errorMsg.put("phoneNo", "電話號碼欄必須輸入");
			}
			if (experience < 0) {
				errorMsg.put("experience", "工作經驗欄應為正整數或 0 ");
			}
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
				rd.forward(request, response);
				return;
			}

			Member member = new Member(iid, userId, password, name, phoneNo, experience, date, null);
			member.setId(iid);
			try {
				Member memberTemp = memberService.findById(iid);
				member.setRegisterTime(memberTemp.getRegisterTime());
				memberService.update(member);
				httpSession.setAttribute("modify", "修改成功");
			} catch (RecordNotFoundException ex) {
				httpSession.setAttribute("error", "要修改的紀錄不存在，鍵值: " + ex.getId());
			} catch (Exception ex) {
				httpSession.setAttribute("error", "修改時發生異常: " + ex.getMessage());
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/queryAllMembers");
	}
}
