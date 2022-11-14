package view;

import controller.Controller;
import javax.swing.JTable;

public class AppointmentView extends javax.swing.JFrame {

  public void startComponents() {
    Controller.fillAppointmentField(
      jTextField1,
      jTextField2,
      jTextField3,
      jTextField4
    );
  }

  public AppointmentView() {
    initComponents();
    this.startComponents();
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {
    headerItem = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jDateChooser1 = new com.toedter.calendar.JDateChooser();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jTextField1 = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jSeparator2 = new javax.swing.JSeparator();
    jLabel5 = new javax.swing.JLabel();
    jTextField3 = new javax.swing.JTextField();
    jSeparator3 = new javax.swing.JSeparator();
    jFormattedTextField1 = new javax.swing.JFormattedTextField();
    jLabel6 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jLabel9 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField();
    jSeparator4 = new javax.swing.JSeparator();
    jLabel10 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    headerItem.setBackground(new java.awt.Color(31, 31, 71));

    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    // jLabel7.setIcon(
    //   new javax.swing.ImageIcon(
    //     "C:\\Users\\PC\\Unicamp\\2ºSem. 2021\\Topicos\\ClinicaVeterinaria\\src\\main\\java\\View\\Icones\\icons8_veterinarian_25px_2.png"
    //   )
    // ); // NOI18N

    jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Veterinary clinic");

    javax.swing.GroupLayout headerItemLayout = new javax.swing.GroupLayout(
      headerItem
    );
    headerItem.setLayout(headerItemLayout);
    headerItemLayout.setHorizontalGroup(
      headerItemLayout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          headerItemLayout
            .createSequentialGroup()
            .addGap(98, 98, 98)
            .addComponent(jLabel7)
            .addGap(18, 18, 18)
            .addComponent(jLabel8)
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );
    headerItemLayout.setVerticalGroup(
      headerItemLayout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jLabel7,
          javax.swing.GroupLayout.Alignment.TRAILING,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          47,
          Short.MAX_VALUE
        )
        .addComponent(
          jLabel8,
          javax.swing.GroupLayout.Alignment.TRAILING,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
    );

    jPanel1.setBackground(new java.awt.Color(241, 242, 249));

    jDateChooser1.setBackground(new java.awt.Color(241, 242, 249));
    jDateChooser1.setForeground(new java.awt.Color(0, 0, 0));
    jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

    jLabel1.setBackground(new java.awt.Color(0, 0, 0));
    jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Date:");

    jLabel2.setBackground(new java.awt.Color(0, 0, 0));
    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Appointment schedule");

    jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Veterinary:");

    jSeparator1.setForeground(new java.awt.Color(185, 190, 223));

    jTextField1.setEditable(false);
    jTextField1.setBackground(new java.awt.Color(255, 255, 255));
    jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jTextField1.setForeground(new java.awt.Color(0, 0, 0));
    jTextField1.setText("jTextField1");

    jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Animal:");
    jLabel4.setPreferredSize(new java.awt.Dimension(70, 20));

    jTextField2.setEditable(false);
    jTextField2.setBackground(new java.awt.Color(255, 255, 255));
    jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jTextField2.setForeground(new java.awt.Color(0, 0, 0));
    jTextField2.setText("jTextField2");

    jSeparator2.setForeground(new java.awt.Color(185, 190, 223));

    jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
    jLabel5.setText("Customer:");
    jLabel5.setPreferredSize(new java.awt.Dimension(70, 20));

    jTextField3.setEditable(false);
    jTextField3.setBackground(new java.awt.Color(255, 255, 255));
    jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jTextField3.setForeground(new java.awt.Color(0, 0, 0));
    jTextField3.setText("jTextField3");

    jSeparator3.setForeground(new java.awt.Color(185, 190, 223));

    jFormattedTextField1.setBackground(new java.awt.Color(255, 255, 255));
    jFormattedTextField1.setForeground(new java.awt.Color(0, 0, 0));
    jFormattedTextField1.setFormatterFactory(
      new javax.swing.text.DefaultFormatterFactory(
        new javax.swing.text.DateFormatter(
          java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT)
        )
      )
    );

    jLabel6.setBackground(new java.awt.Color(0, 0, 0));
    jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 0, 0));
    jLabel6.setText("Hour:");

    jButton1.setBackground(new java.awt.Color(238, 238, 252));
    jButton1.setForeground(new java.awt.Color(0, 0, 0));
    jButton1.setText("Schedule");
    jButton1.addMouseListener(
      new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
          jButton1MouseClicked(evt);
        }
      }
    );

    jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("Treatment:");

    jTextField4.setEditable(false);
    jTextField4.setBackground(new java.awt.Color(255, 255, 255));
    jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jTextField4.setForeground(new java.awt.Color(0, 0, 0));
    jTextField4.setText("jTextField4");

    jSeparator4.setForeground(new java.awt.Color(185, 190, 223));

    jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(0, 0, 0));
    jLabel10.setText("Comments:");

    jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
    jTextArea1.setColumns(20);
    jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

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
            .addGap(13, 13, 13)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2)
                .addComponent(jSeparator1)
                .addComponent(
                  jSeparator3,
                  javax.swing.GroupLayout.Alignment.TRAILING
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          jPanel1Layout
                            .createSequentialGroup()
                            .addComponent(
                              jLabel4,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              javax.swing.GroupLayout.DEFAULT_SIZE,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                            .addGap(18, 18, 18)
                            .addComponent(
                              jTextField3,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              280,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                        )
                        .addGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          jPanel1Layout
                            .createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                            )
                            .addComponent(
                              jTextField4,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              280,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                        )
                        .addGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          jPanel1Layout
                            .createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(
                              jTextField2,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              280,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                        )
                        .addGroup(
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          jPanel1Layout
                            .createSequentialGroup()
                            .addComponent(
                              jLabel5,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              javax.swing.GroupLayout.DEFAULT_SIZE,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                            .addGap(18, 18, 18)
                            .addGroup(
                              jPanel1Layout
                                .createParallelGroup(
                                  javax.swing.GroupLayout.Alignment.LEADING
                                )
                                .addComponent(jLabel2)
                                .addComponent(
                                  jTextField1,
                                  javax.swing.GroupLayout.PREFERRED_SIZE,
                                  280,
                                  javax.swing.GroupLayout.PREFERRED_SIZE
                                )
                            )
                        )
                    )
                    .addGap(0, 4, Short.MAX_VALUE)
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addGroup(
                          jPanel1Layout
                            .createSequentialGroup()
                            .addGroup(
                              jPanel1Layout
                                .createParallelGroup(
                                  javax.swing.GroupLayout.Alignment.LEADING
                                )
                                .addGroup(
                                  jPanel1Layout
                                    .createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(
                                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                                    )
                                    .addComponent(jScrollPane1)
                                )
                                .addComponent(jSeparator4)
                            )
                            .addGap(3, 3, 3)
                        )
                        .addGroup(
                          jPanel1Layout
                            .createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.RELATED
                            )
                            .addComponent(
                              jDateChooser1,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              204,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.RELATED
                            )
                            .addComponent(
                              jFormattedTextField1,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              70,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                            .addGap(0, 0, Short.MAX_VALUE)
                        )
                    )
                )
            )
            .addGap(11, 11, 11)
        )
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(160, 160, 160)
            .addComponent(jButton1)
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
            .addContainerGap()
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  jTextField1,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  jLabel5,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(9, 9, 9)
            .addComponent(
              jSeparator1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              10,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(6, 6, 6)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  jLabel4,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  jTextField3,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jSeparator2,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              10,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(6, 6, 6)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  jTextField2,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(jLabel3)
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jSeparator3,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              10,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9)
                .addComponent(
                  jTextField4,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(6, 6, 6)
            .addComponent(
              jSeparator4,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              10,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel10)
                .addComponent(
                  jScrollPane1,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  40,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addGap(24, 24, 24)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addComponent(
                  jDateChooser1,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addGroup(
                  jPanel1Layout
                    .createParallelGroup(
                      javax.swing.GroupLayout.Alignment.BASELINE
                    )
                    .addComponent(jLabel6)
                    .addComponent(
                      jFormattedTextField1,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
            )
            .addGap(28, 28, 28)
            .addComponent(jButton1)
            .addContainerGap(21, Short.MAX_VALUE)
        )
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          headerItem,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
        .addComponent(
          jPanel1,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addComponent(
              headerItem,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(0, 0, 0)
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );

    pack();
  }

  private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
    Boolean scheduled = Controller.scheduleAppointment(
      jDateChooser1.getDate(),
      jFormattedTextField1.getText(),
      jTextArea1.getText()
    );
    if (scheduled) this.dispose();
  }

  /**
   * @param args the command line arguments
   */
  private javax.swing.JTable appointmentTable;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel headerItem;
  private javax.swing.JButton jButton1;
  private com.toedter.calendar.JDateChooser jDateChooser1;
  private javax.swing.JFormattedTextField jFormattedTextField1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JSeparator jSeparator3;
  private javax.swing.JSeparator jSeparator4;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JTextField jTextField3;
  private javax.swing.JTextField jTextField4;
}
