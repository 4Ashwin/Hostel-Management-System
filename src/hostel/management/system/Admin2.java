package hostel.management.system;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USER
 */
public class Admin2 extends javax.swing.JFrame {
ResultSet rs,rs1,rs4;
int i=0,Tempn=0,rowcount ;
    String admn;
    DefaultTableModel model;
    Connection conn=DBConnection.getConnection();
    String query2 = "INSERT INTO registers VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String query3="UPDATE registers SET in_date=?,in_time=?,status='In',in_month=?,in_day=? WHERE admission_number=? AND status='Out'";
    String query5="INSERT INTO messcount VALUES(?,?,?,?,?) ";
    String query ="SELECT s.admission_number,s.fName, s.class,s.room_no,s.block, r.out_time, r.destination, r.in_date,r.in_time,r.out_date,r.status FROM students s JOIN registers r WHERE s.admission_number = r.admission_number ";
    String query4 ="SELECT s.fName, s.class,s.room_no,s.block, r.out_time, r.destination, r.in_date,r.in_time,r.out_date,r.status FROM students s JOIN registers r WHERE s.admission_number = r.admission_number AND s.admission_number=? ";

    /**
     * Creates new form Admin2
     */
    public Admin2() {
         SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
         Date date=new Date();
        String time=ft.format(date);
        LocalDate da = LocalDate.now();

    // Get the day of the month for the current date
//        int day = da.getDayOfMonth();
        initComponents();
          this.time.setText(time);
        time1.setText(time);
//        while(true)
//        {
//            if(day==30 AND ){}
//        }
        
        setTable();
    
   
    
   
    
    }
    public void clearTable() {
    
    model.setRowCount(0);
    model.fireTableDataChanged();

}
   
    public void setTable()
{
         
               
    
   

    try (
     PreparedStatement statement = conn.prepareStatement(query)) {
             // set the admission number
             rs = statement.executeQuery();
             rs.next();
             rowcount=rs.getInt(1);
             System.out.println(rowcount);
            
              model = new DefaultTableModel() {
                  
    @Override
    public int getColumnCount() {
        return 10;  // number of columns in the table
    }

    @Override
    public int getRowCount() {
        
        return rowcount;  // number of rows in the table
    }
};
// Set the column names
model.setColumnIdentifiers(new String[] {"Adm_no","Name","Class","Block","RoomNo", "IN_Time", "IN_Date", "OUT_DATE","OUT_TIME","Destination"});
// Handle the exception
             while (rs.next()) {
                 // Retrieve the data from the result set
                 String admnum = rs.getString("admission_number");
                 String name = rs.getString("FName");
                 String classn = rs.getString("class");
                  String block = rs.getString("block");
                  String room = rs.getString("room_no");              
                 String itimen = rs.getString("in_time");
                 String destination = rs.getString("destination");
                 String idaten = rs.getString("in_date");
                 String otimen = rs.getString("out_time");
                 String odaten = rs.getString("out_date");
                 
                 // Set the data in the table model
                 model.setValueAt(admnum, i, 0);
                 model.setValueAt(name, i, 1);
                 model.setValueAt(classn, i, 2);
                  model.setValueAt(block, i, 3);
                   model.setValueAt(room, i, 4);
                 model.setValueAt(itimen, i, 5);
                 model.setValueAt(destination, i, 9);
                  model.setValueAt(idaten, i, 6);
                  model.setValueAt(otimen, i, 8);
                 model.setValueAt(odaten, i, 7);
                 i++;
             }
       
    } catch (java.sql.SQLException ex) {
        Logger.getLogger(Admin2.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable1.setModel(model);

}
    
    public void setTable2()
{
         
               DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
    model2.setRowCount(0); //clear the previous data
    
   model2.fireTableDataChanged();

    try (
     PreparedStatement statement = conn.prepareStatement(query)) {
             // set the admission number
             rs = statement.executeQuery();
             rs.next();
             rowcount=rs.getInt(1);
             System.out.println(rowcount);
            
              model = new DefaultTableModel() {
                  
    @Override
    public int getColumnCount() {
        return 10;  // number of columns in the table
    }

    @Override
    public int getRowCount() {
        
        return rowcount;  // number of rows in the table
    }
};
// Set the column names
model.setColumnIdentifiers(new String[] {"Adm_no","Name","Class","Block","RoomNo", "IN_Time", "IN_Date", "OUT_DATE","OUT_TIME","Destination"});
// Handle the exception
             while (rs.next()) {
                 // Retrieve the data from the result set
                 String admnum = rs.getString("admission_number");
                 String name = rs.getString("FName");
                 String classn = rs.getString("class");
                  String block = rs.getString("block");
                  String room = rs.getString("room_no");              
                 String itimen = rs.getString("in_time");
                 String destination = rs.getString("destination");
                 String idaten = rs.getString("in_date");
                 String otimen = rs.getString("out_time");
                 String odaten = rs.getString("out_date");
                 
                 // Set the data in the table model
                 model.setValueAt(admnum, i, 0);
                 model.setValueAt(name, i, 1);
                 model.setValueAt(classn, i, 2);
                  model.setValueAt(block, i, 3);
                   model.setValueAt(room, i, 4);
                 model.setValueAt(itimen, i, 5);
                 model.setValueAt(destination, i, 9);
                  model.setValueAt(idaten, i, 6);
                  model.setValueAt(otimen, i, 8);
                 model.setValueAt(odaten, i, 7);
                 i++;
             }
       
    } catch (java.sql.SQLException ex) {
        Logger.getLogger(Admin2.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable1.setModel(model);
//   
////DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//for (int i = 0; i < model.getRowCount(); i++) {
//    boolean rowIsEmpty = true;
//    for (int j = 0; j < model.getColumnCount(); j++) {
//        
//        if (model.getValueAt(i, j) != null) {
//            rowIsEmpty = false;
//            break;
//        }
//    }
//    if (rowIsEmpty) {
//        model.removeRow(i);
//        i--;
//    }
//}

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        admno2 = new javax.swing.JTextField();
        admb = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        admno = new javax.swing.JTextField();
        datei = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        destination = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        date1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        admno1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        admnom = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        dailyc = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        date2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        room = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        block = new javax.swing.JLabel();
        odate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(0, 71, 97));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HOSTEL REGISTER");
        jLabel1.setToolTipText("");

        jButton4.setBackground(new java.awt.Color(0, 71, 97));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closeicon.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton4)
                .addGap(511, 511, 511)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35))))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Block No  :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Status  :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Room No  :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Name  :");

        admno2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        admno2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        admno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admno2ActionPerformed(evt);
            }
        });

        admb.setBackground(new java.awt.Color(0, 71, 97));
        admb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        admb.setForeground(new java.awt.Color(255, 255, 255));
        admb.setText("Search");
        admb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admbActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Enter Admission Number");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Adm no");

        admno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        datei.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        datei.setText(java.time.LocalDate.now().toString());

        jButton1.setBackground(new java.awt.Color(0, 71, 97));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Date :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Time :");

        time.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        time.setText(java.time.LocalTime.now().toString());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(5, 5, 5)
                                .addComponent(admno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datei))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(106, 106, 106)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(admno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datei)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(time))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Destination");

        destination.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        destination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 71, 97));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        date1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date1.setText(java.time.LocalDate.now().toString());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Date :");

        time1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        time1.setText(java.time.LocalTime.now().toString());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Time :");

        admno1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Adm no");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(admno1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date1)
                    .addComponent(time1))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(144, 144, 144))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(date1)
                    .addComponent(jLabel17)
                    .addComponent(admno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(time1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 71, 97));
        jLabel3.setText("INCOMING REGISTER");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 71, 97));
        jLabel5.setText("OUTGOING REGISTER");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Adm no  :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Skip Mess  :");

        admnom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        admnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admnomActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 71, 97));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Submit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        dailyc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dailyc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Date :");

        date2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date2.setText(java.time.LocalDate.now().toString());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(admnom, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date2)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dailyc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(83, 83, 83))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(admnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(date2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(dailyc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setBackground(new java.awt.Color(0, 71, 97));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 71, 97));
        jLabel11.setText("MESS COUNT");

        name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        room.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        status.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        block.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        odate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(admno2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(admb))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(block, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(odate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(admno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(admb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(name))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(room))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(block))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(status))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(odate)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
String ms2;
int d2,absent;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        try {
        an=admno.getText();
        System.out.println(an);
//         String query3="UPDATE registers SET in_date=?,in_time=?,status='In',out_month=MONTH(?),out_day=DAY(?) WHERE admission_number=? AND status='Out'";
        PreparedStatement pst2=conn.prepareStatement(query3);
        pst2.setString(1,datei.getText());
        pst2.setString(2, time.getText());
        Date dat = new Date();
                SimpleDateFormat df = new SimpleDateFormat("DD");
SimpleDateFormat mf = new SimpleDateFormat("MM");

d2=Integer.parseInt(df.format(dat));
ms2=mf.format(dat);
if(ms2.charAt(0)=='0'){
    ms2 = ms2.substring(1);
}
        pst2.setString(3, ms2);
        
        pst2.setInt(4, d2);
        pst2.setString(5, an);
System.out.println(ms2+d2+an);
        pst2.executeUpdate();
        
             JOptionPane.showMessageDialog(jButton1,"In Coming Register filled Succesfully");   
        // TODO add your handling code here:
    } catch (SQLException ex) {
        System.out.println("ooh1212");
        Logger.getLogger(Admin2.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(jButton1,"Incoming Registeration Failed"); 
    }

        try {
             PreparedStatement psta=conn.prepareStatement("SELECT in_day,out_day,in_month,out_month FROM registers WHERE admission_number=? AND out_month=?");
             psta.setString(1, an);
             
             rs1=psta.executeQuery();
             rs1.next();
             String m1=rs1.getString(3);
             String m2=rs1.getString(4);
             int di=rs1.getInt(1);
             int dou=rs1.getInt(2),extra;
             if(m1 == null ? m2 == null : m1.equals(m2)){
             absent=di-dou;}
             else if("4".equals(m2) || "6".equals(m2) || "9".equals(m2) || "11".equals(m2))
             {
              absent=(30-dou)-di;
//              extra=di;
             }
             else if("1".equals(m2) || "3".equals(m2) || "5".equals(m2) || "7".equals(m2) ||  "8".equals(m2) || "10".equals(m2) ||  "12".equals(m2))
             {
             absent=31-dou+di;
//             extra=di;
             }
             else if("2".equals(m2))
             {
             absent=28-dou+di;
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(StudentFeeDetails.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        try {
             PreparedStatement pst2=conn.prepareStatement("UPDATE Registers SET absent_days=? WHERE admission_number=?");
             pst2.setInt(1,absent);
             pst2.setString(2,an);
            
             pst2.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(StudentFeeDetails.class.getName()).log(Level.SEVERE, null, ex);
         }
        clearTable();
    setTable2();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    int d1;
    String ms1;
    String an,oy;
public  ResultSet rs2;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        an=admno1.getText();
        
        PreparedStatement pst2=conn.prepareStatement(query2);
        pst2.setString(1, an);
        pst2.setString(2, "");
        pst2.setString(3,date1.getText());
        pst2.setString(4,"Out");
        pst2.setString(5,"");
        pst2.setString(6,destination.getText());
        pst2.setString(7,time1.getText());
          Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("DD");
SimpleDateFormat mf = new SimpleDateFormat("MM");
SimpleDateFormat dy1 = new SimpleDateFormat("YYYY");
d1=Integer.parseInt(df.format(date));
ms1=mf.format(date);
oy=dy1.format(date);
//        String input = "01";
if(ms1.charAt(0)=='0'){
    ms1 = ms1.substring(1);
}
        
        pst2.setInt(8,d1);
        pst2.setInt(9,0);
        pst2.setString(10,ms1);
        pst2.setString(11,"");
        pst2.setInt(12,0);
        pst2.setString(13,oy);

        pst2.setString(14,"");



   
               
        pst2.executeUpdate();
        
             JOptionPane.showMessageDialog(jButton2,"Out Going Register filled Succesfully");   
        // TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(Admin2.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(jButton2,"Out Going Registeration Failed"); 
    }
    clearTable();
    setTable2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login lg = new login();
        lg.show();
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void destinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationActionPerformed

    private void admno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admno2ActionPerformed
    
   
       
        // set the admission number
         // Handle the exception
        
            
            // TODO add your handling code here:
        
    private void admbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admbActionPerformed
Tempn=1;        
         if(Tempn==1){
     try {
            admn=admno2.getText();
            
            PreparedStatement st;
            st = conn.prepareStatement(query4);
            st.setString(1, admn);
            rs4 = st.executeQuery();
            rs4.next();
            
            name.setText(rs4.getString(1));
            room.setText(rs4.getString(3));
            block.setText(rs4.getString(4));
            status.setText(rs4.getString(10));
            
            if("Out".equals(rs4.getString(10)))
            {
            odate.setText("Departure Date : "+rs4.getString(9));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
        
        /**
         * @param args the command line arguments
         */
    // TODO add your handling code here:
    }//GEN-LAST:event_admbActionPerformed
String ys,ms;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        try {
            
        an=admnom.getText();
        
        PreparedStatement pst3=conn.prepareStatement(query5);
        pst3.setString(3,dailyc.getSelectedItem().toString());
        pst3.setString(1, an);
        
        pst3.setString(2,date2.getText());
        
        Date date = new Date();
//        date=java.time.LocalDate.now();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
ms=monthFormat.format(date);
ys=yearFormat.format(date);
//        String input = "01";
if(ms.charAt(0)=='0'){
    ms = ms.substring(1);
}


        pst3.setString(4,ys);
        pst3.setString(5,ms);
   
        
        
       
   
               
        pst3.executeUpdate();
        
             JOptionPane.showMessageDialog(jButton2,"Mess count filled succesfully !!");   
        // TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(Admin2.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(jButton2," Failed"); 
    }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void admnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admnomActionPerformed

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
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admb;
    private javax.swing.JTextField admno;
    private javax.swing.JTextField admno1;
    private javax.swing.JTextField admno2;
    private javax.swing.JTextField admnom;
    private javax.swing.JLabel block;
    private javax.swing.JComboBox<String> dailyc;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JLabel datei;
    private javax.swing.JTextField destination;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel odate;
    private javax.swing.JLabel room;
    private javax.swing.JLabel status;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    // End of variables declaration//GEN-END:variables
}
