package com.boll6.steel.entity;


import javax.persistence.*;

/***************
 *author: autogen
 *version: 2018-09-02 19:51:50.338
 */
@Entity
@Table(name = "tb_marketPrice",catalog = "steelweb")
public class TbMarketprice implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	


    public static final String TABLE = "tb_marketPrice";

    /** */
	public static final String ALIAS_PRICE_NAME = "price_name";
    /** */
	public static final String ALIAS_PRICE_RANGE = "price_range";
    /** */
	public static final String ALIAS_PRICE_AVERAGE = "price_average";
    /** */
	public static final String ALIAS_UNIT = "unit";
    /** */
	public static final String ALIAS_APPLIES = "applies";
    /** */
	public static final String ALIAS_PRICE_DATE = "price_date";
    /** */
	public static final String ALIAS_TASK_DATE = "task_date";
    /** */
	public static final String ALIAS_TASK_TYPE = "task_type";
    /** */
	public static final String ALIAS_TASK_ID = "task_id";
	
	

 	@Column(name = "price_name")
    public java.lang.String priceName;
  
 	@Column(name = "price_range")
    public java.lang.String priceRange;
  
 	@Column(name = "price_average")
    public java.lang.String priceAverage;
  
 	@Column(name = "unit")
    public java.lang.String unit;
  
 	@Column(name = "applies")
    public java.lang.String applies;
  
 	@Column(name = "price_date")
    public java.lang.String priceDate;
  
 	@Column(name = "task_date")
    public java.lang.String taskDate;
  
 	@Column(name = "task_type")
    public java.lang.String taskType;
  
 	@Id
@   GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id", unique = true, nullable = false)
    public java.lang.Long taskId;
  





	public java.lang.String getPriceName() {
		return this.priceName;
	}
	
	public void setPriceName(java.lang.String value) {
		this.priceName = value;
	}

	public java.lang.String getPriceRange() {
		return this.priceRange;
	}
	
	public void setPriceRange(java.lang.String value) {
		this.priceRange = value;
	}

	public java.lang.String getPriceAverage() {
		return this.priceAverage;
	}
	
	public void setPriceAverage(java.lang.String value) {
		this.priceAverage = value;
	}

	public java.lang.String getUnit() {
		return this.unit;
	}
	
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}

	public java.lang.String getApplies() {
		return this.applies;
	}
	
	public void setApplies(java.lang.String value) {
		this.applies = value;
	}

	public java.lang.String getPriceDate() {
		return this.priceDate;
	}
	
	public void setPriceDate(java.lang.String value) {
		this.priceDate = value;
	}

	public java.lang.String getTaskDate() {
		return this.taskDate;
	}
	
	public void setTaskDate(java.lang.String value) {
		this.taskDate = value;
	}

	public java.lang.String getTaskType() {
		return this.taskType;
	}
	
	public void setTaskType(java.lang.String value) {
		this.taskType = value;
	}

	public java.lang.Long getTaskId() {
		return this.taskId;
	}
	
	public void setTaskId(java.lang.Long value) {
		this.taskId = value;
	}


	
	public TbMarketprice() {
	}
	
	public TbMarketprice(boolean qryflag) {
	    if(qryflag){
	    		this.priceName = null;
				this.priceRange = null;
				this.priceAverage = null;
				this.unit = null;
				this.applies = null;
				this.priceDate = null;
				this.taskDate = null;
				this.taskType = null;
				this.taskId = null;
			    }
	}


	public TbMarketprice(
	    java.lang.String inPriceName,
	    java.lang.String inPriceRange,
	    java.lang.String inPriceAverage,
	    java.lang.String inUnit,
	    java.lang.String inApplies,
	    java.lang.String inPriceDate,
	    java.lang.String inTaskDate,
	    java.lang.String inTaskType,
		java.lang.Long inTaskId
	 ) {
		super();
				this.priceName = inPriceName;
				this.priceRange = inPriceRange;
				this.priceAverage = inPriceAverage;
				this.unit = inUnit;
				this.applies = inApplies;
				this.priceDate = inPriceDate;
				this.taskDate = inTaskDate;
				this.taskType = inTaskType;
				this.taskId = inTaskId;
			}





}

