/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author talis
 */
public class FramePergunta extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     *
     * @param f
     */
    public FramePergunta(int equipeNumber) {
        initComponents();
        setTitle("Pergunta - Estrat. Social");
        CreateFile();
        AtualizaPergunta();
        setLocationRelativeTo(null);
        Jnao.setVisible(false);
        jsim.setVisible(false);
        jparc.setVisible(false);
        jtexto.setVisible(false);
        jProgressBar.setVisible(false);
        equipe = equipeNumber;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("7.png");
        setIconImage(img);

    }

    RandomAccessFile pontosFile;
    boolean keepGoing = true;
    int equipe;
    int v1 = 1;
    int  i = 0, charPosition1 = 0, charPosition2 = 0;

    private void CreateFile() {
        try {
            pontosFile = new RandomAccessFile("pontos.bk", "rw");

        } catch (FileNotFoundException ex) {
ex.printStackTrace();        }

    }

    private void AtualizaPergunta() {
        int rodada;
        try {
            pontosFile.seek(16);
            rodada = pontosFile.readInt();
            if (rodada == 3) {
                Sorteio("Quais as possiveis causas da desigualdade social");
            }
            if (rodada == 6) {
                Sorteio("Quais os 2 tipos de estratificação social");
            }
            if (rodada == 2) {
                Sorteio("Após qual revolução mudou-se a forma que nos organizamos socialmente");
            }
            if (rodada == 10) {
                Sorteio("Em quais periodos se deu a classificação em estamentos");
            }
            if (rodada == 1) {
                Sorteio("Quais as duas teorias que tentam explicar o que é estratificação social");
            }
            if (rodada == 7) {
                Sorteio("Cite os nomes dos autores responsáveis por elaborar o materialismo didatico");
            }
            if (rodada == 9) {
                Sorteio("Como weber definia a luta de classes");
            }
            if (rodada == 4) {
                Sorteio("O que caracteriza a mobilidade vertical");
            }
            if (rodada == 5) {
                Sorteio("Como é dada a conservação da estratificação social");
            }
            if (rodada == 8) {
                Sorteio("Como eram divididas as hierarquias sociais segundo Weber");
            }

        } catch (IOException ex) {
        }
    }

    private void Sorteio(String pergunta) {
        String CHARACTERS = "0q9wey8uio7pçl6kj5hgf4dsa3zxc2vbn1m?";
        while (CHARACTERS.length() <= pergunta.length()) {
            CHARACTERS = CHARACTERS + CHARACTERS;
        }

        StringBuilder charactersBuilder = new StringBuilder(CHARACTERS);
        Random random = new Random();

        new Thread() {
            @Override
            public void run() {
                while (!String.valueOf(charactersBuilder).equals(pergunta) && keepGoing) {
                    if (charactersBuilder.length() > pergunta.length()) {
                        charactersBuilder.deleteCharAt(charactersBuilder.length() - 1);
                    }
                    charPosition1 = random.nextInt(charactersBuilder.length() - 1);
                    charPosition1 = charPosition1 > pergunta.length() - 1 ? (int) (charPosition1 / 2) : charPosition1;
                    charPosition2 = random.nextInt(pergunta.length() - 1);
                    if (charactersBuilder.charAt(charPosition1) != pergunta.charAt(charPosition1)) {
                        charactersBuilder.setCharAt(charPosition1, pergunta.charAt(charPosition2));
                    }
                    if (charPosition1 * 1.5 < pergunta.length()) {
                        charactersBuilder.setCharAt((int) (charPosition1 * 1.5),
                                pergunta.charAt((int) (charPosition1 * 1.5)));
                    }

                    jpergunta.setText(String.valueOf(charactersBuilder));
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                    }
                    i++;
                }

                jProgressBar.setVisible(true);
                for (int i = 0; i <= 100; i++) {
                    jProgressBar.setValue(i);
                    try {
                        Thread.sleep(350);
                    } catch (InterruptedException ex) {
                    }
                }
                Mostra();
            }
        }
                .start();
    }

    private void Mostra() {

        Jnao.setVisible(true);
        jsim.setVisible(true);
        jparc.setVisible(true);
        jtexto.setVisible(true);
        jProgressBar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtexto = new javax.swing.JLabel();
        jpergunta = new javax.swing.JLabel();
        jparc = new javax.swing.JButton();
        jsim = new javax.swing.JButton();
        Jnao = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();
        jback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtexto.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jtexto.setForeground(new java.awt.Color(0, 204, 204));
        jtexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtexto.setText("A resposta está correta?");
        jtexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtextoMousePressed(evt);
            }
        });
        getContentPane().add(jtexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 380, 40));

        jpergunta.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jpergunta.setForeground(new java.awt.Color(255, 255, 255));
        jpergunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jpergunta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jperguntaMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jperguntaMousePressed(evt);
            }
        });
        getContentPane().add(jpergunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 870, 50));

        jparc.setText("Parcialmente");
        jparc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jparcActionPerformed(evt);
            }
        });
        getContentPane().add(jparc, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 110, 40));

        jsim.setText("Sim");
        jsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsimActionPerformed(evt);
            }
        });
        getContentPane().add(jsim, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 110, 40));

        Jnao.setText("Não");
        Jnao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JnaoActionPerformed(evt);
            }
        });
        getContentPane().add(Jnao, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 110, 40));

        jProgressBar.setForeground(new java.awt.Color(0, 204, 204));
        jProgressBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBarMouseClicked(evt);
            }
        });
        getContentPane().add(jProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 650, -1));

        jback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1.jpg"))); // NOI18N
        jback.setText("   ");
        getContentPane().add(jback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsimActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jsimActionPerformed
        double pontuacaoAtual;

        try {
            if (equipe == 1) {
                pontosFile.seek(0);
                pontuacaoAtual = pontosFile.readDouble();
                pontosFile.seek(0);
                pontosFile.writeDouble(1 + pontuacaoAtual);
            } else {
                pontosFile.seek(0);
                pontosFile.readDouble();
                pontuacaoAtual = pontosFile.readDouble();
                pontosFile.seek(0);
                pontosFile.readDouble();
                pontosFile.writeDouble(pontuacaoAtual + 1);
            }
            pontosFile.seek(0);
            pontosFile.readDouble();
            pontosFile.readDouble();
            int rodada = pontosFile.readInt();
            pontosFile.seek(0);
            pontosFile.readDouble();
            pontosFile.readDouble();
            pontosFile.writeInt(rodada + 1);
        } catch (IOException ex) {
            Logger.getLogger(FramePergunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();// TODO add your handling code here:
    }// GEN-LAST:event_jsimActionPerformed

    private void jparcActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jparcActionPerformed
        double pontuacaoAtual;

        try {
            if (equipe == 1) {
                pontosFile.seek(0);
                pontuacaoAtual = pontosFile.readDouble();
                pontosFile.seek(0);
                pontosFile.writeDouble(0.5 + pontuacaoAtual);
            } else {
                pontosFile.seek(0);
                pontosFile.readDouble();
                pontuacaoAtual = pontosFile.readDouble();
                pontosFile.seek(0);
                pontosFile.readDouble();
                pontosFile.writeDouble(pontuacaoAtual + 0.5);
            }
            pontosFile.seek(0);
            pontosFile.readDouble();
            pontosFile.readDouble();
            int rodada = pontosFile.readInt();
            pontosFile.seek(0);
            pontosFile.readDouble();
            pontosFile.readDouble();
            pontosFile.writeInt(rodada + 1);
        } catch (IOException ex) {
            Logger.getLogger(FramePergunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();

    }// GEN-LAST:event_jparcActionPerformed

    private void JnaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_JnaoActionPerformed
        try {
            pontosFile.seek(16); //after two double (8 bytes) numbers
            int rodada = pontosFile.readInt();
            pontosFile.seek(16);
            pontosFile.writeInt(rodada + 1);
        } catch (IOException ex) {
            Logger.getLogger(FramePergunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }// GEN-LAST:event_JnaoActionPerformed

    private void jProgressBarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jProgressBarMouseClicked
        Mostra();
    }// GEN-LAST:event_jProgressBarMouseClicked

    private void jtextoMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jtextoMousePressed
        Mostra();
    }// GEN-LAST:event_jtextoMousePressed

    private void jperguntaMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jperguntaMousePressed
        keepGoing = false;
    }// GEN-LAST:event_jperguntaMousePressed

    private void jperguntaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jperguntaMouseClicked
        keepGoing = false;
    }// GEN-LAST:event_jperguntaMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FramePergunta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePergunta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePergunta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePergunta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FramePergunta(1).setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jnao;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JLabel jback;
    private javax.swing.JButton jparc;
    private javax.swing.JLabel jpergunta;
    private javax.swing.JButton jsim;
    private javax.swing.JLabel jtexto;
    // End of variables declaration//GEN-END:variables
}
