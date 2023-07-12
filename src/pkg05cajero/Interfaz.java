package pkg05cajero;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

public class Interfaz extends javax.swing.JFrame {
    private int fondo; // Variable para almacenar el fondo actual
    private JLabel jLabel1; // Etiqueta para mostrar el fondo actual

    public Interfaz() {
        initComponents();
        fondo = 0; // Inicializar el fondo en 0 al iniciar la interfaz
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        JButton btnRetirar = new JButton();
        JButton btnDepositar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cajero Automático");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setForeground(Color.GREEN); // Establecer el color verde para la etiqueta
        jLabel1.setText("Fondo: $0"); // Etiqueta inicializada con valor de fondo 0

        btnRetirar.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnRetirar.setText("Retirar");
        btnRetirar.setBackground(Color.GREEN); // Establecer el color verde para el botón "Retirar"
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt); // Llama al método btnRetirarActionPerformed cuando se hace clic en el botón
            }
        });

        btnDepositar.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnDepositar.setText("Depositar");
        btnDepositar.setBackground(Color.GREEN); // Establecer el color verde para el botón "Depositar"
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt); // Llama al método btnDepositarActionPerformed cuando se hace clic en el botón
            }
        });

        // Diseño del panel de la interfaz
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad a retirar:"); // Muestra un cuadro de diálogo para ingresar la cantidad a retirar
        if (cantidadStr != null && !cantidadStr.isEmpty()) { // Verifica que se haya ingresado una cantidad
            try {
                int cantidad = Integer.parseInt(cantidadStr); // Convierte la cantidad ingresada a un valor entero
                if (cantidad > 0) {
                    if (cantidad <= fondo) {
                        fondo -= cantidad; // Resta la cantidad del fondo actual
                        actualizarFondo(); // Actualiza la etiqueta del fondo
                        JOptionPane.showMessageDialog(this, "Retire su dinero"); // Muestra un mensaje de éxito
                    } else {
                        JOptionPane.showMessageDialog(this, "Fondos insuficientes"); // Muestra un mensaje de error si los fondos son insuficientes
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida"); // Muestra un mensaje de error si la cantidad es inválida
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida"); // Muestra un mensaje de error si la cantidad no es un número válido
            }
        }
    }

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {
        String claveStr = JOptionPane.showInputDialog(this, "Ingrese la clave:"); // Muestra un cuadro de diálogo para ingresar la clave
        if (claveStr != null && !claveStr.isEmpty()) { // Verifica que se haya ingresado una clave
            try {
                int clave = Integer.parseInt(claveStr); // Convierte la clave ingresada a un valor entero
                if (clave == 1234) { // Supongamos que la clave es 1234
                    String montoStr = JOptionPane.showInputDialog(this, "Ingrese el monto a depositar:"); // Muestra un cuadro de diálogo para ingresar el monto a depositar
                    if (montoStr != null && !montoStr.isEmpty()) { // Verifica que se haya ingresado un monto
                        try {
                            int monto = Integer.parseInt(montoStr); // Convierte el monto ingresado a un valor entero
                            if (monto > 0) {
                                fondo += monto; // Suma el monto al fondo actual
                                actualizarFondo(); // Actualiza la etiqueta del fondo
                                JOptionPane.showMessageDialog(this, "Depósito realizado"); // Muestra un mensaje de éxito
                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese un monto válido"); // Muestra un mensaje de error si el monto es inválido
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Ingrese un monto válido"); // Muestra un mensaje de error si el monto no es un número válido
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Clave incorrecta"); // Muestra un mensaje de error si la clave es incorrecta
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una clave válida"); // Muestra un mensaje de error si la clave no es un número válido
            }
        }
    }

    private void actualizarFondo() {
        jLabel1.setText("Fondo: $" + fondo); // Actualiza la etiqueta del fondo con el valor actualizado
    }

    public static void main(String args[]) {
        // Método principal para iniciar la interfaz
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
}
