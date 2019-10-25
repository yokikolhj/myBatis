package com.shirly.data.general;

public class MenuTypeInfo {
	
    private Integer menuId;
    
    private String mName;
    
    private Integer mtId;

    public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Integer getMtId() {
		return mtId;
	}

	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Float offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	private Float price;

    private Float offerPrice;

    private String url;
    
    private String typeName;
}