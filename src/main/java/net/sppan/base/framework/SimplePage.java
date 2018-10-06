package net.sppan.base.framework;

import java.io.Serializable;

/**
 * 简单分页
 */
public class SimplePage implements Pageable, Serializable {
	private static final long serialVersionUID = 1L;

	protected int totalCount = 0;
	protected int pageSize = 10;
	protected int pageNo = 1;

	@SuppressWarnings("unused")
	private long startRowNum;
	@SuppressWarnings("unused")
	private long endRowNum;

	public static final int DEF_COUNT = 10;

	public SimplePage() {
	}

	public SimplePage(int pageNo, int totalCount) {
		this(pageNo, DEF_COUNT, totalCount);
	}

	public SimplePage(int pageNo, int pageSize, int totalCount) {
		if (totalCount <= 0) {
			this.totalCount = 0;
		} else {
			this.totalCount = totalCount;
		}
		if (pageSize <= 0) {
			this.pageSize = DEF_COUNT;
		} else {
			this.pageSize = pageSize;
		}
		if (pageNo <= 0) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
		if ((this.pageNo - 1) * this.pageSize >= totalCount) {
			this.pageNo = (int) (totalCount / this.pageSize);
		}
	}

	/**
	 * 调整分页参数，使合理化
	 */
	public void adjustPage() {
		if (totalCount <= 0) {
			totalCount = 0;
		}
		if (pageSize <= 0) {
			pageSize = DEF_COUNT;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if ((pageNo - 1) * pageSize >= totalCount) {
			pageNo = (int) (totalCount / pageSize);
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		int totalPage = (int) (totalCount / pageSize);
		if (totalCount % pageSize != 0 || totalPage == 0) {
			totalPage++;
		}
		return totalPage;
	}

	public boolean isFirstPage() {
		return pageNo <= 1;
	}

	public boolean isLastPage() {
		return pageNo >= getTotalPage();
	}

	public int getNextPage() {
		if (isLastPage()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}

	public int getPrePage() {
		if (isFirstPage()) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 返回当前页首行行号
	 * 
	 * @return
	 */
	public long getStartRowNum() {
		long rowNum = (pageNo - 1) * pageSize;
		return rowNum > 0 ? rowNum : 0;
	}

	public void setStartRowNum(long startRowNum) {
		this.startRowNum = startRowNum;
	}

	/**
	 * 返回当前页结束行号
	 * 
	 * @return
	 */
	public long getEndRowNum() {
		return (pageNo - 1) * pageSize + pageSize + 1;
	}

	public void setEndRowNum(long endRowNum) {
		this.endRowNum = endRowNum;
	}
}