package com.choong.biz.board;

import java.util.Date;

public class BoardFaqDTO {
	private int boardFaqNumber;
	private String boardFaqTitle;
	private String boardFaqContent;
	private String boardFaqUser;
	
	@Override
	public String toString() {
		return "BoardFaqDTO [boardFaqNumber=" + boardFaqNumber + ", boardFaqTitle=" + boardFaqTitle
				+ ", boardFaqContent=" + boardFaqContent + ", boardFaqUser=" + boardFaqUser + "]";
	}
	public int getBoardFaqNumber() {
		return boardFaqNumber;
	}
	public void setBoardFaqNumber(int boardFaqNumber) {
		this.boardFaqNumber = boardFaqNumber;
	}
	public String getBoardFaqTitle() {
		return boardFaqTitle;
	}
	public void setBoardFaqTitle(String boardFaqTitle) {
		this.boardFaqTitle = boardFaqTitle;
	}
	public String getBoardFaqContent() {
		return boardFaqContent;
	}
	public void setBoardFaqContent(String boardFaqContent) {
		this.boardFaqContent = boardFaqContent;
	}
	public String getBoardFaqUser() {
		return boardFaqUser;
	}
	public void setBoardFaqUser(String boardFaqUser) {
		this.boardFaqUser = boardFaqUser;
	}
}
