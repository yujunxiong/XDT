package com.sell.util;

/**
 * @author 余俊雄
 *
 */
public class AccessToken {
	
	/**
	 * JWT生成的token
	 */
	private String access_token;
	
	private String token_type;
	/**
	 * token有效期
	 */
	private long expires_in;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	public AccessToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccessToken(String access_token, String token_type, long expires_in) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
	}
	
	public AccessToken(String access_token, String token_type) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
	}
	
}
