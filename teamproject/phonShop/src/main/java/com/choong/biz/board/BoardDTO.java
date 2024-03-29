package com.choong.biz.board;

import java.util.Date;

public class BoardDTO {
	private int boardNumber;
	private String boardTitle;
	private String boardCategory;
	private String boardContent;
	private String boardImage;
	private String boardUser;
	private Date boardDate;
	
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardImage() {
		return boardImage;
	}
	public void setBoardImage(String boardImage) {
		this.boardImage = boardImage;
	}
	public String getBoardUser() {
		return boardUser;
	}
	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	
	@Override
	public String toString() {
		return "BoardDTO [boardNumber=" + boardNumber + ", boardTitle=" + boardTitle + ", boardCategory="
				+ boardCategory + ", boardContent=" + boardContent + ", boardImage=" + boardImage + ", boardUser="
				+ boardUser + ", boardDate=" + boardDate + "]";
	}
}
