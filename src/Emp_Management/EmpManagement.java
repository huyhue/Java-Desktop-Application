package Emp_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpManagement extends javax.swing.JFrame implements DatabaseInfo{

    public static Connection conn = null;
    Vector<String> header = new Vector<String>();
    Vector data = new Vector();

    public EmpManagement() {
        initComponents();
        //Header of table
        header.add("Id");
        header.add("Name");
        header.add("Department");
        //Show data
        showEmployee();
    }

    //Connect to Database
    public Connection getConnection() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userDB, passDB);
            System.out.println("Connect successfully!");
        } catch (Exception e) {
            System.out.println("Connect failure!");
            e.printStackTrace();
        }
        return conn;
    }

    //Show data on table
    public void showEmployee() {
        try {
            //Remove all of elements
            DefaultTableModel tblModel = (DefaultTableModel) this.tblEmployee.getModel();
            tblModel.getDataVector().removeAllElements();   //xoa het tat ca
            
            //Get data from Database -> Table
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Employee");
            while (rs.next()) {
                String empID = rs.getString(1);
                String empName = rs.getString(2);
                String empDe = rs.getString(3);
                //Add to vector
                Vector emp = new Vector();
                emp.add(empID);
                emp.add(empName);
                emp.add(empDe);
                //Add vector to Data vector
                data.add(emp);
            }
            //Set table model
            tblModel.setDataVector(data, header);
            conn.close();
        } catch (Exception e) {
            System.out.println("Add node failure!");
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbDepartment = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee");

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 2, 5));

        jLabel1.setText("ID");
        jPanel1.add(jLabel1);
        jPanel1.add(txtID);

        jLabel2.setText("Name");
        jPanel1.add(jLabel2);
        jPanel1.add(txtName);

        jLabel3.setText("Department");
        jPanel1.add(jLabel3);

        cbbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "HR" }));
        jPanel1.add(cbbDepartment);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnNew)
                        .addGap(38, 38, 38)
                        .addComponent(btnUpdate)
                        .addGap(53, 53, 53)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //click a row
    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.tblEmployee.getModel();
        this.txtID.setText(model.getValueAt(this.tblEmployee.getSelectedRow(), 0).toString());
        this.txtName.setText(model.getValueAt(this.tblEmployee.getSelectedRow(), 1).toString());
        this.cbbDepartment.setSelectedItem(model.getValueAt(this.tblEmployee.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            conn = getConnection();
            String sql = "INSERT INTO Employee(EmpID, EmpName, EmpDe) VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.txtID.getText());
            stmt.setString(2, this.txtName.getText());
            stmt.setString(3, this.cbbDepartment.getSelectedItem().toString());
            int rc = stmt.executeUpdate();
            conn.close();
            showEmployee();
        } catch (Exception e) {
            System.out.println("Add node failure!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            conn = getConnection();
            String sql = "Update Employee set EmpName=?,EmpDe=? where EmpID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            DefaultTableModel model = (DefaultTableModel) this.tblEmployee.getModel();
            String empID = model.getValueAt(this.tblEmployee.getSelectedRow(), 0).toString();
            stmt.setString(1, this.txtName.getText());
            stmt.setString(2, this.cbbDepartment.getSelectedItem().toString());
            stmt.setString(3, empID);
            int rc = stmt.executeUpdate();
            conn.close();
            showEmployee();
        } catch (Exception e) {
            System.out.println("Add node failure!");
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int ret = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Confirm",JOptionPane.YES_NO_OPTION);
            if (ret == JOptionPane.YES_OPTION) {
                conn = getConnection();
                String sql = "Delete from Employee where EmpID='" + this.txtID.getText() + "'";
                Statement stmt = conn.createStatement();
                int rc = stmt.executeUpdate(sql);
                conn.close();
                showEmployee();
            }
        } catch (Exception e) {
            System.out.println("Add node failure!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmpManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbDepartment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
