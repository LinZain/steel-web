package com.boll6.steel.entity;


import javax.persistence.*;

/***************
 *author: autogen
 *version: 2018-09-28 17:30:09.01
 */
@Entity
@Table(name = "tb_user",catalog = "steelweb")
public class TbUser implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	


    public static final String TABLE = "tb_user";

    /** */
	public static final String ALIAS_USER_ID = "user_id";
    /** */
	public static final String ALIAS_LOGIN_NAME = "login_name";
    /** */
	public static final String ALIAS_PASSWORD = "password";
    /** */
	public static final String ALIAS_ROLE = "role";
    /** */
	public static final String ALIAS_PERMISSION = "permission";
    /** */
	public static final String ALIAS_NICK_NAME = "nick_name";
    /** */
	public static final String ALIAS_ICON_PIC = "icon_pic";
    /** */
	public static final String ALIAS_GROUP_ID = "group_id";
    /** */
	public static final String ALIAS_LOGIN_TIME = "login_time";
	
	

 	@Id
@   GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
    public java.lang.Long userId;
  
 	@Column(name = "login_name")
    public java.lang.String loginName;
  
 	@Column(name = "password")
    public java.lang.String password = "123456";
  
 	@Column(name = "role")
    public java.lang.String role = "admin";
  
 	@Column(name = "permission")
    public java.lang.Integer permission = 1;
  
 	@Column(name = "nick_name")
    public java.lang.String nickName;
  
 	@Column(name = "icon_pic")
    public java.lang.String iconPic;
  
 	@Column(name = "group_id")
    public java.lang.Long groupId;
  
 	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "login_time")
    public java.util.Date loginTime;
  





	public java.lang.Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}

	public java.lang.String getLoginName() {
		return this.loginName;
	}
	
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}

	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}

	public java.lang.String getRole() {
		return this.role;
	}
	
	public void setRole(java.lang.String value) {
		this.role = value;
	}

	public java.lang.Integer getPermission() {
		return this.permission;
	}
	
	public void setPermission(java.lang.Integer value) {
		this.permission = value;
	}

	public java.lang.String getNickName() {
		return this.nickName;
	}
	
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}

	public java.lang.String getIconPic() {
		return this.iconPic;
	}
	
	public void setIconPic(java.lang.String value) {
		this.iconPic = value;
	}

	public java.lang.Long getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(java.lang.Long value) {
		this.groupId = value;
	}

	public java.util.Date getLoginTime() {
		return this.loginTime;
	}
	
	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}


	
	public TbUser() {
	}
	
	public TbUser(boolean qryflag) {
	    if(qryflag){
	    		this.userId = null;
				this.loginName = null;
				this.password = null;
				this.role = null;
				this.permission = null;
				this.nickName = null;
				this.iconPic = null;
				this.groupId = null;
				this.loginTime = null;
			    }
	}


	public TbUser(
	    java.lang.Long inUserId,
	    java.lang.String inLoginName,
	    java.lang.String inPassword,
	    java.lang.String inRole,
	    java.lang.Integer inPermission,
	    java.lang.String inNickName,
	    java.lang.String inIconPic,
	    java.lang.Long inGroupId,
		java.util.Date inLoginTime
	 ) {
		super();
				this.userId = inUserId;
				this.loginName = inLoginName;
				this.password = inPassword;
				this.role = inRole;
				this.permission = inPermission;
				this.nickName = inNickName;
				this.iconPic = inIconPic;
				this.groupId = inGroupId;
				this.loginTime = inLoginTime;
			}





}

