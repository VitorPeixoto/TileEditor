/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editordetiles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Peixoto
 */
public class InterfaceGraficaPeixoto extends javax.swing.JFrame {
    private Image tileImage;
    private ArrayList<Label> labelsArray;
    private int labelIndex;
    private int selectedLabelIndex = -1;
    private String tilesFolder, imagesFolder, commonSaveFolder;
    private TilesLabel viewLabel;
    private ArrayList<String> lastDocuments;
    private DataReader dataReader;
    
    public InterfaceGraficaPeixoto() {
        initComponents();
        viewLabel = new TilesLabel(32, 32);
        jScrollPane2.setViewportView(viewLabel);
        lastDocuments = new ArrayList<>(10);        
        try {
            dataReader = DataReader.newDataReader();
            /*try {
            EditorData.read();
            } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
            lastDocuments.addAll(Arrays.asList(EditorData.getLastFiles()));
            } catch(NullPointerException ex) {
            for(int i = 0; i < EditorData.getLastFiles().length; i++)
            lastDocuments.add((EditorData.getLastFiles()[i] == null ? "" : EditorData.getLastFiles()[i]));
        }*/
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imagesFolder = dataReader.imagesFolder;
        tilesFolder = dataReader.tilesFolder;
        commonSaveFolder = dataReader.tilesFolder;
        
        configureTree();
        labelsArray = new ArrayList<>();
        
        useSelectedTileButton.setEnabled(false);
        
        for(int i = 0; i < 64; i++) {
            labelsArray.add(new Label(Property.WALKABLE_TILE));
            labelsArray.get(i).setBorder(BorderFactory.createSoftBevelBorder(0));
            labelIndex = i;
            labelsArray.get(i).addMouseListener(new MouseListener() {
                private final int thisIndex = labelIndex;
                @Override
                public void mouseClicked(MouseEvent e) {
                    try{
                        labelsArray.get(selectedLabelIndex).setBorder(BorderFactory.createSoftBevelBorder(0));
                    } catch(ArrayIndexOutOfBoundsException ex) {}
                    switch(labelsArray.get(thisIndex).getProperty()) {
                        case UPPER_TILE:
                            normalRadioButton.setSelected(false);
                            uppergroundRadioButton.setSelected(true);
                            wallRadioButton.setSelected(false);
                            break;
                        case WALKABLE_TILE:
                            normalRadioButton.setSelected(true);
                            uppergroundRadioButton.setSelected(false);
                            wallRadioButton.setSelected(false);
                            break;
                        case WALLED_TILE:
                            normalRadioButton.setSelected(false);
                            uppergroundRadioButton.setSelected(false);
                            wallRadioButton.setSelected(true);
                    }
                    selectedLabelIndex = thisIndex;
                    labelsArray.get(thisIndex).setBorder(BorderFactory.createSoftBevelBorder(1));                    
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    
                }
            });
            labelsPanel.add(labelsArray.get(i));
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

        wallRadioButton = new javax.swing.JRadioButton();
        uppergroundRadioButton = new javax.swing.JRadioButton();
        labelsPanel = new javax.swing.JPanel();
        normalRadioButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        commonsTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        useSelectedTileButton = new javax.swing.JButton();
        gridCheckBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        openTileMenu = new javax.swing.JMenu();
        openByTileMenuItem = new javax.swing.JMenuItem();
        openByPngMenuItem = new javax.swing.JMenuItem();
        saveTileMenuItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        undoMenuItem = new javax.swing.JMenuItem();
        redoMenuItem = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        changePngsDirMenuItem = new javax.swing.JMenuItem();
        changeTilesDirMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        wallRadioButton.setText("Wall");
        wallRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallRadioButtonActionPerformed(evt);
            }
        });

        uppergroundRadioButton.setText("Upperground");
        uppergroundRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uppergroundRadioButtonActionPerformed(evt);
            }
        });

        labelsPanel.setLayout(null);
        labelsPanel.setLayout(new java.awt.GridLayout(8, 8, 3, 3));

        normalRadioButton.setText("Normal");
        normalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        commonsTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        commonsTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commonsTreeMouseClicked(evt);
            }
        });
        commonsTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                commonsTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(commonsTree);

        useSelectedTileButton.setText("Use selected tile");
        useSelectedTileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useSelectedTileButtonActionPerformed(evt);
            }
        });

        gridCheckBox.setText("Grid");
        gridCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridCheckBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Wall all");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Upper all");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Normal all");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        FileMenu.setText("File");

        openTileMenu.setText("Open Tile");

        openByTileMenuItem.setText("Open by tile");
        openByTileMenuItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                openByTileMenuItemItemStateChanged(evt);
            }
        });
        openByTileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openByTileMenuItemActionPerformed(evt);
            }
        });
        openTileMenu.add(openByTileMenuItem);

        openByPngMenuItem.setText("Open by png");
        openByPngMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openByPngMenuItemActionPerformed(evt);
            }
        });
        openTileMenu.add(openByPngMenuItem);

        FileMenu.add(openTileMenu);

        saveTileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveTileMenuItem.setText("Save Tile");
        saveTileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTileMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveTileMenuItem);

        MenuBar.add(FileMenu);

        EditMenu.setText("Edit");

        undoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoMenuItem.setText("Undo");
        EditMenu.add(undoMenuItem);

        redoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoMenuItem.setText("Redo");
        EditMenu.add(redoMenuItem);

        MenuBar.add(EditMenu);

        optionsMenu.setText("Options");

        changePngsDirMenuItem.setText("Change PNGs Dir");
        changePngsDirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePngsDirMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(changePngsDirMenuItem);

        changeTilesDirMenuItem.setText("Change Tiles Dir");
        optionsMenu.add(changeTilesDirMenuItem);

        MenuBar.add(optionsMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(gridCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(useSelectedTileButton)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wallRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uppergroundRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(normalRadioButton)
                        .addGap(411, 411, 411))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(labelsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(wallRadioButton)
                                .addComponent(uppergroundRadioButton)
                                .addComponent(normalRadioButton)
                                .addComponent(useSelectedTileButton))
                            .addComponent(gridCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(69, 69, 69))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openByTileMenuItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_openByTileMenuItemItemStateChanged
    }//GEN-LAST:event_openByTileMenuItemItemStateChanged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        labelsArray.get(selectedLabelIndex).setBorder(BorderFactory.createSoftBevelBorder(0));
        selectedLabelIndex = -1;
        normalRadioButton.setSelected(true);
        uppergroundRadioButton.setSelected(false);
        wallRadioButton.setSelected(false);
    }//GEN-LAST:event_formMouseClicked

    private void openByPngMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openByPngMenuItemActionPerformed
        JFileChooser JFC = new JFileChooser();
            JFC.setFileFilter(new FileNameExtensionFilter("Png archives (*.png)", "png"));
            JFC.setCurrentDirectory(new File(imagesFolder));
            JFC.setControlButtonsAreShown(false);
            JFC.setBounds(0, 0, 500, 200);        
            JOptionPane.showMessageDialog(this, JFC);

            boolean ready = false;

            while(!ready) {
                if(JFC.getSelectedFile() != null) {                    
                    ready = true;
                    cleanProperties();
                    try {
                        tileImage = ImageIO.read(JFC.getSelectedFile());
                    } catch (IOException ex) {
                        Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setTilesImage();
                }
                if(JFC.isVisible()) break;
            }            
    }//GEN-LAST:event_openByPngMenuItemActionPerformed

    private void openByTileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openByTileMenuItemActionPerformed
            JFileChooser JFC = new JFileChooser();
            JFC.setFileFilter(new FileNameExtensionFilter("Tile archives (*.tile)", "tile"));
            JFC.setCurrentDirectory(new File(tilesFolder));
            JFC.setControlButtonsAreShown(false);
            JFC.setBounds(0, 0, 500, 200);        
            JOptionPane.showMessageDialog(this, JFC);

            boolean ready = false;

            while(!ready) {
                if(JFC.getSelectedFile() != null) {
                    Tile t = readObject(JFC.getSelectedFile());
                    ready = true;
                    cleanProperties();
                    tileImage = t.getTileImage().getImage();
                    for(int i = 0; i < labelsArray.size(); i++) {
                        labelsArray.get(i).setProperty(t.getTileProperty()[i]);
                    }
                    setTilesImage();
                }
                if(JFC.isVisible()) break;
            }
    }//GEN-LAST:event_openByTileMenuItemActionPerformed

    private void wallRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallRadioButtonActionPerformed
      if(wallRadioButton.isSelected()) {
          uppergroundRadioButton.setSelected(false);  
          normalRadioButton.setSelected(false);
          labelsArray.get(selectedLabelIndex).setProperty(Property.WALLED_TILE);            
          labelsArray.get(selectedLabelIndex).repaint();            
      }
      else {
          normalRadioButton.setSelected(true);
          labelsArray.get(selectedLabelIndex).setProperty(Property.WALKABLE_TILE);            
          labelsArray.get(selectedLabelIndex).repaint();            
      }
    }//GEN-LAST:event_wallRadioButtonActionPerformed

    private void uppergroundRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uppergroundRadioButtonActionPerformed
      if(uppergroundRadioButton.isSelected()) {
          wallRadioButton.setSelected(false);  
          normalRadioButton.setSelected(false);
          labelsArray.get(selectedLabelIndex).setProperty(Property.UPPER_TILE);            
          labelsArray.get(selectedLabelIndex).repaint();            
      }
      else {
          normalRadioButton.setSelected(true);
          labelsArray.get(selectedLabelIndex).setProperty(Property.WALKABLE_TILE);            
          labelsArray.get(selectedLabelIndex).repaint();            
      }
    }//GEN-LAST:event_uppergroundRadioButtonActionPerformed

    private void saveTileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTileMenuItemActionPerformed
        Property propertyVet[] = new Property[64];
        for(int i = 0; i < 64; i++) {
            propertyVet[i] = labelsArray.get(i).getProperty();
        }
        Tile t = new Tile(new ImageIcon(tileImage), 32, 32, propertyVet);
        
        JFileChooser JFC = new JFileChooser();
            JFC.setFileFilter(new FileNameExtensionFilter("Tile archives (*.tile)", "tile"));
            JFC.setControlButtonsAreShown(false);
            JFC.setBounds(0, 0, 500, 200);        
            JFC.setCurrentDirectory(new File(commonSaveFolder));
            JOptionPane.showMessageDialog(this, JFC);

            boolean ready = false;
            
            while(!ready) {
                if(JFC.getSelectedFile() != null) {
                    FileOutputStream file = null;
                    try {
                        JFC.getSelectedFile().createNewFile();
                        file = new FileOutputStream(JFC.getSelectedFile());
                        ObjectOutputStream oos = new ObjectOutputStream(file);
                        oos.writeObject(t);
                        oos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            treeNode2.add(new javax.swing.tree.DefaultMutableTreeNode(JFC.getSelectedFile().getName()));
                            commonsTree.updateUI();
                            file.close();                            
                        } catch (IOException ex) {
                            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if(JFC.isVisible()) break;
            }            
    }//GEN-LAST:event_saveTileMenuItemActionPerformed

    private void normalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalRadioButtonActionPerformed
        if(normalRadioButton.isSelected()) {
          wallRadioButton.setSelected(false);  
          uppergroundRadioButton.setSelected(false);
          labelsArray.get(selectedLabelIndex).setProperty(Property.WALKABLE_TILE);            
          labelsArray.get(selectedLabelIndex).repaint();            
      }
      else {
          normalRadioButton.setSelected(true);
      }
    }//GEN-LAST:event_normalRadioButtonActionPerformed

    private void commonsTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_commonsTreeValueChanged
        if(commonsTree.getSelectionPath().getPathComponent(commonsTree.getSelectionPath().getPathCount()-2).toString().equals("Tiles")) {            
            if(tilesFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString()).contains(".tile")) {
                Tile t = readObject(new File(tilesFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString())));
                //cleanProperties();
                //tileImage = t.getTileImage().getImage();
                viewLabel.setIcon(new ImageIcon(t.getTileImage().getImage()));
                useSelectedTileButton.setEnabled(true);
                /*for(int i = 0; i < labelsArray.size(); i++) {
                    labelsArray.get(i).setProperty(t.getTileProperty()[i]);
                }
                setTilesImage();    */
            }                
        }
        else if(commonsTree.getSelectionPath().getPathComponent(commonsTree.getSelectionPath().getPathCount()-2).toString().equals("PNGs")) {            
            if(imagesFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString()).contains(".png")) {
                //cleanProperties();
                //tileImage = (new ImageIcon((pngsFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString())))).getImage();                
                //setTilesImage();                                
                viewLabel.setIcon(new ImageIcon((imagesFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString()))));
                useSelectedTileButton.setEnabled(true);
            }                
        }
    }//GEN-LAST:event_commonsTreeValueChanged

    private void commonsTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commonsTreeMouseClicked
    }//GEN-LAST:event_commonsTreeMouseClicked

    private void useSelectedTileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useSelectedTileButtonActionPerformed
        if(commonsTree.getSelectionPath().getPathComponent(commonsTree.getSelectionPath().getPathCount()-2).toString().equals("Tiles")) {            
            if(tilesFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString()).contains(".tile")) {
                Tile t = readObject(new File(tilesFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString())));
                cleanProperties();
                tileImage = viewLabel.getTileIcon().getImage();
                for(int i = 0; i < labelsArray.size(); i++) {
                    labelsArray.get(i).setProperty(t.getTileProperty()[i]);
                }
                setTilesImage();
                viewLabel.setIcon(null);
                useSelectedTileButton.setEnabled(false);                
            }                
        }
        else if(commonsTree.getSelectionPath().getPathComponent(commonsTree.getSelectionPath().getPathCount()-2).toString().equals("PNGs")) {            
            if(imagesFolder.concat(commonsTree.getSelectionPath().getLastPathComponent().toString()).contains(".png")) {
                cleanProperties();
                tileImage = viewLabel.getTileIcon().getImage();
                setTilesImage();                                
                viewLabel.setIcon(null);
                useSelectedTileButton.setEnabled(false);
            }                
        }
    }//GEN-LAST:event_useSelectedTileButtonActionPerformed

    private void gridCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridCheckBoxActionPerformed
        viewLabel.setGrid(gridCheckBox.isSelected());
    }//GEN-LAST:event_gridCheckBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(int i = 0; i < labelsArray.size(); i++) {
            labelsArray.get(i).setProperty(Property.WALLED_TILE);
            labelsArray.get(i).repaint();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for(int i = 0; i < labelsArray.size(); i++) {
            labelsArray.get(i).setProperty(Property.UPPER_TILE);
            labelsArray.get(i).repaint();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       for(int i = 0; i < labelsArray.size(); i++) {
            labelsArray.get(i).setProperty(Property.WALKABLE_TILE);
            labelsArray.get(i).repaint();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void changePngsDirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePngsDirMenuItemActionPerformed
        JFileChooser JFC = new JFileChooser();
            JFC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            JFC.setControlButtonsAreShown(false);
            JFC.setBounds(0, 0, 500, 200);        
            JOptionPane.showMessageDialog(this, JFC);

            boolean ready = false;            
            
            while(!ready) {
                if(JFC.getSelectedFile() != null) {
                        commonSaveFolder = JFC.getSelectedFile().getPath();
                        //EditorData.setCommonSaveDir(commonSaveFolder);
                        /*try {
                        EditorData.write();
                        } catch (NotInitiatedYetException | IOException ex) {
                            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
                    }
                if(JFC.isVisible()) break;
            }
    }//GEN-LAST:event_changePngsDirMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new InterfaceGraficaPeixoto().setVisible(true);
                JFileChooser JFC = new JFileChooser();
            }
        });
    }
    
    private void cleanProperties() {
        for(int i = 0; i < labelsArray.size(); i++) {
            labelsArray.get(i).setProperty(Property.WALKABLE_TILE);
        }
    }
    
    private void setTilesImage() {
        BufferedImage buffImage;
        try {
            buffImage = (BufferedImage) tileImage;
        } catch(ClassCastException ex) {
            buffImage = new BufferedImage(tileImage.getWidth(null), tileImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = buffImage.createGraphics();
            g.drawImage(tileImage, 0, 0, null);
        }       
        
        int x = 0, y = 0;
        for(int i = 0; i < 64; i++) {
            labelsArray.get(i).setIcon(resizeImage(new ImageIcon((buffImage.getSubimage(x, y, 4, 4))), 32, 32));
            x += 4;
            if(x >= 32) {
                x = 0; 
                y += 4;
            }
        }
    }
    
    public void configureTree() {
        File pngsdir = new File(imagesFolder);
        File tilesdir = new File(tilesFolder);
        
        try {
            treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Commons");
            treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("PNGs");
            for (File listFile : pngsdir.listFiles()) {
                treeNode2.add(new javax.swing.tree.DefaultMutableTreeNode(listFile.getName()));
            }        
            treeNode1.add(treeNode2);
            
            treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tiles");
            for (File listFile : tilesdir.listFiles()) {
                treeNode2.add(new javax.swing.tree.DefaultMutableTreeNode(listFile.getName()));
            }        
            treeNode1.add(treeNode2);
            commonsTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        } catch(NullPointerException ex) {}
    }

    public ImageIcon resizeImage(ImageIcon toResize, int width, int height) {
        Image image = toResize.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    
    private Tile readObject(File tileFile) {
        Tile toReturn = null;
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(tileFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObjectInputStream  ois = null;
        try {
            ois = new ObjectInputStream(fileIn);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            toReturn = Tile.class.cast(ois.readObject());
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfaceGraficaPeixoto.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return toReturn;
    }
    javax.swing.tree.DefaultMutableTreeNode treeNode1;
    javax.swing.tree.DefaultMutableTreeNode treeNode2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem changePngsDirMenuItem;
    private javax.swing.JMenuItem changeTilesDirMenuItem;
    private javax.swing.JTree commonsTree;
    private javax.swing.JCheckBox gridCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel labelsPanel;
    private javax.swing.JRadioButton normalRadioButton;
    private javax.swing.JMenuItem openByPngMenuItem;
    private javax.swing.JMenuItem openByTileMenuItem;
    private javax.swing.JMenu openTileMenu;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenuItem redoMenuItem;
    private javax.swing.JMenuItem saveTileMenuItem;
    private javax.swing.JMenuItem undoMenuItem;
    private javax.swing.JRadioButton uppergroundRadioButton;
    private javax.swing.JButton useSelectedTileButton;
    private javax.swing.JRadioButton wallRadioButton;
    // End of variables declaration//GEN-END:variables
}
