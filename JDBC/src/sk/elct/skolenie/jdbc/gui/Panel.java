package sk.elct.skolenie.jdbc.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sk.elct.skolenie.jdbc.dao.Book;
import sk.elct.skolenie.jdbc.facade.BooksFacade;

public class Panel extends JPanel

{
// FIELDS
private BooksFacade booksFacade;
private List<Book> books;

//CONSTRUCTORS
	
	public Panel(BooksFacade booksFacade)
	{
	super();
	this.booksFacade = booksFacade;
	this.books = new ArrayList<Book>();
	this.refreshBooks();
	this.refreshGraphics();
	}

//METHODS

	private void refreshBooks()
	{
	this.books = this.booksFacade.getAllBooks();
	}

	private void refreshGraphics()
	{
		this.removeAll();
		for(Book book : books)
		{
			JTextField idField = new JTextField(5);
			idField.setEditable(false);
			JTextField titleField = new JTextField(15);
			JTextField authorField = new JTextField(15);
			JTextField publisherField = new JTextField(15);
			JTextField descriptionField = new JTextField(20);
			JButton updateButton = new JButton("U");
			updateButton.addActionListener((e) -> this.UpdateBook(book.getId(),
					titleField.getText(), authorField.getText(), publisherField.getText(), descriptionField.getText()));
			
			JButton removeButton = new JButton("X");
			removeButton.addActionListener((e) -> this.deleteBook(book.getId()));
			
			
			idField.setText(book.getId() + "");
			titleField.setText(book.getTitle());
			authorField.setText(book.getAuthor());
			publisherField.setText(book.getPublisher());
			descriptionField.setText(book.getDescription());
			
			this.add(idField);
			this.add(titleField);
			this.add(authorField);
			this.add(publisherField);
			this.add(descriptionField);
			this.add(updateButton);
			this.add(removeButton);
		}
	
		JTextField idField = new JTextField(5);
		idField.setEditable(false);
		JTextField titleField = new JTextField(15);
		JTextField authorField = new JTextField(15);
		JTextField publisherField = new JTextField(15);
		JTextField descriptionField = new JTextField(20);
		JButton addButton = new JButton("+");
		
		addButton.addActionListener((e) -> this.addBook(titleField.getText(),authorField.getText(),
				publisherField.getText(),descriptionField.getText()));
		
		
		this.add(idField);
		this.add(titleField);
		this.add(authorField);
		this.add(publisherField);
		this.add(descriptionField);
		this.add(addButton);
		this.add(new JLabel("               "));
		this.repaint();
		this.revalidate();
		
	
	}
private void addBook(String title,String author,String publisher,String description)
{
	Book book = new Book(null,title,author,publisher,description);
	this.booksFacade.insertBook2(book);
	this.refreshBooks();
	this.refreshGraphics();

}

private void deleteBook(Integer id)
{
	
	this.booksFacade.deleteBook(id);
	this.refreshBooks();
	this.refreshGraphics();
	
}

private void UpdateBook(Integer id,String title,String author,String publisher,String description)
{
	Book book = new Book(id,title,author,publisher,description);
	this.booksFacade.UpdateBook(book);
	this.refreshBooks();
	this.refreshGraphics();
}
}
