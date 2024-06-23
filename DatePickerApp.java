package packageGui;

import javax.swing.*;

public class DatePickerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Date Picker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JTextField schedFromtf = new JTextField(); // Create the JTextField for schedFromtf
            JTextField schedUntiltf = new JTextField(); // Create the JTextField for schedUntiltf

            DatePickerPanel datePickerPanel = new DatePickerPanel(schedFromtf, schedUntiltf); // Pass the JTextFields

            frame.add(datePickerPanel);

            frame.setVisible(true);
        });
    }
}
