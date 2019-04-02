package jp.entity;

public class Hangkonggongsi {
	
	private int id;
	private String hangkonggongsi;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHangkonggongsi() {
		return hangkonggongsi;
	}
	public void setHangkonggongsi(String hangkonggongsi) {
		this.hangkonggongsi = hangkonggongsi;
	}
	
	@Override
	public String toString() {
		return "Hangkonggongsi [id=" + id + ", hangkonggongsi=" + hangkonggongsi + "]";
	}
	
	

}
