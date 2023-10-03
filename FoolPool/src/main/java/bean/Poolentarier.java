package bean;

import java.util.Date;

public class Poolentarier {
	private Integer no;	// 글 번호
	private String title; // 글 제목
	private Date date; // 작성일
	Integer view; // 조회수
	String content; // 내용
	String keyword; // 내용
	String imageFileName; // 첨부 이미지
	String plantsName; // 식물 이름
	String id; // 아이디
	String nickname; // 닉네임
	
	public Poolentarier() {
		
	}
	
	public Poolentarier(Integer no, String title, Date date, Integer view, String keyword,
			String imageFileName, String plantsName, String id, String nickname) {
		this.no = no;
		this.title = title;
		this.date = date;
		this.view = view;
		this.keyword = keyword;
		this.imageFileName = imageFileName;
		this.plantsName = plantsName;
		this.id = id;
		this.nickname = nickname;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getPlantsName() {
		return plantsName;
	}

	public void setPlantsName(String plantsName) {
		this.plantsName = plantsName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
