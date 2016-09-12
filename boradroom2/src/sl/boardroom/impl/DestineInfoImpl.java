package sl.boardroom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sl.boardroom.dao.BaseDao;
import sl.boardroom.dao.DestineInfoDao;
import sl.boardroom.entity.DestineInfoEntity;

public class DestineInfoImpl extends BaseDao implements DestineInfoDao {

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public List<DestineInfoEntity> getAllInfoOrderByTime() {
		String sql = "SELECT * FROM destineinfo ORDER BY destine_time DESC";
		List<DestineInfoEntity> list = new ArrayList<DestineInfoEntity>();
		
		rs = exceuteQuery(sql,null);
		try {
			while (rs.next()) {
				DestineInfoEntity die = new DestineInfoEntity();
				die.setId(rs.getInt("id"));
				die.setRoom_name(rs.getString("room_name"));
				die.setDestine_time(rs.getDate("destine_time"));
				die.setDestine_name(rs.getString("destine_name"));
				list.add(die);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pst, rs);
		}
		return list;
	}

	public int addInfo(DestineInfoEntity die) {
		String sql = "INSERT INTO destineinfo VALUES(?,?,?)";
		Object[] params={die.getRoom_name(),die.getDestine_time(),die.getDestine_name()};
		return exceuteUpdate(sql, params);
	}
	
	

}
