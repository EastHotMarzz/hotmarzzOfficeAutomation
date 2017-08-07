package com.hotmarzz.oa.pojo;

import java.util.Date;

public class Resource implements Comparable<Resource>{
	private Long resourceId;
	private ResourceType resourceType;
	private String remark;
	private String menuName;
	//父菜单
	private Resource parentMenu;
	private String menuPath;
	private String menuIcon;
	private Integer menuSort;
	private Integer menuLev;
	private String functionName;
	private String belongMenu;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public enum ResourceType{
		menu,function,element
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public ResourceType getResourceType() {
		return resourceType;
	}
	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Resource getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Resource parentMenu) {
		this.parentMenu = parentMenu;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public Integer getMenuSort() {
		return menuSort;
	}
	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}
	public Integer getMenuLev() {
		return menuLev;
	}
	public void setMenuLev(Integer menuLev) {
		this.menuLev = menuLev;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getBelongMenu() {
		return belongMenu;
	}
	public void setBelongMenu(String belongMenu) {
		this.belongMenu = belongMenu;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public boolean equals(Object obj) {
        if(this==obj)     return  true;
        if(null==obj)     return false;
        if(obj  instanceof  Resource){
        	Resource  r   =   (Resource) obj;
            if(this.resourceType.equals(r.getResourceType())&&this.resourceId.equals(r.getResourceId()))
	            return   true;
        }
        return  false;
}
	@Override
	public int compareTo(Resource o) {
		 if (o == null)
             return 1;
         return  this.menuSort - o.getMenuSort();
	}

}
