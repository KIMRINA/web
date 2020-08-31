package board;

public class BoardVO {
	private String poster;
	private String subject;
	private String contents;
	private int no;
	private String lastpost;
	private int views;
	private String filename;
	
	
	public BoardVO() {
	}
	
	public BoardVO(String poster, String subject, String contents, int no, String lastpost, int views,
			String filename) {
		super();
		this.poster = poster;
		this.subject = subject;
		this.contents = contents;
		this.no = no;
		this.lastpost = lastpost;
		this.views = views;
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "BoardVO [poster=" + poster + ", subject=" + subject + ", contents=" + contents + ", no=" + no
				+ ", lastpost=" + lastpost + ", views=" + views + ", filename=" + filename + "]";
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getLastpost() {
		return lastpost;
	}
	public void setLastpost(String lastpost) {
		this.lastpost = lastpost;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}
