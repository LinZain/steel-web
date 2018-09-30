package com.boll6.steel.entity;


import javax.persistence.*;

/***************
 *author: autogen
 *version: 2018-09-28 17:31:30.592
 */
@Entity
@Table(name = "tb_infomation",catalog = "steelweb")
public class TbInfomation implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	


    public static final String TABLE = "tb_infomation";

    /** */
	public static final String ALIAS_INFO_ID = "info_id";
    /** */
	public static final String ALIAS_USER_ID = "user_id";
    /** */
	public static final String ALIAS_INFO_TAG = "info_tag";
    /** */
	public static final String ALIAS_INFO_WEIGHT = "info_weight";
    /** */
	public static final String ALIAS_FOR_APP = "for_app";
    /** */
	public static final String ALIAS_CONTACT_NAME = "contact_name";
    /** */
	public static final String ALIAS_VALIDITY_DATE = "validity_date";
    /** */
	public static final String ALIAS_INFO_ADDRESS = "info_address";
    /** */
	public static final String ALIAS_INFO_CONTENT = "info_content";
    /** */
	public static final String ALIAS_INFO_PIC = "info_pic";
    /** */
	public static final String ALIAS_CONTACT_PHONE = "contact_phone";
    /** */
	public static final String ALIAS_VIEW_COUNT = "view_count";
    /** */
	public static final String ALIAS_LAST_UPDATE = "last_update";
    /** */
	public static final String ALIAS_INFO_STATUS = "info_status";
	
	

 	@Id
@   GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id", unique = true, nullable = false)
    public java.lang.Long infoId;
  
 	@Column(name = "user_id")
    public java.lang.Long userId;
  
 	@Column(name = "info_tag")
    public java.lang.Integer infoTag;
  
 	@Column(name = "info_weight")
    public java.lang.Integer infoWeight;
  
 	@Column(name = "for_app")
    public java.lang.String forApp;
  
 	@Column(name = "contact_name")
    public java.lang.String contactName;
  
 	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validity_date")
    public java.util.Date validityDate;
  
 	@Column(name = "info_address")
    public java.lang.String infoAddress;
  
 	@Column(name = "info_content")
    public java.lang.String infoContent;
  
 	@Column(name = "info_pic")
    public java.lang.String infoPic;
  
 	@Column(name = "contact_phone")
    public java.lang.String contactPhone;
  
 	@Column(name = "view_count")
    public java.lang.Long viewCount = 0l;
  
 	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
    public java.util.Date lastUpdate;
  
 	@Column(name = "info_status")
    public java.lang.Integer infoStatus;
  





	public java.lang.Long getInfoId() {
		return this.infoId;
	}
	
	public void setInfoId(java.lang.Long value) {
		this.infoId = value;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}

	public java.lang.Integer getInfoTag() {
		return this.infoTag;
	}
	
	public void setInfoTag(java.lang.Integer value) {
		this.infoTag = value;
	}

	public java.lang.Integer getInfoWeight() {
		return this.infoWeight;
	}
	
	public void setInfoWeight(java.lang.Integer value) {
		this.infoWeight = value;
	}

	public java.lang.String getForApp() {
		return this.forApp;
	}
	
	public void setForApp(java.lang.String value) {
		this.forApp = value;
	}

	public java.lang.String getContactName() {
		return this.contactName;
	}
	
	public void setContactName(java.lang.String value) {
		this.contactName = value;
	}

	public java.util.Date getValidityDate() {
		return this.validityDate;
	}
	
	public void setValidityDate(java.util.Date value) {
		this.validityDate = value;
	}

	public java.lang.String getInfoAddress() {
		return this.infoAddress;
	}
	
	public void setInfoAddress(java.lang.String value) {
		this.infoAddress = value;
	}

	public java.lang.String getInfoContent() {
		return this.infoContent;
	}
	
	public void setInfoContent(java.lang.String value) {
		this.infoContent = value;
	}

	public java.lang.String getInfoPic() {
		return this.infoPic;
	}
	
	public void setInfoPic(java.lang.String value) {
		this.infoPic = value;
	}

	public java.lang.String getContactPhone() {
		return this.contactPhone;
	}
	
	public void setContactPhone(java.lang.String value) {
		this.contactPhone = value;
	}

	public java.lang.Long getViewCount() {
		return this.viewCount;
	}
	
	public void setViewCount(java.lang.Long value) {
		this.viewCount = value;
	}

	public java.util.Date getLastUpdate() {
		return this.lastUpdate;
	}
	
	public void setLastUpdate(java.util.Date value) {
		this.lastUpdate = value;
	}

	public java.lang.Integer getInfoStatus() {
		return this.infoStatus;
	}
	
	public void setInfoStatus(java.lang.Integer value) {
		this.infoStatus = value;
	}


	
	public TbInfomation() {
	}
	
	public TbInfomation(boolean qryflag) {
	    if(qryflag){
	    		this.infoId = null;
				this.userId = null;
				this.infoTag = null;
				this.infoWeight = null;
				this.forApp = null;
				this.contactName = null;
				this.validityDate = null;
				this.infoAddress = null;
				this.infoContent = null;
				this.infoPic = null;
				this.contactPhone = null;
				this.viewCount = null;
				this.lastUpdate = null;
				this.infoStatus = null;
			    }
	}


	public TbInfomation(
	    java.lang.Long inInfoId,
	    java.lang.Long inUserId,
	    java.lang.Integer inInfoTag,
	    java.lang.Integer inInfoWeight,
	    java.lang.String inForApp,
	    java.lang.String inContactName,
	    java.util.Date inValidityDate,
	    java.lang.String inInfoAddress,
	    java.lang.String inInfoContent,
	    java.lang.String inInfoPic,
	    java.lang.String inContactPhone,
	    java.lang.Long inViewCount,
	    java.util.Date inLastUpdate,
		java.lang.Integer inInfoStatus
	 ) {
		super();
				this.infoId = inInfoId;
				this.userId = inUserId;
				this.infoTag = inInfoTag;
				this.infoWeight = inInfoWeight;
				this.forApp = inForApp;
				this.contactName = inContactName;
				this.validityDate = inValidityDate;
				this.infoAddress = inInfoAddress;
				this.infoContent = inInfoContent;
				this.infoPic = inInfoPic;
				this.contactPhone = inContactPhone;
				this.viewCount = inViewCount;
				this.lastUpdate = inLastUpdate;
				this.infoStatus = inInfoStatus;
			}





}

