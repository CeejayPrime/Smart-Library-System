package controller;

import java.util.ArrayList;
import model.LibraryItem;

public class ReportGenerator {

    // Category Distribution Report
    public static String categoryDistribution(ArrayList<LibraryItem> items) {

        int books = 0;
        int magazines = 0;
        int journals = 0;

        for (LibraryItem item : items) {

            if (item.getClass().getSimpleName().equals("Book")) {
                books++;
            }
            else if (item.getClass().getSimpleName().equals("Magazine")) {
                magazines++;
            }
            else if (item.getClass().getSimpleName().equals("Journal")) {
                journals++;
            }

        }

        return "Category Distribution\n\n"
                + "Books: " + books + "\n"
                + "Magazines: " + magazines + "\n"
                + "Journals: " + journals;

    }

    // Borrowed Items Report
   public static String mostBorrowedItems(ArrayList<LibraryItem> items) {

    StringBuilder report = new StringBuilder("Most Borrowed Items\n\n");

    // Copy items into a new list for sorting
    ArrayList<LibraryItem> sortedItems = new ArrayList<>(items);

    // Sort by borrowCount (descending)
    sortedItems.sort((a, b) -> Integer.compare(b.getBorrowCount(), a.getBorrowCount()));

    boolean found = false;
    int rank = 1;

    for (LibraryItem item : sortedItems) {

        if (item.getBorrowCount() > 0) {

            found = true;

            report.append(rank)
                  .append(". ")
                  .append(item.getTitle())
                  .append("\nTimes Borrowed: ")
                  .append(item.getBorrowCount())
                  .append("\n\n");

            rank++;
        }
    }

    if (!found) {
        report.append("No borrowing activity recorded yet.");
    }

    return report.toString();
}

    // Overdue Users Report
    public static String overdueUsers(ArrayList<LibraryItem> items) {

         StringBuilder report = new StringBuilder("Overdue Users\n\n");

    java.time.LocalDate today = java.time.LocalDate.now();

    for (LibraryItem item : items) {

        if (item.isBorrowed() && item.getBorrowDate() != null) {

            long daysBorrowed =
                    java.time.temporal.ChronoUnit.DAYS.between(
                            item.getBorrowDate(), today);

            if (daysBorrowed > 3) {   // 3-day borrowing limit

                report.append("User: ")
                      .append(item.getBorrowedBy())
                      .append("\nBook: ")
                      .append(item.getTitle())
                      .append("\nDays overdue: ")
                      .append(daysBorrowed - 14)
                      .append("\n\n");
            }
        }
    }

    return report.toString();

    }
    
}