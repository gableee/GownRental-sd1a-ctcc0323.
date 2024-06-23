package packageGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class SettingsPanel extends JPanel implements ActionListener {

    private Map<String, String> userDatabase;
    private RentGowns mainFrame;
    private JButton changeUserButton, changePassButton, aboutButton, backButton;
    public String newName, Newpass, currentUser, newPassword;

    public SettingsPanel(RentGowns mainFrame) {

        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout());
        setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        changeUserButton = new JButton("Change Username");
        changeUserButton.addActionListener(this);
        add(changeUserButton, gbc);

        gbc.gridy = 1;
        changePassButton = new JButton("Change Password");
        changePassButton.addActionListener(this);
        add(changePassButton, gbc);

        gbc.gridy = 2;
        aboutButton = new JButton("About");
        aboutButton.addActionListener(this);
        add(aboutButton, gbc);

        gbc.gridy = 3;
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(backButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == changeUserButton){
            String newName = JOptionPane.showInputDialog(this, "Enter new username:");
            if (newName != null && !newName.trim().isEmpty() && !userDatabase.containsKey(newName)) {
                userDatabase.put(newName, userDatabase.remove(currentUser));
                currentUser = newName;
                JOptionPane.showMessageDialog(this, "Username updated to: " + newName);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid or already existing username.");
            }
        } else if (e.getSource() == changePassButton) {
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            if (newPassword != null && newPassword.length() > 6) {
                userDatabase.put(currentUser, newPassword);
                JOptionPane.showMessageDialog(this, "Password updated.");
            } else {
                JOptionPane.showMessageDialog(this, "Password must be longer than 6 characters.");
            }
        }  else if (e.getSource() == aboutButton) {
            JOptionPane.showMessageDialog(this, "This is the About section.");
        } else if (e.getSource() == backButton) {
            switchPanel("Login");
        }
    }

        private void switchPanel(String panelName) {
            mainFrame.getCardLayout().show(mainFrame.getMainPanel(), panelName);
    }
}