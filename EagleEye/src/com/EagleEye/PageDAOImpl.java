package com.EagleEye;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageDAOImpl implements PageDAO {
	private static final String INSERT = "INSERT INTO testdb..page VALUES(?,?,?,?,?)";

	private static final String UPDATE = "UPDATE testdb..page SET name = ?, query = ?, "
			+ "input_column = ?,output_column = ? ,status = ? WHERE id = ?";

	private static final String DELETE = "DELETE FROM testdb..page WHERE id = ?";

	private static final String GetPage = "Select id, name, query,input_column,output_column,status FROM testdb..page WHERE id = ?";

	private static final String GetAllPages = "Select id, name, query,input_column,output_column,status FROM testdb..page";

	public void insert(Page page) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(INSERT);
			DBUtil.fillStatement(ps, page.getPageName(), page.getPageQuery(), page.getInputColumn(),
					page.getOutputColumn(), page.getStatus());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			DBUtil.close(ps);
			// DBUtil.close(conn);
		}
	}

	public void update(Page page) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(UPDATE);
			DBUtil.fillStatement(ps, page.getPageName(), page.getPageQuery(), page.getInputColumn(),
					page.getOutputColumn(), page.getStatus(), page.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			DBUtil.close(ps);
			// DBUtil.close(conn);
		}
	}

	public void delete(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(DELETE);
			DBUtil.fillStatement(ps, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			DBUtil.close(ps);
			// DBUtil.close(conn);
		}
	}

	public Page getPage(int id) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		Page page = null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(GetPage);
			DBUtil.fillStatement(ps, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				page = new Page(rs.getInt("id"), rs.getString("name"), rs.getString("query"),
						rs.getString("input_column"), rs.getString("output_column"), rs.getInt("status"));
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			DBUtil.close(ps);
			// DBUtil.close(conn);
		}
		return page;
	}

	public List<Page> getAllPages() throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Page> pages = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(GetAllPages);
			rs = ps.executeQuery();
			while (rs.next()) {
				Page page = new Page(rs.getInt("id"), rs.getString("name"), rs.getString("query"),
						rs.getString("input_column"), rs.getString("output_column"), rs.getInt("status"));
				pages.add(page);
				System.out.println(page);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			// DBUtil.close(conn);
		}
		return pages;
	}
}