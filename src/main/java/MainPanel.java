package view;

import model.CustomerDAO;

public class MainPanel extends javax.swing.JPanel {

  public MainPanel() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jPanel8 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    customer_document = new javax.swing.JTextField();
    customer_name = new javax.swing.JTextField();
    customer_phone = new javax.swing.JTextField();
    customer_email = new javax.swing.JTextField();
    customer_street_number = new javax.swing.JTextField();
    customer_zip_code = new javax.swing.JTextField();
    customer_street_complement = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jLabel10 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jPanel10 = new javax.swing.JPanel();
    jLabel18 = new javax.swing.JLabel();
    specie_name = new javax.swing.JTextField();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jButton9 = new javax.swing.JButton();
    jPanel3 = new javax.swing.JPanel();
    jPanel4 = new javax.swing.JPanel();
    jPanel5 = new javax.swing.JPanel();
    jPanel6 = new javax.swing.JPanel();
    jPanel7 = new javax.swing.JPanel();

    jPanel8.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        null,
        "Customers",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new java.awt.Font("Segoe UI", 0, 18)
      )
    ); // NOI18N

    jLabel2.setText("Phone");

    jLabel3.setText("Name");

    jLabel4.setText("Document number");

    jLabel5.setText("E-mail");

    jLabel6.setText("Postal code");

    jLabel7.setText("Number");

    jLabel8.setText("Complement");

    customer_document.setText("jTextField1");
    customer_document.setName("customer_document"); // NOI18N
    customer_document.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          customer_documentActionPerformed(evt);
        }
      }
    );

    customer_name.setText("jTextField1");
    customer_name.setToolTipText("");
    customer_name.setName("customer_name"); // NOI18N

    customer_phone.setText("jTextField1");
    customer_phone.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          customer_phoneActionPerformed(evt);
        }
      }
    );

    customer_email.setText("jTextField1");

    customer_street_number.setText("jTextField1");
    customer_street_number.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          customer_street_numberActionPerformed(evt);
        }
      }
    );

    customer_zip_code.setText("jTextField1");
    customer_zip_code.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          customer_zip_codeActionPerformed(evt);
        }
      }
    );

    customer_street_complement.setText("jTextField1");
    customer_street_complement.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          customer_street_complementActionPerformed(evt);
        }
      }
    );

    jButton1.setBackground(new java.awt.Color(0, 153, 51));
    jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Register");
    jButton1.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton1ActionPerformed(evt);
        }
      }
    );

    jButton2.setBackground(new java.awt.Color(0, 0, 153));
    jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.setText("Save");

    jButton3.setBackground(new java.awt.Color(204, 0, 0));
    jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jButton3.setForeground(new java.awt.Color(255, 255, 255));
    jButton3.setText("Remove");

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
      jPanel8
    );
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          jPanel8Layout
            .createSequentialGroup()
            .addGap(8, 8, 8)
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(
                  jPanel8Layout
                    .createSequentialGroup()
                    .addComponent(jButton3)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                    .addComponent(jButton2)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(jButton1)
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.LEADING,
                  jPanel8Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel8Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING,
                          false
                        )
                        .addComponent(
                          customer_phone,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          279,
                          Short.MAX_VALUE
                        )
                        .addComponent(
                          jLabel2,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE
                        )
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addGroup(
                      jPanel8Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(
                          customer_email,
                          javax.swing.GroupLayout.Alignment.TRAILING
                        )
                        .addComponent(
                          jLabel5,
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE
                        )
                    )
                )
                .addGroup(
                  jPanel8Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel8Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(customer_name)
                        .addComponent(
                          jLabel3,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE
                        )
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addGroup(
                      jPanel8Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING,
                          false
                        )
                        .addComponent(
                          customer_document,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          269,
                          Short.MAX_VALUE
                        )
                        .addComponent(
                          jLabel4,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE
                        )
                    )
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.LEADING,
                  jPanel8Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel8Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          false
                        )
                        .addComponent(
                          jLabel6,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE
                        )
                        .addComponent(
                          customer_zip_code,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          154,
                          Short.MAX_VALUE
                        )
                    )
                    .addGroup(
                      jPanel8Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addGroup(
                          jPanel8Layout
                            .createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(
                              customer_street_number,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              151,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                        )
                        .addGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          jPanel8Layout
                            .createSequentialGroup()
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.RELATED
                            )
                            .addComponent(
                              jLabel7,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              153,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                        )
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addGroup(
                      jPanel8Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(
                          customer_street_complement,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          225,
                          Short.MAX_VALUE
                        )
                        .addComponent(
                          jLabel8,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE
                        )
                    )
                )
            )
            .addGap(8, 8, 8)
        )
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel8Layout
            .createSequentialGroup()
            .addGap(8, 8, 8)
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jLabel3)
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  customer_document,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  customer_name,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jLabel2)
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  customer_phone,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  customer_email,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(jLabel7)
                .addComponent(jLabel8)
            )
            .addGap(5, 5, 5)
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  customer_zip_code,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  customer_street_number,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  customer_street_complement,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addGroup(
              jPanel8Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2)
                .addComponent(jButton3)
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );

    jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel1.setText("Customers list");

    jTable1.setModel(
      new CustomerTableModel(CustomerDAO.retrieveAllCustomers())
    );
    jScrollPane1.setViewportView(jTable1);

    jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel10.setText("Animals list");

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
            .addContainerGap()
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(
                  jPanel8,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  Short.MAX_VALUE
                )
                .addComponent(
                  jScrollPane1,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  554,
                  Short.MAX_VALUE
                )
                .addComponent(jScrollPane2)
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(
                          jLabel1,
                          javax.swing.GroupLayout.PREFERRED_SIZE,
                          179,
                          javax.swing.GroupLayout.PREFERRED_SIZE
                        )
                        .addComponent(
                          jLabel10,
                          javax.swing.GroupLayout.PREFERRED_SIZE,
                          179,
                          javax.swing.GroupLayout.PREFERRED_SIZE
                        )
                    )
                    .addGap(0, 0, Short.MAX_VALUE)
                )
            )
            .addContainerGap()
        )
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jPanel8,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jScrollPane1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              240,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(jLabel10)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jScrollPane2,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              148,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(49, Short.MAX_VALUE)
        )
    );

    jTabbedPane1.addTab("customeres", jPanel1);

    jPanel10.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        null,
        "Species",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new java.awt.Font("Segoe UI", 0, 18)
      )
    ); // NOI18N

    jLabel18.setText("Name");

    specie_name.setText("jTextField1");
    specie_name.setToolTipText("");
    specie_name.setName("name"); // NOI18N
    specie_name.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          specie_nameActionPerformed(evt);
        }
      }
    );

    jButton7.setBackground(new java.awt.Color(0, 153, 51));
    jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("Register");
    jButton7.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton7ActionPerformed(evt);
        }
      }
    );

    jButton8.setBackground(new java.awt.Color(0, 0, 153));
    jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jButton8.setForeground(new java.awt.Color(255, 255, 255));
    jButton8.setText("Save");

    jButton9.setBackground(new java.awt.Color(204, 0, 0));
    jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jButton9.setForeground(new java.awt.Color(255, 255, 255));
    jButton9.setText("Remove");

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
      jPanel10
    );
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          jPanel10Layout
            .createSequentialGroup()
            .addGap(8, 8, 8)
            .addGroup(
              jPanel10Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(
                  jPanel10Layout
                    .createSequentialGroup()
                    .addComponent(jButton9)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      272,
                      Short.MAX_VALUE
                    )
                    .addComponent(jButton8)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(jButton7)
                    .addGap(8, 8, 8)
                )
                .addGroup(
                  jPanel10Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel10Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING
                        )
                        .addComponent(
                          jLabel18,
                          javax.swing.GroupLayout.Alignment.LEADING,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          Short.MAX_VALUE
                        )
                        .addComponent(specie_name)
                    )
                    .addContainerGap()
                )
            )
        )
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel10Layout
            .createSequentialGroup()
            .addGap(8, 8, 8)
            .addComponent(jLabel18)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              specie_name,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addGroup(
              jPanel10Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton7)
                .addComponent(jButton8)
                .addComponent(jButton9)
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
      jPanel2
    );
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          jPanel2Layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jPanel10,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
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
            .addContainerGap()
            .addComponent(
              jPanel10,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(624, Short.MAX_VALUE)
        )
    );

    jTabbedPane1.addTab("Species", jPanel2);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
      jPanel3
    );
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 566, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 753, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Animals", jPanel3);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
      jPanel4
    );
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 566, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 753, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Appointments", jPanel4);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
      jPanel5
    );
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 566, Short.MAX_VALUE)
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 753, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Exams", jPanel5);

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
      jPanel6
    );
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 566, Short.MAX_VALUE)
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 753, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Treatments", jPanel6);

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
      jPanel7
    );
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 566, Short.MAX_VALUE)
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 753, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Veterinarians", jPanel7);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
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
            .addContainerGap()
            .addComponent(jTabbedPane1)
            .addContainerGap()
        )
    );
  } // </editor-fold>//GEN-END:initComponents

  private void customer_documentActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_customer_documentActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_customer_documentActionPerformed

  private void customer_phoneActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_customer_phoneActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_customer_phoneActionPerformed

  private void customer_street_numberActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_customer_street_numberActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_customer_street_numberActionPerformed

  private void customer_zip_codeActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_customer_zip_codeActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_customer_zip_codeActionPerformed

  private void customer_street_complementActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_customer_street_complementActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_customer_street_complementActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_jButton1ActionPerformed

  private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_jButton7ActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_jButton7ActionPerformed

  private void specie_nameActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_specie_nameActionPerformed
    // TODO add your handling code here:
  } //GEN-LAST:event_specie_nameActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField customer_document;
  private javax.swing.JTextField customer_email;
  private javax.swing.JTextField customer_name;
  private javax.swing.JTextField customer_phone;
  private javax.swing.JTextField customer_street_complement;
  private javax.swing.JTextField customer_street_number;
  private javax.swing.JTextField customer_zip_code;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable jTable2;
  private javax.swing.JTextField specie_name;
  // End of variables declaration//GEN-END:variables
}
