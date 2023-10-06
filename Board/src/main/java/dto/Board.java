package dto;

import java.sql.Date;

public class Board {

	// 필드
	private Integer num;
	private String subject;
	private String content;
	private Date writedate; // java.util.Date
	private String fileurl;
	private String writer;
	private Integer viewcount;
	private Integer likecount;

	// 생성자
	public Board() {
	}

	public Board(Integer num, String subject, String content, Date writedate, String fileurl, String writer) {
		this.num = num;
		this.subject = subject;
		this.content = content;
		this.writedate = writedate;
		this.fileurl = fileurl;
		this.writer = writer;
	}

	// getter, setter
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Integer getViewcount() {
		return viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public Integer getLikecount() {
		return likecount;
	}

	public void setLikecount(Integer likecount) {
		this.likecount = likecount;
	}
	
}