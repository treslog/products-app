
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class ProductsFrame extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();

    // crea una lista de productos
    static List<Product> list = new ArrayList<>();

    void addProduct() {

        // revisa si los campos están vacíos, si lo están, muestra un mensaje
        if (NameField.getText().isEmpty() || PriceField.getText().isEmpty()
                || QuantityField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
        } else {

            try {

                // revisa si los campos son números, si no lo son, muestra un mensaje
                Double.parseDouble(PriceField.getText());
                Integer.parseInt(QuantityField.getText());

                // agrega el producto a la lista y actualiza la tabla
                String name = NameField.getText();
                double price = Double.parseDouble(PriceField.getText());
                int quantity = Integer.parseInt(QuantityField.getText());

                list.add(new Product(name, price, quantity));

                updateAllProducts();
                clearFields();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido");
                return;
            }
        }
    }

    void removeProduct() {
        // revisa si hay un producto seleccionado, si no lo hay, muestra un mensaje
        if (ProductsList.getSelectedRow() == -1) {
            // revisa si la tabla está vacía, si lo está, muestra un mensaje
            if (table.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty");
            } else {
                JOptionPane.showMessageDialog(null, "You must select a product");
            }
        } else {

            try {
                // revisa si los campos son números, si no lo son, muestra un mensaje
                Integer.parseInt(QuantityField.getText());
                list.remove(ProductsList.getSelectedRow());
                table.removeRow(ProductsList.getSelectedRow());
                updateAllProducts();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
                return;
            }
        }
    }

    void updateProduct() {

        try {
            // actualiza el producto seleccionado
            table.setValueAt(NameField.getText(), ProductsList.getSelectedRow(), 1);
            table.setValueAt(PriceField.getText(), ProductsList.getSelectedRow(), 2);
            table.setValueAt(QuantityField.getText(), ProductsList.getSelectedRow(), 3);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un producto");
        }
    }

    void clearTable() {
        // limpia la tabla
        try {
            table.setRowCount(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La tabla está vacía");
        }
    }

    void resetTable() {
        clearTable();
        list.clear();
        JOptionPane.showMessageDialog(null, "La tabla ha sido reiniciada");
    }

    void updateAllProducts() {
        // limpia la tabla y la actualiza

        clearTable();
        for (Product p : list) {
            table.addRow(new Object[] { table.getRowCount() + 1, p.getName(),
                    p.getPrice(), p.getQuantity() });
        }
        clearFields();
    }

    void clearFields() {
        NameField.setText("");
        PriceField.setText("");
        QuantityField.setText("");
    }

    public ProductsFrame() {

        FlatMacLightLaf.setup();
        initComponents();
        String[] titles = new String[] { "Índice", "Nombre", "Precio", "Cantidad" };
        table.setColumnIdentifiers(titles);
        ProductsList.setModel(table);

        // Productos de ejemplo
        list.add(new Product("TV", 900.00, 10));
        list.add(new Product("Mouse", 50.00, 20));
        list.add(new Product("Tablet", 350.50, 30));
        updateAllProducts();
        JOptionPane.showMessageDialog(null,
                "Bienvenido al administrador de producto. Datos de ejemplo agregados");
    }

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void PriceFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void QuantityFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {
        addProduct();
    }

    private void RemoveButtonMouseClicked(java.awt.event.MouseEvent evt) {
        removeProduct();
    }

    private void UpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {
        updateProduct();
    }

    private void ClearTableMouseClicked(java.awt.event.MouseEvent evt) {
        resetTable();
    }

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tableMouseCLicked(java.awt.event.MouseEvent evt) {
        NameField.setText(table.getValueAt(ProductsList.getSelectedRow(), 1).toString());
        PriceField.setText(table.getValueAt(ProductsList.getSelectedRow(), 2).toString());
        QuantityField.setText(table.getValueAt(ProductsList.getSelectedRow(), 3).toString());
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProductsList = new javax.swing.JTable();
        NameLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        PriceLabel = new javax.swing.JLabel();
        PriceField = new javax.swing.JTextField();
        QuantityLabel = new javax.swing.JLabel();
        QuantityField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        ClearTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("Tristan Vidal - Administrador de productos");

        ProductsList.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(ProductsList);

        NameLabel.setText("Nombre producto:");

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        PriceLabel.setText("Precio producto:");

        PriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceFieldActionPerformed(evt);
            }
        });

        QuantityLabel.setText("Cantidad:");

        QuantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityFieldActionPerformed(evt);
            }
        });

        AddButton.setText("Agregar");
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
        });

        RemoveButton.setText("Quitar");
        RemoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveButtonMouseClicked(evt);
            }
        });
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Actualizar");
        UpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseClicked(evt);
            }
        });
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        ClearTable.setText("Limpiar todo");
        ClearTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableMouseClicked(evt);
            }
        });

        ProductsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseCLicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(106, 106, 106)
                                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ClearTable,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(RemoveButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                113,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(UpdateButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                113,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(NameLabel)
                                                                .addComponent(NameField,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 256,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(PriceLabel)
                                                                .addComponent(PriceField,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 256,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(QuantityLabel)
                                                                .addComponent(QuantityField,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 256,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41,
                                        Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(NameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(PriceLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(QuantityLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(QuantityField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(AddButton)
                                                .addGap(86, 86, 86)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(RemoveButton)
                                                        .addComponent(UpdateButton))
                                                .addGap(29, 29, 29)
                                                .addComponent(ClearTable))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(34, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductsFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JButton AddButton;
    private javax.swing.JButton ClearTable;
    private javax.swing.JTextField PriceField;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTable ProductsList;
    private javax.swing.JTextField QuantityField;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JScrollPane jScrollPane1;
}