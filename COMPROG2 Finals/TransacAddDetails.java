import java.awt.*;
import java.util.logging.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

public class TransacAddDetails extends javax.swing.JFrame {

    public TransacAddDetails(String usernameemail, int carId) {
        setTitle("Transaction Additional Details");
        initComponents(usernameemail, carId);
    }

    public TransacAddDetails() {

    }

    private void initComponents(String usernameemail, int carId) {

        popupMenu = new javax.swing.JPopupMenu();
        homePageMenuBtn = new javax.swing.JMenuItem();
        accountMenuBtn = new javax.swing.JMenuItem();
        transactionMenuBtn = new javax.swing.JMenuItem();
        logoutMenuBtn = new javax.swing.JMenuItem();
        topJpanel = new javax.swing.JPanel();
        menuBtn = new javax.swing.JButton();
        carRentalLbl = new javax.swing.JLabel();
        pickUpReturnLocLbl = new javax.swing.JLabel();
        pickUpDateLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        pickUpRentLocCombobox = new javax.swing.JComboBox<>();
        pickUpReturnErrorLbl = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        pickUpDateErrorLbl = new javax.swing.JLabel();
        dateFormatLbl = new javax.swing.JLabel();
        chosenCarPhotoLbl = new javax.swing.JLabel();
        returnDateLbl = new javax.swing.JLabel();
        carNameLbl = new javax.swing.JLabel();
        pickUpDateCalendar = new com.toedter.calendar.JDateChooser();
        dateLbl2 = new javax.swing.JLabel();
        returnDateCalendar = new com.toedter.calendar.JDateChooser();
        returnDateErrorLbl = new javax.swing.JLabel();
        dateFormatLbl2 = new javax.swing.JLabel();
        totalDaysLbl = new javax.swing.JLabel();
        totalDaysValueLbl = new javax.swing.JLabel();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental", "root",
                    "hansignacio");
            Statement stm = con.createStatement();
            String sql = "Select * FROM car_types WHERE car_id='" + carId + "'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                String carname = rs.getString("car_name");

                carNameAssign(carname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        homePageMenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        homePageMenuBtn.setText("Home Page");
        homePageMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePageMenuBtnActionPerformed(evt, usernameemail);
            }
        });
        popupMenu.add(homePageMenuBtn);

        accountMenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        accountMenuBtn.setText("Account");
        accountMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountMenuBtnActionPerformed(evt, usernameemail);
            }
        });
        popupMenu.add(accountMenuBtn);

        transactionMenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        transactionMenuBtn.setText("Transaction");
        transactionMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionMenuBtnActionPerformed(evt, usernameemail);
            }
        });
        popupMenu.add(transactionMenuBtn);

        logoutMenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        popupMenu.add(logoutMenuBtn);
        logoutMenuBtn.setOpaque(true);
        logoutMenuBtn.setBackground(Color.RED);
        logoutMenuBtn.setText("Logout");
        logoutMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuBtnActionPerformed(evt);
            }
        });
        popupMenu.add(logoutMenuBtn);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topJpanel.setBackground(new java.awt.Color(153, 0, 153));
        topJpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        menuBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        carRentalLbl.setFont(new java.awt.Font("Segoe Script", 1, 18));
        carRentalLbl.setForeground(new java.awt.Color(144, 224, 192));
        carRentalLbl.setText("CAR RENTAL");

        javax.swing.GroupLayout topJpanelLayout = new javax.swing.GroupLayout(topJpanel);
        topJpanel.setLayout(topJpanelLayout);
        topJpanelLayout.setHorizontalGroup(
                topJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topJpanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(carRentalLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(menuBtn)
                                .addContainerGap()));
        topJpanelLayout.setVerticalGroup(
                topJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topJpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        topJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(menuBtn)
                                                .addComponent(carRentalLbl))
                                .addContainerGap(7, Short.MAX_VALUE)));

        pickUpReturnLocLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        pickUpReturnLocLbl.setText("Pick-up & Return Location:");

        pickUpDateLbl.setFont(new java.awt.Font("Segoe UI", 1, 18));
        pickUpDateLbl.setText("Pick-up Date:");

        dateLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        dateLbl.setText("Date:");

        pickUpRentLocCombobox.setFont(new java.awt.Font("Segoe UI", 1, 12));
        pickUpRentLocCombobox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Bagac", "Balanga", "Limay" }));
        pickUpRentLocCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickUpRentLocComboboxActionPerformed(evt);
            }
        });

        pickUpReturnErrorLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        pickUpReturnErrorLbl.setForeground(new java.awt.Color(255, 0, 0));
        pickUpReturnErrorLbl.setText("Please choose pick-up and return location");

        nextBtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        nextBtn.setText("NEXT");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt, usernameemail, carId);
            }
        });

        pickUpDateErrorLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        pickUpDateErrorLbl.setForeground(new java.awt.Color(255, 0, 0));

        dateFormatLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        dateFormatLbl.setText(" (mm-dd-yyyy)");

        switch (carId) {
            case 1:
                chosenCarPhotoLbl.setIcon(new javax.swing.ImageIcon("img/Toyota Yaris.jpg"));
                break;
            case 2:
                chosenCarPhotoLbl.setIcon(new javax.swing.ImageIcon("img/Hyundai Accent.jpg"));
                break;
            case 3:
                chosenCarPhotoLbl.setIcon(new javax.swing.ImageIcon("img/Chevrolet Impala.jpg"));
                break;
            case 4:
                chosenCarPhotoLbl.setIcon(new javax.swing.ImageIcon("img/Ford Taurus.jpg"));
                break;
            case 5:
                chosenCarPhotoLbl.setIcon(new javax.swing.ImageIcon("img/Honda Odyssey.jpg"));
                break;
            case 6:
                chosenCarPhotoLbl.setIcon(new javax.swing.ImageIcon("img/Ford Transit.jpg"));
                break;
        }

        returnDateLbl.setFont(new java.awt.Font("Segoe UI", 1, 18));
        returnDateLbl.setText("Return Date:");

        carNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        carNameLbl.setText("Car Name");

        pickUpDateCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pickUpDateCalendarPropertyChange(evt);
            }
        });

        dateLbl2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        dateLbl2.setText("Date:");

        returnDateCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                returnDateCalendarPropertyChange(evt);
            }
        });

        returnDateErrorLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        returnDateErrorLbl.setForeground(new java.awt.Color(255, 0, 0));

        dateFormatLbl2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        dateFormatLbl2.setText(" (mm-dd-yyyy)");

        totalDaysLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        totalDaysLbl.setText("Total Days:");

        totalDaysValueLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(topJpanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addComponent(chosenCarPhotoLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(carNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 121,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pickUpReturnErrorLbl)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(pickUpReturnLocLbl)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(pickUpRentLocCombobox,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(pickUpDateLbl)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(dateLbl2)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(returnDateCalendar,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        140,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(returnDateErrorLbl,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        172,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(returnDateLbl)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(dateLbl)
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        pickUpDateCalendar,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        140,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        pickUpDateErrorLbl,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        172,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(
                                                                                                        dateFormatLbl,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        91,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(totalDaysLbl)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(totalDaysValueLbl,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        79,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(106, 106, 106)
                                                .addComponent(dateFormatLbl2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nextBtn)
                                .addGap(166, 166, 166)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(topJpanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chosenCarPhotoLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(carNameLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pickUpReturnLocLbl)
                                        .addComponent(pickUpRentLocCombobox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pickUpReturnErrorLbl)
                                .addGap(18, 18, 18)
                                .addComponent(pickUpDateLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateLbl)
                                        .addComponent(pickUpDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pickUpDateErrorLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFormatLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(returnDateLbl)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateLbl2)
                                        .addComponent(returnDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(returnDateErrorLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFormatLbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalDaysLbl)
                                        .addComponent(totalDaysValueLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextBtn)
                                .addGap(51, 51, 51)));

        pack();
    }

    public static void carNameAssign(String carname) {
        carNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 12));
        carNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
        carNameLbl.setText(carname);
    }

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        popupMenu.show(menuBtn, 0, menuBtn.getHeight());
    }

    private void homePageMenuBtnActionPerformed(java.awt.event.ActionEvent evt, String usernameemail) {
        dispose();
        HomePage hpage = new HomePage(usernameemail);
        hpage.setVisible(true);
    }

    private void accountMenuBtnActionPerformed(java.awt.event.ActionEvent evt, String usernameemail) {
        dispose();
        AccountPage accpage = new AccountPage(usernameemail);
        accpage.setVisible(true);
    }

    private void transactionMenuBtnActionPerformed(java.awt.event.ActionEvent evt, String usernameemail) {
        dispose();
        TransactionPage transac = new TransactionPage(usernameemail);
        transac.setVisible(true);
    }

    private void logoutMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int response = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to log out?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            dispose();
            loginForm login = new loginForm();
            login.setVisible(true);
        }
    }

    private void pickUpRentLocComboboxActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedItem = (String) pickUpRentLocCombobox.getSelectedItem();
        if ("".equals(selectedItem)) {
            pickUpReturnErrorLbl.setText("Please choose pick-up and return location");
        } else {
            pickUpReturnErrorLbl.setText("");
        }
    }

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt, String usernameemail, int carId) {
        String selectedValue = (String) pickUpRentLocCombobox.getSelectedItem();
        LocalDate rentingDate = pickUpDateCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate returningDate = returnDateCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long daysBetween = ChronoUnit.DAYS.between(rentingDate, returningDate);
        if (pickUpDateErrorLbl.getText().isEmpty() && returnDateErrorLbl.getText().isEmpty()
                && pickUpReturnErrorLbl.getText().isEmpty()) {
            dispose();
            TransactionConfirmation transactConfirm = new TransactionConfirmation(usernameemail, carId, selectedValue,
                    rentDate, returnDate, daysBetween);
            transactConfirm.setVisible(true);
        }
    }

    private void pickUpDateCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {
        Date rentingDate = pickUpDateCalendar.getDate();

        if (rentingDate != null) {
            try {
                Instant instant = rentingDate.toInstant();
                ZoneId zoneId = ZoneId.systemDefault();
                LocalDate inputDate = instant.atZone(zoneId).toLocalDate();

                LocalDate today = LocalDate.now();

                if (!inputDate.isEqual(today) && !inputDate.isAfter(today)) {
                    pickUpDateErrorLbl.setText("Pick a future date");
                } else {
                    pickUpDateErrorLbl.setText("");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String formattedDate = inputDate.format(formatter);
                    rentDate = formattedDate;
                }
                if (returnDateCalendar.getDate() != null) {
                    updateTotalDaysLabel();
                }
            } catch (DateTimeException e) {
                pickUpDateErrorLbl.setText("Invalid date format.");
                e.printStackTrace();
            }
        } else {
            pickUpDateErrorLbl.setText("Invalid input.");
        }
    }

    private void returnDateCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {

        Date returningDate = returnDateCalendar.getDate();
        Date rentingDate = pickUpDateCalendar.getDate();

        if (rentingDate != null && returningDate != null) {
            try {
                Instant instant = returningDate.toInstant();
                ZoneId zoneId = ZoneId.systemDefault();
                LocalDate inputDate = instant.atZone(zoneId).toLocalDate();
                Instant instantRenting = rentingDate.toInstant();
                LocalDate inputDateRent = instantRenting.atZone(zoneId).toLocalDate();

                if (!inputDate.isAfter(inputDateRent)) {
                    returnDateErrorLbl.setText("Pick a future date");
                } else {
                    returnDateErrorLbl.setText("");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String formattedDate = inputDate.format(formatter);
                    returnDate = formattedDate;
                }
                if (pickUpDateCalendar.getDate() != null) {
                    updateTotalDaysLabel();
                }
            } catch (DateTimeException e) {
                returnDateErrorLbl.setText("Invalid date format.");
                e.printStackTrace();
            }
        } else {
            returnDateErrorLbl.setText("Invalid input!");
        }
    }

    private void updateTotalDaysLabel() {
        LocalDate rentingDate = pickUpDateCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate returningDate = returnDateCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long daysBetween = ChronoUnit.DAYS.between(rentingDate, returningDate);

        totalDaysValueLbl.setText(String.valueOf(daysBetween));
        if (daysBetween <= 0) {
            pickUpDateErrorLbl.setText("Return cant be before pickup date");
            returnDateErrorLbl.setText("Return cant be before pickup date");
        } else {
            pickUpDateErrorLbl.setText("");
            returnDateErrorLbl.setText("");
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransacAddDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransacAddDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransacAddDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransacAddDetails.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TransacAddDetails frame = new TransacAddDetails();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration
    private javax.swing.JMenuItem accountMenuBtn;
    private static javax.swing.JLabel carNameLbl;
    private javax.swing.JLabel carRentalLbl;
    private javax.swing.JLabel chosenCarPhotoLbl;
    private javax.swing.JLabel dateFormatLbl;
    private javax.swing.JLabel dateFormatLbl2;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel dateLbl2;
    private javax.swing.JMenuItem homePageMenuBtn;
    private javax.swing.JMenuItem logoutMenuBtn;
    private javax.swing.JButton menuBtn;
    private javax.swing.JButton nextBtn;
    private com.toedter.calendar.JDateChooser pickUpDateCalendar;
    private javax.swing.JLabel pickUpDateErrorLbl;
    private javax.swing.JLabel pickUpDateLbl;
    private javax.swing.JComboBox<String> pickUpRentLocCombobox;
    private javax.swing.JLabel pickUpReturnErrorLbl;
    private javax.swing.JLabel pickUpReturnLocLbl;
    private javax.swing.JPopupMenu popupMenu;
    private com.toedter.calendar.JDateChooser returnDateCalendar;
    private javax.swing.JLabel returnDateErrorLbl;
    private javax.swing.JLabel returnDateLbl;
    private javax.swing.JPanel topJpanel;
    private javax.swing.JLabel totalDaysLbl;
    private javax.swing.JLabel totalDaysValueLbl;
    private javax.swing.JMenuItem transactionMenuBtn;
    private String rentDate;
    private String returnDate;
    // End of variables declaration
}
