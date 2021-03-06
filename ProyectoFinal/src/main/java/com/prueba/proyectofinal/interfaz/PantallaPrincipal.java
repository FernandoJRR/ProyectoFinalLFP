/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.proyectofinal.interfaz;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.prueba.proyectofinal.analizadorLexico.Token;
import com.prueba.proyectofinal.analizadorSintactico.Arbol;
import com.prueba.proyectofinal.analizadorSintactico.AutomataPila;
import com.prueba.proyectofinal.analizadorSintactico.ParsingException;
import com.prueba.proyectofinal.interprete.LoopBoundInvalidoException;
import com.prueba.proyectofinal.interprete.SimboloNoEncontradoException;
import com.prueba.proyectofinal.modeloAnalisis.ModelAnalizador;

/**
 *
 * @author fernanrod
 */
public class PantallaPrincipal extends javax.swing.JFrame {

        javax.swing.undo.UndoManager undoManager;
	/**
	 * Creates new form PantallaPrincipal
	 */
	public PantallaPrincipal() {
                undoManager = new javax.swing.undo.UndoManager();
                undoManager.setLimit(10);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jSpinner1 = new javax.swing.JSpinner();
                jPanel1 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                editorTextArea = new javax.swing.JTextArea();
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                consolaTextPane = new javax.swing.JTextPane();
                barraMenuBar = new javax.swing.JMenuBar();
                jMenu1 = new javax.swing.JMenu();
                abrirMenuItem = new javax.swing.JMenuItem();
                jMenuItem6 = new javax.swing.JMenuItem();
                guardarMenuItem = new javax.swing.JMenuItem();
                guardarComoMenuItem = new javax.swing.JMenuItem();
                acercaDeMenuItem = new javax.swing.JMenuItem();
                jMenu2 = new javax.swing.JMenu();
                jMenuItem1 = new javax.swing.JMenuItem();
                jMenuItem2 = new javax.swing.JMenuItem();
                deshacerMenuItem = new javax.swing.JMenuItem();
                rehacerMenuItem = new javax.swing.JMenuItem();
                jMenu3 = new javax.swing.JMenu();
                analisisLexicoMenuItem = new javax.swing.JMenuItem();
                analisisSintacticoMenuItem = new javax.swing.JMenuItem();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                editorTextArea.setColumns(20);
                editorTextArea.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
                editorTextArea.setRows(5);
                editorTextArea.setTabSize(4);
                editorTextArea.addCaretListener(new javax.swing.event.CaretListener() {
                        public void caretUpdate(javax.swing.event.CaretEvent evt) {
                                editorTextAreaCaretUpdate(evt);
                        }
                });
                jScrollPane3.setViewportView(editorTextArea);
                TextLineNumber textLineNumber = new TextLineNumber(editorTextArea);
                jScrollPane3.setRowHeaderView( textLineNumber );

                editorTextArea.getDocument().addUndoableEditListener(
                        new javax.swing.event.UndoableEditListener() {
                                public void undoableEditHappened(javax.swing.event.UndoableEditEvent e) {
                                        undoManager.addEdit(e.getEdit());
                                }
                        }
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                );

                jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                jLabel1.setText("Consola");

                consolaTextPane.setEditable(false);
                consolaTextPane.setBackground(java.awt.Color.darkGray);
                jScrollPane1.setViewportView(consolaTextPane);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(926, Short.MAX_VALUE))
                        .addComponent(jScrollPane1)
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                );

                jMenu1.setText("Archivo");

                abrirMenuItem.setText("Abrir");
                abrirMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                abrirMenuItemActionPerformed(evt);
                        }
                });
                jMenu1.add(abrirMenuItem);

                jMenuItem6.setText("Nuevo");
                jMenu1.add(jMenuItem6);

                guardarMenuItem.setText("Guardar");
                guardarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                guardarMenuItemActionPerformed(evt);
                        }
                });
                jMenu1.add(guardarMenuItem);

                guardarComoMenuItem.setText("Guardar como...");
                guardarComoMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                guardarComoMenuItemActionPerformed(evt);
                        }
                });
                jMenu1.add(guardarComoMenuItem);

                acercaDeMenuItem.setText("Acerca De...");
                acercaDeMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                acercaDeMenuItemActionPerformed(evt);
                        }
                });
                jMenu1.add(acercaDeMenuItem);

                barraMenuBar.add(jMenu1);

                jMenu2.setText("Editar");

                jMenuItem1.setText("Copiar");
                jMenu2.add(jMenuItem1);

                jMenuItem2.setText("Pegar");
                jMenu2.add(jMenuItem2);

                deshacerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
                deshacerMenuItem.setText("Deshacer");
                deshacerMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                deshacerMenuItemActionPerformed(evt);
                        }
                });
                jMenu2.add(deshacerMenuItem);

                rehacerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
                rehacerMenuItem.setText("Rehacer");
                rehacerMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rehacerMenuItemActionPerformed(evt);
                        }
                });
                jMenu2.add(rehacerMenuItem);

                barraMenuBar.add(jMenu2);

                jMenu3.setText("Analisis");

                analisisLexicoMenuItem.setText("Iniciar Analisis Lexico");
                analisisLexicoMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                analisisLexicoMenuItemActionPerformed(evt);
                        }
                });
                jMenu3.add(analisisLexicoMenuItem);

                analisisSintacticoMenuItem.setText("Iniciar Analisis Sintactico e Interpretar");
                analisisSintacticoMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                analisisSintacticoMenuItemActionPerformed(evt);
                        }
                });
                jMenu3.add(analisisSintacticoMenuItem);

                barraMenuBar.add(jMenu3);

                setJMenuBar(barraMenuBar);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void analisisLexicoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analisisLexicoMenuItemActionPerformed
                //Se limpia la consola
                consolaTextPane.setText("");
                //Se ajusta el tama??o del tab
                ModelAnalizador.setSizeTabulador(editorTextArea.getTabSize());
                //Se indica el inicio del analisis
                appendAPane(consolaTextPane, "-------------------- Iniciando Analisis Lexico --------------------\n\n", java.awt.Color.YELLOW);
                //Se envia el texto al tokenizador
                ModelAnalizador.tokenizar(editorTextArea.getText());
                if (ModelAnalizador.getErroresLexicos()) {
                        ModelAnalizador.setAnalisisLexicoRealizado(false);
                        appendAPane(consolaTextPane, "----------------- Errores Lexicos Detectados -----------------\n\n", java.awt.Color.RED);
                        divisor();
                        appendAPane(consolaTextPane, "| Tipo de Token || Lexema || Posicion (Fila:Columna) |\n", java.awt.Color.LIGHT_GRAY);
                        divisor();
                        divisor();
                        for (Token token : ModelAnalizador.getTokensError()) {
                                appendAPane(consolaTextPane, "| "+token.tipoToken()+"  ||  "+token.lexema()+"  ||  "+token.posicion()[0]+":"+token.posicion()[1]+" |\n", java.awt.Color.LIGHT_GRAY);
                                divisor();
                        }
                } else {
                        appendAPane(consolaTextPane, "------------------------- Tokens Obtenidos ------------------------\n\n", java.awt.Color.GREEN);
                        divisor();
                        appendAPane(consolaTextPane, "| Tipo de Token || Lexema || Posicion (Fila:Columna) |\n", java.awt.Color.LIGHT_GRAY);
                        divisor();
                        divisor();
                        for (Token token : ModelAnalizador.getTokens()) {
                                appendAPane(consolaTextPane, "| "+token.tipoToken()+"  ||  "+token.lexema()+"  ||  "+token.posicion()[0]+":"+token.posicion()[1]+"\n", java.awt.Color.LIGHT_GRAY);
                                divisor();
                        }
                        ModelAnalizador.setAnalisisLexicoRealizado(true);
                }
        }//GEN-LAST:event_analisisLexicoMenuItemActionPerformed

        private void deshacerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerMenuItemActionPerformed
                try {
                        undoManager.undo();
                } catch (CannotUndoException e) {}
        }//GEN-LAST:event_deshacerMenuItemActionPerformed

        private void rehacerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rehacerMenuItemActionPerformed
                try {
                        undoManager.redo();
                } catch (CannotRedoException e) {}
                
        }//GEN-LAST:event_rehacerMenuItemActionPerformed

        private void analisisSintacticoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analisisSintacticoMenuItemActionPerformed
                if (ModelAnalizador.getAnalisisLexicoRealizado() && !ModelAnalizador.getErroresLexicos()) {
                        appendAPane(consolaTextPane, "-------------------- Iniciando Analisis Sintactico --------------------\n\n", java.awt.Color.YELLOW);
                        ArrayList<String> arbolTexto = ModelAnalizador.parse();
                        if (arbolTexto.get(arbolTexto.size()-1).equals("")) {
                                for (int i = 0; i < arbolTexto.size()-2; i++) {
                                        appendAPane(consolaTextPane, arbolTexto.get(i)+"\n", java.awt.Color.LIGHT_GRAY);
                                }
                                appendAPane(consolaTextPane, arbolTexto.get(arbolTexto.size()-2), java.awt.Color.RED);
                        } else {
                                for (String nodo : arbolTexto) {
                                        appendAPane(consolaTextPane, nodo+"\n", java.awt.Color.LIGHT_GRAY);
                                }
                                appendAPane(consolaTextPane, "----------------------- Arbol Sintactico Generado ----------------------\n\n", java.awt.Color.GREEN);
                                appendAPane(consolaTextPane, "-------------------- Analisis Sintactico Completado --------------------\n\n", java.awt.Color.GREEN);
                                try {
                                        appendAPane(consolaTextPane, "----------------------- Elige un path para guardar el output ----------------------\n\n", java.awt.Color.YELLOW);
                                        
                                        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
                                        fileChooser.setCurrentDirectory(new java.io.File("."));
                                        fileChooser.setApproveButtonText("Guardar");
                                        fileChooser.setDialogTitle("Guardar Output");
                                        //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                        //
                                        // disable the "All files" option.
                                        //
                                        fileChooser.setAcceptAllFileFilterUsed(false);
                                        //    
                                        if (fileChooser.showOpenDialog(this) != javax.swing.JFileChooser.APPROVE_OPTION) { 
                                                System.out.println("No Selection ");
                                        }
                                        String path = fileChooser.getSelectedFile().toString();
                                        System.out.println(path);

                                        //fDialog.setVisible(true);

                                        appendAPane(consolaTextPane, "----------------------- Realizando Interpretacion ----------------------\n\n", java.awt.Color.YELLOW);
                                        
                                        ModelAnalizador.interpretar();

                                        ModelAnalizador.guardarOutputInterprete(path);

                                        appendAPane(consolaTextPane, "----------------------- Interpretacion Realizada ----------------------\n\n", java.awt.Color.GREEN);
                                        appendAPane(consolaTextPane, "Puedes revisar el output en "+path, java.awt.Color.GREEN);

                                } catch (IOException e) {
                                        appendAPane(consolaTextPane, "Error, no se ha podido guardar el archivo", java.awt.Color.RED);
                                } catch (SimboloNoEncontradoException e) {
                                        appendAPane(consolaTextPane, e.getMessage(), java.awt.Color.RED);
                                } catch (LoopBoundInvalidoException e) {
                                        appendAPane(consolaTextPane, "Error, un ciclo no puede tener una cantidad de repeticiones menor o igual a 0", java.awt.Color.RED);
                                }
                        }
                } else {
                        appendAPane(consolaTextPane, "Debes realizar el analisis lexico antes del analizador sintactico siempre que se cambie el programa o haya errores!", java.awt.Color.ORANGE);
                }
        }//GEN-LAST:event_analisisSintacticoMenuItemActionPerformed

        private void editorTextAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editorTextAreaCaretUpdate
                //Se obliga al usuario a realizar un nuevo analisis lexico
                ModelAnalizador.setAnalisisLexicoRealizado(false);
                ModelAnalizador.setCambioTexto(true);
        }//GEN-LAST:event_editorTextAreaCaretUpdate

        private void guardarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMenuItemActionPerformed
                try {
                        ModelAnalizador.guardar(editorTextArea.getText());
                } catch (IOException e) {
                        appendAPane(consolaTextPane, "Error, no se ha podido guardar el archivo", java.awt.Color.RED);
                }
        }//GEN-LAST:event_guardarMenuItemActionPerformed

        private void abrirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirMenuItemActionPerformed
                javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
                fileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(this);
                if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
                        java.io.File selectedFile = fileChooser.getSelectedFile();
                        try {
                                ArrayList<String> lineasPrograma = ModelAnalizador.abrir(selectedFile);
                                editorTextArea.setText("");
                                consolaTextPane.setText("");
                                for (String linea : lineasPrograma) {
                                        editorTextArea.append(linea+"\n");
                                }
                        } catch (IOException e) {
                                appendAPane(consolaTextPane, "Error, no se ha podido abrir el archivo", java.awt.Color.RED);
                        }
                }
        }//GEN-LAST:event_abrirMenuItemActionPerformed

        private void guardarComoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoMenuItemActionPerformed
                java.awt.FileDialog fDialog = new java.awt.FileDialog(this, "Save", java.awt.FileDialog.SAVE);
                String path = fDialog.getDirectory()+fDialog.getFile();
                fDialog.setVisible(true);
                try {
                        ModelAnalizador.guardarComo(editorTextArea.getText(), path);
                } catch (IOException e) {
                        appendAPane(consolaTextPane, "Error, no se ha podido guardar el archivo", java.awt.Color.RED);
                }
        }//GEN-LAST:event_guardarComoMenuItemActionPerformed

        private void acercaDeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeMenuItemActionPerformed
                javax.swing.JOptionPane.showMessageDialog(null, "Programa de Analisis\n"+
                                                    "Creado por Fernando Rodriguez 202030542");
        }//GEN-LAST:event_acercaDeMenuItemActionPerformed

        private void appendAPane(javax.swing.JTextPane textPane, String string, java.awt.Color color) {
                //Se habilita la edicion del panel para cambiar el texto
                consolaTextPane.setEditable(true);
                javax.swing.text.StyleContext sc = javax.swing.text.StyleContext.getDefaultStyleContext();
                javax.swing.text.AttributeSet aset = sc.addAttribute(javax.swing.text.SimpleAttributeSet.EMPTY, javax.swing.text.StyleConstants.Foreground, color);

                int len = textPane.getDocument().getLength();
                textPane.setCaretPosition(len);
                textPane.setCharacterAttributes(aset, false);
                textPane.replaceSelection(string);

                //Se deshabilita la edicion del panel para evitar que el usuario la edite
                consolaTextPane.setEditable(false);
        }
        
        private void divisor() {
                appendAPane(consolaTextPane, "+------------------------------------------------------------------------------+\n", java.awt.Color.LIGHT_GRAY);
        }
        
        private void guardarComo() {

        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenuItem abrirMenuItem;
        private javax.swing.JMenuItem acercaDeMenuItem;
        private javax.swing.JMenuItem analisisLexicoMenuItem;
        private javax.swing.JMenuItem analisisSintacticoMenuItem;
        private javax.swing.JMenuBar barraMenuBar;
        private javax.swing.JTextPane consolaTextPane;
        private javax.swing.JMenuItem deshacerMenuItem;
        private javax.swing.JTextArea editorTextArea;
        private javax.swing.JMenuItem guardarComoMenuItem;
        private javax.swing.JMenuItem guardarMenuItem;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JMenu jMenu1;
        private javax.swing.JMenu jMenu2;
        private javax.swing.JMenu jMenu3;
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JMenuItem jMenuItem2;
        private javax.swing.JMenuItem jMenuItem6;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JSpinner jSpinner1;
        private javax.swing.JMenuItem rehacerMenuItem;
        // End of variables declaration//GEN-END:variables
}
