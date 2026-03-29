package controller;

import java.util.ArrayList;
import model.LibraryItem;

public class SearchEngine {

    // ===============================
    // SEARCH ALGORITHMS
    // ===============================

    // Linear Search
    public static LibraryItem linearSearchByTitle(ArrayList<LibraryItem> items, String title) {

        for (LibraryItem item : items) {

            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }

        }

        return null;
    }

    // Binary Search (list must already be sorted)
    public static LibraryItem binarySearchByTitle(ArrayList<LibraryItem> items, String title) {

        int low = 0;
        int high = items.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            LibraryItem item = items.get(mid);

            int comparison = item.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return item;
            }

            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return null;
    }

    // Recursive Search
    public static LibraryItem recursiveSearchByTitle(ArrayList<LibraryItem> items, String title, int index) {

        if (index >= items.size()) {
            return null;
        }

        if (items.get(index).getTitle().equalsIgnoreCase(title)) {
            return items.get(index);
        }

        return recursiveSearchByTitle(items, title, index + 1);
    }


    // ===============================
    // SORTING ALGORITHMS
    // ===============================

    // Selection Sort
    public static void selectionSortByTitle(ArrayList<LibraryItem> items) {

        int n = items.size();

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (items.get(j).getTitle()
                        .compareToIgnoreCase(items.get(minIndex).getTitle()) < 0) {

                    minIndex = j;

                }

            }

            LibraryItem temp = items.get(i);
            items.set(i, items.get(minIndex));
            items.set(minIndex, temp);

        }

    }
    
       public static void selectionSortByAuthor(ArrayList<LibraryItem> items) {

    int n = items.size();

    for (int i = 0; i < n - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < n; j++) {

            if (items.get(j).getAuthor()
                    .compareToIgnoreCase(items.get(minIndex).getAuthor()) < 0) {

                minIndex = j;
            }
        }

        LibraryItem temp = items.get(i);
        items.set(i, items.get(minIndex));
        items.set(minIndex, temp);
    }
}
    
    public static void selectionSortByYear(ArrayList<LibraryItem> items) {

    int n = items.size();

    for (int i = 0; i < n - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < n; j++) {

            if (items.get(j).getYear() < items.get(minIndex).getYear()) {

                minIndex = j;
            }
        }

        LibraryItem temp = items.get(i);
        items.set(i, items.get(minIndex));
        items.set(minIndex, temp);
    }
}

    // Merge Sort
    public static void mergeSortByTitle(ArrayList<LibraryItem> items) {

        if (items.size() <= 1) {
            return;
        }

        int mid = items.size() / 2;

        ArrayList<LibraryItem> left = new ArrayList<>(items.subList(0, mid));
        ArrayList<LibraryItem> right = new ArrayList<>(items.subList(mid, items.size()));

        mergeSortByTitle(left);
        mergeSortByTitle(right);

        merge(items, left, right);

    }

    // Merge Helper Method
    private static void merge(ArrayList<LibraryItem> items,
                              ArrayList<LibraryItem> left,
                              ArrayList<LibraryItem> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i).getTitle()
                    .compareToIgnoreCase(right.get(j).getTitle()) <= 0) {

                items.set(k++, left.get(i++));

            } else {

                items.set(k++, right.get(j++));

            }

        }

        while (i < left.size()) {
            items.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            items.set(k++, right.get(j++));
        }

    }
    private static void mergeByAuthor(ArrayList<LibraryItem> items,
                                  ArrayList<LibraryItem> left,
                                  ArrayList<LibraryItem> right) {

        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i).getAuthor()
                    .compareToIgnoreCase(right.get(j).getAuthor()) <= 0) {

                items.set(k++, left.get(i++));
            } else {
                items.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) items.set(k++, left.get(i++));
        while (j < right.size()) items.set(k++, right.get(j++));
    }
    public static void mergeSortByAuthor(ArrayList<LibraryItem> items) {

        if (items.size() <= 1) return;

        int mid = items.size() / 2;

        ArrayList<LibraryItem> left = new ArrayList<>(items.subList(0, mid));
        ArrayList<LibraryItem> right = new ArrayList<>(items.subList(mid, items.size()));

        mergeSortByAuthor(left);
        mergeSortByAuthor(right);

        mergeByAuthor(items, left, right);
    }
    
    public static void mergeSortByYear(ArrayList<LibraryItem> items) {

    if (items.size() <= 1) return;

    int mid = items.size() / 2;

    ArrayList<LibraryItem> left = new ArrayList<>(items.subList(0, mid));
    ArrayList<LibraryItem> right = new ArrayList<>(items.subList(mid, items.size()));

    mergeSortByYear(left);
    mergeSortByYear(right);

    mergeByYear(items, left, right);
}
    
    private static void mergeByYear(ArrayList<LibraryItem> items,
                               ArrayList<LibraryItem> left,
                               ArrayList<LibraryItem> right) {

    int i = 0, j = 0, k = 0;

    while (i < left.size() && j < right.size()) {

        if (left.get(i).getYear() <= right.get(j).getYear()) {

            items.set(k++, left.get(i++));
        } else {
            items.set(k++, right.get(j++));
        }
    }

    while (i < left.size()) items.set(k++, left.get(i++));
    while (j < right.size()) items.set(k++, right.get(j++));
}
}