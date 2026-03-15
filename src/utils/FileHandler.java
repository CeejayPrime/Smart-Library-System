package utils;

import java.io.*;
import java.util.ArrayList;
import model.*;

public class FileHandler {

    // Save items to file
    public static void saveItems(ArrayList<LibraryItem> items, String filename) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for (LibraryItem item : items) {

                String type = item.getClass().getSimpleName();

                writer.println(
                    item.getId() + "|" +
                    item.getTitle() + "|" +
                    item.getAuthor() + "|" +
                    item.getYear() + "|" +
                    type + "|" +
                    item.isBorrowed() + "|" +
                    item.getBorrowedBy()
                );

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    // Load items from file
    public static ArrayList<LibraryItem> loadItems(String filename) {

        ArrayList<LibraryItem> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                String id = parts[0];
                String title = parts[1];
                String author = parts[2];
                int year = Integer.parseInt(parts[3]);
                String type = parts[4];
                boolean borrowed = Boolean.parseBoolean(parts[5]);
                String borrowedBy = parts.length > 6 ? parts[6] : null;

                LibraryItem item;

                if (type.equals("Book")) {

                    item = new Book(id, title, author, year, "ISBN");

                } else if (type.equals("Magazine")) {

                    item = new Magazine(id, title, author, year);

                } else {

                    item = new Journal(id, title, author, year);

                }

                item.setBorrowed(borrowed);
                item.setBorrowedBy(borrowedBy);
                
                items.add(item);

            }

        } catch (IOException e) {

            System.out.println("No saved data found.");

        }

        return items;

    }

}