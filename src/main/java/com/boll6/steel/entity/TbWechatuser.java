package com.boll6.steel.entity;


import javax.persistence.*;

/***************
 *author: autogen
 *version: 2018-09-28 17:30:40.006
 */
@Entity
@Table(name = "tb_wechatUser",catalog = "steelweb")
public class TbWechatuser implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	


    public static final String TABLE = "tb_wechatUser";

    /** */
	public static final String ALIAS_USER_ID = "user_id";
    /** */
	public static final String ALIAS_TO_ID = "to_id";
    /** */
	public static final String ALIAS_LOGIN_NAME = "login_name";
    /** */
	public static final String ALIAS_PASSWORD = "password";
    /** */
	public static final String ALIAS_NICK_NAME = "nick_name";
    /** */
	public static final String ALIAS_REAL_NAME = "real_name";
    /** */
	public static final String ALIAS_MOBILE = "mobile";
    /** */
	public static final String ALIAS_EMAIL = "email";
    /** */
	public static final String ALIAS_GEN_TIME = "gen_time";
    /** */
	public static final String ALIAS_LOGIN_TIME = "login_time";
    /** */
	public static final String ALIAS_COUNT = "count";
    /** */
	public static final String ALIAS_SOURCE = "source";
    /** */
	public static final String ALIAS_ADDRESS = "address";
    /** */
	public static final String ALIAS_OPEN_ID = "open_id";
    /** */
	public static final String ALIAS_GENDER = "gender";
    /** */
	public static final String ALIAS_SLOGAN = "slogan";
    /** */
	public static final String ALIAS_AVATARURL = "avatarUrl";
    /** */
	public static final String ALIAS_COMPANY = "company";
    /** */
	public static final String ALIAS_POSITION = "position";
	
	

 	@Id
@   GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
    public java.lang.Long userId;
  
 	@Column(name = "to_id")
    public java.lang.Long toId = 1l;
  
 	@Column(name = "login_name")
    public java.lang.String loginName;
  
 	@Column(name = "password")
    public java.lang.String password;
  
 	@Column(name = "nick_name")
    public java.lang.String nickName;
  
 	@Column(name = "real_name")
    public java.lang.String realName;
  
 	@Column(name = "mobile")
    public java.lang.String mobile;
  
 	@Column(name = "email")
    public java.lang.String email;
  
 	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "gen_time")
    public java.util.Date genTime;
  
 	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "login_time")
    public java.util.Date loginTime;
  
 	@Column(name = "count")
    public java.lang.Long count = 30l;
  
 	@Column(name = "source")
    public java.lang.String source;
  
 	@Column(name = "address")
    public java.lang.String address;
  
 	@Column(name = "open_id")
    public java.lang.String openId;
  
 	@Column(name = "gender")
    public java.lang.Long gender = 0l;
  
 	@Column(name = "slogan")
    public java.lang.String slogan;

 	@Column(name = "avatarUrl")
    public java.lang.String avatarurl;

 	@Column(name = "company")
    public java.lang.String company;

 	@Column(name = "position")
    public java.lang.String position;






	public java.lang.Long getUserId() {
		return this.userId;
	}

	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}

	public java.lang.Long getToId() {
		return this.toId;
	}

	public void setToId(java.lang.Long value) {
		this.toId = value;
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

	public java.lang.String getNickName() {
		return this.nickName;
	}

	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}

	public java.lang.String getRealName() {
		return this.realName;
	}

	public void setRealName(java.lang.String value) {
		this.realName = value;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}

	public java.lang.String getEmail() {
		return this.email;
	}

	public void setEmail(java.lang.String value) {
		this.email = value;
	}

	public java.util.Date getGenTime() {
		return this.genTime;
	}

	public void setGenTime(java.util.Date value) {
		this.genTime = value;
	}

	public java.util.Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}

	public java.lang.Long getCount() {
		return this.count;
	}

	public void setCount(java.lang.Long value) {
		this.count = value;
	}

	public java.lang.String getSource() {
		return this.source;
	}

	public void setSource(java.lang.String value) {
		this.source = value;
	}

	public java.lang.String getAddress() {
		return this.address;
	}

	public void setAddress(java.lang.String value) {
		this.address = value;
	}

	public java.lang.String getOpenId() {
		return this.openId;
	}

	public void setOpenId(java.lang.String value) {
		this.openId = value;
	}

	public java.lang.Long getGender() {
		return this.gender;
	}

	public void setGender(java.lang.Long value) {
		this.gender = value;
	}

	public java.lang.String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(java.lang.String value) {
		this.slogan = value;
	}

	public java.lang.String getAvatarurl() {
		return this.avatarurl;
	}

	public void setAvatarurl(java.lang.String value) {
		this.avatarurl = value;
	}

	public java.lang.String getCompany() {
		return this.company;
	}

	public void setCompany(java.lang.String value) {
		this.company = value;
	}

	public java.lang.String getPosition() {
		return this.position;
	}

	public void setPosition(java.lang.String value) {
		this.position = value;
	}



	public TbWechatuser() {
	}

	public TbWechatuser(boolean qryflag) {
	    if(qryflag){
	    		this.userId = null;
				this.toId = null;
				this.loginName = null;
				this.password = null;
				this.nickName = null;
				this.realName = null;
				this.mobile = null;
				this.email = null;
				this.genTime = null;
				this.loginTime = null;
				this.count = null;
				this.source = null;
				this.address = null;
				this.openId = null;
				this.gender = null;
				this.slogan = null;
				this.avatarurl = null;
				this.company = null;
				this.position = null;
			    }
	}


	public TbWechatuser(
	    java.lang.Long inUserId,
	    java.lang.Long inToId,
	    java.lang.String inLoginName,
	    java.lang.String inPassword,
	    java.lang.String inNickName,
	    java.lang.String inRealName,
	    java.lang.String inMobile,
	    java.lang.String inEmail,
	    java.util.Date inGenTime,
	    java.util.Date inLoginTime,
	    java.lang.Long inCount,
	    java.lang.String inSource,
	    java.lang.String inAddress,
	    java.lang.String inOpenId,
	    java.lang.Long inGender,
	    java.lang.String inSlogan,
	    java.lang.String inAvatarurl,
	    java.lang.String inCompany,
		java.lang.String inPosition
	 ) {
		super();
				this.userId = inUserId;
				this.toId = inToId;
				this.loginName = inLoginName;
				this.password = inPassword;
				this.nickName = inNickName;
				this.realName = inRealName;
				this.mobile = inMobile;
				this.email = inEmail;
				this.genTime = inGenTime;
				this.loginTime = inLoginTime;
				this.count = inCount;
				this.source = inSource;
				this.address = inAddress;
				this.openId = inOpenId;
				this.gender = inGender;
				this.slogan = inSlogan;
				this.avatarurl = inAvatarurl;
				this.company = inCompany;
				this.position = inPosition;
			}





}

