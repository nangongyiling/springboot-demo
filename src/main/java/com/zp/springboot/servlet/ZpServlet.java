package com.zp.springboot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 带WebServlet注解的servlet注册需要@ServletComponentScan注解的扫描
 * @author guitai
 *
 */
@WebServlet(urlPatterns="/zp/*")
public class ZpServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -44711038469812L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is zpServlet dopost method");
		PrintWriter pw = resp.getWriter();
		pw.write("hello springboot servlet register by ZpServlet");
		pw.flush();
		pw.close();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	
}
