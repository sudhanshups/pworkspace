package com.EagleEye;

import java.util.List;

import com.EagleEye.DAOException;
import com.EagleEye.Page;
import com.EagleEye.PageDAO;
import com.EagleEye.PageDAOImpl;

public class PageBO {
	PageDAO pageDAO = new PageDAOImpl();

	public void insert(Page page) throws DAOException {
		pageDAO.insert(page);
		// write code to send welcome email to the page
	}

	public void update(Page page) throws DAOException{
		pageDAO.update(page);
	}

	public void delete(int id) throws DAOException {
		pageDAO.delete(id);
	}

	public Page getPage(int id) throws DAOException {
		return pageDAO.getPage(id);
	}

	public List<Page> getAllPages() throws DAOException {
		return pageDAO.getAllPages();
	}
}
