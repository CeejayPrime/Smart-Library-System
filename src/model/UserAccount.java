package model;

import java.util.ArrayList;

public class UserAccount {

    private String userId;
    private String name;

    private ArrayList<LibraryItem> borrowedItems;
    private ArrayList<LibraryItem> borrowHistory;

    public UserAccount(String userId, String name) {

        this.userId = userId;
        this.name = name;

        borrowedItems = new ArrayList<>();
        borrowHistory = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item) {

        borrowedItems.add(item);
        borrowHistory.add(item);

    }

    public void returnItem(LibraryItem item) {

        borrowedItems.remove(item);

    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public ArrayList<LibraryItem> getBorrowHistory() {
        return borrowHistory;
    }

}