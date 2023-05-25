package view;

import com.formdev.flatlaf.IntelliJTheme;
import controller.BranchController;
import controller.exception.SpaceException;
import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.util.Util;
import javax.swing.JOptionPane;
import view.combomodel.MonthComboModel;
import view.tablemodel.BranchTableModel;
import view.tablemodel.SaleTableModel;

/**
 *
 * @author miguel
 */
public class BranchFrm extends javax.swing.JDialog {

    private BranchController controller = new BranchController();
    private BranchTableModel modelBrch = new BranchTableModel();
    private SaleTableModel modelSale = new SaleTableModel();
    private MonthComboModel modelCombo = new MonthComboModel();
    private int rowSale = -1;

    /**
     * Creates new form BranchFrm
     *
     * @param parent
     * @param modal
     */
    public BranchFrm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pnSale.setVisible(false);
        loadTableBrch();
        loadTableSale();
        comboMonth.setModel(modelCombo);
    }

    private void clear() {

        if (controller.getBranches().getSize() == 4) {
            this.btnAdd.setEnabled(false);
        }
        loadTableBrch();
        controller.setBranch(null);

    }

    private void showAlert(String message, int type) {
        JOptionPane.showMessageDialog(null, message, "PopUp Dialog", type);
    }

    private void loadTableBrch() {
        
        if (this.controller.getBranches().getSize() >= 4) {
            this.btnAdd.setEnabled(false);
        }
        modelBrch.setData(controller.getBranches());
        tbOfficies.setModel(modelBrch);
        tbOfficies.updateUI();
        
    }

    private void loadTableSale() {
        
        modelSale.setData(controller.getBranch().getSales());
        tbSales.setModel(modelSale);
        tbSales.updateUI();
        
    }

    private void showInfoSales() throws EmptyException, IndexException {
        
        int row = tbOfficies.getSelectedRow();

        if (modelBrch.getData().get(row) != null) {
            
            this.controller.setBranch(modelBrch.getData().get(row));
            loadTableSale();
            
            lbNameBranch.setText(controller.getBranch().getName() + "'s Officie");
            tbOfficies.clearSelection();
            
        }
        
    }

    private void showSale() throws SpaceException, EmptyException, IndexException {
        rowSale = tbSales.getSelectedRow();

        if (rowSale < 0) {
            throw new SpaceException();
        }

        this.controller.setSale(this.controller.getBranch().getSales().get(rowSale));

        new SaleFrm(null, true, this.controller, rowSale).setVisible(true);
        tbSales.clearSelection();
    }

    private void getLowestSale() throws EmptyException, IndexException {
        
        String infoLowest = Util.lowestSaleMonth(controller.getBranches());

        JOptionPane.showMessageDialog(null, infoLowest, "Lowest Sale", JOptionPane.INFORMATION_MESSAGE);
        
    }

    private void getHighestSale() throws EmptyException, IndexException, SpaceException {
        
        int index = comboMonth.getSelectedIndex();

        if (index == -1) {
            throw new SpaceException("Select a month");
        }

        int highSale = Util.highestSaleIndex(controller.getBranches(), index);

        if (highSale == -1) {
            throw new SpaceException("Enter all sales");
        }

        String infoHighest = comboMonth.getSelectedItem() + " "
                + " -> Branch [ id: "
                + controller.getBranches().get(highSale).getId()
                + " value: "
                + controller.getBranches().get(highSale).getSales().get(index)
                + " ]";

        JOptionPane.showMessageDialog(null,
                infoHighest,
                "Highest Sale",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private void getAverageSales() throws SpaceException, EmptyException, IndexException {
        
        int index = comboMonth.getSelectedIndex();

        if (index == -1) {
            throw new SpaceException("Select a month");
        }

        String infoMonthAverage = Util.averageSaleMonth(controller.getBranches(), index);

        JOptionPane.showMessageDialog(null,
                infoMonthAverage,
                "Average Sales",
                HEIGHT);
        
    }

    private void showRequest() {
        new RequestFrm(null, true).setVisible(true);
    }

    private void showHistory() {
        new HistoryFrm(null, true, controller.getHistory()).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JButton();
        pnOffies = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOfficies = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRequest = new javax.swing.JButton();
        btnSmallest = new javax.swing.JButton();
        btnLargest = new javax.swing.JButton();
        btnAverageMonth = new javax.swing.JButton();
        comboMonth = new javax.swing.JComboBox<>();
        pnSale = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSales = new javax.swing.JTable();
        lbNameBranch = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("TlwgMono", 1, 18)); // NOI18N
        jLabel1.setText("ECOLOGICOS HOUSE");

        btnHistory.setFont(new java.awt.Font("TlwgMono", 0, 15)); // NOI18N
        btnHistory.setText("History");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHistory)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnHistory))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnOffies.setBackground(new java.awt.Color(255, 255, 255));
        pnOffies.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbOfficies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbOfficies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOfficiesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbOfficiesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbOfficies);

        btnAdd.setFont(new java.awt.Font("TlwgMono", 0, 15)); // NOI18N
        btnAdd.setText("new");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setText("Officies");

        btnRequest.setFont(new java.awt.Font("TlwgMono", 0, 15)); // NOI18N
        btnRequest.setText("Request");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnSmallest.setFont(new java.awt.Font("TlwgMono", 0, 15)); // NOI18N
        btnSmallest.setText("Lowest");
        btnSmallest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSmallestActionPerformed(evt);
            }
        });

        btnLargest.setFont(new java.awt.Font("TlwgMono", 0, 15)); // NOI18N
        btnLargest.setText("Highest");
        btnLargest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLargestActionPerformed(evt);
            }
        });

        btnAverageMonth.setFont(new java.awt.Font("TlwgMono", 0, 15)); // NOI18N
        btnAverageMonth.setText("Average");
        btnAverageMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAverageMonthActionPerformed(evt);
            }
        });

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnOffiesLayout = new javax.swing.GroupLayout(pnOffies);
        pnOffies.setLayout(pnOffiesLayout);
        pnOffiesLayout.setHorizontalGroup(
            pnOffiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOffiesLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pnOffiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnOffiesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(350, 350, 350)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(pnOffiesLayout.createSequentialGroup()
                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAverageMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLargest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSmallest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnOffiesLayout.setVerticalGroup(
            pnOffiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOffiesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnOffiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnOffiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRequest)
                    .addComponent(btnSmallest)
                    .addComponent(btnLargest)
                    .addComponent(btnAverageMonth)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pnSale.setBackground(new java.awt.Color(255, 255, 255));
        pnSale.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSalesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSales);

        lbNameBranch.setFont(new java.awt.Font("TlwgMono", 1, 18)); // NOI18N
        lbNameBranch.setText("name of branch");

        jButton5.setFont(new java.awt.Font("TlwgMono", 1, 10)); // NOI18N
        jButton5.setText("brack");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSaleLayout = new javax.swing.GroupLayout(pnSale);
        pnSale.setLayout(pnSaleLayout);
        pnSaleLayout.setHorizontalGroup(
            pnSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSaleLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnSaleLayout.createSequentialGroup()
                        .addComponent(lbNameBranch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        pnSaleLayout.setVerticalGroup(
            pnSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSaleLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNameBranch)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnOffies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnOffies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(pnSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        new AddBranch(null, true, controller).setVisible(true);
        loadTableBrch();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed

        showRequest();

    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed

        showHistory();

    }//GEN-LAST:event_btnHistoryActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        this.pnSale.setVisible(false);
        this.pnOffies.setVisible(true);
        this.controller.setBranch(null);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSalesMouseClicked

        try {
            showSale();
        } catch (EmptyException | IndexException | SpaceException ex) {
            showAlert(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_tbSalesMouseClicked

    private void tbOfficiesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOfficiesMousePressed
    }//GEN-LAST:event_tbOfficiesMousePressed

    private void btnLargestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLargestActionPerformed

        try {
            getHighestSale();
        } catch (EmptyException | IndexException | SpaceException ex) {
            showAlert(ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnLargestActionPerformed

    private void btnSmallestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSmallestActionPerformed

        try {
            getLowestSale();
        } catch (EmptyException | IndexException ex) {
            showAlert(ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnSmallestActionPerformed

    private void tbOfficiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOfficiesMouseClicked

        try {
            // TODO add your handling code here:
            showInfoSales();
        } catch (EmptyException | IndexException ex) {
            showAlert(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        this.pnOffies.setVisible(false);
        this.pnSale.setVisible(true);
    }//GEN-LAST:event_tbOfficiesMouseClicked

    private void btnAverageMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAverageMonthActionPerformed

        try {
            getAverageSales();
        } catch (EmptyException | IndexException | SpaceException ex) {
            showAlert(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAverageMonthActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
 /* Using github theme for this project (Lib flatlaf-3.1.1)*/

        IntelliJTheme.setup(BranchFrm.class.getResourceAsStream(
                "/theme/GitHub.theme.json"));

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            BranchFrm dialog = new BranchFrm(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAverageMonth;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnLargest;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnSmallest;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbNameBranch;
    private javax.swing.JPanel pnOffies;
    private javax.swing.JPanel pnSale;
    private javax.swing.JTable tbOfficies;
    private javax.swing.JTable tbSales;
    // End of variables declaration//GEN-END:variables
}
