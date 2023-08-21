/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author talis
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    double oldPontos1, oldPontos2;

    public FramePrincipal() {
 setTitle("Principal - Estrat. Social");
        initComponents();
        CreateFile();
        jSortear.setVisible(false);
        rEquipe1.setVisible(false);
        rEquipe2.setVisible(false);
        jpontos1.setVisible(false);
        jpontos2.setVisible(false);
        jrodada.setVisible(false);
        //    rEquipe2.setBackground(new Color(0, 0, 0, 0));
        //    rEquipe1.setBackground(new Color(0, 0, 0, 0));
        //  jSortear.setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException ex) {

                }
                titulo2.setText("Pergunta para:");
                jSortear.setVisible(true);
                rEquipe1.setVisible(true);
                rEquipe2.setVisible(true);
                jpontos1.setVisible(true);
                jpontos2.setVisible(true);
                titulo.setVisible(false);
                jrodada.setVisible(true);
            }
        }.start();
Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("d:\\7.png");//este caminho é onde está a figura que eu quero colocar na minha aplicação
        setIconImage(img);

    }
    boolean correto;

    RandomAccessFile p;

    private void CreateFile() {
        try {
            p = new RandomAccessFile("pontos.bk", "rw");
            Atualiza();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    private void Atualiza() throws IOException {
        p.seek(0);
        int rodada;
        double pontos1, pontos2;
        pontos1 = p.readDouble();
        pontos2 = p.readDouble();
        rodada = p.readInt();

        jpontos1.setText(String.valueOf(pontos1) + " pontos");
        jpontos2.setText(String.valueOf(pontos2) + " pontos");
        new Thread() {
            public void run() {
                for (int j = 0; j < 1; j++) {
                    if (oldPontos1 != pontos1) {
                        try {
                            Thread.sleep(500);
                            jpontos1.setVisible(false);

                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        jpontos1.setVisible(true);
                        try {
                            Thread.sleep(500);
                            jpontos1.setVisible(false);
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        jpontos1.setVisible(true);
                    }
                    if (oldPontos2 != pontos2) {
                        try {
                            Thread.sleep(500);
                            jpontos2.setVisible(false);
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        jpontos2.setVisible(true);
                        try {
                            Thread.sleep(500);
                            jpontos2.setVisible(false);
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                        }
                        jpontos2.setVisible(true);
                    }
                }
                oldPontos1 = pontos1;
                oldPontos2 = pontos2;
            }
        }.start();
        jrodada.setText("Rodada " + String.valueOf(rodada));
        if (rodada == 1) {
            jpontos1.setText("0 pontos");
            jpontos2.setText("0 pontos");
        }
        if (rodada == 7) {
            if (pontos1 > pontos2) {
                new FrameFinal("1", pontos1, pontos2).setVisible(true);
                dispose();
            } else if (pontos1 < pontos2) {
                new FrameFinal("2", pontos2, pontos1).setVisible(true);
                dispose();
            }
        }
        if (rodada == 9) {
            if (pontos1 > pontos2) {
                new FrameFinal("1", pontos1, pontos2).setVisible(true);
                dispose();
            } else if (pontos1 < pontos2) {
                new FrameFinal("2", pontos2, pontos1).setVisible(true);
                dispose();
            }
        }
        if (rodada == 11) {
            if (pontos1 > pontos2) {
                
                new FrameFinal("1", pontos1, pontos2).setVisible(true);
                dispose();
            } else if (pontos1 < pontos2) {
                new FrameFinal("2", pontos2, pontos1).setVisible(true);
                dispose();
            } else {
                new FrameFinal("", pontos2, pontos1).setVisible(true);
                dispose();

            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        rEquipe2 = new javax.swing.JRadioButton();
        rEquipe1 = new javax.swing.JRadioButton();
        jSortear = new javax.swing.JButton();
        jpontos1 = new javax.swing.JLabel();
        jpontos2 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jrodada = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rEquipe2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        rEquipe2.setForeground(new java.awt.Color(0, 204, 204));
        rEquipe2.setText(" Equipe 2  -");
        rEquipe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEquipe2ActionPerformed(evt);
            }
        });
        getContentPane().add(rEquipe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 230, 60));

        rEquipe1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        rEquipe1.setForeground(new java.awt.Color(0, 204, 204));
        rEquipe1.setText(" Equipe 1  -");
        rEquipe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEquipe1ActionPerformed(evt);
            }
        });
        getContentPane().add(rEquipe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 230, 60));

        jSortear.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jSortear.setForeground(new java.awt.Color(0, 204, 204));
        jSortear.setText("Sortear Pergunta");
        jSortear.setBorderPainted(false);
        jSortear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSortearActionPerformed(evt);
            }
        });
        getContentPane().add(jSortear, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 310, 90));

        jpontos1.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        jpontos1.setForeground(new java.awt.Color(255, 255, 255));
        jpontos1.setText("0");
        getContentPane().add(jpontos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 370, 40));

        jpontos2.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        jpontos2.setForeground(new java.awt.Color(255, 255, 255));
        jpontos2.setText("0");
        getContentPane().add(jpontos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 370, 40));

        titulo.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 204, 204));
        titulo.setText("Equipe 7");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 370, 50));

        jrodada.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jrodada.setForeground(new java.awt.Color(255, 255, 255));
        jrodada.setText("Rodada 1");
        getContentPane().add(jrodada, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 130, 40));

        titulo2.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        titulo2.setForeground(new java.awt.Color(255, 255, 255));
        titulo2.setText("Estratificação Social");
        getContentPane().add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 540, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Imagens/bg-1.jpg"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 470));

        pack();
    }

    private void jSortearActionPerformed(java.awt.event.ActionEvent evt) {
        if (rEquipe1.isSelected()) {
            new FramePergunta(1).setVisible(true);
        } else if (rEquipe2.isSelected()) {
            new FramePergunta(2).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necesário selecionar uma equipe");
        }

  
    }

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        try {
            Atualiza();        // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formFocusGained

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        try {
            Atualiza();        
        } catch (IOException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }  // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            Atualiza();        
        } catch (IOException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_formWindowGainedFocus

    private void rEquipe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEquipe1ActionPerformed
        rEquipe2.setSelected(false);
    }//GEN-LAST:event_rEquipe1ActionPerformed

    private void rEquipe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEquipe2ActionPerformed
        rEquipe1.setSelected(false);
    }//GEN-LAST:event_rEquipe2ActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jSortear;
    private javax.swing.JLabel jpontos1;
    private javax.swing.JLabel jpontos2;
    private javax.swing.JLabel jrodada;
    private javax.swing.JRadioButton rEquipe1;
    private javax.swing.JRadioButton rEquipe2;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo2;
    // End of variables declaration//GEN-END:variables
}
