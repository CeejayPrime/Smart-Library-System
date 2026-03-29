package model;

public class Book extends LibraryItem implements Borrowable {

    private String isbn;

    public Book(String id, String title, String author, int year, String isbn) {
        super(id, title, author, year);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
   

    @Override
    public void borrowItem() {
        borrowed = true;
    }

    @Override
    public void returnItem() {
        borrowed = false;
    }

    @Override
    public boolean isAvailable() {
        return !borrowed;
    }
    
}