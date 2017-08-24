package examples.pubhub.dao;


	import java.util.List;
	import examples.pubhub.model.BookTags;
	

	public interface TagDAO {


		public boolean removeTag(String isbn13,String tagName);
		public List<BookTags> getAllTags();
		public List<BookTags> getAllTagsByTagName(String tagName);
		boolean addTag(String isbn13,String tagName);

		
		
	}


