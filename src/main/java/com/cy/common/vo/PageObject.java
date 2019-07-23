package com.cy.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable{

	private static final long serialVersionUID = 1451110109363856200L;
	/** 当前页的页码值 */
	private Integer pageCurrent = 1;
	/** 页面大小 */
	private Integer pageSize = 5;
	/** 总行数(通过查询获得) */
	private Integer rowCount = 0;
	/** 总页数(通过计算获得) */
	private Integer pageCount = 0;
	/** 当前页记录 */
	private List<T> records;
	
	public PageObject() {
	}
	
	public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageCount = (rowCount-1)/pageSize+1;
		this.records = records;
	}

	public Integer getPageCurrent() {
		return pageCurrent;
	}
	
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", rowCount=" + rowCount
				+ ", pageCount=" + pageCount + ", records=" + records + "]";
	}
	
}
