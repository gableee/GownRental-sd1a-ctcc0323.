package packageGui;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;


public class OwnerPanel extends JPanel {
    // Components
    private JPanel rightPanel;
    private CardLayout cardLayout;

    // Update price based on selected gown and size
    public OwnerPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Upper panel with OWNER label
        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.setPreferredSize(new Dimension(getWidth(), 80));
        upperPanel.setBackground(new Color(129, 143, 124));

        JLabel adminLabel = new JLabel("OWNER", SwingConstants.LEFT);
        adminLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        upperPanel.add(adminLabel, BorderLayout.WEST);
        upperPanel.setBorder(new EmptyBorder(10, 20, 10, 10));

        JSeparator upperSeparator = new JSeparator(JSeparator.HORIZONTAL);
        upperPanel.add(upperSeparator, BorderLayout.SOUTH);
        add(upperPanel, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        JButton btnAvailableGown = new JButton("Available Gowns");
        btnAvailableGown.setBackground(Color.WHITE); // Set background color to white
        btnAvailableGown.addActionListener(e -> {
            GList gownListApp = new GList();
        
        // Set the GList instance to be visible
        gownListApp.setVisible(true);
        });

        JButton btnRentReturnGown = new JButton("Inbox");
        btnRentReturnGown.setBackground(Color.WHITE); // Set background color to white

        JButton btnSetting = new JButton("Settings");
        btnSetting.setBackground(Color.WHITE); // Set background color to white


        // Set the same size for all buttons
        Dimension buttonSize = new Dimension(200, 30);
        btnAvailableGown.setMaximumSize(buttonSize);
        btnRentReturnGown.setMaximumSize(buttonSize);
        btnSetting.setMaximumSize(buttonSize);

        buttonsPanel.add(btnAvailableGown);
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(btnRentReturnGown);
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(btnSetting);
        buttonsPanel.add(Box.createVerticalStrut(10));

        // Panel for buttons with horizontal separator
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(buttonsPanel, BorderLayout.CENTER);
        leftPanel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.SOUTH);
        leftPanel.setBorder(new EmptyBorder(15, 0, 0, 10));

        // Add left panel to main panel
        add(leftPanel, BorderLayout.WEST);

        // Vertical separator
        JSeparator verticalSeparator = new JSeparator(SwingConstants.VERTICAL);
        add(verticalSeparator, BorderLayout.CENTER);

        // Right panel with CardLayout
        cardLayout = new CardLayout();
        rightPanel = new JPanel(cardLayout);
        rightPanel.setBackground(Color.WHITE); // Set background color to white
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(rightPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        btnAvailableGown.addActionListener(e -> showAvailableGowns());
        btnRentReturnGown.addActionListener(e -> showRentReturnPanel());
        btnSetting.addActionListener(e -> showSettingsPanel());
    }


    /*-----------------------------SHOW AVAILABLE GOWNS------------------------*/
    private void showAvailableGowns() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton GownAvailable = new JButton();
        GownAvailable.setBounds(450,650,200,200);
    
        panel.add(GownAvailable);

        // label for the title "Available Gowns"
        JLabel gownLabel = new JLabel("Available Gowns");
        gownLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align the label
        gownLabel.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Set font to Times New Roman, bold, size 15
        gownLabel.setBackground(Color.WHITE); // Set background color to white
        panel.add(gownLabel); // Add the label to the main panel

           // Add the details panel to the rightPanel
           rightPanel.removeAll();
           rightPanel.add(panel, BorderLayout.CENTER);
           rightPanel.revalidate();
           rightPanel.repaint();
        }
     
    /*-------------------------------------------------------------------------*/



    /*-----------------------------SHOW RENT/RETURN PANEL---------------------*/
    private void showRentReturnPanel() {
        
        // Create the message list panel
        String[] messages = {"This panel will shown the receipt of the Customer.", 
                             "This panel will shown the receipt of the Customer.", 
                             "This panel will shown the receipt of the Customer."};

        // Create a JList to display messages
        JList<String> messageList = new JList<>(messages);
        messageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Set custom cell renderer for JList
        messageList.setCellRenderer(new DefaultListCellRenderer() {
            private final JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);

            {
                separator.setPreferredSize(new Dimension(300, 10)); // Set separator size
                separator.setForeground(Color.GRAY); // Set separator color
            }
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JPanel panel = new JPanel(new BorderLayout());
                JLabel label = new JLabel((String) value);
                label.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add padding around label
                panel.add(separator, BorderLayout.NORTH); // Add separator above label
                panel.add(label, BorderLayout.CENTER); // Add label in the center
                panel.add(separator, BorderLayout.SOUTH); // Add separator below label
                return panel;
            }
        });

        // A JScrollPane to scroll through messages
        JScrollPane listScrollPane = new JScrollPane(messageList);
        listScrollPane.setPreferredSize(new Dimension(300, 400)); // Adjust scroll pane size

        // Create Color object with RGB values
        Color customColor = new Color(129, 143, 124);
        
        // Set border with custom color
        listScrollPane.setBorder(BorderFactory.createLineBorder(customColor, 2));
    
        // Panel to hold the scrollable list of messages
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(listScrollPane, BorderLayout.CENTER);
        listPanel.setBorder(BorderFactory.createTitledBorder("Messages")); // title border
    
        // Create the message content panel
        JTextArea messageContentArea = new JTextArea();
        messageContentArea.setEditable(false);
        JScrollPane contentScrollPane = new JScrollPane(messageContentArea);
        contentScrollPane.setPreferredSize(new Dimension(300, 400)); // Adjust scroll pane size
    
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE); // Set background color to white
        backButton.addActionListener(e -> cardLayout.show(rightPanel, "List"));
    
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(contentScrollPane, BorderLayout.CENTER);
        contentPanel.add(backButton, BorderLayout.SOUTH);
    
        // Add panels to the card layout
        rightPanel.add(listPanel, "List");
        rightPanel.add(contentPanel, "Content");
    
        // Add list selection listener to the message list
        messageList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedMessage = messageList.getSelectedValue();
                if (selectedMessage != null) {
                    messageContentArea.setText(selectedMessage);
                    cardLayout.show(rightPanel, "Content");
                }
            }
        });
    
        // Show the list panel initially
        cardLayout.show(rightPanel, "List");
    }
    
    /*-------------------------------------------------------------------------*/



     /*-----------------------------SHOW SETTINGS PANEL------------------------*/
    private void showSettingsPanel() {
        
        rightPanel.removeAll();
        rightPanel.add(new SettingsPanel(null), BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();
    }
     /*-------------------------------------------------------------------------*/

    public static void main(String[] args) {
        // Create an instance of ClassA
            // GList objA = new GList();
             // Call methodA from ClassA
        //objA.methodA();
    }
}