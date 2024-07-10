package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Dvd;
import com.study.dvd.util.DBConnectionMgr;

public class DvdDao {
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static List<Dvd> searchDvdByTitle(String searchText) {
		List<Dvd> dvds = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from dvd_view "); // 띄어쓰기 잘 보기. view 뒤에도 띄어쓰기 하나 있어야  
			sql.append("where title like ? limit 0, 50"); // 다음줄에 표시할 단어와 이어지지 않는다 & setString을 사용하기 때문에 "" 가 들어가지 않는 구문을 사용
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(0, "%" + searchText + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Dvd dvd = Dvd.builder()
						.dvdId(rs.getInt(1))
						.registrationNumber(rs.getString(2))
						.title(rs.getString(3))
//						.producerId(rs.getInt(4))
						.producerName(rs.getString(5))
						.publisherId(rs.getInt(6))
						.publisherName(rs.getString(7))
						.publicationYear(rs.getInt(8))
						.databaseDate(rs.getDate(9).toLocalDate())
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return dvds;
	}
}
