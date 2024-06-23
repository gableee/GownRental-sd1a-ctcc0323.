package packageGui;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class rent extends JFrame implements ActionListener {

    public JPanel rentPanel;
    private RentGowns mainFrame;
    public boolean Check1T, Check2T, Check3T;
    public Image BG1, BG2;
    public JLabel DaysDeets;
    public long daysBetween;
    public DateTimeFormatter formatter;
    public DatePickerPanel datePickerPanel;
    private JTextField SchedFromtf, SchedUntiltf;;
    public JTextField Nametf, Emailtf, Contacttf, Addresstf;
    public JLabel Name, Email, Contact, Address, Days, GownTotalPrice;
    public JButton G1, G2, G3, G4, G5, arrow, Confirm;
    public JLabel CustomerName, CustomerEmail, CustomerContact, CustomerAddress, CustomerAddress1, Design0, SizeDeets;
    public JLabel ColorDeets, FromDeets, UntilDeets, PriceDeets, PerDay;
    

    //For receipt
    public String NameCon, EmailCon, ContactCon, AddressCon, fromDates, untilDates;
    public LocalDate fromDate, untilDate;
    public String Sdeets, Cdeets, Fdeets, Udeets,Ddeets, Pdeets, Pdaydeets, GTPdeets, Namedeets, Emaildeets, Contactdeets, Addressdeets, Designdeets, Addressdeets1; 
    


    public rent(RentGowns mainFrame) {
        this.mainFrame = mainFrame;
        RentG1();
    }

    public rent() {
        //TODO Auto-generated constructor stub
    }

    public void RentG1() {   

        // Main panel with a background image
        rentPanel = new RentPanel();
        rentPanel.setLayout(null);


    /*-----------------------------INNER PANNEL--------------------------- */
        JPanel innerPanel = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\pic1.jpg");
        innerPanel.setPreferredSize(new Dimension(250, 550));
        innerPanel.setLayout(null); 

        // Add components to the inner panel
        JLabel CName = new JLabel("Customer");  
        CName.setFont(new Font("Serif", Font.BOLD, 20));
        CName.setBounds(85,15,200,30);      
        innerPanel.add(CName);

        Name = new JLabel("Full Name:");
        Name.setFont(new Font("Arial", Font.BOLD, 13));
        Name.setBounds(20, 60, 200 ,30);
        innerPanel.add(Name);

        Nametf = new JTextField();
        Nametf.setBounds(20, 85, 200, 20);
        innerPanel.add(Nametf);

        Email = new JLabel("Email:");
        Email.setFont(new Font("Arial", Font.BOLD, 13));
        Email.setBounds(20, 100, 200 ,30);
        innerPanel.add(Email);

        Emailtf = new JTextField();
        Emailtf.setBounds(20, 125, 200, 20);
        innerPanel.add(Emailtf);


        Contact = new JLabel("Contact:");
        Contact.setFont(new Font("Arial", Font.BOLD, 13));
        Contact.setBounds(20, 140, 200 ,30);
        innerPanel.add(Contact);

        Contacttf = new JTextField();
        Contacttf.setBounds(20, 165, 200, 20);
        innerPanel.add(Contacttf);

        Address = new JLabel("Address:");
        Address.setFont(new Font("Arial", Font.BOLD, 13));
        Address.setBounds(20, 180, 200 ,30);
        innerPanel.add(Address);

        Addresstf = new JTextField();
        Addresstf.setBounds(20, 205, 200, 20);
        innerPanel.add(Addresstf);  

        Confirm = new JButton("Confirm");
        Confirm.setBounds(70, 250,100,50);
        Confirm.setFont(new Font("Arial", Font.BOLD, 13));
        Confirm.setBackground(new Color(255, 209, 220));
        Confirm.addActionListener(this);
        innerPanel.add(Confirm);

    /*------------------------------------------------------------------------- */


    /*-----------------------------Panel for Gown Image----------------------------- */

        JPanel Gown1 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\A-LineGown.png");
        Gown1.setBounds(300, 60, 150, 190);
        rentPanel.add(Gown1);

        JPanel Gown2 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\BallGown.png");
        Gown2.setBounds(500, 60, 150, 190);
        rentPanel.add(Gown2);

        JPanel Gown3 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\CocktailGown.png");
        Gown3.setBounds(700, 60, 150, 190);
        rentPanel.add(Gown3);

        JPanel Gown4 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\EmpireStyleGown.png");
        Gown4.setBounds(400, 330, 150, 190);
        rentPanel.add(Gown4);

        JPanel Gown5 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\MermaidGown.png");
        Gown5.setBounds(600, 330, 150, 190);
        rentPanel.add(Gown5);

        /*------------------------------------------------------------------------------- */

    /*-----------------------------Button for Gown (names)-------------------------- */

        G1 = new JButton("A-Line Gown");
        G1.setBounds(310,260,130,30);
        G1.setBackground(new Color(229, 170, 112));
        G1.addActionListener(this);
        rentPanel.add(G1);

        G2 = new JButton("Ball Gown");
        G2.setBounds(510,260,130,30);
        G2.setBackground(new Color(229, 170, 112));
        G2.addActionListener(this);
        rentPanel.add(G2);

        G3 = new JButton("Cocktail Gown");
        G3.setBounds(710,260,130,30);
        G3.setBackground(new Color(229, 170, 112));
        G3.addActionListener(this);
        rentPanel.add(G3);

        G4 = new JButton("Empire-Style");
        G4.setBounds(410,530,130,30);
        G4.setBackground(new Color(229, 170, 112));
        G4.addActionListener(this);
        rentPanel.add(G4);
        
        G5 = new JButton("Mermaid Gown");
        G5.setBounds(610,530,130,30);
        G5.setBackground(new Color(229, 170, 112));
        G5.addActionListener(this);
        rentPanel.add(G5);
        
        arrow = new JButton("<<<"); // Back Button to go back to the Log in panel
        arrow.setFont(new Font("Arial", Font.BOLD, 17));
        arrow.setBounds(10,0,70,40);
        Transparent(arrow);
        arrow.addActionListener(e -> {
        mainFrame.switchPanel("loginPanel");
        });
        rentPanel.add(arrow);
    /*------------------------------------------------------------------------------ */
        
        innerPanel.setBounds(30, 40, 250, 600); // Position and size of the inner panel
        rentPanel.add(innerPanel);
        setTitle("Rent a Gown");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setContentPane(rentPanel);
        setVisible(true);
    }

    public JPanel getRentPanel() {
        return rentPanel;
    }

    /*---------------------Main Panel Background------------------------ */

        private class RentPanel extends JPanel { //used for the panel and add image/background
            private Image BG1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\webweb.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(BG1, 0, 0, getWidth(), getHeight(), this);
        }
    }

 /*-----------------Class for ImageBackground insertion------------------- */
        private class ImagePanel extends JPanel { //Get the image 
        private Image image;

        public ImagePanel(String imagePath) {
            this.image = new ImageIcon(imagePath).getImage();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
        }

 /*---------To Make the background of the button Transparent------------- */
        private void Transparent(JButton button) {
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        
        }

   /*--------------Button for when the Gown Name is clicked-------------- */

     public void actionPerformed(ActionEvent e) {

        /*---------Button For Confirm and Gown------- */
        if(e.getSource() == Confirm){

            NameCon = Nametf.getText();
            EmailCon = Emailtf.getText();
            ContactCon = Contacttf.getText();
            AddressCon = Addresstf.getText();
        }
        else if (e.getSource() == G1) { 
            PickGown1();
        } else if (e.getSource() == G2) {
            PickGown2();
        } else if (e.getSource() == G3) {
            PickGown3();
        } else if (e.getSource() == G4) {
            PickGown4();
        } else if (e.getSource() == G5) {
            PickGown5();
        }

    }

    private void PickGown1() {
                BG2 = new ImageIcon("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\webweb.png").getImage();


                /*-------------------Choose Gown Main Panel------------------------- */
                // Create a new panel for choosing the gown
                JPanel ChooseGown = new ChooseGown();
                ChooseGown.setLayout(null); 

                // Image Panel for the picked gown
                JPanel PICK1 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\A-LineGown.png");
                PICK1.setBounds(30, 20, 270, 270);
                ChooseGown.add(PICK1);


                /* ------------------JLabel Inside The Panel ---------------- */
                JLabel Size = new JLabel("Gown Size");
                Size.setFont(new Font("Arial", Font.BOLD, 24));
                Size.setBounds(520, 80, 150,20);
                Size.setForeground(new Color(255, 255, 255));
                ChooseGown.add(Size);

                JLabel GColor = new JLabel("Gown Color");
                GColor.setFont(new Font("Arial", Font.BOLD, 24));
                GColor.setBounds(360, 200, 150,20);
                GColor.setForeground(new Color(255, 255, 255));
                ChooseGown.add(GColor);

                JLabel Schedule = new JLabel("Gown Schedule");
                Schedule.setFont(new Font("Arial", Font.BOLD, 24));
                Schedule.setBounds(600, 200, 200,20);
                Schedule.setForeground(new Color(255, 255, 255));
                ChooseGown.add(Schedule);



/*---------------------Panel For Customer Details and receipt---------------------- */
                JPanel innerPanel = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\pic1.jpg");
                innerPanel.setPreferredSize(new Dimension(250, 300));
                innerPanel.setBounds(30,320, 270, 320);
                innerPanel.setLayout(null); 
                ChooseGown.add(innerPanel);
            
                CustomerName = new JLabel("Name:      " + NameCon); // + add customer name that field in the rent panel
                CustomerName.setFont(new Font("Arial", Font.BOLD, 13));
                CustomerName.setBounds(11, 10, 200,20);
                innerPanel.add(CustomerName);
        
                CustomerEmail = new JLabel("Email:      " + EmailCon); // + add customer email that field in the rent panel
                CustomerEmail.setFont(new Font("Arial", Font.BOLD, 13));
                CustomerEmail.setBounds(12, 30, 200,20);
                innerPanel.add(CustomerEmail);

                CustomerContact = new JLabel("Contact:  " + ContactCon); // + add customer contact that field in the rent panel
                CustomerContact.setFont(new Font("Arial", Font.BOLD, 13));
                CustomerContact.setBounds(10, 50, 200,20);
                innerPanel.add(CustomerContact);

                CustomerAddress = new JLabel("Address: "); // + add customer address that field in the rent panel
                CustomerAddress.setFont(new Font("Arial", Font.BOLD, 13));
                CustomerAddress.setBounds(10, 70, 200,20);
                innerPanel.add(CustomerAddress);

                CustomerAddress1 = new JLabel(AddressCon);
                CustomerAddress1.setFont(new Font("Arial", Font.BOLD, 13));
                CustomerAddress1.setBounds(10, 90, 250,20);
                innerPanel.add(CustomerAddress1);

                Design0 = new JLabel("-------------------------------------------------------------");
                Design0.setFont(new Font("Arial", Font.BOLD, 13));
                Design0.setBounds(10, 110, 300,20);
                innerPanel.add(Design0);

                SizeDeets = new JLabel("Gown Size: ");
                SizeDeets.setBounds(10, 130, 200, 20); 
                SizeDeets.setFont(new Font("Arial", Font.BOLD, 13));
                innerPanel.add(SizeDeets);

                ColorDeets = new JLabel("Gown Color: ");
                ColorDeets.setBounds(10, 150, 200, 20);  
                ColorDeets.setFont(new Font("Arial", Font.BOLD, 13));
                innerPanel.add(ColorDeets);

                FromDeets = new JLabel("Rent From: ");
                FromDeets.setBounds(10,170, 250, 20);
                FromDeets.setFont(new Font("Arial", Font.BOLD, 13));
                innerPanel.add(FromDeets);

                UntilDeets = new JLabel("Rent Until: ");
                UntilDeets.setBounds(10,190, 250, 20);
                UntilDeets.setFont(new Font("Arial", Font.BOLD, 13));
                innerPanel.add(UntilDeets);

                DaysDeets = new JLabel("Rental Duration: ");
                DaysDeets.setBounds(10,210, 250, 20);
                DaysDeets.setFont(new Font("Arial", Font.BOLD, 13));
                innerPanel.add(DaysDeets);

                PriceDeets = new JLabel("Gown Price: Php1,000.00");
                PriceDeets.setBounds(10,230, 250, 20);
                PriceDeets.setFont(new Font("Arial", Font.BOLD, 13));
                innerPanel.add(PriceDeets);

                PerDay = new JLabel("Overdue Penalty: Php100.00 ");
                PerDay.setBounds(10,250, 250, 20);
                PerDay.setFont(new Font("Arial", Font.BOLD, 13));
                innerPanel.add(PerDay);

/*----------------Panel For Buttons (Size)------------------ */

                JButton XS = new JButton("XS");
                XS.setBounds(340,120,50,50);
                XS.setFont(new Font("Arial", Font.BOLD, 10));
                XS.setBackground(new Color(255, 209, 220));
                ChooseGown.add(XS);

                JButton S = new JButton("S");
                S.setBounds(410,120,50,50);
                S.setFont(new Font("Arial", Font.BOLD, 10));
                S.setBackground(new Color(255, 209, 220));
                ChooseGown.add(S);

                JButton M = new JButton("M");
                M.setBounds(480,120,50,50);
                M.setFont(new Font("Arial", Font.BOLD, 10));
                M.setBackground(new Color(255, 209, 220));
                ChooseGown.add(M);

                JButton L = new JButton("L");
                L.setBounds(550,120,50,50);
                L.setFont(new Font("Arial", Font.BOLD, 10));
                L.setBackground(new Color(255, 209, 220));
                ChooseGown.add(L);

                JButton XL = new JButton("XL");
                XL.setBounds(620,120,50,50);
                XL.setFont(new Font("Arial", Font.BOLD, 10));
                XL.setBackground(new Color(255, 209, 220));
                ChooseGown.add(XL);

                JButton XXL = new JButton("2XL");
                XXL.setBounds(700,120,50,50);
                XXL.setFont(new Font("Arial", Font.BOLD, 9));
                XXL.setBackground(new Color(255, 209, 220));
                ChooseGown.add(XXL);

                JButton XXXL = new JButton("3XL");
                XXXL.setBounds(770,120,50,50);
                XXXL.setFont(new Font("Arial", Font.BOLD, 9));
                XXXL.setBackground(new Color(255, 209, 220));
                ChooseGown.add(XXXL);

                //Button for Size Dimensions//
                ImageIcon SizeIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\size.png");
                Image Dimen = SizeIcon.getImage();
                Image resizedDimen = Dimen.getScaledInstance(35, 30, Image.SCALE_SMOOTH);
                ImageIcon resizedIconSD = new ImageIcon(resizedDimen);

                JButton SD = new JButton(resizedIconSD);
                SD.setBounds(472, 67, 50,50);
                SD.setContentAreaFilled(false);
                SD.setBorderPainted(false);
                SD.setOpaque(false);
                SD.addActionListener(e -> {
                    Dimensions();
                    });
                ChooseGown.add(SD);


            /*----------------Schedule of Gown Rental---------- */

                        JLabel SchedFrom = new JLabel("Rent From: (dd/mm/yyyy)");
                        SchedFrom.setBounds(600, 230, 200,50);
                        SchedFrom.setFont(new Font("Arial", Font.BOLD, 13));
                        SchedFrom.setForeground(new Color(255, 255, 255));
                        ChooseGown.add(SchedFrom);
                
                        SchedFromtf = new JTextField();
                        SchedFromtf.setBounds(670, 270, 100, 23);
                        ChooseGown.add(SchedFromtf);
                
                        JLabel SchedUntil = new JLabel("Rent Until:     (dd/mm/yyyy)");
                        SchedUntil.setBounds(600, 290, 200,50);
                        SchedUntil.setFont(new Font("Arial", Font.BOLD, 13));
                        SchedUntil.setForeground(new Color(255, 255, 255));
                        ChooseGown.add(SchedUntil);
                
                        SchedUntiltf = new JTextField();
                        SchedUntiltf.setBounds(670, 330, 100, 23);
                        ChooseGown.add(SchedUntiltf);
                
                        /*----------------Button For Schedule----------------------- */
                        ImageIcon calendarIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\calendar.png");
                        Image img = calendarIcon.getImage();
                        Image resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                        ImageIcon resizedIcon = new ImageIcon(resizedImg);

                        JButton Check1 = new JButton(resizedIcon);
                        Check1.setBounds(770, 255, 50,50);
                        Check1.setContentAreaFilled(false);
                        Check1.setBorderPainted(false);
                        Check1.setOpaque(false);
                        ChooseGown.add(Check1);
                
                        JButton Check2 = new JButton(resizedIcon);
                        Check2.setBounds(770, 315, 50,50);
                        Check2.setContentAreaFilled(false);
                        Check2.setBorderPainted(false);
                        Check2.setOpaque(false);
                        ChooseGown.add(Check2);

                        JButton OK = new JButton("Book Now");
                        OK.setBounds(700, 550, 100,40);
                        OK.setBackground(Color.green);
                        ChooseGown.add(OK);

                        


            /*-------------------Gown Days of rental --------------------- */
                Days = new JLabel("Rental Duration: ");
                Days.setBounds(605, 350, 200,50);
                Days.setFont(new Font("Arial", Font.BOLD, 13));
                Days.setForeground(new Color(255, 255, 255));
                ChooseGown.add(Days);
                                   
                /*-------------------Action Button For Sizes and price-------------------- */
                Map<String, String> prices = new HashMap<>();
                prices.put("XS", "Php1,000.00");
                prices.put("S", "Php2,000.00");
                prices.put("M", "Php3,000.00");
                prices.put("L", "Php4,000.00");
                prices.put("XL", "Php5,000.00");
                prices.put("2XL", "Php6,000.00");
                prices.put("3XL", "Php7,000.00");


                
                ActionListener sizeButtonListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton source = (JButton) e.getSource();
                        String size = ""; // Initialize size variable
                        
                        if (source == XS) {
                            size = "XS";
                        }else if (source == S) {
                            size = "S";
                        } else if (source == M) {
                            size = "M"; 
                        } else if (source == L) {
                            size = "L"; 
                        } else if (source == XL) {
                            size = "XL"; 
                        } else if (source == XXL) {
                            size = "2XL"; 
                        } else if (source == XXXL) {
                            size = "3XL"; 
                        }
                        
                
                        // Update SizeDeets JLabel
                        SizeDeets.setText("Gown Size: " + size);
                        // Update GownTotalPrice JLabel based on selected size
                        if (prices.containsKey(size)) {                  
                        PriceDeets.setText("Gown Price: " + prices.get(size));
                        } else {
                    }
                    }
                };
            
                XS.addActionListener(sizeButtonListener);
                S.addActionListener(sizeButtonListener);
                M.addActionListener(sizeButtonListener);
                L.addActionListener(sizeButtonListener);
                XL.addActionListener(sizeButtonListener);
                XXL.addActionListener(sizeButtonListener);
                XXXL.addActionListener(sizeButtonListener);


                /*----------------Panel For Buttons (Colors)------------------ */

                JButton Red = new JButton();
                Red.setBounds(375,240, 40,40);
                Red.setBackground(Color.red);
                ChooseGown.add(Red);

                JButton Orange = new JButton();
                Orange.setBounds(435,240, 40,40);
                Orange.setBackground(Color.orange);
                ChooseGown.add(Orange);

                JButton Yellow = new JButton();
                Yellow.setBounds(375,290, 40,40);
                Yellow.setBackground(Color.yellow);
                ChooseGown.add(Yellow);

                JButton Green = new JButton();
                Green.setBounds(435,290, 40,40);
                Green.setBackground(Color.green);
                ChooseGown.add(Green);

                JButton Blue = new JButton();
                Blue.setBounds(375,340, 40,40);
                Blue.setBackground(Color.blue);
                ChooseGown.add(Blue);

                JButton Purple = new JButton();
                Purple.setBounds(435,340, 40,40);
                Purple.setBackground(new Color(160,32,240));
                ChooseGown.add(Purple);

                JButton Pink = new JButton();
                Pink.setBounds(375,390, 40,40);
                Pink.setBackground(new Color(255, 209,220));
                ChooseGown.add(Pink);

                JButton White = new JButton();
                White.setBounds(435,390, 40,40);
                White.setBackground(new Color(255, 255,255));
                ChooseGown.add(White);


                /*--------------Action Button For Colors-------------- */

                ActionListener colorButtonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    Color color = source.getBackground();
                    String colorName = getColorName(color);

                    // Update ColorDeets JLabel on the EDT
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            ColorDeets.setText("Gown Color: " + colorName);
                        }
                    });
                }

                private String getColorName(Color color) {
                if (color.equals(Color.red)) {
                    return "Red";
                } else if (color.equals(Color.orange)) {
                    return "Orange";
                } else if (color.equals(Color.yellow)) {
                    return "Yellow";
                } else if (color.equals(Color.green)) {
                    return "Green";
                } else if (color.equals(Color.blue)) {
                    return "Blue";
                } else if (color.equals(new Color(160, 32, 240))) {
                    return "Purple";
                } else if (color.equals(new Color(255, 209, 220))) {
                    return "Pink";
                } else if (color.equals(new Color(255, 255, 255))) {
                    return "White";
                } else {
                    return color.toString();
                }
                }
            };
                    
                    // Attach listeners to each color button
                    Red.addActionListener(colorButtonListener);
                    Orange.addActionListener(colorButtonListener);
                    Yellow.addActionListener(colorButtonListener);
                    Green.addActionListener(colorButtonListener);
                    Blue.addActionListener(colorButtonListener);
                    Purple.addActionListener(colorButtonListener);
                    Pink.addActionListener(colorButtonListener);
                    White.addActionListener(colorButtonListener);


                
                    /*-------------------Action Button For Schedule-------------------- */
                    ActionListener SchedButtonListener = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == Check1) { 
                                showCalendarDialog(SchedFromtf);
                                fromDates = SchedFromtf.getText(); // Get text from SchedFromtf
                                FromDeets.setText("Rent From: " + fromDates);
                                Check1T = true;
                            } else if (e.getSource() == Check2) { 
                                showCalendarDialog(SchedUntiltf);
                                untilDates = SchedUntiltf.getText(); // Get text from SchedUntiltf
                                UntilDeets.setText("Rent Until: " + untilDates);
                                calculateRentDuration();
                                Check2T = true;  
                        } else if (e.getSource() == OK) {
                                if (Check1T && Check2T) {
                                receipt();
                                ChooseGown.setVisible(false);
                                mainFrame.switchPanel("loginPanel");
                                RentG1();setVisible(true);
                            }  else {
                                JOptionPane.showMessageDialog(null, "Please fill in all details first.");
                            }
                        }
                    }
                    };

                    Check1.addActionListener(SchedButtonListener);
                    Check2.addActionListener(SchedButtonListener);
                    OK.addActionListener(SchedButtonListener);
                
                

                    /*-------------------Back Button------------- */
                    JButton Back = new JButton("<<<");
                    Back.setBounds(300,0, 100, 70);
                    Back.setFont(new Font("Arial", Font.BOLD, 25));
                    Back.setForeground(Color.red);
                    Back.setOpaque(false);
                    Back.setContentAreaFilled(false);
                    Back.setBorderPainted(false);
                    Back.addActionListener(e -> {
                        ChooseGown.setVisible(false);
                        RentG1();setVisible(true);
                        setLocationRelativeTo(null);
                        
                    });
                    ChooseGown.add(Back);

                    

                    // Frame properties
                    setContentPane(ChooseGown);
                    setTitle("Rent a Gown - A-Line Gown");
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    setSize(900, 700);
                    setLocationRelativeTo(null);
                
                    rentPanel.setVisible(false);
                    setVisible(true);
                    revalidate();
                    repaint();
                    }
    
    private void PickGown2() {

            BG2 = new ImageIcon("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\webweb.png").getImage();


            /*-------------------Choose Gown Main Panel------------------------- */
            // Create a new panel for choosing the gown
            JPanel ChooseGown = new ChooseGown();
            ChooseGown.setLayout(null); 

            // Image Panel for the picked gown
            JPanel PICK1 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\BallGown.png");
            PICK1.setBounds(30, 20, 270, 270);
            ChooseGown.add(PICK1);


            /* ------------------JLabel Inside The Panel ---------------- */
            JLabel Size = new JLabel("Gown Size");
            Size.setFont(new Font("Arial", Font.BOLD, 24));
            Size.setBounds(520, 80, 150,20);
            Size.setForeground(new Color(255, 255, 255));
            ChooseGown.add(Size);

            JLabel GColor = new JLabel("Gown Color");
            GColor.setFont(new Font("Arial", Font.BOLD, 24));
            GColor.setBounds(360, 200, 150,20);
            GColor.setForeground(new Color(255, 255, 255));
            ChooseGown.add(GColor);

            JLabel Schedule = new JLabel("Gown Schedule");
            Schedule.setFont(new Font("Arial", Font.BOLD, 24));
            Schedule.setBounds(600, 200, 200,20);
            Schedule.setForeground(new Color(255, 255, 255));
            ChooseGown.add(Schedule);

            /*---------------------Panel For Customer Details and receipt---------------------- */
            JPanel innerPanel = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\pic1.jpg");
            innerPanel.setPreferredSize(new Dimension(250, 300));
            innerPanel.setBounds(30,320, 270, 320);
            innerPanel.setLayout(null); 
            ChooseGown.add(innerPanel);
        
            CustomerName = new JLabel("Name:      " + NameCon); // + add customer name that field in the rent panel
            CustomerName.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerName.setBounds(11, 10, 200,20);
            innerPanel.add(CustomerName);
    
            CustomerEmail = new JLabel("Email:      " + EmailCon); // + add customer email that field in the rent panel
            CustomerEmail.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerEmail.setBounds(12, 30, 200,20);
            innerPanel.add(CustomerEmail);

            CustomerContact = new JLabel("Contact:  " + ContactCon); // + add customer contact that field in the rent panel
            CustomerContact.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerContact.setBounds(10, 50, 200,20);
            innerPanel.add(CustomerContact);

            CustomerAddress = new JLabel("Address: "); // + add customer address that field in the rent panel
            CustomerAddress.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerAddress.setBounds(10, 70, 200,20);
            innerPanel.add(CustomerAddress);

            CustomerAddress1 = new JLabel(AddressCon);
            CustomerAddress1.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerAddress1.setBounds(10, 90, 250,20);
            innerPanel.add(CustomerAddress1);

            Design0 = new JLabel("-------------------------------------------------------------");
            Design0.setFont(new Font("Arial", Font.BOLD, 13));
            Design0.setBounds(10, 110, 300,20);
            innerPanel.add(Design0);

            SizeDeets = new JLabel("Gown Size: ");
            SizeDeets.setBounds(10, 130, 200, 20); 
            SizeDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(SizeDeets);

            ColorDeets = new JLabel("Gown Color: ");
            ColorDeets.setBounds(10, 150, 200, 20);  
            ColorDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(ColorDeets);

            FromDeets = new JLabel("Rent From: ");
            FromDeets.setBounds(10,170, 250, 20);
            FromDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(FromDeets);

            UntilDeets = new JLabel("Rent Until: ");
            UntilDeets.setBounds(10,190, 250, 20);
            UntilDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(UntilDeets);

            DaysDeets = new JLabel("Rental Duration: ");
            DaysDeets.setBounds(10,210, 250, 20);
            DaysDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(DaysDeets);

            PriceDeets = new JLabel("Gown Price: Php1,400.00");
            PriceDeets.setBounds(10,230, 250, 20);
            PriceDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(PriceDeets);

            PerDay = new JLabel("Overdue Penalty: Php140.00 ");
            PerDay.setBounds(10,250, 250, 20);
            PerDay.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(PerDay);

            /*----------------Panel For Buttons (Size)------------------ */

            JButton XS = new JButton("XS");
            XS.setBounds(340,120,50,50);
            XS.setFont(new Font("Arial", Font.BOLD, 10));
            XS.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XS);

            JButton S = new JButton("S");
            S.setBounds(410,120,50,50);
            S.setFont(new Font("Arial", Font.BOLD, 10));
            S.setBackground(new Color(255, 209, 220));
            ChooseGown.add(S);

            JButton M = new JButton("M");
            M.setBounds(480,120,50,50);
            M.setFont(new Font("Arial", Font.BOLD, 10));
            M.setBackground(new Color(255, 209, 220));
            ChooseGown.add(M);

            JButton L = new JButton("L");
            L.setBounds(550,120,50,50);
            L.setFont(new Font("Arial", Font.BOLD, 10));
            L.setBackground(new Color(255, 209, 220));
            ChooseGown.add(L);

            JButton XL = new JButton("XL");
            XL.setBounds(620,120,50,50);
            XL.setFont(new Font("Arial", Font.BOLD, 10));
            XL.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XL);

            JButton XXL = new JButton("2XL");
            XXL.setBounds(700,120,50,50);
            XXL.setFont(new Font("Arial", Font.BOLD, 9));
            XXL.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XXL);

            JButton XXXL = new JButton("3XL");
            XXXL.setBounds(770,120,50,50);
            XXXL.setFont(new Font("Arial", Font.BOLD, 9));
            XXXL.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XXXL);

            //Button for Size Dimensions//
            ImageIcon SizeIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\size.png");
            Image Dimen = SizeIcon.getImage();
            Image resizedDimen = Dimen.getScaledInstance(35, 30, Image.SCALE_SMOOTH);
            ImageIcon resizedIconSD = new ImageIcon(resizedDimen);

            JButton SD = new JButton(resizedIconSD);
            SD.setBounds(472, 67, 50,50);
            SD.setContentAreaFilled(false);
            SD.setBorderPainted(false);
            SD.setOpaque(false);
            SD.addActionListener(e -> {
                Dimensions();
                });
            ChooseGown.add(SD);

            /*----------------Schedule of Gown Rental---------- */

            JLabel SchedFrom = new JLabel("Rent From: (dd/mm/yyyy)");
            SchedFrom.setBounds(600, 230, 200,50);
            SchedFrom.setFont(new Font("Arial", Font.BOLD, 13));
            SchedFrom.setForeground(new Color(255, 255, 255));
            ChooseGown.add(SchedFrom);
    
            SchedFromtf = new JTextField();
            SchedFromtf.setBounds(670, 270, 100, 23);
            ChooseGown.add(SchedFromtf);
    
            JLabel SchedUntil = new JLabel("Rent Until:     (dd/mm/yyyy)");
            SchedUntil.setBounds(600, 290, 200,50);
            SchedUntil.setFont(new Font("Arial", Font.BOLD, 13));
            SchedUntil.setForeground(new Color(255, 255, 255));
            ChooseGown.add(SchedUntil);
    
            SchedUntiltf = new JTextField();
            SchedUntiltf.setBounds(670, 330, 100, 23);
            ChooseGown.add(SchedUntiltf);
    
            /*----------------Button For Schedule----------------------- */
            ImageIcon calendarIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\calendar.png");
            Image img = calendarIcon.getImage();
            Image resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);

            JButton Check1 = new JButton(resizedIcon);
            Check1.setBounds(770, 255, 50,50);
            Check1.setContentAreaFilled(false);
            Check1.setBorderPainted(false);
            Check1.setOpaque(false);
            ChooseGown.add(Check1);
    
            JButton Check2 = new JButton(resizedIcon);
            Check2.setBounds(770, 315, 50,50);
            Check2.setContentAreaFilled(false);
            Check2.setBorderPainted(false);
            Check2.setOpaque(false);
            ChooseGown.add(Check2);

            JButton OK = new JButton("Book Now");
            OK.setBounds(700, 550, 100,40);
            OK.setBackground(Color.green);
            ChooseGown.add(OK);

            


        /*-------------------Gown Days of rental --------------------- */
            Days = new JLabel("Rental Duration: ");
            Days.setBounds(605, 350, 200,50);
            Days.setFont(new Font("Arial", Font.BOLD, 13));
            Days.setForeground(new Color(255, 255, 255));
            ChooseGown.add(Days);
                        
            
            /*-------------------Action Button For Sizes and price-------------------- */
            Map<String, String> prices = new HashMap<>();
            prices.put("XS", "Php1,400.00");
            prices.put("S", "Php2,400.00");
            prices.put("M", "Php3,400.00");
            prices.put("L", "Php4,400.00");
            prices.put("XL", "Php5,400.00");
            prices.put("2XL", "Php6,400.00");
            prices.put("3XL", "Php7,400.00");


            
            ActionListener sizeButtonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    String size = ""; // Initialize size variable
                    
                    if (source == XS) {
                        size = "XS";
                    }else if (source == S) {
                        size = "S";
                    } else if (source == M) {
                        size = "M"; 
                    } else if (source == L) {
                        size = "L"; 
                    } else if (source == XL) {
                        size = "XL"; 
                    } else if (source == XXL) {
                        size = "2XL"; 
                    } else if (source == XXXL) {
                        size = "3XL"; 
                    }
                    // Update SizeDeets JLabel
                    SizeDeets.setText("Gown Size: " + size);
                    // Update GownTotalPrice JLabel based on selected size
                    if (prices.containsKey(size)) {                  
                    PriceDeets.setText("Gown Price: " + prices.get(size));
                    }else {
                    GownTotalPrice.setText("Gown Total Price: Php0.00"); // Default to zero or handle error
                }
                }
            };
        
            XS.addActionListener(sizeButtonListener);
            S.addActionListener(sizeButtonListener);
            M.addActionListener(sizeButtonListener);
            L.addActionListener(sizeButtonListener);
            XL.addActionListener(sizeButtonListener);
            XXL.addActionListener(sizeButtonListener);
            XXXL.addActionListener(sizeButtonListener);


            /*----------------Panel For Buttons (Colors)------------------ */

            JButton Red = new JButton();
            Red.setBounds(375,240, 40,40);
            Red.setBackground(Color.red);
            ChooseGown.add(Red);

            JButton Orange = new JButton();
            Orange.setBounds(435,240, 40,40);
            Orange.setBackground(Color.orange);
            ChooseGown.add(Orange);

            JButton Yellow = new JButton();
            Yellow.setBounds(375,290, 40,40);
            Yellow.setBackground(Color.yellow);
            ChooseGown.add(Yellow);

            JButton Green = new JButton();
            Green.setBounds(435,290, 40,40);
            Green.setBackground(Color.green);
            ChooseGown.add(Green);

            JButton Blue = new JButton();
            Blue.setBounds(375,340, 40,40);
            Blue.setBackground(Color.blue);
            ChooseGown.add(Blue);

            JButton Purple = new JButton();
            Purple.setBounds(435,340, 40,40);
            Purple.setBackground(new Color(160,32,240));
            ChooseGown.add(Purple);

            JButton Pink = new JButton();
            Pink.setBounds(375,390, 40,40);
            Pink.setBackground(new Color(255, 209,220));
            ChooseGown.add(Pink);

            JButton White = new JButton();
            White.setBounds(435,390, 40,40);
            White.setBackground(new Color(255, 255,255));
            ChooseGown.add(White);


            /*--------------Action Button For Colors-------------- */

            ActionListener colorButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                Color color = source.getBackground();
                String colorName = getColorName(color);

                // Update ColorDeets JLabel on the EDT
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ColorDeets.setText("Gown Color: " + colorName);
                    }
                });
            }

            private String getColorName(Color color) {
                if (color.equals(Color.red)) {
                    return "Red";
                } else if (color.equals(Color.orange)) {
                    return "Orange";
                } else if (color.equals(Color.yellow)) {
                    return "Yellow";
                } else if (color.equals(Color.green)) {
                    return "Green";
                } else if (color.equals(Color.blue)) {
                    return "Blue";
                } else if (color.equals(new Color(160, 32, 240))) {
                    return "Purple";
                } else if (color.equals(new Color(255, 209, 220))) {
                    return "Pink";
                } else if (color.equals(new Color(255, 255, 255))) {
                    return "White";
                } else {
                    return color.toString();
                }
            }
        };
                
                // Attach listeners to each color button
                Red.addActionListener(colorButtonListener);
                Orange.addActionListener(colorButtonListener);
                Yellow.addActionListener(colorButtonListener);
                Green.addActionListener(colorButtonListener);
                Blue.addActionListener(colorButtonListener);
                Purple.addActionListener(colorButtonListener);
                Pink.addActionListener(colorButtonListener);
                White.addActionListener(colorButtonListener);


            
                /*-------------------Action Button For Schedule-------------------- */
                ActionListener SchedButtonListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == Check1) { 
                            showCalendarDialog(SchedFromtf);
                            fromDates = SchedFromtf.getText(); // Get text from SchedFromtf
                            FromDeets.setText("Rent From: " + fromDates);
                            Check1T = true;
                        } else if (e.getSource() == Check2) { 
                            showCalendarDialog(SchedUntiltf);
                            untilDates = SchedUntiltf.getText(); // Get text from SchedUntiltf
                            UntilDeets.setText("Rent Until: " + untilDates);
                            calculateRentDuration();
                            Check2T = true;  
                    } else if (e.getSource() == OK) {
                            if (Check1T && Check2T) {
                            receipt();
                            // Switch back to the rentg1 panel
                            ChooseGown.setVisible(false);
                            mainFrame.switchPanel("loginPanel");
                            RentG1();setVisible(false);
                        }  else {
                            JOptionPane.showMessageDialog(null, "Please fill in all details first.");
                        }
                    }
                }
                };

                Check1.addActionListener(SchedButtonListener);
                Check2.addActionListener(SchedButtonListener);
                OK.addActionListener(SchedButtonListener);
        
        

            /*-------------------Back Button------------- */
            JButton Back = new JButton("<<<");
            Back.setBounds(300,0, 100, 70);
            Back.setFont(new Font("Arial", Font.BOLD, 25));
            Back.setForeground(Color.red);
            Back.setOpaque(false);
            Back.setContentAreaFilled(false);
            Back.setBorderPainted(false);
            Back.addActionListener(e -> {
                ChooseGown.setVisible(false);
                RentG1();setVisible(true);
                setLocationRelativeTo(null);
                
            });
            ChooseGown.add(Back);

            

            // Frame properties
            setContentPane(ChooseGown);
            setTitle("Rent a Gown - Ball Gown");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(900, 700);
            setLocationRelativeTo(null);
        
            rentPanel.setVisible(false);
            setVisible(true);
            revalidate();
            repaint();
        }

    private void PickGown3() {

                 BG2 = new ImageIcon("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\webweb.png").getImage();


                    /*-------------------Choose Gown Main Panel------------------------- */
                    // Create a new panel for choosing the gown
                    JPanel ChooseGown = new ChooseGown();
                    ChooseGown.setLayout(null); 

                    // Image Panel for the picked gown
                    JPanel PICK1 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\CocktailGown.png");
                    PICK1.setBounds(30, 20, 270, 270);
                    ChooseGown.add(PICK1);


                    /* ------------------JLabel Inside The Panel ---------------- */
                    JLabel Size = new JLabel("Gown Size");
                    Size.setFont(new Font("Arial", Font.BOLD, 24));
                    Size.setBounds(520, 80, 150,20);
                    Size.setForeground(new Color(255, 255, 255));
                    ChooseGown.add(Size);

                    JLabel GColor = new JLabel("Gown Color");
                    GColor.setFont(new Font("Arial", Font.BOLD, 24));
                    GColor.setBounds(360, 200, 150,20);
                    GColor.setForeground(new Color(255, 255, 255));
                    ChooseGown.add(GColor);

                    JLabel Schedule = new JLabel("Gown Schedule");
                    Schedule.setFont(new Font("Arial", Font.BOLD, 24));
                    Schedule.setBounds(600, 200, 200,20);
                    Schedule.setForeground(new Color(255, 255, 255));
                    ChooseGown.add(Schedule);





                    /*---------------------Panel For Customer Details and receipt---------------------- */
                    JPanel innerPanel = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\pic1.jpg");
                    innerPanel.setPreferredSize(new Dimension(250, 300));
                    innerPanel.setBounds(30,320, 270, 320);
                    innerPanel.setLayout(null); 
                    ChooseGown.add(innerPanel);
                
                    CustomerName = new JLabel("Name:      " + NameCon); // + add customer name that field in the rent panel
                    CustomerName.setFont(new Font("Arial", Font.BOLD, 13));
                    CustomerName.setBounds(11, 10, 200,20);
                    innerPanel.add(CustomerName);
            
                    CustomerEmail = new JLabel("Email:      " + EmailCon); // + add customer email that field in the rent panel
                    CustomerEmail.setFont(new Font("Arial", Font.BOLD, 13));
                    CustomerEmail.setBounds(12, 30, 200,20);
                    innerPanel.add(CustomerEmail);

                    CustomerContact = new JLabel("Contact:  " + ContactCon); // + add customer contact that field in the rent panel
                    CustomerContact.setFont(new Font("Arial", Font.BOLD, 13));
                    CustomerContact.setBounds(10, 50, 200,20);
                    innerPanel.add(CustomerContact);

                    CustomerAddress = new JLabel("Address: "); // + add customer address that field in the rent panel
                    CustomerAddress.setFont(new Font("Arial", Font.BOLD, 13));
                    CustomerAddress.setBounds(10, 70, 200,20);
                    innerPanel.add(CustomerAddress);

                    CustomerAddress1 = new JLabel(AddressCon);
                    CustomerAddress1.setFont(new Font("Arial", Font.BOLD, 13));
                    CustomerAddress1.setBounds(10, 90, 250,20);
                    innerPanel.add(CustomerAddress1);

                    Design0 = new JLabel("-------------------------------------------------------------");
                    Design0.setFont(new Font("Arial", Font.BOLD, 13));
                    Design0.setBounds(10, 110, 300,20);
                    innerPanel.add(Design0);

                    SizeDeets = new JLabel("Gown Size: ");
                    SizeDeets.setBounds(10, 130, 200, 20); 
                    SizeDeets.setFont(new Font("Arial", Font.BOLD, 13));
                    innerPanel.add(SizeDeets);

                    ColorDeets = new JLabel("Gown Color: ");
                    ColorDeets.setBounds(10, 150, 200, 20);  
                    ColorDeets.setFont(new Font("Arial", Font.BOLD, 13));
                    innerPanel.add(ColorDeets);

                    FromDeets = new JLabel("Rent From: ");
                    FromDeets.setBounds(10,170, 250, 20);
                    FromDeets.setFont(new Font("Arial", Font.BOLD, 13));
                    innerPanel.add(FromDeets);

                    UntilDeets = new JLabel("Rent Until: ");
                    UntilDeets.setBounds(10,190, 250, 20);
                    UntilDeets.setFont(new Font("Arial", Font.BOLD, 13));
                    innerPanel.add(UntilDeets);

                    DaysDeets = new JLabel("Rental Duration: ");
                    DaysDeets.setBounds(10,210, 250, 20);
                    DaysDeets.setFont(new Font("Arial", Font.BOLD, 13));
                    innerPanel.add(DaysDeets);

                    PriceDeets = new JLabel("Gown Price: Php1,300.00");
                    PriceDeets.setBounds(10,230, 250, 20);
                    PriceDeets.setFont(new Font("Arial", Font.BOLD, 13));
                    innerPanel.add(PriceDeets);

                    PerDay = new JLabel("Overdue Penalty: Php130.00 ");
                    PerDay.setBounds(10,250, 250, 20);
                    PerDay.setFont(new Font("Arial", Font.BOLD, 13));
                    innerPanel.add(PerDay);


                    /*----------------Panel For Buttons (Size)------------------ */

                    JButton XS = new JButton("XS");
                    XS.setBounds(340,120,50,50);
                    XS.setFont(new Font("Arial", Font.BOLD, 10));
                    XS.setBackground(new Color(255, 209, 220));
                    ChooseGown.add(XS);

                    JButton S = new JButton("S");
                    S.setBounds(410,120,50,50);
                    S.setFont(new Font("Arial", Font.BOLD, 10));
                    S.setBackground(new Color(255, 209, 220));
                    ChooseGown.add(S);

                    JButton M = new JButton("M");
                    M.setBounds(480,120,50,50);
                    M.setFont(new Font("Arial", Font.BOLD, 10));
                    M.setBackground(new Color(255, 209, 220));
                    ChooseGown.add(M);

                    JButton L = new JButton("L");
                    L.setBounds(550,120,50,50);
                    L.setFont(new Font("Arial", Font.BOLD, 10));
                    L.setBackground(new Color(255, 209, 220));
                    ChooseGown.add(L);

                    JButton XL = new JButton("XL");
                    XL.setBounds(620,120,50,50);
                    XL.setFont(new Font("Arial", Font.BOLD, 10));
                    XL.setBackground(new Color(255, 209, 220));
                    ChooseGown.add(XL);

                    JButton XXL = new JButton("2XL");
                    XXL.setBounds(700,120,50,50);
                    XXL.setFont(new Font("Arial", Font.BOLD, 9));
                    XXL.setBackground(new Color(255, 209, 220));
                    ChooseGown.add(XXL);

                    JButton XXXL = new JButton("3XL");
                    XXXL.setBounds(770,120,50,50);
                    XXXL.setFont(new Font("Arial", Font.BOLD, 9));
                    XXXL.setBackground(new Color(255, 209, 220));
                    ChooseGown.add(XXXL);

                    //Button for Size Dimensions//
                    ImageIcon SizeIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\size.png");
                    Image Dimen = SizeIcon.getImage();
                    Image resizedDimen = Dimen.getScaledInstance(35, 30, Image.SCALE_SMOOTH);
                    ImageIcon resizedIconSD = new ImageIcon(resizedDimen);

                    JButton SD = new JButton(resizedIconSD);
                    SD.setBounds(472, 67, 50,50);
                    SD.setContentAreaFilled(false);
                    SD.setBorderPainted(false);
                    SD.setOpaque(false);
                    SD.addActionListener(e -> {
                        Dimensions();
                        });
                    ChooseGown.add(SD);

                    /*----------------Schedule of Gown Rental---------- */

                    JLabel SchedFrom = new JLabel("Rent From: (dd/mm/yyyy)");
                    SchedFrom.setBounds(600, 230, 200,50);
                    SchedFrom.setFont(new Font("Arial", Font.BOLD, 13));
                    SchedFrom.setForeground(new Color(255, 255, 255));
                    ChooseGown.add(SchedFrom);
            
                    SchedFromtf = new JTextField();
                    SchedFromtf.setBounds(670, 270, 100, 23);
                    ChooseGown.add(SchedFromtf);
            
                    JLabel SchedUntil = new JLabel("Rent Until:     (dd/mm/yyyy)");
                    SchedUntil.setBounds(600, 290, 200,50);
                    SchedUntil.setFont(new Font("Arial", Font.BOLD, 13));
                    SchedUntil.setForeground(new Color(255, 255, 255));
                    ChooseGown.add(SchedUntil);
            
                    SchedUntiltf = new JTextField();
                    SchedUntiltf.setBounds(670, 330, 100, 23);
                    ChooseGown.add(SchedUntiltf);
            
                    /*----------------Button For Schedule----------------------- */
                    ImageIcon calendarIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\calendar.png");
                    Image img = calendarIcon.getImage();
                    Image resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImg);

                    JButton Check1 = new JButton(resizedIcon);
                    Check1.setBounds(770, 255, 50,50);
                    Check1.setContentAreaFilled(false);
                    Check1.setBorderPainted(false);
                    Check1.setOpaque(false);
                    ChooseGown.add(Check1);
            
                    JButton Check2 = new JButton(resizedIcon);
                    Check2.setBounds(770, 315, 50,50);
                    Check2.setContentAreaFilled(false);
                    Check2.setBorderPainted(false);
                    Check2.setOpaque(false);
                    ChooseGown.add(Check2);

                    JButton OK = new JButton("Book Now");
                    OK.setBounds(700, 550, 100,40);
                    OK.setBackground(Color.green);
                    ChooseGown.add(OK);

                /*-------------------Gown Days of rental --------------------- */
                    Days = new JLabel("Rental Duration: ");
                    Days.setBounds(605, 350, 200,50);
                    Days.setFont(new Font("Arial", Font.BOLD, 13));
                    Days.setForeground(new Color(255, 255, 255));
                    ChooseGown.add(Days);
                                        
                    

                    /*-------------------Action Button For Sizes and price-------------------- */
                    Map<String, String> prices = new HashMap<>();
                    prices.put("XS", "Php1,300.00");
                    prices.put("S", "Php2,300.00");
                    prices.put("M", "Php3,300.00");
                    prices.put("L", "Php4,300.00");
                    prices.put("XL", "Php5,300.00");
                    prices.put("2XL", "Php6,300.00");
                    prices.put("3XL", "Php7,300.00");


                    
                    ActionListener sizeButtonListener = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton source = (JButton) e.getSource();
                            String size = ""; // Initialize size variable
                            
                            if (source == XS) {
                                size = "XS";
                            }else if (source == S) {
                                size = "S";
                            } else if (source == M) {
                                size = "M"; 
                            } else if (source == L) {
                                size = "L"; 
                            } else if (source == XL) {
                                size = "XL"; 
                            } else if (source == XXL) {
                                size = "2XL"; 
                            } else if (source == XXXL) {
                                size = "3XL"; 
                            }
                           // Update SizeDeets JLabel
                        SizeDeets.setText("Gown Size: " + size);
                        // Update GownTotalPrice JLabel based on selected size
                        if (prices.containsKey(size)) {                  
                        PriceDeets.setText("Gown Price: " + prices.get(size));
                        } else {
                            GownTotalPrice.setText("Gown Total Price: Php0.00"); // Default to zero or handle error
                        }
                        }
                    };
                
                    XS.addActionListener(sizeButtonListener);
                    S.addActionListener(sizeButtonListener);
                    M.addActionListener(sizeButtonListener);
                    L.addActionListener(sizeButtonListener);
                    XL.addActionListener(sizeButtonListener);
                    XXL.addActionListener(sizeButtonListener);
                    XXXL.addActionListener(sizeButtonListener);


                    /*----------------Panel For Buttons (Colors)------------------ */

                    JButton Red = new JButton();
                    Red.setBounds(375,240, 40,40);
                    Red.setBackground(Color.red);
                    ChooseGown.add(Red);

                    JButton Orange = new JButton();
                    Orange.setBounds(435,240, 40,40);
                    Orange.setBackground(Color.orange);
                    ChooseGown.add(Orange);

                    JButton Yellow = new JButton();
                    Yellow.setBounds(375,290, 40,40);
                    Yellow.setBackground(Color.yellow);
                    ChooseGown.add(Yellow);

                    JButton Green = new JButton();
                    Green.setBounds(435,290, 40,40);
                    Green.setBackground(Color.green);
                    ChooseGown.add(Green);

                    JButton Blue = new JButton();
                    Blue.setBounds(375,340, 40,40);
                    Blue.setBackground(Color.blue);
                    ChooseGown.add(Blue);

                    JButton Purple = new JButton();
                    Purple.setBounds(435,340, 40,40);
                    Purple.setBackground(new Color(160,32,240));
                    ChooseGown.add(Purple);

                    JButton Pink = new JButton();
                    Pink.setBounds(375,390, 40,40);
                    Pink.setBackground(new Color(255, 209,220));
                    ChooseGown.add(Pink);

                    JButton White = new JButton();
                    White.setBounds(435,390, 40,40);
                    White.setBackground(new Color(255, 255,255));
                    ChooseGown.add(White);


                    /*--------------Action Button For Colors-------------- */

                    ActionListener colorButtonListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton source = (JButton) e.getSource();
                        Color color = source.getBackground();
                        String colorName = getColorName(color);

                        // Update ColorDeets JLabel on the EDT
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                ColorDeets.setText("Gown Color: " + colorName);
                            }
                        });
                    }

                    private String getColorName(Color color) {
                        if (color.equals(Color.red)) {
                            return "Red";
                        } else if (color.equals(Color.orange)) {
                            return "Orange";
                        } else if (color.equals(Color.yellow)) {
                            return "Yellow";
                        } else if (color.equals(Color.green)) {
                            return "Green";
                        } else if (color.equals(Color.blue)) {
                            return "Blue";
                        } else if (color.equals(new Color(160, 32, 240))) {
                            return "Purple";
                        } else if (color.equals(new Color(255, 209, 220))) {
                            return "Pink";
                        } else if (color.equals(new Color(255, 255, 255))) {
                            return "White";
                        } else {
                            return color.toString();
                        }
                    }
                };
                        
                        // Attach listeners to each color button
                        Red.addActionListener(colorButtonListener);
                        Orange.addActionListener(colorButtonListener);
                        Yellow.addActionListener(colorButtonListener);
                        Green.addActionListener(colorButtonListener);
                        Blue.addActionListener(colorButtonListener);
                        Purple.addActionListener(colorButtonListener);
                        Pink.addActionListener(colorButtonListener);
                        White.addActionListener(colorButtonListener);


                    
                        /*-------------------Action Button For Schedule-------------------- */
                        ActionListener SchedButtonListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (e.getSource() == Check1) { 
                                    showCalendarDialog(SchedFromtf);
                                    fromDates = SchedFromtf.getText(); // Get text from SchedFromtf
                                    FromDeets.setText("Rent From: " + fromDates);
                                    Check1T = true;
                                } else if (e.getSource() == Check2) { 
                                    showCalendarDialog(SchedUntiltf);
                                    untilDates = SchedUntiltf.getText(); // Get text from SchedUntiltf
                                    UntilDeets.setText("Rent Until: " + untilDates);
                                    calculateRentDuration();
                                    Check2T = true;  
                            } else if (e.getSource() == OK) {
                                    if (Check1T && Check2T) {
                                    receipt();
                                    ChooseGown.setVisible(false);
                                    mainFrame.switchPanel("loginPanel");
                                    RentG1();setVisible(true);
                                }  else {
                                    JOptionPane.showMessageDialog(null, "Please fill in all details first.");
                                }
                            }
                        }
                        };
    
                        Check1.addActionListener(SchedButtonListener);
                        Check2.addActionListener(SchedButtonListener);
                        OK.addActionListener(SchedButtonListener);

                        /*-------------------Back Button------------- */
                        JButton Back = new JButton("<<<");
                        Back.setBounds(300,0, 100, 70);
                        Back.setFont(new Font("Arial", Font.BOLD, 25));
                        Back.setForeground(Color.red);
                        Back.setOpaque(false);
                        Back.setContentAreaFilled(false);
                        Back.setBorderPainted(false);
                        Back.addActionListener(e -> {
                            ChooseGown.setVisible(false);
                            RentG1();setVisible(true);
                            setLocationRelativeTo(null);
                            
                        });
                        ChooseGown.add(Back);

                        // Frame properties
                        setContentPane(ChooseGown);
                        setTitle("Rent a Gown - Cocktail Gown");
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        setSize(900, 700);
                        setLocationRelativeTo(null);
                    
                        rentPanel.setVisible(false);
                        setVisible(true);
                        revalidate();
                        repaint();
                    }

    private void PickGown4() {

            BG2 = new ImageIcon("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\webweb.png").getImage();


            /*-------------------Choose Gown Main Panel------------------------- */
            // Create a new panel for choosing the gown
            JPanel ChooseGown = new ChooseGown();
            ChooseGown.setLayout(null); 

            // Image Panel for the picked gown
            JPanel PICK1 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\EmpireStyleGown.png");
            PICK1.setBounds(30, 20, 270, 270);
            ChooseGown.add(PICK1);


            /* ------------------JLabel Inside The Panel ---------------- */
            JLabel Size = new JLabel("Gown Size");
            Size.setFont(new Font("Arial", Font.BOLD, 24));
            Size.setBounds(520, 80, 150,20);
            Size.setForeground(new Color(255, 255, 255));
            ChooseGown.add(Size);

            JLabel GColor = new JLabel("Gown Color");
            GColor.setFont(new Font("Arial", Font.BOLD, 24));
            GColor.setBounds(360, 200, 150,20);
            GColor.setForeground(new Color(255, 255, 255));
            ChooseGown.add(GColor);

            JLabel Schedule = new JLabel("Gown Schedule");
            Schedule.setFont(new Font("Arial", Font.BOLD, 24));
            Schedule.setBounds(600, 200, 200,20);
            Schedule.setForeground(new Color(255, 255, 255));
            ChooseGown.add(Schedule);





            /*---------------------Panel For Customer Details and receipt---------------------- */
            JPanel innerPanel = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\pic1.jpg");
            innerPanel.setPreferredSize(new Dimension(250, 300));
            innerPanel.setBounds(30,320, 270, 320);
            innerPanel.setLayout(null); 
            ChooseGown.add(innerPanel);
        
            CustomerName = new JLabel("Name:      " + NameCon); // + add customer name that field in the rent panel
            CustomerName.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerName.setBounds(11, 10, 200,20);
            innerPanel.add(CustomerName);
    
            CustomerEmail = new JLabel("Email:      " + EmailCon); // + add customer email that field in the rent panel
            CustomerEmail.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerEmail.setBounds(12, 30, 200,20);
            innerPanel.add(CustomerEmail);

            CustomerContact = new JLabel("Contact:  " + ContactCon); // + add customer contact that field in the rent panel
            CustomerContact.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerContact.setBounds(10, 50, 200,20);
            innerPanel.add(CustomerContact);

            CustomerAddress = new JLabel("Address: "); // + add customer address that field in the rent panel
            CustomerAddress.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerAddress.setBounds(10, 70, 200,20);
            innerPanel.add(CustomerAddress);

            CustomerAddress1 = new JLabel(AddressCon);
            CustomerAddress1.setFont(new Font("Arial", Font.BOLD, 13));
            CustomerAddress1.setBounds(10, 90, 250,20);
            innerPanel.add(CustomerAddress1);

            Design0 = new JLabel("-------------------------------------------------------------");
            Design0.setFont(new Font("Arial", Font.BOLD, 13));
            Design0.setBounds(10, 110, 300,20);
            innerPanel.add(Design0);

            SizeDeets = new JLabel("Gown Size: ");
            SizeDeets.setBounds(10, 130, 200, 20); 
            SizeDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(SizeDeets);

            ColorDeets = new JLabel("Gown Color: ");
            ColorDeets.setBounds(10, 150, 200, 20);  
            ColorDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(ColorDeets);

            FromDeets = new JLabel("Rent From: ");
            FromDeets.setBounds(10,170, 250, 20);
            FromDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(FromDeets);

            UntilDeets = new JLabel("Rent Until: ");
            UntilDeets.setBounds(10,190, 250, 20);
            UntilDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(UntilDeets);

            DaysDeets = new JLabel("Rental Duration: ");
            DaysDeets.setBounds(10,210, 250, 20);
            DaysDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(DaysDeets);

            PriceDeets = new JLabel("Gown Price: Php1,200.00");
            PriceDeets.setBounds(10,230, 250, 20);
            PriceDeets.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(PriceDeets);

            PerDay = new JLabel("Overdue Penalty: Php120.00 ");
            PerDay.setBounds(10,250, 250, 20);
            PerDay.setFont(new Font("Arial", Font.BOLD, 13));
            innerPanel.add(PerDay);

            /*----------------Panel For Buttons (Size)------------------ */

            JButton XS = new JButton("XS");
            XS.setBounds(340,120,50,50);
            XS.setFont(new Font("Arial", Font.BOLD, 10));
            XS.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XS);

            JButton S = new JButton("S");
            S.setBounds(410,120,50,50);
            S.setFont(new Font("Arial", Font.BOLD, 10));
            S.setBackground(new Color(255, 209, 220));
            ChooseGown.add(S);

            JButton M = new JButton("M");
            M.setBounds(480,120,50,50);
            M.setFont(new Font("Arial", Font.BOLD, 10));
            M.setBackground(new Color(255, 209, 220));
            ChooseGown.add(M);

            JButton L = new JButton("L");
            L.setBounds(550,120,50,50);
            L.setFont(new Font("Arial", Font.BOLD, 10));
            L.setBackground(new Color(255, 209, 220));
            ChooseGown.add(L);

            JButton XL = new JButton("XL");
            XL.setBounds(620,120,50,50);
            XL.setFont(new Font("Arial", Font.BOLD, 10));
            XL.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XL);

            JButton XXL = new JButton("2XL");
            XXL.setBounds(700,120,50,50);
            XXL.setFont(new Font("Arial", Font.BOLD, 9));
            XXL.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XXL);

            JButton XXXL = new JButton("3XL");
            XXXL.setBounds(770,120,50,50);
            XXXL.setFont(new Font("Arial", Font.BOLD, 9));
            XXXL.setBackground(new Color(255, 209, 220));
            ChooseGown.add(XXXL);

            //Button for Size Dimensions//
            ImageIcon SizeIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\size.png");
            Image Dimen = SizeIcon.getImage();
            Image resizedDimen = Dimen.getScaledInstance(35, 30, Image.SCALE_SMOOTH);
            ImageIcon resizedIconSD = new ImageIcon(resizedDimen);

            JButton SD = new JButton(resizedIconSD);
            SD.setBounds(472, 67, 50,50);
            SD.setContentAreaFilled(false);
            SD.setBorderPainted(false);
            SD.setOpaque(false);
            SD.addActionListener(e -> {
                Dimensions();
            });
            ChooseGown.add(SD);            


            //*----------------Schedule of Gown Rental---------- */

            JLabel SchedFrom = new JLabel("Rent From: (dd/mm/yyyy)");
            SchedFrom.setBounds(600, 230, 200,50);
            SchedFrom.setFont(new Font("Arial", Font.BOLD, 13));
            SchedFrom.setForeground(new Color(255, 255, 255));
            ChooseGown.add(SchedFrom);
    
            SchedFromtf = new JTextField();
            SchedFromtf.setBounds(670, 270, 100, 23);
            ChooseGown.add(SchedFromtf);
    
            JLabel SchedUntil = new JLabel("Rent Until:     (dd/mm/yyyy)");
            SchedUntil.setBounds(600, 290, 200,50);
            SchedUntil.setFont(new Font("Arial", Font.BOLD, 13));
            SchedUntil.setForeground(new Color(255, 255, 255));
            ChooseGown.add(SchedUntil);
    
            SchedUntiltf = new JTextField();
            SchedUntiltf.setBounds(670, 330, 100, 23);
            ChooseGown.add(SchedUntiltf);
    
            /*----------------Button For Schedule----------------------- */
            ImageIcon calendarIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\calendar.png");
            Image img = calendarIcon.getImage();
            Image resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);

            JButton Check1 = new JButton(resizedIcon);
            Check1.setBounds(770, 255, 50,50);
            Check1.setContentAreaFilled(false);
            Check1.setBorderPainted(false);
            Check1.setOpaque(false);
            ChooseGown.add(Check1);
    
            JButton Check2 = new JButton(resizedIcon);
            Check2.setBounds(770, 315, 50,50);
            Check2.setContentAreaFilled(false);
            Check2.setBorderPainted(false);
            Check2.setOpaque(false);
            ChooseGown.add(Check2);

            JButton OK = new JButton("Book Now");
            OK.setBounds(700, 550, 100,40);
            OK.setBackground(Color.green);
            ChooseGown.add(OK);

            


        /*-------------------Gown Days of rental --------------------- */
            Days = new JLabel("Rental Duration: ");
            Days.setBounds(605, 350, 200,50);
            Days.setFont(new Font("Arial", Font.BOLD, 13));
            Days.setForeground(new Color(255, 255, 255));
            ChooseGown.add(Days);
                       

            /*-------------------Action Button For Sizes and price-------------------- */
            Map<String, String> prices = new HashMap<>();
            prices.put("XS", "Php1,200.00");
            prices.put("S", "Php2,200.00");
            prices.put("M", "Php3,200.00");
            prices.put("L", "Php4,200.00");
            prices.put("XL", "Php5,200.00");
            prices.put("2XL", "Php6,200.00");
            prices.put("3XL", "Php7,200.00");


            
            ActionListener sizeButtonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    String size = ""; // Initialize size variable
                    
                    if (source == XS) {
                        size = "XS";
                    }else if (source == S) {
                        size = "S";
                    } else if (source == M) {
                        size = "M"; 
                    } else if (source == L) {
                        size = "L"; 
                    } else if (source == XL) {
                        size = "XL"; 
                    } else if (source == XXL) {
                        size = "2XL"; 
                    } else if (source == XXXL) {
                        size = "3XL"; 
                    }
                    // Update SizeDeets JLabel
                    SizeDeets.setText("Gown Size: " + size);
                    // Update GownTotalPrice JLabel based on selected size
                    if (prices.containsKey(size)) {                  
                    PriceDeets.setText("Gown Price: " + prices.get(size));
                    } else {
                    GownTotalPrice.setText("Gown Total Price: Php0.00"); // Default to zero or handle error
                }
                }
            };
        
            XS.addActionListener(sizeButtonListener);
            S.addActionListener(sizeButtonListener);
            M.addActionListener(sizeButtonListener);
            L.addActionListener(sizeButtonListener);
            XL.addActionListener(sizeButtonListener);
            XXL.addActionListener(sizeButtonListener);
            XXXL.addActionListener(sizeButtonListener);


            /*----------------Panel For Buttons (Colors)------------------ */

            JButton Red = new JButton();
            Red.setBounds(375,240, 40,40);
            Red.setBackground(Color.red);
            ChooseGown.add(Red);

            JButton Orange = new JButton();
            Orange.setBounds(435,240, 40,40);
            Orange.setBackground(Color.orange);
            ChooseGown.add(Orange);

            JButton Yellow = new JButton();
            Yellow.setBounds(375,290, 40,40);
            Yellow.setBackground(Color.yellow);
            ChooseGown.add(Yellow);

            JButton Green = new JButton();
            Green.setBounds(435,290, 40,40);
            Green.setBackground(Color.green);
            ChooseGown.add(Green);

            JButton Blue = new JButton();
            Blue.setBounds(375,340, 40,40);
            Blue.setBackground(Color.blue);
            ChooseGown.add(Blue);

            JButton Purple = new JButton();
            Purple.setBounds(435,340, 40,40);
            Purple.setBackground(new Color(160,32,240));
            ChooseGown.add(Purple);

            JButton Pink = new JButton();
            Pink.setBounds(375,390, 40,40);
            Pink.setBackground(new Color(255, 209,220));
            ChooseGown.add(Pink);

            JButton White = new JButton();
            White.setBounds(435,390, 40,40);
            White.setBackground(new Color(255, 255,255));
            ChooseGown.add(White);


            /*--------------Action Button For Colors-------------- */

            ActionListener colorButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                Color color = source.getBackground();
                String colorName = getColorName(color);

                // Update ColorDeets JLabel on the EDT
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ColorDeets.setText("Gown Color: " + colorName);
                    }
                });
            }

            private String getColorName(Color color) {
                if (color.equals(Color.red)) {
                    return "Red";
                } else if (color.equals(Color.orange)) {
                    return "Orange";
                } else if (color.equals(Color.yellow)) {
                    return "Yellow";
                } else if (color.equals(Color.green)) {
                    return "Green";
                } else if (color.equals(Color.blue)) {
                    return "Blue";
                } else if (color.equals(new Color(160, 32, 240))) {
                    return "Purple";
                } else if (color.equals(new Color(255, 209, 220))) {
                    return "Pink";
                } else if (color.equals(new Color(255, 255, 255))) {
                    return "White";
                } else {
                    return color.toString();
                }
            }
        };
                
                // Attach listeners to each color button
                Red.addActionListener(colorButtonListener);
                Orange.addActionListener(colorButtonListener);
                Yellow.addActionListener(colorButtonListener);
                Green.addActionListener(colorButtonListener);
                Blue.addActionListener(colorButtonListener);
                Purple.addActionListener(colorButtonListener);
                Pink.addActionListener(colorButtonListener);
                White.addActionListener(colorButtonListener);


            
                /*-------------------Action Button For Schedule-------------------- */
                ActionListener SchedButtonListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == Check1) { 
                            showCalendarDialog(SchedFromtf);
                            fromDates = SchedFromtf.getText(); // Get text from SchedFromtf
                            FromDeets.setText("Rent From: " + fromDates);
                            Check1T = true;
                        } else if (e.getSource() == Check2) { 
                            showCalendarDialog(SchedUntiltf);
                            untilDates = SchedUntiltf.getText(); // Get text from SchedUntiltf
                            UntilDeets.setText("Rent Until: " + untilDates);
                            calculateRentDuration();
                            Check2T = true;  
                    } else if (e.getSource() == OK) {
                            if (Check1T && Check2T) {
                            receipt();
                            ChooseGown.setVisible(false);
                            mainFrame.switchPanel("loginPanel");
                            RentG1();setVisible(true);
                        }  else {
                            JOptionPane.showMessageDialog(null, "Please fill in all details first.");
                        }
                    }
                }
                };

                Check1.addActionListener(SchedButtonListener);
                Check2.addActionListener(SchedButtonListener);
                OK.addActionListener(SchedButtonListener);
            

                /*-------------------Back Button------------- */
                JButton Back = new JButton("<<<");
                Back.setBounds(300,0, 100, 70);
                Back.setFont(new Font("Arial", Font.BOLD, 25));
                Back.setForeground(Color.red);
                Back.setOpaque(false);
                Back.setContentAreaFilled(false);
                Back.setBorderPainted(false);
                Back.addActionListener(e -> {
                    ChooseGown.setVisible(false);
                    RentG1();setVisible(true);
                    setLocationRelativeTo(null);
                    
                });
                ChooseGown.add(Back);

                

                // Frame properties
                setContentPane(ChooseGown);
                setTitle("Rent a Gown - Empire Style Gown");
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setSize(900, 700);
                setLocationRelativeTo(null);
            
                rentPanel.setVisible(false);
                setVisible(true);
                revalidate();
                repaint();
            }

    private void PickGown5() {

        BG2 = new ImageIcon("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\webweb.png").getImage();


        /*-------------------Choose Gown Main Panel------------------------- */
        // Create a new panel for choosing the gown
        JPanel ChooseGown = new ChooseGown();
        ChooseGown.setLayout(null); 

        // Image Panel for the picked gown
        JPanel PICK1 = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\MermaidGown.png");
        PICK1.setBounds(30, 20, 270, 270);
        ChooseGown.add(PICK1);


        /* ------------------JLabel Inside The Panel ---------------- */
        JLabel Size = new JLabel("Gown Size");
        Size.setFont(new Font("Arial", Font.BOLD, 24));
        Size.setBounds(520, 80, 150,20);
        Size.setForeground(new Color(255, 255, 255));
        ChooseGown.add(Size);

        JLabel GColor = new JLabel("Gown Color");
        GColor.setFont(new Font("Arial", Font.BOLD, 24));
        GColor.setBounds(360, 200, 150,20);
        GColor.setForeground(new Color(255, 255, 255));
        ChooseGown.add(GColor);

        JLabel Schedule = new JLabel("Gown Schedule");
        Schedule.setFont(new Font("Arial", Font.BOLD, 24));
        Schedule.setBounds(600, 200, 200,20);
        Schedule.setForeground(new Color(255, 255, 255));
        ChooseGown.add(Schedule);

        /*---------------------Panel For Customer Details and receipt---------------------- */
        JPanel innerPanel = new ImagePanel("C:\\Users\\Admin\\Desktop\\JavaGui\\T1Gown\\GownTest1\\src\\lib\\pic1.jpg");
        innerPanel.setPreferredSize(new Dimension(250, 300));
        innerPanel.setBounds(30,320, 270, 320);
        innerPanel.setLayout(null); 
        ChooseGown.add(innerPanel);
    
        CustomerName = new JLabel("Name:      " + NameCon); // + add customer name that field in the rent panel
        CustomerName.setFont(new Font("Arial", Font.BOLD, 13));
        CustomerName.setBounds(11, 10, 200,20);
        innerPanel.add(CustomerName);
 
        CustomerEmail = new JLabel("Email:      " + EmailCon); // + add customer email that field in the rent panel
        CustomerEmail.setFont(new Font("Arial", Font.BOLD, 13));
        CustomerEmail.setBounds(12, 30, 200,20);
        innerPanel.add(CustomerEmail);

        CustomerContact = new JLabel("Contact:  " + ContactCon); // + add customer contact that field in the rent panel
        CustomerContact.setFont(new Font("Arial", Font.BOLD, 13));
        CustomerContact.setBounds(10, 50, 200,20);
        innerPanel.add(CustomerContact);

        CustomerAddress = new JLabel("Address: "); // + add customer address that field in the rent panel
        CustomerAddress.setFont(new Font("Arial", Font.BOLD, 13));
        CustomerAddress.setBounds(10, 70, 200,20);
        innerPanel.add(CustomerAddress);

        CustomerAddress1 = new JLabel(AddressCon);
        CustomerAddress1.setFont(new Font("Arial", Font.BOLD, 13));
        CustomerAddress1.setBounds(10, 90, 250,20);
        innerPanel.add(CustomerAddress1);

        Design0 = new JLabel("-------------------------------------------------------------");
        Design0.setFont(new Font("Arial", Font.BOLD, 13));
        Design0.setBounds(10, 110, 300,20);
        innerPanel.add(Design0);

        SizeDeets = new JLabel("Gown Size: ");
        SizeDeets.setBounds(10, 130, 200, 20); 
        SizeDeets.setFont(new Font("Arial", Font.BOLD, 13));
        innerPanel.add(SizeDeets);

        ColorDeets = new JLabel("Gown Color: ");
        ColorDeets.setBounds(10, 150, 200, 20);  
        ColorDeets.setFont(new Font("Arial", Font.BOLD, 13));
        innerPanel.add(ColorDeets);

        FromDeets = new JLabel("Rent From: ");
        FromDeets.setBounds(10,170, 250, 20);
        FromDeets.setFont(new Font("Arial", Font.BOLD, 13));
        innerPanel.add(FromDeets);

        UntilDeets = new JLabel("Rent Until: ");
        UntilDeets.setBounds(10,190, 250, 20);
        UntilDeets.setFont(new Font("Arial", Font.BOLD, 13));
        innerPanel.add(UntilDeets);

        DaysDeets = new JLabel("Rental Duration: ");
        DaysDeets.setBounds(10,210, 250, 20);
        DaysDeets.setFont(new Font("Arial", Font.BOLD, 13));
        innerPanel.add(DaysDeets);

        PriceDeets = new JLabel("Gown Price: Php1,100.00");
        PriceDeets.setBounds(10,230, 250, 20);
        PriceDeets.setFont(new Font("Arial", Font.BOLD, 13));
        innerPanel.add(PriceDeets);

        PerDay = new JLabel("Overdue Penalty: Php110.00 ");
        PerDay.setBounds(10,250, 250, 20);
        PerDay.setFont(new Font("Arial", Font.BOLD, 13));
        innerPanel.add(PerDay);


        /*----------------Panel For Buttons (Size)------------------ */

        JButton XS = new JButton("XS");
        XS.setBounds(340,120,50,50);
        XS.setFont(new Font("Arial", Font.BOLD, 10));
        XS.setBackground(new Color(255, 209, 220));
        ChooseGown.add(XS);

        JButton S = new JButton("S");
        S.setBounds(410,120,50,50);
        S.setFont(new Font("Arial", Font.BOLD, 10));
        S.setBackground(new Color(255, 209, 220));
        ChooseGown.add(S);

        JButton M = new JButton("M");
        M.setBounds(480,120,50,50);
        M.setFont(new Font("Arial", Font.BOLD, 10));
        M.setBackground(new Color(255, 209, 220));
        ChooseGown.add(M);

        JButton L = new JButton("L");
        L.setBounds(550,120,50,50);
        L.setFont(new Font("Arial", Font.BOLD, 10));
        L.setBackground(new Color(255, 209, 220));
        ChooseGown.add(L);

        JButton XL = new JButton("XL");
        XL.setBounds(620,120,50,50);
        XL.setFont(new Font("Arial", Font.BOLD, 10));
        XL.setBackground(new Color(255, 209, 220));
        ChooseGown.add(XL);

        JButton XXL = new JButton("2XL");
        XXL.setBounds(700,120,50,50);
        XXL.setFont(new Font("Arial", Font.BOLD, 9));
        XXL.setBackground(new Color(255, 209, 220));
        ChooseGown.add(XXL);

        JButton XXXL = new JButton("3XL");
        XXXL.setBounds(770,120,50,50);
        XXXL.setFont(new Font("Arial", Font.BOLD, 9));
        XXXL.setBackground(new Color(255, 209, 220));
        ChooseGown.add(XXXL);

        //Button for Size Dimensions//
        ImageIcon SizeIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\size.png");
        Image Dimen = SizeIcon.getImage();
        Image resizedDimen = Dimen.getScaledInstance(35, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIconSD = new ImageIcon(resizedDimen);

        JButton SD = new JButton(resizedIconSD);
        SD.setBounds(472, 67, 50,50);
        SD.setContentAreaFilled(false);
        SD.setBorderPainted(false);
        SD.setOpaque(false);
        SD.addActionListener(e -> {
            Dimensions();
        });
        ChooseGown.add(SD); 


        /*----------------Schedule of Gown Rental---------- */

        JLabel SchedFrom = new JLabel("Rent From: (dd/mm/yyyy)");
        SchedFrom.setBounds(600, 230, 200,50);
        SchedFrom.setFont(new Font("Arial", Font.BOLD, 13));
        SchedFrom.setForeground(new Color(255, 255, 255));
        ChooseGown.add(SchedFrom);

        SchedFromtf = new JTextField();
        SchedFromtf.setBounds(670, 270, 100, 23);
        ChooseGown.add(SchedFromtf);

        JLabel SchedUntil = new JLabel("Rent Until:     (dd/mm/yyyy)");
        SchedUntil.setBounds(600, 290, 200,50);
        SchedUntil.setFont(new Font("Arial", Font.BOLD, 13));
        SchedUntil.setForeground(new Color(255, 255, 255));
        ChooseGown.add(SchedUntil);

        SchedUntiltf = new JTextField();
        SchedUntiltf.setBounds(670, 330, 100, 23);
        ChooseGown.add(SchedUntiltf);

        /*----------------Button For Schedule----------------------- */
        ImageIcon calendarIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\GUIGOWN\\rent\\src\\packageGui\\calendar.png");
        Image img = calendarIcon.getImage();
        Image resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);

        JButton Check1 = new JButton(resizedIcon);
        Check1.setBounds(770, 255, 50,50);
        Check1.setContentAreaFilled(false);
        Check1.setBorderPainted(false);
        Check1.setOpaque(false);
        ChooseGown.add(Check1);

        JButton Check2 = new JButton(resizedIcon);
        Check2.setBounds(770, 315, 50,50);
        Check2.setContentAreaFilled(false);
        Check2.setBorderPainted(false);
        Check2.setOpaque(false);
        ChooseGown.add(Check2);

        JButton OK = new JButton("Book Now");
        OK.setBounds(700, 550, 100,40);
        OK.setBackground(Color.green);
        ChooseGown.add(OK);

        


        /*-------------------Gown Days of rental --------------------- */
        Days = new JLabel("Rental Duration: ");
        Days.setBounds(605, 350, 200,50);
        Days.setFont(new Font("Arial", Font.BOLD, 13));
        Days.setForeground(new Color(255, 255, 255));
        ChooseGown.add(Days);
                        

        /*-------------------Action Button For Sizes and price-------------------- */
        Map<String, String> prices = new HashMap<>();
        prices.put("XS", "Php1,100.00");
        prices.put("S", "Php2,100.00");
        prices.put("M", "Php3,100.00");
        prices.put("L", "Php4,100.00");
        prices.put("XL", "Php5,100.00");
        prices.put("2XL", "Php6,100.00");
        prices.put("3XL", "Php7,100.00");


        
        ActionListener sizeButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String size = ""; // Initialize size variable
                
                if (source == XS) {
                    size = "XS";
                }else if (source == S) {
                    size = "S";
                } else if (source == M) {
                    size = "M"; 
                } else if (source == L) {
                    size = "L"; 
                } else if (source == XL) {
                    size = "XL"; 
                } else if (source == XXL) {
                    size = "2XL"; 
                } else if (source == XXXL) {
                    size = "3XL"; 
                }
                // Update SizeDeets JLabel
                SizeDeets.setText("Gown Size: " + size);
                // Update GownTotalPrice JLabel based on selected size
                if (prices.containsKey(size)) {                  
                PriceDeets.setText("Gown Price: " + prices.get(size));
                } else {
                GownTotalPrice.setText("Gown Total Price: Php0.00"); // Default to zero or handle error
             }
            }
        };
    
        XS.addActionListener(sizeButtonListener);
        S.addActionListener(sizeButtonListener);
        M.addActionListener(sizeButtonListener);
        L.addActionListener(sizeButtonListener);
        XL.addActionListener(sizeButtonListener);
        XXL.addActionListener(sizeButtonListener);
        XXXL.addActionListener(sizeButtonListener);


        /*----------------Panel For Buttons (Colors)------------------ */

        JButton Red = new JButton();
        Red.setBounds(375,240, 40,40);
        Red.setBackground(Color.red);
        ChooseGown.add(Red);

        JButton Orange = new JButton();
        Orange.setBounds(435,240, 40,40);
        Orange.setBackground(Color.orange);
        ChooseGown.add(Orange);

        JButton Yellow = new JButton();
        Yellow.setBounds(375,290, 40,40);
        Yellow.setBackground(Color.yellow);
        ChooseGown.add(Yellow);

        JButton Green = new JButton();
        Green.setBounds(435,290, 40,40);
        Green.setBackground(Color.green);
        ChooseGown.add(Green);

        JButton Blue = new JButton();
        Blue.setBounds(375,340, 40,40);
        Blue.setBackground(Color.blue);
        ChooseGown.add(Blue);

        JButton Purple = new JButton();
        Purple.setBounds(435,340, 40,40);
        Purple.setBackground(new Color(160,32,240));
        ChooseGown.add(Purple);

        JButton Pink = new JButton();
        Pink.setBounds(375,390, 40,40);
        Pink.setBackground(new Color(255, 209,220));
        ChooseGown.add(Pink);

        JButton White = new JButton();
        White.setBounds(435,390, 40,40);
        White.setBackground(new Color(255, 255,255));
        ChooseGown.add(White);


        /*--------------Action Button For Colors-------------- */

        ActionListener colorButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            Color color = source.getBackground();
            String colorName = getColorName(color);

            // Update ColorDeets JLabel on the EDT
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ColorDeets.setText("Gown Color: " + colorName);
                }
            });
        }

            private String getColorName(Color color) {
                if (color.equals(Color.red)) {
                    return "Red";
                } else if (color.equals(Color.orange)) {
                    return "Orange";
                } else if (color.equals(Color.yellow)) {
                    return "Yellow";
                } else if (color.equals(Color.green)) {
                    return "Green";
                } else if (color.equals(Color.blue)) {
                    return "Blue";
                } else if (color.equals(new Color(160, 32, 240))) {
                    return "Purple";
                } else if (color.equals(new Color(255, 209, 220))) {
                    return "Pink";
                } else if (color.equals(new Color(255, 255, 255))) {
                    return "White";
                } else {
                    return color.toString();
                }
            }
        };
                
                // Attach listeners to each color button
                Red.addActionListener(colorButtonListener);
                Orange.addActionListener(colorButtonListener);
                Yellow.addActionListener(colorButtonListener);
                Green.addActionListener(colorButtonListener);
                Blue.addActionListener(colorButtonListener);
                Purple.addActionListener(colorButtonListener);
                Pink.addActionListener(colorButtonListener);
                White.addActionListener(colorButtonListener);


            
                /*-------------------Action Button For Schedule-------------------- */
                ActionListener SchedButtonListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == Check1) { 
                            showCalendarDialog(SchedFromtf);
                            fromDates = SchedFromtf.getText(); // Get text from SchedFromtf
                            FromDeets.setText("Rent From: " + fromDates);
                            Check1T = true;
                        } else if (e.getSource() == Check2) { 
                            showCalendarDialog(SchedUntiltf);
                            untilDates = SchedUntiltf.getText(); // Get text from SchedUntiltf
                            UntilDeets.setText("Rent Until: " + untilDates);
                            calculateRentDuration();
                            Check2T = true;  
                    } else if (e.getSource() == OK) {
                            if (Check1T && Check2T) {
                            receipt();
                            ChooseGown.setVisible(false);
                            mainFrame.switchPanel("loginPanel");
                            RentG1();setVisible(false);
                        }  else {
                            JOptionPane.showMessageDialog(null, "Please fill in all details first.");
                        }
                    }
                }
                };

                Check1.addActionListener(SchedButtonListener);
                Check2.addActionListener(SchedButtonListener);
                OK.addActionListener(SchedButtonListener);
            

                /*-------------------Back Button------------- */
                JButton Back = new JButton("<<<");
                Back.setBounds(300,0, 100, 70);
                Back.setFont(new Font("Arial", Font.BOLD, 25));
                Back.setForeground(Color.red);
                Back.setOpaque(false);
                Back.setContentAreaFilled(false);
                Back.setBorderPainted(false);
                Back.addActionListener(e -> {
                    ChooseGown.setVisible(false);
                    RentG1();setVisible(true);
                    setLocationRelativeTo(null);
                    
                });
                ChooseGown.add(Back);

                

                // Frame properties
                setContentPane(ChooseGown);
                setTitle("Rent a Gown - Mermaid Gown");
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setSize(900, 700);
                setLocationRelativeTo(null);
            
                rentPanel.setVisible(false);
                setVisible(true);
                revalidate();
                repaint();
            }
 /*-------------Choose Gown Class background------------------- */   
     private class ChooseGown extends JPanel { //used for the panel and add image/background
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(BG2, 0, 0, getWidth(), getHeight(), this);
        }
     }

     private void showCalendarDialog(JTextField targetTextField) {
        JDialog calendarDialog = new JDialog((Frame) null, "Select Date", true);
        calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        calendarDialog.setSize(400, 410);
        calendarDialog.setLocationRelativeTo(null); // Center the dialog on screen
    
        DatePickerPanel datePickerPanel = new DatePickerPanel(SchedFromtf, SchedUntiltf);
        datePickerPanel.setDateSelectionListener(new DatePickerPanel.DateSelectionListener() {
            @Override
            public void dateSelected(String selectedDate) {
                targetTextField.setText(selectedDate);
                calendarDialog.dispose(); // Close the calendar dialog after selection
            }
        });
    
        calendarDialog.getContentPane().add(datePickerPanel);
        calendarDialog.setVisible(true);
    }
    private void calculateRentDuration() {
        try {
            // Define the date format
            formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);

            // Parse the dates from the text fields
            fromDate = LocalDate.parse(SchedFromtf.getText(), formatter);
            untilDate = LocalDate.parse(SchedUntiltf.getText(), formatter);

            // Calculate the duration
            daysBetween = ChronoUnit.DAYS.between(fromDate, untilDate);

            // Display the duration
            DaysDeets.setText("Rental Duration: " + daysBetween + " day(s)");
            Days.setText("Rental Duration: " + daysBetween + " day(s)");
        } catch (DateTimeParseException ex) {
            DaysDeets.setText("Rental Duration: Invalid");
        }
    }

    private void receipt() {         
                        Namedeets = CustomerName.getText();
                            Emaildeets = CustomerEmail.getText();
                            Contactdeets = CustomerContact.getText();
                            Addressdeets = CustomerAddress.getText();
                            Addressdeets1 = CustomerAddress1.getText();
                            Designdeets = Design0.getText();

                            Sdeets = SizeDeets.getText();
                            Cdeets = ColorDeets.getText();
                            Fdeets = FromDeets.getText();
                            Udeets = UntilDeets.getText();
                            Ddeets = DaysDeets.getText();
                            Pdeets = PriceDeets.getText();
                            Pdaydeets = PerDay.getText();

                            String message = String.format(
                                    "Customer %s\nCustomer %s\nCustomer %s\nCustomer %s\n%s\n %s\nGown Size: %s\nGown Color: %s\n%s\n%s\n%s\n%s\n%s",
                                    Namedeets, Emaildeets, Contactdeets, Addressdeets, Addressdeets1, Designdeets,
                                    Sdeets, Cdeets, Fdeets, Udeets, Ddeets, Pdeets, Pdaydeets, GTPdeets
                            );

                            JOptionPane.showMessageDialog(null, message);
                        } 
    
    private void Dimensions() {
            SizeDimensions[] sizes = {
                new SizeDimensions("XS", 30, 24, 34, 50),
                new SizeDimensions("S", 32, 26, 36, 51),
                new SizeDimensions("M", 34, 28, 38, 52),
                new SizeDimensions("L", 36, 30, 40, 53),
                new SizeDimensions("XL", 38, 32, 42, 54),
                new SizeDimensions("2XL", 40, 34, 44, 55),
                new SizeDimensions("3XL", 42, 36, 46, 56)
            };
    
            String[] columnNames = {"Size(In)", "Bust(In)", "Waist(In)", "Hips(In)", "Length(In)"};
            Object[][] data = new Object[sizes.length][5];
    
            for (int i = 0; i < sizes.length; i++) {
                data[i][0] = sizes[i].getSize();
                data[i][1] = sizes[i].getBust();
                data[i][2] = sizes[i].getWaist();
                data[i][3] = sizes[i].getHips();
                data[i][4] = sizes[i].getLength();
            }
    
            JTable table = new JTable(data, columnNames);

            // Set the font size for the table content
            Font tableFont = new Font("Arial", Font.PLAIN, 18);
            table.setFont(tableFont);
            table.setRowHeight(25);

            // Set the font size for the table header
            JTableHeader header = table.getTableHeader();
            Font headerFont = new Font("Arial", Font.PLAIN, 20);
            header.setFont(headerFont);

            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

    
            JFrame tableFrame = new JFrame("Size Dimensions Table in Inches");
            tableFrame.setSize(500, 250);
            tableFrame.add(scrollPane);
            tableFrame.setVisible(true);
        }
    

/*-------------------Run-------------------- */
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new rent(new RentGowns());
            }
        });
    }
}