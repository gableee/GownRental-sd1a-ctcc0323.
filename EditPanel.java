package packageGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPanel extends JPanel implements ActionListener {

    private JButton settingsButton, rentButton, returnButton;

    public EditPanel(RentGowns mainFrame) {
        setLayout(null);
        setOpaque(false);

        // Add settings button in the upper right corner
        settingsButton = new JButton("Settings");
        settingsButton.setBounds(getWidth() - 100, 20, 90, 20);
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.getCardLayout().show(mainFrame.getMainPanel(), "settingsPanel");
            }
        });
        add(settingsButton);

        // Add "Rent a Gown" button
        rentButton = new JButton("Rent a Gown");
        rentButton.addActionListener(this);
        rentButton.setBounds(getWidth() / 2 - 100, getHeight() / 2 - 40, 200, 40);
        add(rentButton);

        // Add "Return a Gown" button
        returnButton = new JButton("Return a Gown");
        returnButton.addActionListener(this);
        returnButton.setBounds(getWidth() / 2 - 100, getHeight() / 2, 200, 40);
        add(returnButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}