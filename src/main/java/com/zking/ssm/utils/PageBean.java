package com.zking.ssm.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * ��ҳ������
 *
 */
public class PageBean {

	// ��������
	private int page = 1;// ҳ��
	private int rows = 10;// ҳ��С
	private int total = 0;// �ܼ�¼��
	private boolean pagination = true;// �Ƿ��ҳ
	
	private String url;  //�����·��   ��Ŀ�� + �����action
	
	private Map<String,String[]> parameterMap; // �������
	

	public PageBean() {
		super();
	}
	
	
	/**
	 * ��pageBean���г�ʼ�� 
	 */
	public void setRequest(HttpServletRequest req) {
		String page  =  req.getParameter("page");
		String rows = req.getParameter("rows");
		String pagination = req.getParameter("pagination");
		this.setPage(page);
		this.setRows(rows);
		this.setPagination(pagination);
		this.url = req.getContextPath() + req.getServletPath();
		this.parameterMap = req.getParameterMap();
	}


	

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}


	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public void setPage(String page) {
		if(page!=null && !"".equals(page.trim())) {
			this.page = Integer.parseInt(page);
		}
	}

	

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setRows(String rows) {
		if (null != rows && !"".equals(rows.trim())) {
			this.rows = Integer.parseInt(rows);
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal(String total) {
		this.total = Integer.parseInt(total);
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public void setPagination(String pagination) {
		if (null != pagination && !"".equals(pagination.trim())) {
			this.pagination = Boolean.parseBoolean(pagination);
		}
	}

	/**
	 * �����ʼ��¼���±�
	 * 
	 * @return
	 */
	public int getStartIndex() {
		return (this.page - 1) * this.rows;
	}
	/**
	 * ������ҳ��
	 * @return
	 */
	public int getMaxPage() {
		int maxPage = this.total / this.rows;
		if(this.total % this.rows !=0) {
			maxPage++;
		}
		return maxPage;
	}
	
	/**
	 * �����һҳ
	 * @return
	 */
	public int getNextPage() {
		int nextPage =  this.page + 1;
		if(nextPage > this.getMaxPage()) {
			nextPage = this.getMaxPage();
		}
		return nextPage;
	}
	
	/**
	 * �����һҳ
	 * @return
	 */
	public int getPreviousPage() {
		int previousPage = this.page -1;
		if(previousPage <1) {
			previousPage = 1;
		}
		return previousPage;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
	}

}
