package jp.entity;

public class Jipiao {
	
	private int id;
	private String chufadi;
	private String daodadi;
	private int piaojia;
	private String chufashijian;
	private String daodashijian;
	private String chufariqi;
	private Hangkonggongsi hangkonggongsi_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChufadi() {
		return chufadi;
	}
	public void setChufadi(String chufadi) {
		this.chufadi = chufadi;
	}
	public String getDaodadi() {
		return daodadi;
	}
	public void setDaodadi(String daodadi) {
		this.daodadi = daodadi;
	}
	public int getPiaojia() {
		return piaojia;
	}
	public void setPiaojia(int piaojia) {
		this.piaojia = piaojia;
	}
	public String getChufashijian() {
		return chufashijian;
	}
	public void setChufashijian(String chufashijian) {
		this.chufashijian = chufashijian;
	}
	public String getDaodashijian() {
		return daodashijian;
	}
	public void setDaodashijian(String daodashijian) {
		this.daodashijian = daodashijian;
	}
	public String getChufariqi() {
		return chufariqi;
	}
	public void setChufariqi(String chufariqi) {
		this.chufariqi = chufariqi;
	}
	public Hangkonggongsi getHangkonggongsi_id() {
		return hangkonggongsi_id;
	}
	public void setHangkonggongsi_id(Hangkonggongsi hangkonggongsi_id) {
		this.hangkonggongsi_id = hangkonggongsi_id;
	}
	
	@Override
	public String toString() {
		return "Jipiao [id=" + id + ", chufadi=" + chufadi + ", daodadi=" + daodadi + ", piaojia=" + piaojia
				+ ", chufashijian=" + chufashijian + ", daodashijian=" + daodashijian + ", chufariqi=" + chufariqi
				+ ", hangkonggongsi_id=" + hangkonggongsi_id + "]";
	}
	
	
	
}
