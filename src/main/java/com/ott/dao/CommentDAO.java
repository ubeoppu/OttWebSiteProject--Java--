package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ott.dto.CommentVO;
import com.ott.util.DBManager;

public class CommentDAO {

	private static CommentDAO instance = new CommentDAO();
	
	public CommentDAO() {}
	
	public static CommentDAO getInstance() {
		return instance;
	}
	
   public void insertComment(int bulletinNum, String commentContent,  String userId) {
         
         Connection con = null;
         PreparedStatement pstmt = null;
         
         String sql = "insert into comments(bulletinNum ,commentNum, commentContent, userid) values(?, comments_seq.nextval, ?, ?)";
         
         try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, bulletinNum);
            pstmt.setString(2, commentContent);
            pstmt.setString(3, userId);
            
            pstmt.executeUpdate();
            
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            DBManager.close(con, pstmt);
         }
      }

	
	public void updateComment(CommentVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "udpate comments set commentContent=? where commentNum=?";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCommentContent());
			pstmt.setInt(2, vo.getCommentNum());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
	}
	
	public void deleteComment(int commentNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from comments where commentNum=?";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNum);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
	}
	
	public List<CommentVO> getComments(int bulletinNum){
	      List<CommentVO> list = new ArrayList<CommentVO>();
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "select * from comments where bulletinNum = ? order by commentNum desc";
	      try {
	         con = DBManager.getConnection();
	         
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, bulletinNum);
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            CommentVO vo = new CommentVO();
	            
	            vo.setCommentContent(rs.getString("commentContent"));
	            vo.setCommentDate(rs.getTimestamp("commentDate"));
	            vo.setUserId(rs.getString("UserId"));
	            
	            list.add(vo);
	         }
	         System.out.println("댓글리스트>>" + list);
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(con, pstmt, rs);
	      }
	      
	      
	      return list;
	   }
	
}
