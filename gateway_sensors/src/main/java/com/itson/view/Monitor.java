/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.view;

import com.itson.dao.impl.GatewayDAOImpl;
import com.itson.gateway.impl.Gateway;
import com.itson.utilities.gatewayformat.MessageFormat;
import com.itson.utils.observer.Observable;

import java.awt.*;

/**
 *
 * @author jairo-rhz
 */
public class Monitor extends javax.swing.JFrame implements Observable{

    protected final Gateway gateway;
    private final Principal principal;
    private boolean status = true;

    /**
     * Creates new form Monitor
     *
     * @param gateway
     * @param principal
     */
    public Monitor(Gateway gateway, Principal principal) {
        initComponents();
        this.gateway = gateway;
        this.principal = principal;
        gateway.addObservable(this);
        cargarDatosPantalla();
        validarStatus();
    }

    private void cargarDatosPantalla() {
        this.txtSerie.setText(gateway.getSeries());
        this.txtTiempo.setText(String.valueOf(gateway.getCaptureTime()));
    }

    private void actualizarArea() {
        this.txtAreaDatos.setText("");
        for (MessageFormat mensaje : gateway.getMensajes()) {
            txtAreaDatos.append(mensaje.toString() + "\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDatos = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(42, 50, 60));

        txtAreaDatos.setEditable(false);
        txtAreaDatos.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaDatos.setColumns(20);
        txtAreaDatos.setFont(new java.awt.Font("Liberation Sans", 1, 10)); // NOI18N
        txtAreaDatos.setForeground(new java.awt.Color(51, 255, 51));
        txtAreaDatos.setRows(5);
        txtAreaDatos.setBorder(null);
        jScrollPane1.setViewportView(txtAreaDatos);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gateway");

        txtSerie.setForeground(new java.awt.Color(255, 255, 255));
        txtSerie.setText("serie");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tiempo de envio");

        txtTiempo.setForeground(new java.awt.Color(255, 255, 255));
        txtTiempo.setText("tiempo");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estatus");

        btnStatus.setBackground(new java.awt.Color(255, 0, 0));
        btnStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnStatusLayout = new javax.swing.GroupLayout(btnStatus);
        btnStatus.setLayout(btnStatusLayout);
        btnStatusLayout.setHorizontalGroup(
                btnStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );
        btnStatusLayout.setVerticalGroup(
                btnStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel1)
                                                .addGap(113, 113, 113)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(txtSerie)
                                                .addGap(184, 184, 184)
                                                .addComponent(txtTiempo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(99, 99, 99))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(120, 120, 120))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtSerie)
                                                .addComponent(txtTiempo))
                                        .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseClicked
        // TODO add your handling code here:
        validarMonitor();
    }//GEN-LAST:event_btnStatusMouseClicked

    protected void validarMonitor() {
        if (status) {
            status = false;
        } else {
            status = true;
        }
        validarStatus();
        actualizarGateway();
    }

    private void validarStatus() {
        if (status) {
            this.btnStatus.setBackground(Color.GREEN);
            gateway.startGateway();
        } else {
            this.btnStatus.setBackground(Color.RED);
            gateway.finishGateway();
        }
    }

    private void actualizarGateway() {
        GatewayDAOImpl.getInstance().updateGateway(gateway);
        principal.cargarDatosTabla();
    }

    @Override
    public void dispose() {
        super.dispose();
        if (status) {
            gateway.finishGateway();
            actualizarGateway();
        }

    }

    public Gateway getGateway() {
        return gateway;
    }

    @Override
    public void update() {
        actualizarArea();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaDatos;
    private javax.swing.JLabel txtSerie;
    private javax.swing.JLabel txtTiempo;
    // End of variables declaration//GEN-END:variables
}
