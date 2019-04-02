package jp.entity;

public class User {

	private int id;
	private String useraccount;
	private String useridcare;
	private String username;
	private String password;
	private int sex;
	private String phone;
	private int money;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public String getUseridcare() {
		return useridcare;
	}
	public void setUseridcare(String useridcare) {
		this.useridcare = useridcare;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", useraccount=" + useraccount + ", useridcare=" + useridcare + ", username="
				+ username + ", password=" + password + ", sex=" + sex + ", phone=" + phone + ", money=" + money + "]";
	}
	
	
}
