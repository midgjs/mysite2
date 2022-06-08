package com.javaex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.BoardDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.BoardVo;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//action을 꺼낸다
		String action = request.getParameter("action");	
		
		if("writeForm".equals(action)) {
			System.out.println("bc > writeForm");
			//글쓰기 폼 포워드
			WebUtil.forword(request, response, "/WEB-INF/views/board/writeForm.jsp");
		} else if("write".equals(action)) {
			System.out.println("bc > write");
			
			//파라미터 꺼내기
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int hit = Integer.parseInt(request.getParameter("hit"));
			String reg_date = request.getParameter("reg_date");
			int user_no = Integer.parseInt(request.getParameter("user_no"));
			
			//Vo만들기
			BoardVo boardVo = new BoardVo(title, content, hit, reg_date, user_no);
			System.out.println(boardVo);
			
			//Dao를 이용해서 저장하기
			BoardDao boardDao = new BoardDao();
			boardDao.insert(boardVo);
			
			//리다이렉트
			WebUtil.redirect(request, response, "/mysite2/board");
		
		} else if("list".equals(action)) {
			System.out.println("bc > list");
			//파라미터 꺼내기
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int hit = Integer.parseInt(request.getParameter("hit"));
			String reg_date = request.getParameter("reg_date");
			int user_no = Integer.parseInt(request.getParameter("user_no"));
			
			//리스트 폼 포워드
			WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");
		} else if("read".equals(action)) {
			System.out.println("bc > read");
			//리드 폼 포워드
			WebUtil.forword(request, response, "/WEB-INF/views/board/read.jsp");
		} else if("modifyForm".equals(action)) {
			System.out.println("bc > modyfyForm");
			//수정 폼 포워드
			WebUtil.forword(request, response, "/WEB-INF/views/board/modifyForm.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
