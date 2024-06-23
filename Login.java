package packageGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener {

    private RentGowns mainFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Image backgroundImage;
    private JButton loginButton, clearButton, exitButton;

    public Login(RentGowns mainFrame) {

        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout());
        setOpaque(false);

        // Load the background image
        backgroundImage = new ImageIcon("C:\\Users\\lenovo\\Downloads\\JavaProject\\src\\GownRentalApp\\images\\Wallpaper.jpg").getImage();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Username: ");
        userLabel.setForeground(Color.WHITE); // Set text color to white
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);

        usernameField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setForeground(Color.WHITE); // Set text color to white
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(passLabel, gbc);

        passwordField = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(passwordField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setOpaque(false);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(buttonPanel, gbc);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
    
            // Assuming mainFrame, usernameField, and passwordField are correctly initialized
            if (mainFrame.getUserDatabase().containsKey(username) &&
                mainFrame.getUserDatabase().get(username).equals(password)) {
    
                mainFrame.setCurrentUser(username);
                if ("Owner".equalsIgnoreCase(username)) {
                    // Check if the OwnerPanel is already added to prevent duplication
                    if (!mainFrame.getMainPanel().getComponents().toString().contains("OwnerPanel")) {
                        mainFrame.getMainPanel().add(new OwnerPanel(), "OwnerPanel");
                    }
                    mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "OwnerPanel");
                } else if ("Customer".equalsIgnoreCase(username)) {
                    mainFrame.setVisible(false); // Hide the main frame
                    rent rentObject = new rent();
                    rentObject.RentG1();
                }
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Incorrect username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            usernameField.setText("");
            passwordField.setText("");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        // Test the Login panel in a JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.add(new Login(null)); // Pass the appropriate RentGowns instance if needed
        frame.setVisible(true);
    }
    
}