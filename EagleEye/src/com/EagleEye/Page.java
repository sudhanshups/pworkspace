package com.EagleEye;

public class Page {
	private Integer id;
	private String pageName;
	private String pageQuery;
	private String inputColumn;
	private String outputColumn;
	private Integer status;
	
	public Page(){ }
	
	public Page(int id, String pageName, String pageQuery,String inputColumn,String outputColumn,int status){
		super();
		this.id = id;
		this.pageName = pageName;
		this.pageQuery = pageQuery;
		this.inputColumn = inputColumn;
		this.outputColumn = outputColumn;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}	
	public String getPageQuery() {
		return pageQuery;
	}
	public void setPageQuery(String pageQuery) {
		this.pageQuery = pageQuery;
	}
	public String getInputColumn() {
		return inputColumn;
	}

	public void setInputColumn(String inputColumn) {
		this.inputColumn = inputColumn;
	}

	public String getOutputColumn() {
		return outputColumn;
	}

	public void setOutput_column(String outputColumn) {
		this.outputColumn = outputColumn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Page [id=" + id + ", pageName=" + pageName + ", pageQuery=" + pageQuery + ", inputColumn="
				+ inputColumn + ", outputColumn=" + outputColumn + ", status=" + status + "]";
	}

}
