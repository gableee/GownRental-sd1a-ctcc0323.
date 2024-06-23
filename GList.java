package packageGui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GList extends JFrame {

    private static final String[] GOWN_NAMES = {"A-Line Gown", "Mermaid Gown", "Empire Style Gown", "Cocktail Dress", "Ball Gown"};
    private static final String[] SIZES = {"XS", "S", "M", "L", "XL", "2XL", "3XL"};
    private static final String[] COLORS = {"Red", "Blue", "Green", "Black", "White", "Pink"};
    private static final int[][] PRICE_MATRIX = {
            {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000},
            {1100, 2100, 3100, 4100, 5100, 6100, 7100, 8100},
            {1200, 2200, 3200, 4200, 5200, 6200, 7200, 8200},
            {1300, 2300, 3300, 4300, 5300, 6300, 7300, 8300},
            {1400, 2400, 3400, 4400, 5400, 6400, 7400, 8400}
    };

    private DefaultTableModel rentedTableModel;
    private DefaultTableModel historyTableModel;
    private JTable rentedTable;
    private JTable historyTable;

    private JComboBox<String> gownComboBox;
    private JComboBox<String> sizeComboBox;
    private JComboBox<String> colorComboBox;
    private JLabel priceLabel;

    public GList() {
        setTitle("Available Gowns");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComboBoxes();
        initializeTables();
        setupRentReturnPanel();

        setVisible(true);
    }

    private void initializeComboBoxes() {
        gownComboBox = new JComboBox<>(GOWN_NAMES);
        sizeComboBox = new JComboBox<>(SIZES);
        colorComboBox = new JComboBox<>(COLORS);
        priceLabel = new JLabel("Price: ₱0");

        gownComboBox.addActionListener(e -> updatePrice());
        sizeComboBox.addActionListener(e -> updatePrice());
    }

    private void updatePrice() {
        int gownIndex = gownComboBox.getSelectedIndex();
        int sizeIndex = sizeComboBox.getSelectedIndex();
        if (gownIndex >= 0 && sizeIndex >= 0) {
            int price = PRICE_MATRIX[gownIndex][sizeIndex];
            priceLabel.setText("Price: ₱" + price);
        }
    }

    private void initializeTables() {
        rentedTableModel = new DefaultTableModel(new String[]{"Gown", "Size", "Color", "Price (₱)", "Status"}, 0);
        rentedTable = createTable(rentedTableModel);
        rentedTable.getColumnModel().getColumn(4).setCellRenderer(new StatusCellRenderer());

        historyTableModel = new DefaultTableModel(new String[]{"Gown", "Size", "Color", "Date Rent", "Date Return", "Gown Price (₱)", "Penalty Payment (₱)", "Total Amount (₱)"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 6; // Allow editing for Date Return and Penalty Payment columns
            }
        };
        historyTable = createTable(historyTableModel);

        JPanel tablesPanel = new JPanel(new GridLayout(2, 1));
        tablesPanel.add(new JScrollPane(rentedTable));
        tablesPanel.add(new JScrollPane(historyTable));

        add(tablesPanel, BorderLayout.CENTER);
    }

    private JTable createTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setDefaultRenderer(Object.class, new CenterCellRenderer());
        return table;
    }

    private void setupRentReturnPanel() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Gown:"));
        topPanel.add(gownComboBox);
        topPanel.add(new JLabel("Size:"));
        topPanel.add(sizeComboBox);
        topPanel.add(new JLabel("Color:"));
        topPanel.add(colorComboBox);
        topPanel.add(priceLabel);

        JPanel buttonPanel = new JPanel();
        JButton rentButton = new JButton("Confirm Rent");
        JButton returnButton = new JButton("Confirm Return");

        rentButton.addActionListener(e -> handleRentAction());
        returnButton.addActionListener(e -> handleReturnAction());

        buttonPanel.add(rentButton);
        buttonPanel.add(returnButton);

        JPanel rentReturnPanel = new JPanel(new BorderLayout());
        rentReturnPanel.add(topPanel, BorderLayout.NORTH);
        rentReturnPanel.add(buttonPanel, BorderLayout.CENTER);

        add(rentReturnPanel, BorderLayout.NORTH);
    }

    private void handleRentAction() {
        String gown = (String) gownComboBox.getSelectedItem();
        String size = (String) sizeComboBox.getSelectedItem();
        String color = (String) colorComboBox.getSelectedItem();
        int gownIndex = gownComboBox.getSelectedIndex();
        int sizeIndex = sizeComboBox.getSelectedIndex();
        int price = PRICE_MATRIX[gownIndex][sizeIndex];
        String priceStr = "₱" + price;

        rentedTableModel.addRow(new Object[]{gown, size, color, priceStr, "Rented"});

        String currentDate = getCurrentDate();
        historyTableModel.addRow(new Object[]{gown, size, color, currentDate, "", priceStr, "", ""});
    }

    private void handleReturnAction() {
        int[] selectedRows = rentedTable.getSelectedRows();
        String currentDate = getCurrentDate();

        for (int row : selectedRows) {
            String gown = (String) rentedTableModel.getValueAt(row, 0);
            String size = (String) rentedTableModel.getValueAt(row, 1);
            String color = (String) rentedTableModel.getValueAt(row, 2);
            String priceStr = (String) rentedTableModel.getValueAt(row, 3);
            int price = Integer.parseInt(priceStr.replace("₱", ""));

            for (int i = 0; i < historyTableModel.getRowCount(); i++) {
                if (historyTableModel.getValueAt(i, 0).equals(gown) &&
                        historyTableModel.getValueAt(i, 1).equals(size) &&
                        historyTableModel.getValueAt(i, 2).equals(color) &&
                        historyTableModel.getValueAt(i, 4).equals("")) {
                    historyTableModel.setValueAt(currentDate, i, 4);

                    String penaltyPaymentStr = JOptionPane.showInputDialog(this, "Enter Penalty Payment (₱):");
                    if (penaltyPaymentStr == null || penaltyPaymentStr.isEmpty()) {
                        penaltyPaymentStr = "₱0";
                    } else {
                        penaltyPaymentStr = "₱" + penaltyPaymentStr;
                    }
                    int penaltyPayment = Integer.parseInt(penaltyPaymentStr.replace("₱", ""));
                    historyTableModel.setValueAt(penaltyPaymentStr, i, 6);

                    int totalAmount = price + penaltyPayment;
                    historyTableModel.setValueAt("₱" + totalAmount, i, 7);

                    break;
                }
            }
        }

        for (int i = selectedRows.length - 1; i >= 0; i--) {
            rentedTableModel.removeRow(selectedRows[i]);
        }
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GList::new);
    }

    class CenterCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(JLabel.CENTER);
            return c;
        }
    }

    class StatusCellRenderer extends CenterCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if ("Rented".equals(value)) {
                c.setFont(c.getFont().deriveFont(Font.BOLD));
            }
            return c;
        }
    }
}