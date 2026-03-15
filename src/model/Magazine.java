package model;

public class Magazine extends LibraryItem implements Borrowable {

    public Magazine(String id, String title, String author, int year) {
        super(id, title, author, year);
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