package view;

import controller.Controller;
import javax.swing.JOptionPane;
import model.AppointmentDAO;
import model.ExamDAO;

public class MainPanel extends javax.swing.JFrame {
  public void myInitComponents() {
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jRadioButton1.setSelected(true);
    Controller.jradioButtonSelectedCustomer(jTable1);
    Controller.setTextFields(jTextField1, jTextField2, jTextField4);
    Controller.setTableModel(
      jTable2,
      new AppointmentTableModel(AppointmentDAO.getInstance().retrieveAll())
    );
  }

  public MainPanel() {
    initComponents();
    this.myInitComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jTextField2 = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel2 = new javax.swing.JPanel();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    jRadioButton3 = new javax.swing.JRadioButton();
    jRadioButton4 = new javax.swing.JRadioButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    jTextField3 = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    jButton4 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    jToggleButton1 = new javax.swing.JToggleButton();
    jToggleButton2 = new javax.swing.JToggleButton();
    jToggleButton3 = new javax.swing.JToggleButton();
    jPanel4 = new javax.swing.JPanel();
    jPanel5 = new javax.swing.JPanel();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTable3 = new javax.swing.JTable();
    jButton9 = new javax.swing.JButton();
    jToggleButton4 = new javax.swing.JToggleButton();
    jToggleButton5 = new javax.swing.JToggleButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Registers");

    jPanel1.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        "Selected customer and animals"
      )
    );

    jLabel1.setText("Customer:");

    jLabel2.setText("Animal:");

    jTextField1.setText("jTextField1");

    jTextField2.setText("jTextField2");

    jLabel4.setText("Veterinarian:");

    jTextField4.setText("jTextField4");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
      jPanel1
    );
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(41, 41, 41)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(
                  javax.swing.GroupLayout.Alignment.LEADING,
                  false
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(
                          jLabel2,
                          javax.swing.GroupLayout.Alignment.TRAILING
                        )
                        .addComponent(jLabel1)
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(jTextField2)
                        .addComponent(jTextField1)
                    )
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(jLabel4)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(
                      jTextField4,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      456,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(
                  jTextField1,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(18, 18, 18)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(
                  jTextField2,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(18, 18, 18)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(
                  jTextField4,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );

    jTabbedPane1.setToolTipText("");
    jTabbedPane1.setName("Registers"); // NOI18N
    jTabbedPane1.addChangeListener(
      new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
          jTabbedPane1StateChanged(evt);
        }
      }
    );
    jTabbedPane1.addFocusListener(
      new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
          jTabbedPane1FocusGained(evt);
        }
      }
    );

    jPanel2.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        null,
        "",
        javax.swing.border.TitledBorder.CENTER,
        javax.swing.border.TitledBorder.ABOVE_TOP
      )
    );

    buttonGroup1.add(jRadioButton1);
    jRadioButton1.setText("Customers registration");
    jRadioButton1.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jRadioButton1ActionPerformed(evt);
        }
      }
    );

    buttonGroup1.add(jRadioButton2);
    jRadioButton2.setText("Animals registration");
    jRadioButton2.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jRadioButton2ActionPerformed(evt);
        }
      }
    );

    buttonGroup1.add(jRadioButton3);
    jRadioButton3.setText("Species registration");
    jRadioButton3.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jRadioButton3ActionPerformed(evt);
        }
      }
    );

    buttonGroup1.add(jRadioButton4);
    jRadioButton4.setText("Veterinarians registration");
    jRadioButton4.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jRadioButton4ActionPerformed(evt);
        }
      }
    );

    jTable1.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
        },
        new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }
      )
    );
    jTable1.setShowGrid(false);
    jTable1.addMouseListener(
      new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
          jTable1MousePressed(evt);
        }
      }
    );
    jScrollPane1.setViewportView(jTable1);

    jButton1.setText("All");
    jButton1.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton1ActionPerformed(evt);
        }
      }
    );

    jButton2.setText("New");
    jButton2.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton2ActionPerformed(evt);
        }
      }
    );

    jButton3.setText("Delete");
    jButton3.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton3ActionPerformed(evt);
        }
      }
    );

    jLabel3.setText("Search:");

    jTextField3.setText("jTextField3");
    jTextField3.addInputMethodListener(
      new java.awt.event.InputMethodListener() {
        public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {}

        public void inputMethodTextChanged(
          java.awt.event.InputMethodEvent evt
        ) {
          jTextField3InputMethodTextChanged(evt);
        }
      }
    );
    jTextField3.addKeyListener(
      new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
          jTextField3KeyTyped(evt);
        }
      }
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
      jPanel2
    );
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel2Layout
            .createSequentialGroup()
            .addGap(14, 14, 14)
            .addGroup(
              jPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
                .addGroup(
                  jPanel2Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel2Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addGroup(
                          jPanel2Layout
                            .createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                            )
                            .addComponent(jRadioButton2)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                            )
                            .addComponent(jRadioButton3)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                            )
                            .addComponent(jRadioButton4)
                        )
                        .addGroup(
                          jPanel2Layout
                            .createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.RELATED
                            )
                            .addComponent(jButton2)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.RELATED
                            )
                            .addComponent(jButton3)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.RELATED
                            )
                            .addComponent(
                              jTextField3,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              343,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                        )
                    )
                    .addGap(0, 0, Short.MAX_VALUE)
                )
            )
            .addContainerGap()
        )
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel2Layout
            .createSequentialGroup()
            .addGap(17, 17, 17)
            .addGroup(
              jPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jRadioButton1)
                .addComponent(jRadioButton2)
                .addComponent(jRadioButton3)
                .addComponent(jRadioButton4)
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2)
                .addComponent(jButton3)
                .addComponent(jLabel3)
                .addComponent(
                  jTextField3,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(24, 24, 24)
            .addComponent(
              jScrollPane1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              189,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(14, Short.MAX_VALUE)
        )
    );

    jTabbedPane1.addTab("Registers", jPanel2);

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    jButton4.setText("New");
    jButton4.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton4ActionPerformed(evt);
        }
      }
    );

    jButton5.setText("Delete");
    jButton5.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton5ActionPerformed(evt);
        }
      }
    );

    jButton6.setText("Filter");
    jButton6.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton6ActionPerformed(evt);
        }
      }
    );

    jTable2.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
        },
        new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }
      )
    );
    jScrollPane2.setViewportView(jTable2);

    jToggleButton1.setText("All");
    jToggleButton1.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jToggleButton1ActionPerformed(evt);
        }
      }
    );

    jToggleButton2.setText("Today");

    jToggleButton3.setText("Veterinarian");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
      jPanel3
    );
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel3Layout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
              jPanel3Layout
                .createParallelGroup(
                  javax.swing.GroupLayout.Alignment.LEADING,
                  false
                )
                .addGroup(
                  jPanel3Layout
                    .createSequentialGroup()
                    .addComponent(jButton4)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(jButton5)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                    .addComponent(jButton6)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(jToggleButton1)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(jToggleButton2)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(jToggleButton3)
                )
                .addComponent(
                  jScrollPane2,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  793,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addContainerGap(10, Short.MAX_VALUE)
        )
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel3Layout
            .createSequentialGroup()
            .addGap(9, 9, 9)
            .addGroup(
              jPanel3Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4)
                .addComponent(jButton5)
                .addComponent(jButton6)
                .addComponent(jToggleButton1)
                .addComponent(jToggleButton2)
                .addComponent(jToggleButton3)
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(
              jScrollPane2,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              202,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(48, Short.MAX_VALUE)
        )
    );

    jTabbedPane1.addTab("Appointments scheduling", jPanel3);

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    jButton7.setText("New");
    jButton7.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton7ActionPerformed(evt);
        }
      }
    );

    jButton8.setText("Delete");
    jButton8.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton8ActionPerformed(evt);
        }
      }
    );

    jTable3.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
        },
        new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }
      )
    );
    jScrollPane3.setViewportView(jTable3);

    jButton9.setText("Filter");
    jButton9.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton9ActionPerformed(evt);
        }
      }
    );

    jToggleButton4.setText("All");
    jToggleButton4.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jToggleButton4ActionPerformed(evt);
        }
      }
    );

    jToggleButton5.setText("Today");

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
      jPanel5
    );
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel5Layout
            .createSequentialGroup()
            .addGap(29, 29, 29)
            .addComponent(jButton7)
            .addGap(18, 18, 18)
            .addComponent(jButton8)
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              327,
              Short.MAX_VALUE
            )
            .addComponent(jButton9)
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(jToggleButton4)
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(jToggleButton5)
            .addGap(71, 71, 71)
        )
        .addGroup(
          jPanel5Layout
            .createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(
              jScrollPane3,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              774,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel5Layout
            .createSequentialGroup()
            .addGroup(
              jPanel5Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  jPanel5Layout
                    .createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(
                      jPanel5Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.BASELINE
                        )
                        .addComponent(jButton7)
                        .addComponent(jButton8)
                    )
                )
                .addGroup(
                  jPanel5Layout
                    .createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(
                      jPanel5Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.BASELINE
                        )
                        .addComponent(jButton9)
                        .addComponent(jToggleButton4)
                        .addComponent(jToggleButton5)
                    )
                )
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(
              jScrollPane3,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              210,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
      jPanel4
    );
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jPanel5,
          javax.swing.GroupLayout.Alignment.TRAILING,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel4Layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jPanel5,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(19, Short.MAX_VALUE)
        )
    );

    jTabbedPane1.addTab("Exams management", jPanel4);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jPanel1,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1)
            .addContainerGap()
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(
              jTabbedPane1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              329,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap()
        )
    );

    jTabbedPane1.getAccessibleContext().setAccessibleName("");

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jToggleButton1ActionPerformed

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    // TODO add your handling code here:
    Controller.filterAppointment(
      jTable2,
      jToggleButton1,
      jToggleButton2,
      jToggleButton3
    );
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:
    if (!Controller.addRegister(jTable2)) {
      JOptionPane.showMessageDialog(
        this,
        "Select an animal and a veterinarian"
      );
    }
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
    Controller.updateSimilarName(jTable1, jTextField3.getText());
  }//GEN-LAST:event_jTextField3KeyTyped

  private void jTextField3InputMethodTextChanged(
    java.awt.event.InputMethodEvent evt
  ) {//GEN-FIRST:event_jTextField3InputMethodTextChanged
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField3InputMethodTextChanged

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    Controller.deleteRegister(
      jTable1,
      ((GenericTableModel) jTable1.getModel()).getItem(jTable1.getSelectedRow())
    );
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    Controller.addRegister(jTable1);
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    Controller.clearSearch(jTable1);
    Controller.setSelected(null);
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField4.setText("");
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
    // TODO add your handling code here:
    Controller.setSelected(
      ((GenericTableModel) jTable1.getModel()).getItem(jTable1.getSelectedRow())
    );
  }//GEN-LAST:event_jTable1MousePressed

  private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
    // TODO add your handling code here:
    Controller.jradioButtonSelectedVeterinarian(jTable1);
  }//GEN-LAST:event_jRadioButton4ActionPerformed

  private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
    // TODO add your handling code here:
    Controller.jradioButtonSelectedSpecies(jTable1);
  }//GEN-LAST:event_jRadioButton3ActionPerformed

  private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    if (!Controller.jradioButtonSelectedAnimals(jTable1)) {
      JOptionPane.showMessageDialog(this, "Select a customer");
    }
  }//GEN-LAST:event_jRadioButton2ActionPerformed

  private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
    Controller.jradioButtonSelectedCustomer(jTable1);
  }//GEN-LAST:event_jRadioButton1ActionPerformed

  private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    // TODO add your handling code here:
    if (!Controller.addRegister(jTable3)) {
      JOptionPane.showMessageDialog(this, "Select an animal");
    }
  }//GEN-LAST:event_jButton7ActionPerformed

  private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    // TODO add your handling code here:
    Controller.filterExam(jTable3, jToggleButton4, jToggleButton5);
  }//GEN-LAST:event_jButton9ActionPerformed

  private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jToggleButton4ActionPerformed

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    // TODO add your handling code here:
    Controller.deleteRegister(
      jTable2,
      ((GenericTableModel) jTable2.getModel()).getItem(jTable2.getSelectedRow())
    );
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
    // TODO add your handling code here:

  }//GEN-LAST:event_jTabbedPane1FocusGained

  private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
    // TODO add your handling code here:
    if (jTabbedPane1.getSelectedIndex() == 2) {
      if (Controller.getSelectedAnimal() != null) {
        Controller.setTableModel(
          jTable3,
          new ExamTableModel(
            ExamDAO
              .getInstance()
              .retrieveByAnimalId(Controller.getSelectedAnimal().getId())
          )
        );
      } else {
        JOptionPane.showMessageDialog(this, "Select an animal");
      }
    }
  }//GEN-LAST:event_jTabbedPane1StateChanged

  private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    // TODO add your handling code here:
    Controller.deleteRegister(
      jTable3,
      ((GenericTableModel) jTable3.getModel()).getItem(jTable3.getSelectedRow())
    );
  }//GEN-LAST:event_jButton8ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger
        .getLogger(MainPanel.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(MainPanel.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(MainPanel.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(MainPanel.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new MainPanel().setVisible(true);
        }
      }
    );
  }

  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JRadioButton jRadioButton3;
  private javax.swing.JRadioButton jRadioButton4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable jTable2;
  private javax.swing.JTable jTable3;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JTextField jTextField3;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JToggleButton jToggleButton1;
  private javax.swing.JToggleButton jToggleButton2;
  private javax.swing.JToggleButton jToggleButton3;
  private javax.swing.JToggleButton jToggleButton4;
  private javax.swing.JToggleButton jToggleButton5;
}
