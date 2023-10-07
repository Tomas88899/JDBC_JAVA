package sk.elct.skolenie.jdbc.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sk.elct.skolenie.jdbc.dao.Book;

public class BooksFacade 
{
// FIELDS
private static final String DB_URL = "jdbc:mysql://localhost:3306/knihkupectvo";
private static final String USER = "Tomas";
private static final String PASS = "Skuska2023MojeSLQ";
	
	
//CONSTRUCTORS

public BooksFacade()
{
	super();
}
	
//METHODS

//get all book from database
	
public List<Book> getAllBooks()
{
	List<Book> books = new ArrayList<Book>();
	
	try (
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM books");
		)
	{
		while(rs.next())
		{
			Integer id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String publisher = rs.getString("publisher");
			String description = rs.getString("description");
		
		Book book = new Book(id,title,author,publisher,description);
		books.add(book);
		}
	}
catch(SQLException e)
	{
	  e.printStackTrace();
	}
return books;



}
/**
 * method to insert book
 * 
 * @param book
 */
public void insertBook(Book book)
{
	try(
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
		)
	{
		String sql = "INSERT INTO books (title,author,publisher,description) VALUES"
				+ "('" + book.getTitle() + "', '" + book.getAuthor() + "', '" + book.getPublisher()
				+ "', '" + book.getDescription() + "')";
		stmt.executeUpdate(sql);
	}
	catch(SQLException sqle)
	{
		sqle.printStackTrace();
	}
}
/**
 * This is alternative method to insert, it uses
 * prepered statements
 * @param book the book to be inserted
 */

public void insertBook2(Book book)
{
	try(
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement stmt = conn.prepareStatement ( 
			"INSERT INTO books (title,author,publisher,description) VALUES (?,?,?,?)" );
		)
	{
		stmt.setString(1, book.getTitle());
		stmt.setString(2, book.getAuthor());
		stmt.setString(3, book.getPublisher());
		stmt.setString(4, book.getDescription());
		stmt.executeUpdate();
	}
	catch(SQLException sqle)
	{
		sqle.printStackTrace();
	}
}

public void deleteBook(Integer id)
{
	try(
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement stmt = conn.prepareStatement ( 
					"DELETE FROM books WHERE id = ?");
		)
	{
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	catch(SQLException sqle)
	{
		sqle.printStackTrace();
	}
}

public void UpdateBook(Book book)
{
	try(
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement stmt = conn.prepareStatement ( 
					"UPDATE books SET title = ?, author = ?, publisher = ?, description = ? WHERE id = ?");
		)
	{
		stmt.setString(1, book.getTitle());
		stmt.setString(2, book.getAuthor());
		stmt.setString(3, book.getPublisher());
		stmt.setString(4, book.getDescription());
		stmt.setInt(5,book.getId());
		
		stmt.executeUpdate();
	}
	catch(SQLException sqle)
	{
		sqle.printStackTrace();
	}
}


}
