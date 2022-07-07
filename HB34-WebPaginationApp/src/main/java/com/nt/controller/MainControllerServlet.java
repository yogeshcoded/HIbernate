package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.nt.entity.Product;
import com.nt.service.IProductService;
import com.nt.service.ProductServiceImpl;



public class MainControllerServlet extends HttpServlet {
	private IProductService service;
	
	@Override
	public void init() throws ServletException {
	service=new ProductServiceImpl();
			}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pageSize=req.getParameter("pageSize");
		String pgNo=req.getParameter("pgNo");
		HttpSession ses=req.getSession();
		
		int pageNo=0;
		if(pageSize!=null) {
			ses.setAttribute("pageSize", pageSize);
			pgNo="1";
			pageNo=Integer.parseInt(pgNo);
		}//if
		else {
			pageNo=Integer.parseInt(pgNo);
			if(ses.getAttribute("pageSize")!=null)
				pageSize=(String) ses.getAttribute("pageSize");
				else 
					pageSize="3";
		}
		
		//use service
		try {
		long pageCount=service.getPagesCount(Integer.parseInt(pageSize));
		List<Product> list=service.getPageData(pageNo, Integer.parseInt(pageSize));
	 req.setAttribute("pageData", list);
	 req.setAttribute("pageCount", pageCount);
	 //forword 
	 RequestDispatcher rd=req.getRequestDispatcher("/show_report.jsp");
	 rd.forward(req, res);
		}
		catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg",e.getMessage());
			 RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			 rd.forward(req, res);
		}
		
		}//doGet()
				
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPOST()
	
	
	
}//class
