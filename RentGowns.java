package packageGui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RentGowns extends JFrame {

    private Map<String, String> userDatabase;
    private String currentUser;
    private static Image backgroundImage;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public RentGowns() {

        // Initialize components
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize user database
        userDatabase = new HashMap<>();
        addUser("Owner", "Owner", "qwerty123");
        addUser("Customer", "Customer", "qwerty123");

        // Load background image
        backgroundImage = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\Wallpaper.jpg").getImage();

        // Frame settings
        setTitle("Gown Rental App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        // Card layout for switching panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        setContentPane(mainPanel);

        // Initialize and add login panel
        Login loginPanel = new Login(this);
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.setVisible(true);

        // Make frame visible
        setVisible(true);
    }

    private void addUser(String type, String username, String password) {
        userDatabase.put(username, password);
    }

    public Map<String, String> getUserDatabase() {
        return userDatabase;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RentGowns frame = new RentGowns();
                frame.setVisible(true);


            }
        });
    }
    
   
    // BackgroundPanel class remains the same
    class backgroundImage extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}