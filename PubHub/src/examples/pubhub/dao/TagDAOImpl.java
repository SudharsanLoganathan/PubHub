package examples.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.BookTags;

import examples.pubhub.utilities.DAOUtilities;

public class TagDAOImpl implements TagDAO{
	
	Connection connection = null;	
	PreparedStatement stmt = null;	
	
	@Override
	public boolean addTag(String isbn13,String tagName) {
		try {
			connection = DAOUtilities.getConnection();
		String sql = "INSERT INTO book_tags VALUES(?,?);";
			stmt = connection.prepareStatement(sql);
			
		
			stmt.setString(1,isbn13);
			stmt.setString(2,tagName);
			
		
			if (stmt.executeUpdate() != 0)
			{
				
				return true;
			}
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	

	@Override
	public boolean removeTag(String isbn13,String tagName) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM book_tags WHERE tag_name=? and isbn13=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,tagName);
			stmt.setString(2, isbn13);
		
			if (stmt.executeUpdate() != 0)
			
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 		
	}

	@Override
	public List<BookTags> getAllTags() {
		
		List<BookTags> tagList= new ArrayList<>();
		try {
			connection = DAOUtilities.getConnection();	
			String sql = "select * from book_tags;" ;		
			PreparedStatement stmt = connection.prepareStatement(sql);	
			List<BookTags> bookTags= new ArrayList<>();
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookTags bookTag=new BookTags();
				Book book=new Book();
				String isbn13=rs.getString("isbn_13");
				String tagName=rs.getString("tag_name");
				book.setIsbn13(isbn13);
				bookTag.setIsbn13(book);
				bookTag.setTagName(tagName);
				bookTags.add(bookTag);
				return bookTags;
			}	
			rs.close();			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tagList;
	}

	@Override
	public List<BookTags> getAllTagsByTagName(String tagName) {
		List<BookTags> bookTags= new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();	
			String sql = "SELECT * FROM book_tags WHERE book_tags.`tag_name`=?;";			
			stmt = connection.prepareStatement(sql);	
			
			stmt.setString(1,tagName);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BookTags bookTag=new BookTags();
				Book book=new Book();
				book.setIsbn13(rs.getString("isbn_13"));
				bookTag.setIsbn13(book);
				bookTag.setTagName(tagName);
				bookTags.add(bookTag);
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return bookTags;
	}




}
