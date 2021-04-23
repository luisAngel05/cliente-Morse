/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientemorse;
import java.io.*;
import java.net.*;
public class convertir extends javax.swing.JFrame {

    Socket cliente = null;
    DataInputStream entrada = null;
    DataOutputStream salida = null;
    String ipServidor = "127.0.0.1";
    public convertir() {
        initComponents();
        //Localizar en el centro de la Pantalla del computador
        this.setLocationRelativeTo(this);
        this.setLocationRelativeTo(null);
           try {
            cliente = new Socket(ipServidor, 2017);
            //asignamos este numero de puerto
            entrada = new DataInputStream(cliente.getInputStream());
            // será lo que enviaremos al servidor	
            salida = new DataOutputStream(cliente.getOutputStream());
            // será lo que nos devuelva el servidor	

        } catch (UnknownHostException excepcion) {
            System.err.println("El servidor no está levantado");
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JEditorPane();
        btnConvertir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JEditorPane();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Traductor de Codigo Morse [ Versión 1.0 ] [ 2014 ]");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Interfaz Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 530, -1));

        jLayeredPane2.setBackground(new java.awt.Color(0, 204, 204));
        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Codigo Morse");
        jLayeredPane2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        getContentPane().add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, -20, 140, 440));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Introduzca el texto a convertir a Morse");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 90, 326, -1));

        txtTexto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(txtTexto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 210, 80));

        btnConvertir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConvertir.setText("Convertir");
        btnConvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertirActionPerformed(evt);
            }
        });
        getContentPane().add(btnConvertir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 30));

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 70, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Codigo Morse");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 206, -1));

        txtResultado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(txtResultado);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 204, 80));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CODIGO MORSE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 331, -1, -1));

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, -1, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/morse_alfabeto.gif"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 360, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertirActionPerformed
         try {
            //  while (true) {
            String linea_recibida;
            salida.writeUTF(txtTexto.getText());
            linea_recibida = entrada.readUTF();

            txtResultado.setText(linea_recibida);
            
//                salida.close();
//                entrada.close();
//                cliente.close();
            //
        } catch (UnknownHostException excepcion) {
            System.err.println("No encuentro el servidor en la dirección" + ipServidor);
        } catch (IOException excepcion) {
            System.err.println("Error de entrada/salida");
        } catch (Exception e) {
            System.err.println("Error: " + e);

        }
    }//GEN-LAST:event_btnConvertirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtTexto.setText("");
        txtResultado.setText("");
        txtTexto.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(convertir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new convertir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvertir;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JEditorPane txtResultado;
    private javax.swing.JEditorPane txtTexto;
    // End of variables declaration//GEN-END:variables
public static String stringConvertido(String loreString)
{
    String cadena;
    String getMorse;
    String convertirString = "";

    for (int i = 0; i < loreString.length(); i++)
    {
        //Obtiene un caracter en la posición i
        cadena = loreString.charAt(i) + "";  

        //convertir caracteres a código Morse
        getMorse = convierte(cadena);

        //palabras separadas con el símbolo |
        if (getMorse.equals(" "))
        {
            convertirString= convertirString + "  |  ";
        } 

        else 
        {
            //concatena la letra convertida
            convertirString = convertirString + getMorse;

            //Añadir un espacio entre cada letra
            if (!getMorse.equals(" ")) 
            {
                convertirString = convertirString + " ";
            }   
        }           
    }

    return convertirString;

}
 public static String convierte (String letra)  
    {  
        String morse = letra;  

        if (letra.equalsIgnoreCase("a"))  
            morse = ".-";  
        if (letra.equalsIgnoreCase("b"))  
            morse = "-...";  
        if (letra.equalsIgnoreCase("c"))  
            morse = "-.-.";  
        if (letra.equalsIgnoreCase("d"))  
            morse = "-..";  
        if (letra.equalsIgnoreCase("e"))  
            morse = ".";  
        if (letra.equalsIgnoreCase("f"))  
            morse = "..-.";  
        if (letra.equalsIgnoreCase("g"))  
            morse = "--.";  
        if (letra.equalsIgnoreCase("h"))  
            morse = "....";  
        if (letra.equalsIgnoreCase("i"))  
            morse = "..";  
        if (letra.equalsIgnoreCase("j"))  
            morse = ".---";  
        if (letra.equalsIgnoreCase("k"))  
            morse = "-.-";  
        if (letra.equalsIgnoreCase("l"))  
            morse = ".-..";  
        if (letra.equalsIgnoreCase("m"))  
            morse = "--";  
        if (letra.equalsIgnoreCase("n"))  
            morse = "-.";  
        if (letra.equalsIgnoreCase("o"))  
            morse = "---";  
        if (letra.equalsIgnoreCase("p"))  
            morse = ".--.";  
        if (letra.equalsIgnoreCase("q"))  
            morse = "--.-";  
        if (letra.equalsIgnoreCase("r"))  
            morse = ".-.";  
        if (letra.equalsIgnoreCase("s"))  
            morse = "...";  
        if (letra.equalsIgnoreCase("t"))  
            morse = "-";  
        if (letra.equalsIgnoreCase("u"))  
            morse = "..-";  
        if (letra.equalsIgnoreCase("v"))  
            morse = "...-";  
        if (letra.equalsIgnoreCase("w"))  
            morse = ".--";  
        if (letra.equalsIgnoreCase("x"))  
            morse = "-..-";  
        if (letra.equalsIgnoreCase("y"))  
            morse = "-.--";  
        if (letra.equalsIgnoreCase("z"))  
            morse = "--..";  
        if (letra.equalsIgnoreCase("0"))  
            morse = "-----";  
        if (letra.equalsIgnoreCase("1"))  
            morse = ".----";  
        if (letra.equalsIgnoreCase("2"))  
            morse = "..---";  
        if (letra.equalsIgnoreCase("3"))  
            morse = "...--";  
        if (letra.equalsIgnoreCase("4"))  
            morse = "....-";  
        if (letra.equalsIgnoreCase("5"))  
            morse = ".....";  
        if (letra.equalsIgnoreCase("6"))  
            morse = "-....";  
        if (letra.equalsIgnoreCase("7"))  
            morse = "--...";  
        if (letra.equalsIgnoreCase("8"))  
            morse = "---..";  
        if (letra.equalsIgnoreCase("9"))  
            morse = "----.";  
        if (letra.equalsIgnoreCase("."))  
            morse = ".-.-";  
        if (letra.equalsIgnoreCase(","))  
            morse = "--..--";  
        if (letra.equalsIgnoreCase("?"))  
            morse = "..--.."; 

        return morse;      
    }    
}
