/*    
    Copyright (C) 2012 http://software-talk.org/ (developer@software-talk.org)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package connect4.View;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import connect4.Controller.GameController;
import connect4.Model.AiCharacter;
import connect4.Model.Buffer;
import javax.swing.UIManager;

/**
 * this class is the gui for the game "4Gewinnt".
 */
public class GameGui extends javax.swing.JFrame {

    /** Creates new form Gui 
     * @param ctrl the controllerclass to communicate with.
     * @param buff the buffer to put on the human mouse inputs
     */
    public GameGui(GameController ctrl, Buffer<MouseEvent> buff) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("could not set systems look and feel, using java default.");
        }
        initComponents();
        this.ctrl = ctrl;
        this.buff = buff;
        drawPanel.setLayout(new GridLayout(ctrl.getHeight(), ctrl.getWidth()));
        panels = new GamePanel[ctrl.getHeight()][ctrl.getWidth()];
        makePanels();
    }
    
    private GameController ctrl;
    private GamePanel[][] panels;
    private Buffer<MouseEvent> buff;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        playerButtonGroup = new javax.swing.ButtonGroup();
        ComputerOneButtonGroup = new javax.swing.ButtonGroup();
        ComputerTwoButtonGroup = new javax.swing.ButtonGroup();
        drawPanel = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        exitGameButton = new javax.swing.JMenu();
        resetGameButton = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        GamemodeMenu = new javax.swing.JMenu();
        humanVsHumanButton = new javax.swing.JCheckBoxMenuItem();
        humanVsComButton = new javax.swing.JCheckBoxMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        exitGameButton.setText("Game");

        resetGameButton.setText("Reset");
        resetGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetGameButtonActionPerformed(evt);
            }
        });
        exitGameButton.add(resetGameButton);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        exitGameButton.add(jMenuItem2);

        jMenuBar1.add(exitGameButton);

        GamemodeMenu.setText("Gamemode");

        playerButtonGroup.add(humanVsHumanButton);
        humanVsHumanButton.setSelected(true);
        humanVsHumanButton.setText("Human vs. Human");
        humanVsHumanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanVsHumanButtonActionPerformed(evt);
            }
        });
        GamemodeMenu.add(humanVsHumanButton);

        playerButtonGroup.add(humanVsComButton);
        humanVsComButton.setText("Human vs. Com.");
        humanVsComButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanVsComButtonActionPerformed(evt);
            }
        });
        GamemodeMenu.add(humanVsComButton);

        jMenuBar1.add(GamemodeMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
            .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * resets the <code>drawPanel</code> to its original state.
     * The <code>GamePanel</code>s will be added and drawn, but all
     * X and O will be deleted.
     *
     * @param evt 
     */
private void resetGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetGameButtonActionPerformed
    ctrl.reset(); 
    messageLabel.setText(null);
}//GEN-LAST:event_resetGameButtonActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    System.exit(0);
}//GEN-LAST:event_jMenuItem2ActionPerformed

    private void humanVsHumanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanVsHumanButtonActionPerformed
        ctrl.setIsP1Computer(false);
        ctrl.setIsP2Computer(false);
    }//GEN-LAST:event_humanVsHumanButtonActionPerformed

    private void humanVsComButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanVsComButtonActionPerformed
        ctrl.setIsP1Computer(false);
        ctrl.setIsP2Computer(true);
    }//GEN-LAST:event_humanVsComButtonActionPerformed

    /**
     * removes everything from the drawPanel and draws all boxes from the field.
     * Adds a mouselistener to each box.
     */
    private void makePanels() {
        for (int row = 0; row < ctrl.getHeight(); row++) {
            for (int column = 0; column < ctrl.getWidth(); column++) {
                GamePanel newPanel = new GamePanel(row, column);
                newPanel.addMouseListener(new GuiMouseListener());
                panels[row][column] = newPanel;
                drawPanel.add(newPanel);
            }
        }
        drawPanel.updateUI();
    }
    
    /**
     * returns the <code>GamePanel</code> at the
     * specific position.
     * @param row the row
     * @param column the column
     * @return the <code>GamePanel</code> at the position
     */
    public GamePanel getPanelAt(int row, int column) {
        return panels[row][column];
    }

    /**
     * calls the <code>draw()</code> method of all panels.
     */
    public void printGame() {
        for (int row = 0; row < ctrl.getHeight(); row++) {
            for (int column = 0; column < ctrl.getWidth(); column++) {
                panels[row][column].draw();
            }
        }
    }
    
    /**
     * calls the <code>clear()</code> method of all panels.
     */
    public void deletePanelContent() {
        for (int row = 0; row < ctrl.getHeight(); row++) {
            for (int column = 0; column < ctrl.getWidth(); column++) {
                panels[row][column].clear();
            }
        }
    }

    /**
     * prints a message to the <code>messageLabel</code>
     * @param msg the message to print
     */
    public void sendMessage(String msg) {
        messageLabel.setText(msg);
    }
    

    /**
     * overwrites the paint method to redraw all panels. In special Case
     * this will be use by resizing events from the gui automaticly.
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        printGame();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ComputerOneButtonGroup;
    private javax.swing.ButtonGroup ComputerTwoButtonGroup;
    private javax.swing.JMenu GamemodeMenu;
    private javax.swing.JPanel drawPanel;
    private javax.swing.JMenu exitGameButton;
    private javax.swing.JCheckBoxMenuItem humanVsComButton;
    private javax.swing.JCheckBoxMenuItem humanVsHumanButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.ButtonGroup playerButtonGroup;
    private javax.swing.JMenuItem resetGameButton;
    // End of variables declaration//GEN-END:variables

    /**
     * the mouselistener for the gui to provide clickable 
     * boxes, which could draw something. Writes his event 
     * in an buffer for the backend.
     */
    private class GuiMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent event) {
            buff.write(event);
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
    }
}
