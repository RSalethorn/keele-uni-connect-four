package c4;

//Importing packages, unused packages can be removed once we finish
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.border.*;
import javax.swing.event.*;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class C4 extends JFrame{
    //Creating GUI element variables that will be used
    JPanel control = new JPanel();
    Canvas game = new Canvas();
    JPanel player1 = new JPanel();
    JPanel player2 = new JPanel();
    String[] colours = { "Red","Yellow","Green","Blue"};
    JComboBox colour1 = new JComboBox(colours);
    JComboBox colour2 = new JComboBox(colours);
    JCheckBox ai1 = new JCheckBox("AI?");
    JCheckBox ai2 = new JCheckBox("AI?");
    JButton play = new JButton("Play");

    Board board;
    int selectedColumn = 0;
    
    public C4(){
        super("Connect 4");
        setSize(1280,720); //Setting window size and window name (in pixels)
        
        control.setBorder(new TitledBorder(new EtchedBorder(), "Settings"));
        control.setPreferredSize(new Dimension(200, 100));
            player1.setBorder(new TitledBorder(new EtchedBorder(), "Player 1"));
            player1.setPreferredSize(new Dimension(190,100));
            player1.setLayout(new GridLayout(2,1));
                colour1.setSelectedIndex(0);
                colour1.addActionListener(new colourPickListener());
            player2.setBorder(new TitledBorder(new EtchedBorder(), "Player 2"));
            player2.setPreferredSize(new Dimension(190,100));
                colour2.setSelectedIndex(1);
                colour2.addActionListener(new colourPickListener());
            player2.setLayout(new GridLayout(2,1));
            play.setPreferredSize(new Dimension(150,40));
            play.addActionListener(new playClickListener());
        
        add(control, BorderLayout.WEST);
            control.add(player1);
                player1.add(colour1);
                player1.add(ai1);
            control.add(player2);
                player2.add(colour2);
                player2.add(ai2);
            control.add(play);
        add(game, BorderLayout.CENTER);
        game.addMouseMotionListener(new mouseMoveListener());
        game.addMouseListener(new mouseClickListener());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    class Canvas extends JPanel{
        //Leave as is, code for initialising the canvas
        public void paintComponent (Graphics g){
            super.paintComponent(g);
            draw(g);
        }
    }
    
    private void draw(Graphics g){
        int w = game.getWidth();
        int h = game.getHeight();
        //Put code which directly redraws the board here, handle board interactions in the respective object however
        if (board != null) {
            board.render(g, selectedColumn);
        }
    }
    
    public Dimension getCanvasSize(){
        Dimension size = game.getSize();
        return size;
    }
    
    class colourPickListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //Code which handles the error check in which two players select the same colour
            String p1Colour = (String)colour1.getSelectedItem();
            String p2Colour = (String)colour2.getSelectedItem();
            try{
                if (p1Colour.equals(p2Colour)){
                    //An error message pops up informing the player that they may not do this
                    JOptionPane.showMessageDialog(control,"Two players can not have the same colour", "Error",JOptionPane.ERROR_MESSAGE);
                    colour2.setSelectedIndex(colour1.getSelectedIndex()+1);
                }
            } catch (IllegalArgumentException ex) {
                //To prevent going out of bounds just go in the other direction
                colour2.setSelectedIndex(colour1.getSelectedIndex()-1);
            }
        }
    }

    class playClickListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
        //Code which initialises connect 4 board, read from check boxs and drop downs at this point if possible
        board = new Board(game, "Red", "Green");
        game.repaint();
        }
    }
    
    class mouseMoveListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            float x = e.getX();
            Dimension size = game.getSize();
            float columnDifference = size.width/7;
            selectedColumn = (int)Math.floor(x/columnDifference);
            game.repaint();
        }
        
    }
    
    class mouseClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            float x = e.getX();
            Dimension size = game.getSize();
            float columnDifference = size.width/7;
            selectedColumn = (int)Math.floor(x/columnDifference);
            board.takeTurn(selectedColumn);
            game.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
        
    }
    
    public static void main(String[] args){
        C4 Menu = new C4(); //Code which creates the object which holds the GUI
    }

}
