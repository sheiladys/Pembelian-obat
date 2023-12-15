package sheiladwi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class formTransaksi extends javax.swing.JFrame {

    koneksi Konek = new koneksi();
    private Connection Con;
    Statement Stm;
    ResultSet Rs;
    String Sql; 
    DefaultTableModel Dtm;
    private int selectedId; 
    
    public formTransaksi() {
        initComponents();
        TampilPadaTabel();
        KosongObjek();
    }

        void KosongObjek(){
        txtObat.setText("");
        txtNama.setText("");
        txtJumlah.setText("");
        txtHarga.setText("");
        txtTotal.setText("");
        txtObat.requestFocus(); 
    }
    
   private void AturJTable(JTable Lihat, int[] Lebar) {
    try {
        // Set the auto-resize mode to OFF to control column widths manually
        Lihat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        int banyak = Lihat.getColumnCount();

        // Check if the length of the 'Lebar' array is sufficient for the number of columns
        if (Lebar.length >= banyak) {
            for (int i = 0; i < banyak; i++) {
                // Get the TableColumn for the current column index
                TableColumn kolom = Lihat.getColumnModel().getColumn(i);

                // Set the preferred width for the current column
                kolom.setPreferredWidth(Lebar[i]);
            }

            // Set the row height for all rows
            Lihat.setRowHeight(20);
        } else {
            // Display an error message if the length of the 'Lebar' array is insufficient
            JOptionPane.showMessageDialog(null, "Panjang Array 'Lebar' terlalu pendek", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        // Handle any exceptions that might occur during the process
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    
    private void TampilModelJTabel(){
       try {
            String[]kolom={"ID_OBAT","NAMA PEMBELI","HARGA", "JUMLAH","TOTAL", "TGL TRANSAKSI",};
            Dtm = new DefaultTableModel(null, kolom){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
            }
            };
            tblTransaksi.setModel(Dtm);
            AturJTable(tblTransaksi, new int[]{100, 200, 150, 80, 120, 200});
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah"+e);
            }
    }
    
    void TampilPadaTabel(){
        try {
            Con = koneksi.getKoneksi();
            Stm = Con.createStatement();
            TampilModelJTabel();
            try {
                Sql = "select * from transaksi";
                Rs = Stm.executeQuery(Sql);
                while (Rs.next()) {
                    Dtm.addRow(new Object[]{
                            Rs.getString("id_obat"),
                            Rs.getString("nama_pembeli"),
                            Rs.getInt("harga"),
                            Rs.getInt("jumlah"),
                            Rs.getString("total"),
                            Rs.getInt("tgl_transaksi"),
                    });
                    tblTransaksi.setModel(Dtm);
                }
            } catch (Exception e) {
                System.out.println("Ada Kesalahan " + e.toString());
            }
        } catch (SQLException e) {
            System.out.println("koneksi gagal " + e.toString());
        }
    }
    
    private void HitungTotal() {
        try {
            int harga = Integer.parseInt(txtHarga.getText());
            int jumlah = Integer.parseInt(txtJumlah.getText());

            int total = harga * jumlah;
            txtTotal.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga dan Jumlah harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void GetDataByIdObat() {
        String idObat = txtObat.getText();  
        try {
            Con = koneksi.getKoneksi();
            Stm = Con.createStatement();
            Sql = "SELECT * FROM data WHERE id_obat = '" + idObat + "'";
            Rs = Stm.executeQuery(Sql);

            while (Rs.next()) {
                txtNama.setText(Rs.getString("nama_pembeli"));
                txtHarga.setText(String.valueOf(Rs.getInt("harga")));
                txtJumlah.setText(String.valueOf(Rs.getInt("jumlah")));
            }

            Stm.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtObat = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        dcTransaksi = new com.toedter.calendar.JDateChooser();
        btnHitung = new javax.swing.JButton();
        GetDataByIdObat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        cmbCari = new javax.swing.JComboBox<>();
        btnCari = new javax.swing.JButton();
        btnReff = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("MS Gothic", 1, 36)); // NOI18N
        jLabel1.setText("TRANSAKSI PEMBELIAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(547, 547, 547)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel16.setText("TRANSAKSI");

        jLabel2.setText("ID OBAT");

        jLabel3.setText("NAMA PEMBELI");

        jLabel4.setText("HARGA OBAT");

        jLabel5.setText("JUMLAH BELI");

        jLabel6.setText("TOTAL PEMBELIAN");

        jLabel7.setText("TGL TRANSAKSI");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnHitung.setText("HITUNG");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        GetDataByIdObat.setText("GET ID OBAT");
        GetDataByIdObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetDataByIdObatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtObat, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(GetDataByIdObat)
                                    .addComponent(btnHitung))))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GetDataByIdObat))
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3))
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHitung))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID OBAT", "NAMA PEMBELI", "HARGA OBAT", "JUMLAH BELI", "TOTAL PEMBELIAN", "TGL TRANSAKSI"
            }
        ));
        jScrollPane1.setViewportView(tblTransaksi);

        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel8.setText("CARI");

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_OBAT", "NAMA PEMBELI", "TOTAL" }));
        cmbCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCariActionPerformed(evt);
            }
        });

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnReff.setText("REFF");
        btnReff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar)
                        .addGap(333, 333, 333)
                        .addComponent(btnCetak))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(380, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel8)
                .addGap(50, 50, 50)
                .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReff)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnHapus)
                                .addComponent(btnEdit)
                                .addComponent(btnBatal)
                                .addComponent(btnKeluar))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCetak)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(btnReff))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        HitungTotal();
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            Con = koneksi.getKoneksi();

            // Check if dcTransaksi is not null
            if (dcTransaksi.getDate() != null) {
                Sql = "INSERT INTO transaksi (id_obat, nama_pembeli, harga, jumlah, total, tgl_transaksi) " +
                    "VALUES ('" + txtObat.getText() + "', '" + txtNama.getText() + "', '" + 
                    txtHarga.getText() + "', '" + txtJumlah.getText() + "', '" + 
                    txtTotal.getText() + "', '" + new SimpleDateFormat("yyyy-MM-dd").format(dcTransaksi.getDate()) + "')";

                try (Statement statement = Con.createStatement()) {
                    int AdaPenambahanRecord = statement.executeUpdate(Sql);
                    if (AdaPenambahanRecord > 0) {
                        JOptionPane.showMessageDialog(this, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        TampilPadaTabel();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tanggal Transaksi is null", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            System.out.println("Koneksi Gagal " + e.toString());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            Con = koneksi.getKoneksi();
            Stm = Con.createStatement();

            // Ensure dcTransaksi.getDate() is not null before proceeding
            if (dcTransaksi.getDate() != null) {
                String tglTransaksi = new SimpleDateFormat("yyyy-MM-dd").format(dcTransaksi.getDate());
                String idObat = txtObat.getText(); 

                String sql = "UPDATE transaksi SET tgl_transaksi=? WHERE id_obat=?";

                try (PreparedStatement preparedStatement = Con.prepareStatement(sql)) {
                    preparedStatement.setString(1, tglTransaksi);
                    preparedStatement.setString(2, idObat);

                    int AdaPenambahanRecord = preparedStatement.executeUpdate();

                    TampilPadaTabel();

                    if (AdaPenambahanRecord > 0) {
                        JOptionPane.showMessageDialog(this, "Data Berhasil Terupdate", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Data Gagal Terupdate", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException e) {
                    System.out.println("Ada Kesalahan " + e.toString());
                }
            } else {
                // Handle the case where dcTransaksi.getDate() is null
                JOptionPane.showMessageDialog(this, "Tanggal transaksi tidak valid", "Informasi", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal " + e.toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
             Con = koneksi.getKoneksi();
            String idObatToDelete = JOptionPane.showInputDialog(this, "Enter the ID_OBAT to delete:");

            if (idObatToDelete != null && !idObatToDelete.isEmpty()) {
                String sql = "DELETE FROM transaksi WHERE id_obat = ?";

                try (PreparedStatement preparedStatement = Con.prepareStatement(sql)) {
                    int idObat = Integer.parseInt(idObatToDelete);
                    preparedStatement.setInt(1, idObat);

                    int AdaPenghapusanRecord = preparedStatement.executeUpdate();
                    TampilPadaTabel();

                    if (AdaPenghapusanRecord > 0) {
                        JOptionPane.showMessageDialog(this, "Data Berhasil Terhapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Data Gagal Terhapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi Gagal " + e.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for ID_OBAT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        KosongObjek();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void GetDataByIdObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetDataByIdObatActionPerformed
        GetDataByIdObat();
    }//GEN-LAST:event_GetDataByIdObatActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void cmbCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCariActionPerformed
        String jenisValue = cmbCari.getSelectedItem().toString();
        int selectedRow = tblTransaksi.getSelectedRow();
        if (selectedRow != -1 && tblTransaksi.getColumnCount() >= 10) {
            tblTransaksi.setValueAt(jenisValue, selectedRow, 9);
        }
    }//GEN-LAST:event_cmbCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        try {
            Con = koneksi.getKoneksi();
            Stm = Con.createStatement();
            TampilModelJTabel();

            try {
                String namaKolom = cmbCari.getSelectedItem().toString();
                String searchTerm = txtCari.getText();

                String sql;

                if ("NAMA PEMBELI".equals(namaKolom)) {
                    sql = "SELECT * FROM transaksi WHERE `nama_pembeli` LIKE ?";
                } else {
                    sql = "SELECT * FROM transaksi WHERE `" + namaKolom + "` LIKE ?";
                }

                try (PreparedStatement preparedStatement = Con.prepareStatement(sql)) {
                    preparedStatement.setString(1, "%" + searchTerm.replace("'", "''") + "%");
                    Rs = preparedStatement.executeQuery();

                    while (Rs.next()) {
                        Dtm.addRow(new Object[]{
                            Rs.getString("id_obat"),
                            Rs.getString("nama_pembeli"),
                            Rs.getInt("harga"),
                            Rs.getInt("jumlah"),
                            Rs.getString("total"),
                            Rs.getInt("tgl_transaksi"),
                        });
                    }
                }
            } catch (Exception e) {
                System.out.println("Ada Kesalahan " + e.toString());
            }
        } catch (SQLException e) {
            System.out.println("koneksi gagal " + e.toString());
        }
        tblTransaksi.setModel(Dtm);
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnReffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReffActionPerformed
        TampilPadaTabel();
    }//GEN-LAST:event_btnReffActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        
    }//GEN-LAST:event_txtNamaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        txtNama.disable();
        txtHarga.disable();
        txtJumlah.disable();
        txtTotal.disable();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GetDataByIdObat;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnReff;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbCari;
    private com.toedter.calendar.JDateChooser dcTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtObat;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
