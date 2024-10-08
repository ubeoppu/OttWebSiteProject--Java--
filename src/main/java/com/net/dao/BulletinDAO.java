package com.net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.net.dto.BulletinVO;
import com.ott.util.DBManager;

public class BulletinDAO {

	private static BulletinDAO instance = new BulletinDAO();

	private BulletinDAO() {
	}

	public static BulletinDAO getInstance() {
		return instance;
	}
	
	public int getBulletinList() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from bulletin";
		
		int count = 0;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return count;
	}
	
	public List<BulletinVO> getAllBulletinList(int page, int limit) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from (select rownum rnum, bulletinNum "
				+ ", userId, name, bulletinTitle, bulletinDate, "
				+ " bulletinContent, readCount from "
				+ "(select * from bulletin order by bulletinNum desc)) "
				+ "where rnum >= ? and rnum <=?";
		
		List<BulletinVO> list = new ArrayList<BulletinVO>();

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			int startrow = (page-1)*limit +1;
			int endrow = startrow+limit-1;
			
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BulletinVO vo = new BulletinVO();

				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setName(rs.getString("name"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadCount(rs.getInt("readCount"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;
	}
	
	public List<BulletinVO> getAllBulletin() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BulletinVO> list = new ArrayList<BulletinVO>();

		String sql = "select * from bulletin order by bulletinNum desc";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BulletinVO vo = new BulletinVO();

				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setName(rs.getString("name"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadCount(rs.getInt("readCount"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;

	}

	public BulletinVO getOneBulletin(int bulletinNum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from bulletin where bulletinNum = ?";
		BulletinVO vo = new BulletinVO();

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bulletinNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setName(rs.getString("name"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getTimestamp("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadCount(rs.getInt("readCount"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;

	}
	
	public void deleteBulletin(int bulletinNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from bulletin where bulletinNum = ?";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bulletinNum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

		
	}
	
	

}
