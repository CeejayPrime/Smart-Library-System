package model;

import java.util.ArrayList;
import java.util.Stack;

public class LibraryDatabase {

    private ArrayList<LibraryItem> items;
    private Stack<LibraryItem> deletedItems;
    private LibraryItem[] cache = new LibraryItem[10];
    
    public void cacheItem(LibraryItem item) {

    for (int i = cache.length - 1; i > 0; i--) {

        cache[i] = cache[i - 1];

    }

    cache[0] = item;

}
    
    public LibraryItem[] getCache() {

    return cache;

}

    public LibraryDatabase() {
        items = new ArrayList<>();
        deletedItems = new Stack<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(String id) {

          LibraryItem itemToRemove = null;

          for (LibraryItem item : items) {

            if (item.getId().equals(id)) {
                itemToRemove = item;
                break;
            }

    }

            if (itemToRemove != null) {

                deletedItems.push(itemToRemove);   // save for undo
                items.remove(itemToRemove);        // remove item

            }

    }

    public LibraryItem undoDelete() {

    if (!deletedItems.isEmpty()) {

        LibraryItem item = deletedItems.pop();
        items.add(item);
        return item;

    }

    return null;
}

    public ArrayList<LibraryItem> getItems() {
        return items;
    }
}