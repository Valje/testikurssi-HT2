package game;

import game.character.Boat;
import game.character.Character;
import java.awt.event.*;

public class GameWindow extends javax.swing.JFrame {

    private GameEngine gameEngine;
    private static GameWindow window;
    Thread thread;

    public GameWindow() {
        initComponents();
    }
    
    public void updateControlPanel(Boat b){
        this.controlPanel.updateControlPanel(b);
    }
    
    public static GameWindow getInstance() {
        if (window != null) {
            return window;

        } else {
            synchronized (GameWindow.class) {
                if (window == null) {
                    window = new GameWindow();
                }
            }

        }
        return window;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlGame = new javax.swing.JPanel();
        controlPanel = new game.ControlPanel();
        renderer = new game.Renderer();
        jBtnGo = new javax.swing.JButton();
        jBtnStorm = new javax.swing.JButton();
        jPrgEnergy = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPnlGame.setBackground(new java.awt.Color(204, 204, 255));
        jPnlGame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPnlGame.add(controlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 370, -1));

        renderer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rendererMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rendererMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rendererMouseReleased(evt);
            }
        });
        renderer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                rendererMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                rendererMouseMoved(evt);
            }
        });
        renderer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rendererKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rendererKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout rendererLayout = new javax.swing.GroupLayout(renderer);
        renderer.setLayout(rendererLayout);
        rendererLayout.setHorizontalGroup(
            rendererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        rendererLayout.setVerticalGroup(
            rendererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPnlGame.add(renderer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 680, 570));

        jBtnGo.setText("Go!");
        jBtnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGoActionPerformed(evt);
            }
        });
        jPnlGame.add(jBtnGo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 30));

        jBtnStorm.setText("Storm");
        jBtnStorm.setEnabled(false);
        jBtnStorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStormActionPerformed(evt);
            }
        });
        jPnlGame.add(jBtnStorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, 30));

        jPrgEnergy.setValue(100);
        jPnlGame.add(jPrgEnergy, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 280, -1));

        jLabel1.setText("Energy");
        jPnlGame.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        getContentPane().add(jPnlGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jBtnStormActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnStormActionPerformed
    {//GEN-HEADEREND:event_jBtnStormActionPerformed


        InputController.getInstance().triggerStorm();
}//GEN-LAST:event_jBtnStormActionPerformed

    private void rendererMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_rendererMouseDragged
    {//GEN-HEADEREND:event_rendererMouseDragged
        InputController c = InputController.getInstance();
        c.handleMouseMove(evt);
    // TODO add your handling code here:
    }//GEN-LAST:event_rendererMouseDragged

    private void rendererKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_rendererKeyReleased
    {//GEN-HEADEREND:event_rendererKeyReleased

        InputController c = InputController.getInstance();
        c.handleKeyRelease(evt);
    }//GEN-LAST:event_rendererKeyReleased

    private void rendererKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_rendererKeyPressed
    {//GEN-HEADEREND:event_rendererKeyPressed

        InputController c = InputController.getInstance();
        c.handleKeyPress(evt);
    }//GEN-LAST:event_rendererKeyPressed

    private void jBtnGoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnGoActionPerformed
    {//GEN-HEADEREND:event_jBtnGoActionPerformed

        startGame();
    }//GEN-LAST:event_jBtnGoActionPerformed

    public void startGame(){

        renderer.requestFocusInWindow();
        getInstance().go();
        this.jBtnStorm.setEnabled(true);        
    }
    
    public void setEnergyBarLevel(int e){
        this.jPrgEnergy.setValue(e);
    }
    
    private void rendererMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_rendererMousePressed
    {//GEN-HEADEREND:event_rendererMousePressed
        renderer.requestFocusInWindow();

        InputController c = InputController.getInstance();
        c.handleMouseClick(evt);
    }//GEN-LAST:event_rendererMousePressed

    private void rendererMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_rendererMouseReleased
    {//GEN-HEADEREND:event_rendererMouseReleased
        InputController.getInstance().handleMouseReleased(evt);
	
    }//GEN-LAST:event_rendererMouseReleased

    private void rendererMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_rendererMouseEntered
    {//GEN-HEADEREND:event_rendererMouseEntered
        this.requestFocusInWindow();
        InputController c = InputController.getInstance();
        c.handleMouseMove(evt);
    }//GEN-LAST:event_rendererMouseEntered

    private void rendererMouseMoved(java.awt.event.MouseEvent evt)//GEN-FIRST:event_rendererMouseMoved
    {//GEN-HEADEREND:event_rendererMouseMoved
        InputController c = InputController.getInstance();
        c.handleMouseMove(evt);
	
	
    }//GEN-LAST:event_rendererMouseMoved

    private void rendererMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_rendererMouseClicked
    {//GEN-HEADEREND:event_rendererMouseClicked
	
    }//GEN-LAST:event_rendererMouseClicked

    private void formKeyReleased(KeyEvent evt) {
        InputController.getInstance().handleKeyRelease(evt);
    }

    private void formKeyPressed(KeyEvent evt) {
        InputController.getInstance().handleKeyPress(evt);

    }


    public void go() {

        gameEngine = GameEngine.getInstance();
        gameEngine.initialize();

        thread = new Thread(gameEngine);
        thread.setName("GameEngineThread");
        thread.start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GameWindow gameWindow = new GameWindow();
                gameWindow.setVisible(true);

            }
        });
    }

    void initializeControlPanel(Character characterBoat) {
        this.controlPanel.initializeControlPanel(characterBoat);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private game.ControlPanel controlPanel;
    private javax.swing.JButton jBtnGo;
    private javax.swing.JButton jBtnStorm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPnlGame;
    private javax.swing.JProgressBar jPrgEnergy;
    private game.Renderer renderer;
    // End of variables declaration//GEN-END:variables
}
