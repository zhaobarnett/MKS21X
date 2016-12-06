public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	this("unknown author", "untitled", "number");
    }
    
    public Book(String author, String title, String ISBN){
	this.author = author;
	this.title = title;
	this.ISBN = ISBN;
    }
    
    public String getAuthor(){
	return author;
    }

    public void setAuthor(String author){
	this.author = author;
    }

    public String getTitle(){
	return title;
    }

    public void setTitle(String title){
	this.title = title;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setISBN(String ISBN){
	this.ISBN = ISBN;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }

}

    
	
