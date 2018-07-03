package com.gpnu.entity;

public class Page {
	
	private int pageNow;
	
	private int rowCount;
	
	private int pageCount;
	
	private int row;

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", rowCount=" + rowCount + ", pageCount=" + pageCount + ", row=" + row
				+ "]";
	}

}
