package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import model.LibraryItem;
import model.LibraryDatabase;

public class OverdueTableRenderer extends DefaultTableCellRenderer {

    private LibraryDatabase database;

    public OverdueTableRenderer(LibraryDatabase database) {
        this.database = database;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        String itemId = table.getValueAt(row, 0).toString();

        LibraryItem item = null;

        for (LibraryItem i : database.getItems()) {
            if (i.getId().equals(itemId)) {
                item = i;
                break;
            }
        }

        if (item != null && item.isBorrowed()) {

            if (item.getBorrowDate() != null) {

                long daysBorrowed = ChronoUnit.DAYS.between(
                        item.getBorrowDate(),
                        LocalDate.now());

                if (daysBorrowed > 1) {

                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);

                } else {

                    c.setBackground(Color.ORANGE);
                    c.setForeground(Color.BLACK);

                }

            }

        } else {

            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);

        }

        return c;
    }
}