package webapp.TopicServlet;


public class topic {
	protected String name;
	protected String content;
	protected String date;
	protected String number;


	public topic() {
	}

	public topic(String name, String content, String number, String date) {
		super();
		this.name = name;
		this.content = content;
		this.number = number;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	

}
