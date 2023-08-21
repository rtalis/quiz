/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author talis
 */
public class FrameFinal extends javax.swing.JFrame {

    /**
     * Creates new form FrameFinal
     *
     * @param s
     */
    public FrameFinal(String s, double b1, double b2) {
        initComponents();
        setTitle("Resultado - Estrat. Social");
        setLocationRelativeTo(null);
        if (s.equals("")) {
        texto = "Parabéns as duas equipes pelo empate";
        } else {
        texto = "Parabéns a equipe " + s + " pela vitória";
        }
        Escreve();
        
        jProgressBar1.setVisible(false);
        this.b1 = b1;
        this.b2 = b2;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("d:\\7.png");//este caminho é onde está a figura que eu quero colocar na minha aplicação
        setIconImage(img);

    }
    int modo = 1;
    String texto;
    double b1, b2;

    private void Escreve() {

        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    jtexto.setText(jtexto.getText() + texto.charAt(i));
                    if (i >= texto.length() - 1) {
                        break;
                    }
                    i = i + 1;
                    try {
                        Thread.sleep(180);
                    } catch (InterruptedException ex) {
                    }
                }
                if (modo == 1) {
                    try {
                        Thread.sleep(2000);
                        jplacar.setText(b1 + " à " + b2);
                        Thread.sleep(2000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(FrameFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jProgressBar1.setVisible(true);
                    for (i = 0; i <= 100; i++) {
                        jProgressBar1.setValue(i);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                        }
                    }
                    jtexto.setText("");
                    jplacar.setText("");
                    jProgressBar1.setVisible(false);
                    modo++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FrameFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                        texto = "Obrigado pela atenção!";

                    Escreve();

                } else if (modo == 2) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                    }
                    jplacar.setText("Equipe 7");
                    modo++;

                }
            }
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplacar = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jtexto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplacar.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jplacar.setForeground(new java.awt.Color(0, 204, 204));
        jplacar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jplacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 310, 80));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 310, -1));

        jtexto.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jtexto.setForeground(new java.awt.Color(255, 255, 255));
        jtexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jtexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 810, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrameFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameFinal("2", 1, 2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel jplacar;
    private javax.swing.JLabel jtexto;
    // End of variables declaration//GEN-END:variables

}
