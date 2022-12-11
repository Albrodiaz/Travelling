package es.travelworld.travelling.repository.response.hotels;

import com.google.gson.annotations.SerializedName;

public class Pagination{

	@SerializedName("nextPageGroup")
	private String nextPageGroup;

	@SerializedName("nextPageNumber")
	private int nextPageNumber;

	@SerializedName("pageGroup")
	private String pageGroup;

	@SerializedName("currentPage")
	private int currentPage;

	@SerializedName("nextPageStartIndex")
	private int nextPageStartIndex;

	public String getNextPageGroup(){
		return nextPageGroup;
	}

	public int getNextPageNumber(){
		return nextPageNumber;
	}

	public String getPageGroup(){
		return pageGroup;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	public int getNextPageStartIndex(){
		return nextPageStartIndex;
	}
}