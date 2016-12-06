public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
        super(author, title, ISBN, callNumber);
	currentHolder = null; 
	dueDate = null;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public void setCurrentHolder(String currentHolder){
	this.currentHolder = currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setDueDate(String dueDate){
	this.dueDate = dueDate;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if (currentHolder == null && dueDate == null){
	    return "book available on shelves";
	}
	else {
	    return "currentHolder: " + currentHolder + "\ndueDate: " + dueDate;
	}
    }

    public String toString(){
	if (currentHolder == null && dueDate == null){
	    return super.toString();
	}
	else {
	    return super.toString() + ", " + currentHolder + ", " + dueDate;
	}
    }	
    

}
