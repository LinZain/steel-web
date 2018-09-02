package com.boll6.steel.entity;


import javax.persistence.*;

/***************
 *author: autogen
 *version: 2018-09-02 20:01:22.198
 */
@Entity
@Table(name = "tb_wechatProduct",catalog = "steelweb")
public class TbWechatproduct implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	


    public static final String TABLE = "tb_wechatProduct";

    /** */
	public static final String ALIAS_ID = "id";
    /** */
	public static final String ALIAS_APP_ID = "app_id";
    /** */
	public static final String ALIAS_APP_PATH = "app_path";
    /** */
	public static final String ALIAS_BRAND = "brand";
    /** */
	public static final String ALIAS_PDT_TITLE = "pdt_title";
    /** */
	public static final String ALIAS_PDT_TYPE = "pdt_type";
    /** */
	public static final String ALIAS_PDT_PRICE = "pdt_price";
    /** */
	public static final String ALIAS_PIC_URL = "pic_url";
    /** */
	public static final String ALIAS_PDT_SOURCE = "pdt_source";
    /** */
	public static final String ALIAS_PDT_WEIGHT = "pdt_weight";
	
	

 	@Id
@   GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    public java.lang.Long id;
  
 	@Column(name = "app_id")
    public java.lang.String appId;
  
 	@Column(name = "app_path")
    public java.lang.String appPath;
  
 	@Column(name = "brand")
    public java.lang.String brand;
  
 	@Column(name = "pdt_title")
    public java.lang.String pdtTitle;
  
 	@Column(name = "pdt_type")
    public java.lang.String pdtType;
  
 	@Column(name = "pdt_price")
    public java.lang.String pdtPrice;
  
 	@Column(name = "pic_url")
    public java.lang.String picUrl;
  
 	@Column(name = "pdt_source")
    public java.lang.String pdtSource;
  
 	@Column(name = "pdt_weight")
    public java.lang.Long pdtWeight;
  





	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}

	public java.lang.String getAppId() {
		return this.appId;
	}
	
	public void setAppId(java.lang.String value) {
		this.appId = value;
	}

	public java.lang.String getAppPath() {
		return this.appPath;
	}
	
	public void setAppPath(java.lang.String value) {
		this.appPath = value;
	}

	public java.lang.String getBrand() {
		return this.brand;
	}
	
	public void setBrand(java.lang.String value) {
		this.brand = value;
	}

	public java.lang.String getPdtTitle() {
		return this.pdtTitle;
	}
	
	public void setPdtTitle(java.lang.String value) {
		this.pdtTitle = value;
	}

	public java.lang.String getPdtType() {
		return this.pdtType;
	}
	
	public void setPdtType(java.lang.String value) {
		this.pdtType = value;
	}

	public java.lang.String getPdtPrice() {
		return this.pdtPrice;
	}
	
	public void setPdtPrice(java.lang.String value) {
		this.pdtPrice = value;
	}

	public java.lang.String getPicUrl() {
		return this.picUrl;
	}
	
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}

	public java.lang.String getPdtSource() {
		return this.pdtSource;
	}
	
	public void setPdtSource(java.lang.String value) {
		this.pdtSource = value;
	}

	public java.lang.Long getPdtWeight() {
		return this.pdtWeight;
	}
	
	public void setPdtWeight(java.lang.Long value) {
		this.pdtWeight = value;
	}


	
	public TbWechatproduct() {
	}
	
	public TbWechatproduct(boolean qryflag) {
	    if(qryflag){
	    		this.id = null;
				this.appId = null;
				this.appPath = null;
				this.brand = null;
				this.pdtTitle = null;
				this.pdtType = null;
				this.pdtPrice = null;
				this.picUrl = null;
				this.pdtSource = null;
				this.pdtWeight = null;
			    }
	}


	public TbWechatproduct(
	    java.lang.Long inId,
	    java.lang.String inAppId,
	    java.lang.String inAppPath,
	    java.lang.String inBrand,
	    java.lang.String inPdtTitle,
	    java.lang.String inPdtType,
	    java.lang.String inPdtPrice,
	    java.lang.String inPicUrl,
	    java.lang.String inPdtSource,
		java.lang.Long inPdtWeight
	 ) {
		super();
				this.id = inId;
				this.appId = inAppId;
				this.appPath = inAppPath;
				this.brand = inBrand;
				this.pdtTitle = inPdtTitle;
				this.pdtType = inPdtType;
				this.pdtPrice = inPdtPrice;
				this.picUrl = inPicUrl;
				this.pdtSource = inPdtSource;
				this.pdtWeight = inPdtWeight;
			}





}

