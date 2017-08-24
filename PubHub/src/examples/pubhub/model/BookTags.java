package examples.pubhub.model;

public class BookTags {
	private Book isbn13;
	private String tagName;
	public Book getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(Book isbn13) {
		this.isbn13 = isbn13;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
}
