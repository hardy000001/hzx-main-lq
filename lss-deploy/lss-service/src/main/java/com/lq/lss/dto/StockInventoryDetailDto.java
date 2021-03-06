package com.lq.lss.dto;


/**
 *
 * @author  作者: hzx
 * @date 创建时间: 2016-12-29 13:26:15
 */
public class StockInventoryDetailDto{

	
	/** id**/
    private String id;
	/** 盘点单据流水号**/
    private String inventorySerialno;
	/** 物资编号 b_material_info.code**/
    private String materialcode;
	/** 账面库存总数量  **/
    private String accTotalS;
	/** 实际库存总数量  **/
    private String realTotalS;
	/** 差异率  差异数量/账面数量**/
    private String diffrate;
	/** 单位**/
    private String unit;
	/** 备注**/
    private String remark;

    private String name;
    private String fname;
    private String typeId;
    private String covertRatio;
    private String accountFlag;
    private String totalM;
	
   /**
    * 获取属性:id
    * id
    * @return id
    */
   public String getId() {
       return id;
   }
   /**
    * 设置属性:id
    * id
    * @param id
    */
   public void setId(String id) {
       this.id = id;
   }
	
   /**
    * 获取属性:inventorySerialno
    * 盘点单据流水号
    * @return inventorySerialno
    */
   public String getInventorySerialno() {
       return inventorySerialno;
   }
   /**
    * 设置属性:inventorySerialno
    * 盘点单据流水号
    * @param inventorySerialno
    */
   public void setInventorySerialno(String inventorySerialno) {
       this.inventorySerialno = inventorySerialno;
   }
	
   /**
    * 获取属性:materialcode
    * 物资编号 b_material_info.code
    * @return materialcode
    */
   public String getMaterialcode() {
       return materialcode;
   }
   /**
    * 设置属性:materialcode
    * 物资编号 b_material_info.code
    * @param materialcode
    */
   public void setMaterialcode(String materialcode) {
       this.materialcode = materialcode;
   }
	
   /**
    * 获取属性:accTotalS
    * 账面库存总数量  
    * @return accTotalS
    */
   public String getAccTotalS() {
       return accTotalS;
   }
   /**
    * 设置属性:accTotalS
    * 账面库存总数量  
    * @param accTotalS
    */
   public void setAccTotalS(String accTotalS) {
       this.accTotalS = accTotalS;
   }
	
   /**
    * 获取属性:realTotalS
    * 实际库存总数量  
    * @return realTotalS
    */
   public String getRealTotalS() {
       return realTotalS;
   }
   /**
    * 设置属性:realTotalS
    * 实际库存总数量  
    * @param realTotalS
    */
   public void setRealTotalS(String realTotalS) {
       this.realTotalS = realTotalS;
   }
	
   /**
    * 获取属性:diffrate
    * 差异率  差异数量/账面数量
    * @return diffrate
    */
   public String getDiffrate() {
       return diffrate;
   }
   /**
    * 设置属性:diffrate
    * 差异率  差异数量/账面数量
    * @param diffrate
    */
   public void setDiffrate(String diffrate) {
       this.diffrate = diffrate;
   }
	
   /**
    * 获取属性:unit
    * 单位
    * @return unit
    */
   public String getUnit() {
       return unit;
   }
   /**
    * 设置属性:unit
    * 单位
    * @param unit
    */
   public void setUnit(String unit) {
       this.unit = unit;
   }
	
   /**
    * 获取属性:remark
    * 备注
    * @return remark
    */
   public String getRemark() {
       return remark;
   }
   /**
    * 设置属性:remark
    * 备注
    * @param remark
    */
   public void setRemark(String remark) {
       this.remark = remark;
   }
   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getCovertRatio() {
		return covertRatio;
	}
	public void setCovertRatio(String covertRatio) {
		this.covertRatio = covertRatio;
	}
	public String getAccountFlag() {
		return accountFlag;
	}
	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}
	public String getTotalM() {
		return totalM;
	}
	public void setTotalM(String totalM) {
		this.totalM = totalM;
	}
    
}