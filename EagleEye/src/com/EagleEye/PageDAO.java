
package com.EagleEye;

import java.util.List;

public interface PageDAO 
{
	public void insert(Page page) throws DAOException;
	public void update(Page page) throws DAOException;
	public void delete(int id) throws DAOException;

	public Page getPage(int id) throws DAOException;	
	public List<Page> getAllPages() throws DAOException;
}
