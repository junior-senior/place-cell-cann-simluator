/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class UI2 extends javax.swing.JFrame {

    CANN CANN;
    public int position, environment, condition,n = 1;
    private int mouseX, mouseY;
    private int scale = 2;

    public UI2() {

        initComponents();
        CANN = new CANN(200, 200, 2);
        setVisible(true);
        setFocusable(true);
        jPanel2.add(CANN.imagePanel);
        jPanel3.add(CANN.environment.imagePanel);
        CANN.imageFrame.setVisible(false);
        CANN.environment.imageFrame.setVisible(false);
        jPanel3.addMouseListener(new BotMouseListener());
    }

    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        addKeyListener(new BotKeyListener());

        jLabel1.setText("Control Panel");

        jLabel2.setText("CANN");

        jLabel3.setText("Simulation");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Environment 1");
        jRadioButton1.setFocusable(false);
        jRadioButton1.setSelected(true);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Environment 2");
        jRadioButton2.setFocusable(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Environment 3");
        jRadioButton3.setFocusable(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Environment 4");
        jRadioButton4.setFocusable(false);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        
        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Position 1");
        jRadioButton5.setFocusable(false);
        jRadioButton5.setSelected(true);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("Position 3");
        jRadioButton6.setFocusable(false);
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setText("Position 2");
        jRadioButton7.setFocusable(false);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        
        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("Position 4");
        jRadioButton8.setFocusable(false);
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setText("Condition 1: Normal");
        jRadioButton9.setSelected(true);
        jRadioButton9.setFocusable(false);
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });
        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setText("Condition 2: Lights Off");
        jRadioButton10.setFocusable(false);
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });
        
        buttonGroup3.add(jRadioButton11);
        jRadioButton11.setText("Condition 3: LM Shift");
        jRadioButton11.setFocusable(false);
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });
        
        buttonGroup3.add(jRadioButton12);
        jRadioButton12.setText("Condition 4: LM Rotate");
        jRadioButton12.setFocusable(false);
        jRadioButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton12ActionPerformed(evt);
            }
        });
        
        jButton1.setText("Reset Vbot");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset CANN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.setText("Learn Environment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2)
                                .addComponent(jRadioButton3)
                                .addComponent(jRadioButton4)
                                .addComponent(jRadioButton5)
                                .addComponent(jRadioButton6)
                                .addComponent(jRadioButton7)
                                .addComponent(jRadioButton8)
                                .addComponent(jRadioButton9)
                                .addComponent(jRadioButton10)
                                .addComponent(jRadioButton11)
                                .addComponent(jRadioButton12)

                                .addComponent(jButton1)
                                .addComponent(jButton2)
                                .addComponent(jButton3))
                        
                        .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4)
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton8)                  
                        .addGap(34, 34, 34)
                        .addComponent(jRadioButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton12)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addContainerGap(135, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setText("Message Area");
        jButton1.setFocusable(false);
        jButton2.setFocusable(false);
        jButton3.setFocusable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane1)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel3)
                                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1)))
                        .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
    //Environment 1 button pressed
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int vbxo = CANN.environment.vbot.getxCoor();
        int vbyo = CANN.environment.vbot.getyCoor();
            CANN.environment.number = 1;
            CANN.environment.clearLandmarks();
            CANN.environment.initLandmarks();
            CANN.setCellMaxXY();
            CANN.environment.vbot.setxCoor(vbxo);
            CANN.environment.vbot.setyCoor(vbyo);
            CANN.environment.vBotandLandmarks();
            CANN.I=0;
            CANN.VbotAsInput();
        
//        CANN.environment.clearvBot();
//        CANN.environment.initvBot();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Environment 2 button pressed
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int vbxo = CANN.environment.vbot.getxCoor();
        int vbyo = CANN.environment.vbot.getyCoor();
            CANN.environment.number = 2;
            CANN.environment.clearLandmarks();
            CANN.environment.initLandmarks();
            CANN.setCellMaxXY();
            CANN.environment.vbot.setxCoor(vbxo);
            CANN.environment.vbot.setyCoor(vbyo);
            CANN.environment.vBotandLandmarks();
            CANN.I=0;
            CANN.VbotAsInput();
        
//        CANN.environment.clearvBot();
//        CANN.environment.initvBot();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Environment 3 button pressed
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int vbxo = CANN.environment.vbot.getxCoor();
        int vbyo = CANN.environment.vbot.getyCoor();
            CANN.environment.number = 3;
            CANN.environment.clearLandmarks();
            CANN.environment.initLandmarks();   
            CANN.environment.clearvBot();
            CANN.environment.initvBot();
            CANN.setCellMaxXY();
            CANN.environment.vbot.setxCoor(vbxo);
            CANN.environment.vbot.setyCoor(vbyo);
            CANN.environment.vBotandLandmarks();
            CANN.I=0;
            CANN.VbotAsInput();
        

//        CANN.environment.clearvBot();
//        CANN.environment.initvBot();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Environment 4 button pressed
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int vbxo = CANN.environment.vbot.getxCoor();
        int vbyo = CANN.environment.vbot.getyCoor();
            CANN.environment.number = 4;
            CANN.environment.clearLandmarks();
            CANN.environment.initLandmarks();
            CANN.environment.clearvBot();
            CANN.environment.initvBot();
            CANN.setCellMaxXY();
            CANN.environment.vbot.setxCoor(vbxo);
            CANN.environment.vbot.setyCoor(vbyo);
            CANN.environment.vBotandLandmarks();
            CANN.I=0;
            CANN.VbotAsInput();
//        CANN.environment.clearvBot();
//        CANN.environment.initvBot();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Position 1 button pressed
    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        CANN.environment.clearvBot();
        CANN.environment.position = 1;
        CANN.environment.initvBot();
        CANN.environment.vBotandLandmarks();
        CANN.VbotAsInput();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Position 2 button pressed
    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CANN.environment.clearvBot();
        CANN.environment.position = 2;
        CANN.environment.initvBot();
        CANN.environment.vBotandLandmarks();
        CANN.VbotAsInput();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Position 3 button pressed
    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CANN.environment.clearvBot();
        CANN.environment.position = 3;
        CANN.environment.initvBot();
        CANN.environment.vBotandLandmarks();
        CANN.VbotAsInput();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Position 4 button pressed
    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        CANN.environment.clearvBot();
        CANN.environment.position = 4;
        CANN.environment.initvBot();
        CANN.environment.vBotandLandmarks();
        CANN.VbotAsInput();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Condition 1 button pressed
    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //Normal Conditions
        int vbxo = CANN.environment.vbot.getxCoor();
        int vbyo = CANN.environment.vbot.getyCoor();
        CANN.setVision(true);
        CANN.environment.clearLandmarks();
        CANN.environment.initLandmarks();
        CANN.environment.clearvBot();
        CANN.environment.initvBot();
        CANN.environment.vbot.setxCoor(vbxo);
        CANN.environment.vbot.setyCoor(vbyo);
        CANN.setCellMaxXY();
        condition = 1;
        jTextArea1.append("\nVision is on.");
        CANN.setCellMaxXY();
        CANN.I = 0;
        CANN.environment.vBotandLandmarks();
        CANN.VbotAsInput();
//        jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//        jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//        jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + "\n");
    }
    //Condition 2 button pressed
    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:    
        CANN.setVision(false);
        jTextArea1.append("\nVision is off. ");
        //no visual input
    }
    //Condition 3 button pressed
    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        condition = 3;
        CANN.environment.clearLandmarks();
        CANN.environment.condition3Landmarks();
        CANN.setCellMaxXY();
        CANN.I = 0;
        CANN.environment.vBotandLandmarks();
        CANN.VbotAsInput();
        //Move environemnt by a small amount degrees
    }
    //Condition 4 button pressed
    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        condition = 4;
        CANN.environment.clearLandmarks();
        CANN.environment.condition4Landmarks();
        CANN.setCellMaxXY();
        CANN.I = 0;
        CANN.environment.vBotandLandmarks();
        CANN.VbotAsInput();
        //Rotate the environment by 90 degrees
    }
    //Reset Vbot button pressed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        CANN.environment.clearvBot();
        CANN.environment.initvBot();
    }
    //Reset CANN button pressed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        CANN.clearCells();
        CANN.initCells();
        CANN.initConnections();
        CANN.environment.vBotandLandmarks();
    }
    //'Learn Environment Pressed'
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        CANN.learn();
        jTextArea1.append(" \n Learning Phase Complete"); 
    }
    //Virtual Robot W,A,S,D movement method
    class BotKeyListener implements KeyListener {

        public void keyPressed(KeyEvent e) {
            try {
                int Klmc = 0;
                int h = CANN.environment.height;
                int w = CANN.environment.width;
                int x = CANN.environment.vbot.getxCoor();
                int y = CANN.environment.vbot.getyCoor();
                int ox = CANN.environment.vbot.getxCoor();
                int oy = CANN.environment.vbot.getyCoor();
                int keypressed = e.getKeyCode();
                switch (keypressed) {

                    case KeyEvent.VK_W:
                        if (y < 20) {
                            break;
                        }
                        CANN.environment.vbot.move(2);
                        break;
                    case KeyEvent.VK_A:
                        if (x < 31) {
                            break;
                        }
                        CANN.environment.vbot.move(3);
                        break;
                    case KeyEvent.VK_S:
                        if (y > 370) {
                            break;
                        }
                        CANN.environment.vbot.move(4);
                        break;
                    case KeyEvent.VK_D:
                        if (x > 370) {
                            break;
                        }
                        CANN.environment.vbot.move(1);
                        break;
                   case KeyEvent.VK_M:
                        n++;
                        BufferedImage bi = CANN.environment.scaledImage;
                        File outputfile = new File("Map save" + n + ".png");
                         ImageIO.write(bi, "png", outputfile);
                }
                int v = CANN.environment.vbot.getxCoor();
                int b = CANN.environment.vbot.getyCoor();
                for (int i = v - 16; i <= v + 16; i++) {
                    if (Klmc == 1) {
                        break;
                    }
                    for (int j = b - 11; j <= b + 11; j++) {
                        if (j > 0 && i > 0) {
                            if (CANN.environment.landmarkLocationArray[i][j] == 1) {
                                Klmc = 1;
                                break;
                            }
                        }

                    }
                }
                if (v > 370) {
                    v = 370;
                }
                if (b > 375) {
                    b = 375;
                }
                if (Klmc == 0) {
                    CANN.environment.clearvBot();
                    for (int i = v - 14; i <= v + 14; i++) {
                        for (int j = b - 9; j <= b + 9; j++) {
                            if (i >= v - 9 && i <= v + 9) {
                                CANN.environment.vBotLocationArray[i][j] = 1;
                            } else if (i >= v - 14 && i <= v + 14) {
                                CANN.environment.vBotLocationArray[i][j] = 2;
                            } else {
                                CANN.environment.vBotLocationArray[i][j] = 0;
                            }
                        }
                    }
                    if (CANN.vision == true) {
                        CANN.environment.vBotandLandmarks();
                    }

//                    jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//                    jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//                    jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//                    jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//                    jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + ((CANN.environment.totaltheta/4)*400) + "\n");
//                    jTextArea1.append("Total Distance: " + ((CANN.environment.lm1dxy2+CANN.environment.lm2dxy2+CANN.environment.lm3dxy2+CANN.environment.lm4dxy2)/4)*400 + "\n");
//                    jTextArea1.append("X: " + CANN.environment.vbot.getxCoor() + " Y: " + CANN.environment.vbot.getyCoor() + "\n");
                }
                if (Klmc == 1) {
                    CANN.environment.vbot.setxCoor(ox);
                    CANN.environment.vbot.setyCoor(oy);
                }

            } catch (ArrayIndexOutOfBoundsException exception) {

            } catch (IOException ex) {
                Logger.getLogger(UI2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void keyReleased(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {

        }
    }
    //Virtual Robot Mouse movement method
    class BotMouseListener implements MouseListener {

        public void mousePressed(MouseEvent event) {
            //when mouse is pressed, copy of array made, new connections found for new mouse location
            //Activation of nodes shifts with duration of mouse press, pressed for >1 second stay active at new mouse location
            //delay between mouse press and nodes changing
            ;

        }

        public void mouseReleased(MouseEvent event) {

        }

        public void mouseClicked(MouseEvent event) {
            int mx = event.getX();
            int my = event.getY();
            int ox = CANN.environment.vbot.getxCoor();
            int oy = CANN.environment.vbot.getyCoor();
            int lmc = 0;

            mouseX = event.getX();
            mouseY = event.getY();

            for (int mouseXc = mouseX - 6; mouseXc < mouseX + 6; mouseXc++) {
                if (mouseX % (6 * scale) == 0) {
                    break;
                }
                if (mouseXc % (6 * scale) == 0) {
                    mouseX = mouseXc;
                    break;
                }
            }
            for (int mouseYc = mouseY - 6; mouseYc < mouseY + 6; mouseYc++) {
                if (mouseY % (6 * scale) == 0) {
                    break;
                }
                if (mouseYc % (6 * scale) == 0) {
                    mouseY = mouseYc;
                    break;
                }
            }

            for (int i = mouseX - 25; i <= mouseX + 25; i++) {
                if (lmc == 1) {
                    break;
                }
                for (int j = mouseY - 25; j <= mouseY + 25; j++) {
                    if (j > 0 && i > 0 && i < 400 && j < 400) {
                        if (CANN.environment.landmarkLocationArray[i][j] == 1) {
                            lmc = 1;
                            break;
                        }
                    }

                }
            }
            if (lmc == 0) {
                CANN.environment.clearvBot();
                if (mx < 30) {
                    mouseX = 30;
                }
                if (mx > 370) {
                    mouseX = 370;
                }
                if (my < 20) {
                    mouseY = 20;
                }
                if (my > 370) {
                    mouseY = 370;
                }
                CANN.environment.vbot.setxCoor(mouseX);
                CANN.environment.vbot.setyCoor(mouseY);
                for (int i = mouseX - 14; i <= mouseX + 14; i++) {
                    for (int j = mouseY - 9; j <= mouseY + 9; j++) {
                        if (i > mouseX - 9 && i <= mouseX + 9) {
                            CANN.environment.vBotLocationArray[i][j] = 1;
                        } else if (i >= mouseX - 14 && i <= mouseX + 14) {
                            CANN.environment.vBotLocationArray[i][j] = 2;
                        } else {
                            CANN.environment.vBotLocationArray[i][j] = 0;
                        }
                    }
                }
                if (CANN.vision == true) {
                    CANN.environment.vBotandLandmarks();
                }
//                jTextArea1.append("Distance and angle to 1st landmark: " + CANN.environment.lm1dxy2 + " at " + CANN.environment.thetalm1dx + " radians" + "\n");
//                    jTextArea1.append("Distance and angle to 2nd landmark: " + CANN.environment.lm2dxy2 + " at " + CANN.environment.thetalm2dy + " radians" + "\n");
//                    jTextArea1.append("Distance and angle to 3rd landmark: " + CANN.environment.lm3dxy2 + " at " + CANN.environment.thetalm3dx + " radians" + "\n");
//                    jTextArea1.append("Distance and angle to 4th landmark: " + CANN.environment.lm4dxy2 + " at " + CANN.environment.thetalm4dy + " radians" + "\n" + "\n");
//                    jTextArea1.append("Total Theta: " + CANN.environment.totaltheta + "\n" + ((CANN.environment.totaltheta/4)*400) + "\n");
//                    jTextArea1.append("Total Distance: " + ((CANN.environment.lm1dxy2+CANN.environment.lm2dxy2+CANN.environment.lm3dxy2+CANN.environment.lm4dxy2)/4)*400  + "\n");
//                    jTextArea1.append("X: " + CANN.environment.vbot.getxCoor() + " Y: " + CANN.environment.vbot.getyCoor() + "\n");
                CANN.environment.updateGridImage();

            }
        }

        public void mouseEntered(MouseEvent event) {
            ;
        }

        public void mouseExited(MouseEvent event) {
            ;
        }
    }

    // Variables declaration - do not modify  
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
