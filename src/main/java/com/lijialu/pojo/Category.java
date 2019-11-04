package com.lijialu.pojo;

import java.util.List;

/**
 * 分类模块的实体类
 * 
 * @author qdmmy6
 * 
 */
public class Category {
	private String cid;// 主键
	private String cname;// 分类名称
	private Category parent;// 父分�?
	private String desc;// 分类描述
	private List<Category> children;// 子分�?
	private String pid;
	private String orderBy;
	
	public Category() {
		super();
	}

	public Category(String cid, String cname, String desc, String pid, String orderBy) {
		this.cid = cid;
		this.cname = cname;
		this.desc = desc;
		this.pid = pid;
		this.orderBy = orderBy;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}
}
