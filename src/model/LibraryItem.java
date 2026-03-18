package model;

import java.util.LinkedList;
import java.util.Queue;

public abstract class LibraryItem {

    protected String id;
    protected String title;
    protected String author;
    protected int year;
    protected boolean borrowed;
    

    // NEW: store who borrowed the book
    protected String borrowedBy;
    protected java.time.LocalDate borrowDate;
    public int borrowCount;

    protected Queue<UserAccount> reservationQueue = new LinkedList<>();

    public LibraryItem(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false;
        this.borrowedBy = null;   // initially no borrower
        this.borrowDate = null;
        this.borrowCount = 0;
    }

    // Reservation Queue Methods

    public void addToReservation(UserAccount user) {
        reservationQueue.add(user);
    }

    public UserAccount getNextReservation() {
        return reservationQueue.poll();
    }
    
    public int getReservationQueueSize() {
     return reservationQueue.size();
    }

    //Get time and date
    public java.time.LocalDate getBorrowDate() {
    return borrowDate;
    }

    public void setBorrowDate(java.time.LocalDate date) {
        this.borrowDate = date;
    }

    // Getters
    
    public int getBorrowCount() {
        return borrowCount;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }
    
    // Setters

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setBorrowedBy(String userId) {
        this.borrowedBy = userId;
    }
}