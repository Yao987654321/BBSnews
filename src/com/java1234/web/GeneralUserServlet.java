package com.java1234.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java1234.dao.GeneralUserDao;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;
import com.java1234.model.GeneralUser;
public class GeneralUserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil=new DbUtil();
	GeneralUserDao generalUserDao =new GeneralUserDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if("loginuser".equals(action)){
			this.loginuser(request, response);
		}else if("registereduser".equals(action)){
			this.registereduser(request,response);
		}else if("logoutuser".equals(action)) {
			this.logout(request,response);
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) 
		// TODO 退出用户
		throws ServletException, IOException {
			request.getSession().invalidate();
			System.out.println(request.getContextPath()+"/index.jsp");
			response.sendRedirect(request.getContextPath()+"/index.jsp");			
	}

	private void registereduser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String generalusername=request.getParameter("name1");
		String generaluserpassword=request.getParameter("password1");
		String generaluseremil=request.getParameter("email1");
		String generaluserpassword2=request.getParameter("password11");
		
		Connection con=null;
		
		GeneralUser generalUser =new GeneralUser(generalusername, generaluserpassword, generaluseremil);		
		try{		
				con=dbUtil.getCon();
				if(generalusername==null||generalusername=="") {
					request.setAttribute("message", "账户不能为空");
					
				}if(generaluseremil==null||generaluseremil=="") {
					request.setAttribute("message", "邮箱不能为空");
					
				}if(generaluserpassword==null||generaluserpassword=="") {
					request.setAttribute("message", "密码不能为空");
					
				}if(generaluserpassword2==null||generaluserpassword2=="") {
					request.setAttribute("message", "请确认密码");
					
				}if(generaluserpassword2!=generaluserpassword) {
					request.setAttribute("message", "两次密码不一样");					
				}
				generalUserDao.addUser(con, generalUser);
				request.setAttribute("flag",1);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);				
			}
			catch(Exception e){
					e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void loginuser(HttpServletRequest request, HttpServletResponse response)
	// TODO 用户登录
		throws ServletException, IOException {
		String generalusername=request.getParameter("name");
		String generaluserpassword=request.getParameter("password");
		
		HttpSession session=request.getSession();
		Connection con=null;
		try {
			con=dbUtil.getCon();
			GeneralUser generalUser=new GeneralUser(generalusername,generaluserpassword, generaluserpassword);
			GeneralUser currentUser=generalUserDao.loginUser(con, generalUser);
			if(currentUser==null) {
				request.setAttribute("error", "用户名或者密码错误！");
				request.setAttribute("password", generaluserpassword);
				request.setAttribute("name", generalusername);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}else {
				
				session.setAttribute("currentUser", currentUser);
				request.getRequestDispatcher("/goIndex").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
