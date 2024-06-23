package packageGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatePickerPanel extends JPanel {
    private DateSelectionListener dateSelectionListener;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;
    private JPanel calendarPanel;
    private JLabel selectedDateLabel;
    private int selectedDay;
    private JButton okButton;
    private JTextField schedFromtf;
    private JTextField schedUntiltf;
    private JButton selectedButton; // Track the selected day button

    public interface DateSelectionListener {
        void dateSelected(String selectedDate);
    }

    public DatePickerPanel(JTextField schedFromtf, JTextField schedUntiltf) {
        this.schedFromtf = schedFromtf;
        this.schedUntiltf = schedUntiltf;
        initializeComponents();
        setupLayout();
        setupCalendarPanel();
        setupOKButton();
        setupListeners();
        displayCalendar();
    }

    private void initializeComponents() {
        monthComboBox = new JComboBox<>(getMonthNames());
        yearComboBox = new JComboBox<>(getYearRange());
        selectedDateLabel = new JLabel("Selected Date: None", SwingConstants.CENTER);
        okButton = new JButton("OK");
        okButton.setEnabled(false);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Panel for control (monthComboBox and yearComboBox)
        JPanel controlPanel = new JPanel();
        controlPanel.add(monthComboBox);
        controlPanel.add(yearComboBox);
        add(controlPanel, BorderLayout.NORTH);

        // Panel for OK button and selectedDateLabel
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Panel for selectedDateLabel on the lower left
        JPanel selectedDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        selectedDatePanel.add(selectedDateLabel);
        bottomPanel.add(selectedDatePanel, BorderLayout.WEST);

        // Panel for OK button on the lower right (half its size)
        JPanel okButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        Dimension buttonSize = okButton.getPreferredSize();
      // Reduce the height of the button
        okButton.setPreferredSize(buttonSize);
        buttonSize.width *= 2; 
        okButtonPanel.add(okButton);
        bottomPanel.add(okButtonPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setupCalendarPanel() {
        calendarPanel = new JPanel(new GridLayout(0, 7));
        add(calendarPanel, BorderLayout.CENTER);
    }

    private void setupOKButton() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDate = getSelectedDate();
                if (selectedDate != null) {
                    if (schedFromtf.isFocusOwner()) {
                        schedFromtf.setText(selectedDate);
                    } else if (schedUntiltf.isFocusOwner()) {
                        schedUntiltf.setText(selectedDate);
                    }
                    selectDate(selectedDate);
                }
            }
        });
    }

    private void setupListeners() {
        monthComboBox.addActionListener(new DateChangeListener());
        yearComboBox.addActionListener(new DateChangeListener());
    }

    private void notifyDateSelected(String selectedDate) {
        if (dateSelectionListener != null) {
            dateSelectionListener.dateSelected(selectedDate);
        }
    }

    public void setDateSelectionListener(DateSelectionListener listener) {
        this.dateSelectionListener = listener;
    }

    public void selectDate(String selectedDate) {
        notifyDateSelected(selectedDate);
    }

    private String[] getMonthNames() {
        return new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    }

    private Integer[] getYearRange() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer[] years = new Integer[20];
        for (int i = 0; i < 20; i++) {
            years[i] = currentYear - 10 + i;
        }
        return years;
    }

    private void displayCalendar() {
        calendarPanel.removeAll();

        int month = monthComboBox.getSelectedIndex();
        int year = (Integer) yearComboBox.getSelectedItem();

        Calendar calendar = new GregorianCalendar(year, month, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            calendarPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            final int selectedDay = day;
            JButton dayButton = new JButton(String.valueOf(day));
            dayButton.addActionListener(e -> {
                // Update selected day
                this.selectedDay = selectedDay;
                selectedDateLabel.setText("Selected Date: " + selectedDay + " " + monthComboBox.getSelectedItem() + " " + year);
                okButton.setEnabled(true);

                // Highlight the selected button and remove highlight from previously selected button
                if (selectedButton != null) {
                    selectedButton.setBackground(null); // Remove highlight
                }
                selectedButton = dayButton;
                dayButton.setBackground((Color.GREEN));
            });
            calendarPanel.add(dayButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public String getSelectedDate() {
        if (selectedDay != 0) {
            int month = monthComboBox.getSelectedIndex();
            int year = (Integer) yearComboBox.getSelectedItem();
            return String.format("%02d", selectedDay) + " " + getMonthNames()[month] + " " + year;
        } else {
            return null;
        }
    }

    private class DateChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayCalendar();
        }
    }
}
