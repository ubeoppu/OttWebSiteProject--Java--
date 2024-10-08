package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ott.dto.ContentVO;
import com.ott.util.DBManager;

public class ContentDAO {

	private static ContentDAO instance = new ContentDAO();
	
	private ContentDAO() {}
	
	private static ContentDAO getInstance() {
		return instance;
	}
	
	public int getContentList() {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "select count(*) from content";
	      int count=0; 
	      
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
	   
	   public List<ContentVO> getAllContentList(int page, int limit) {

	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      List<ContentVO> list = new ArrayList<ContentVO>();

	      String sql = "select * from (select rownum rnum, contentNum, "
	            + "contentName, genre, actor, year, story, poster, director "
	            + "from (select * from content order by contentNum desc)) "
	            + "where rnum >=? and rnum <= ?";

	      try {
	         con = DBManager.getConnection();
	         pstmt = con.prepareStatement(sql);
	         
	         int startrow = (page - 1)*limit+1;
	         int endrow = startrow+limit-1;
	         
	         pstmt.setInt(1, startrow);
	         pstmt.setInt(2, endrow);
	         
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	            ContentVO vo = new ContentVO();

	            vo.setContentNum(rs.getInt("contentNum"));
	            vo.setContentName(rs.getString("contentName"));
	            vo.setGenre(rs.getString("genre"));
	            vo.setActor(rs.getString("actor"));
	            vo.setYear(rs.getInt("year"));
	            vo.setStory(rs.getString("story"));
	            vo.setPoster(rs.getString("poster"));
	            vo.setDirector(rs.getString("director"));

	            list.add(vo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(con, pstmt, rs);
	      }

	      return list;
	   }
	
}
