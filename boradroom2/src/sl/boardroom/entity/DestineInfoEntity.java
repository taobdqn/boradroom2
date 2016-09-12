package sl.boardroom.entity;

import java.sql.Date;

public class DestineInfoEntity {
	private int id;
	private String room_name;
	private Date destine_time;
	private String destine_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public Date getDestine_time() {
		return destine_time;
	}
	public void setDestine_time(Date destine_time) {
		this.destine_time = destine_time;
	}
	public String getDestine_name() {
		return destine_name;
	}
	public void setDestine_name(String destine_name) {
		this.destine_name = destine_name;
	}
	
	

}
