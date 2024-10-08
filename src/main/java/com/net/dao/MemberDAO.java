package com.net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.net.dto.memberVO;
import com.ott.util.DBManager;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int getMemberList() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from member";
		
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
	
public List<memberVO> getAllMemberList(int page, int limit){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from "
				+ "(select rownum rnum, userId,admin, name, pwd, "
				+ "email, phone, address from "
				+ "(select * from member order by userId desc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		List<memberVO> list = new ArrayList<memberVO>();
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			int startrow = (page-1)*limit+1;
			int endrow = startrow+limit-1;

			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberVO vo = new memberVO();
				
				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserId(rs.getString("userId"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				
				list.add(vo);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		return list;
		
	}
	
	public List<memberVO> getAllMember(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member order by userId desc";
		
		List<memberVO> list = new ArrayList<memberVO>();
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberVO vo = new memberVO();
				
				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserId(rs.getString("userId"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				
				list.add(vo);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		return list;
		
	}
	
	public memberVO getOneMember(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where userId = ?";
		
		memberVO vo = new memberVO();
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserId(rs.getString("userId"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		return vo;
	}

	
	public void deleteMember(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
String sql = "delete from member where userId = ?";
		
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
		

		
	}
}
