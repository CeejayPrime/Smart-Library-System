package controller;

import model.LibraryItem;
import model.UserAccount;

public class BorrowController {

    public static boolean borrowItem(UserAccount user, LibraryItem item) {

        if (!item.isBorrowed()) {

            item.setBorrowed(true);
            user.borrowItem(item);

            return true;
        }

        return false;
    }

    public static void returnItem(UserAccount user, LibraryItem item) {

        item.setBorrowed(false);
        user.returnItem(item);

    }

    public static void reserveItem(UserAccount user, LibraryItem item) {

        item.addToReservation(user);

    }

    public static void assignNextUser(LibraryItem item) {

        UserAccount nextUser = item.getNextReservation();

        if (nextUser != null) {

            item.setBorrowed(true);
            nextUser.borrowItem(item);

        }

    }

}