package sk.elct.skolenie.jdbc.dao;

public class Book
{
// FIELDS
private Integer id;
private String title;
private String author;
private String publisher;
private String description;
	
//CONSTRUCTORS
public Book()
{
	super();
}

public Book(Integer id, String title, String author, String publisher, String description)
{
	super();
	this.id = id;
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.description = description;
}

//METHODS

public Integer getId() 
{
	return id;
}

public void setId(Integer id) 
{
	this.id = id;
}

public String getTitle()
{
	return title;
}

public void setTitle(String title) 
{
	this.title = title;
}

public String getAuthor() 
{
	return author;
}

public void setAuthor(String author)
{
	this.author = author;
}

public String getPublisher() 
{
	return publisher;
}

public void setPublisher(String publisher)
{
	this.publisher = publisher;
}

public String getDescription()
{
	return description;
}

public void setDescription(String description)
{
	this.description = description;
}


@Override
public String toString()
{
	return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", description="
			+ description + "]";
}
	










}
