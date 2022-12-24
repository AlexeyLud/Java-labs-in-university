package laba4;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;


public class Indexes extends javax.swing.JFrame {

    public Indexes() {
        initComponents();
        Connect();
        Load();
    }

    Connection conn;
    Statement s;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    
    public void Connect()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/citytransport","root","root");       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Transport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Transport.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void Load()
    {
        try 
        {
            pst = conn.prepareStatement("select * from indexes");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v = new Vector();
                for(int i = 0; i <= c; i++)
                {
                    v.add(rs.getString("id"));
                    v.add(rs.getString("data_id"));
                    v.add(rs.getString("route_id"));
                    v.add(rs.getString("work_id"));
                    v.add(rs.getString("tran_id"));
                }
                d.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Alex
    private void initComponents() {
        jButton1 = new JButton();
        jButton3 = new JButton();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton2 = new JButton();
        jButton4 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- jButton1 ----
        jButton1.setText("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c");
        jButton1.setToolTipText("");
        jButton1.addActionListener(e -> jButton1ActionPerformed(e));

        //---- jButton3 ----
        jButton3.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c");
        jButton3.addActionListener(e -> jButton3ActionPerformed(e));

        //---- jLabel1 ----
        jLabel1.setText("\u0418\u043d\u0434\u0435\u043a\u0441\u044b \u0442\u0440\u0430\u043d\u0441\u043f\u043e\u0440\u0442\u043e\u0432");

        //======== jScrollPane1 ========
        {

            //---- jTable1 ----
            jTable1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "data_id", "route_id", "work_id", "tran_id"
                }
            ));
            jTable1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    jTable1MouseClicked(e);
                }
            });
            jScrollPane1.setViewportView(jTable1);
        }

        //---- jButton2 ----
        jButton2.setText("\u041e\u0447\u0438\u0441\u0442\u0438\u0442\u044c");
        jButton2.setToolTipText("");
        jButton2.addActionListener(e -> jButton2ActionPerformed(e));

        //---- jButton4 ----
        jButton4.setText("\u041d\u0430\u0437\u0430\u0434");
        jButton4.addActionListener(e -> jButton4ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jLabel1)
                    .addGap(29, 29, 29)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(jButton2)
                    .addGap(30, 30, 30)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(31, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Добавить
        try
        {
            String sql = "select count(*) from router";
            s = conn.createStatement();
            ResultSet ress = s.executeQuery(sql);
            int count = 0;
            while(ress.next()){
                count = ress.getInt(1);
            }
            
            String sql_sel = "select id_r from router";
            s = conn.createStatement();
            ResultSet res = s.executeQuery(sql_sel);
            int route = 0;
            int[] r = new int[count];
            int i = 0;
            while (res.next()){
                route = res.getInt(1);
                r[i] = route;
                i++;
            }
            
            String sql_sel2 = "select id_d from dataintro";
            s = conn.createStatement();
            ResultSet res2 = s.executeQuery(sql_sel2);
            int data = 0;
            int[] d = new int[count];
            int j = 0;
            while (res2.next()){
                data = res2.getInt(1);
                d[j] = data;
                j++;
            }
            
            String sql_sel3 = "select id_w from worktime";
            s = conn.createStatement();
            ResultSet res3 = s.executeQuery(sql_sel3);
            int work = 0;
            int[] w = new int[count];
            int l = 0;
            while (res3.next()){
                work = res3.getInt(1);
                w[l] = work;
                l++;
            }
            
            String sql_sel4 = "select id_tr from tranname";
            s = conn.createStatement();
            ResultSet res4 = s.executeQuery(sql_sel4);
            int tran = 0;
            int[] t = new int[count];
            int e = 0;
            while (res4.next()){
                tran = res4.getInt(1);
                t[e] = tran;
                e++;
            }
            
            int k = 0;
            
            for(int p = 0; p < count; p++){
                pst = conn.prepareStatement("insert into indexes(data_id, route_id, work_id, tran_id) values(?,?,?,?)");
                pst.setInt(1, d[p]);
                pst.setInt(2, r[p]);
                pst.setInt(3, w[p]);
                pst.setInt(4, t[p]);
                k = pst.executeUpdate(); 
            }
            
            if(k > 0)
            {
                JOptionPane.showMessageDialog(this, "Данные успешно добавлены");
                Load();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ошибка, не удалось добавить данные");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Удалить
        try
        {
            d = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();
            String id = d.getValueAt(selectIndex, 0).toString();

            pst = conn.prepareStatement("delete from indexes where id=?");
            pst.setString(1, id);

            int k = pst.executeUpdate();
            if(k == 1)
            {
                JOptionPane.showMessageDialog(this, "Данные успешно удалены");
                jButton1.setEnabled(true);
                Load();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ошибка, не удалось удалить данные");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //  Удаление по клику на мышку
        d = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        String id = d.getValueAt(selectIndex, 0).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Очистить
        try
        {
            d.setRowCount(0);
            pst = conn.prepareStatement("delete from indexes");
            int k = pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Данные успешно удалены");
        }catch (SQLException ex) {
            Logger.getLogger(Transport.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Назад
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Indexes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Indexes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Indexes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Indexes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Indexes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alex
    private JButton jButton1;
    private JButton jButton3;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JButton jButton2;
    private JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
