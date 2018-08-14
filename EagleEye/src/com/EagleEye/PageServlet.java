package com.EagleEye;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PageBO pageBO = new PageBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextView = null;
		boolean redirect = false;

		String action = request.getParameter("action");

		if (action == null)
			action = "";

		switch (action) {
		case "Add":
			Page page = new Page();
			request.setAttribute("page", page);
			nextView = "/pageForm.jsp";
			redirect = false;
			break;
		case "Edit":
			int id = Integer.parseInt(request.getParameter("id"));
			page = pageBO.getPage(id);
			request.setAttribute("page", page);
			nextView = "/pageForm.jsp";
			redirect = false;
			break;
		case "Save":
			String strid = request.getParameter("id");

			if (strid != null && strid.trim().length() != 0)
				id = Integer.parseInt(strid);
			else
				id = -1;

			String pageName = request.getParameter("pageName");
			String pageQuery = request.getParameter("pageQuery");
			String inputColumn = request.getParameter("inputColumn");
			String outputColumn = request.getParameter("outputColumn");
			int status = 1;

			page = new Page(id, pageName, pageQuery, inputColumn, outputColumn, status);

			if (strid != null && strid.trim().length() != 0)
				pageBO.update(page);
			else
				pageBO.insert(page);

			nextView = "PageServlet";
			redirect = true;
			break;
		case "Delete":
			id = Integer.parseInt(request.getParameter("id"));
			pageBO.delete(id);
			nextView = "PageServlet";
			redirect = true;
			break;
		default:
			List<Page> pages = pageBO.getAllPages();
			request.setAttribute("pages", pages);
			nextView = "/pages.jsp";
			redirect = false;
			break;
		}

		if (redirect) {
			response.sendRedirect(nextView);
		} else {
			ServletContext application = getServletContext();
			RequestDispatcher dispatcher = application.getRequestDispatcher(nextView);
			dispatcher.forward(request, response);
		}
	}
}
