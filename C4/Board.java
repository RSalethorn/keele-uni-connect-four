/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author w8g33
 */
public class Board {
    private int turnNo;
    private Piece[][] boardArray;
    private Graphics gc;
    private Player player1;
    private Player player2;
    //Add game as a attribute - private C4 game;
    
    //Add another parameter for whether each player is AI
    public Board(Graphics g, String player1Colour, String player2Colour) {
        gc = g;
        
    }
    
    public void render(Graphics g) {
        g.setColor(new Color(0, 0, 102));
        /*Dimension size = .getSize();
        for (int n = 0; n < (size.getWidth()) / 10; n++) {
            g.drawLine((n * 10), 0, (n * 10), (int) size.getHeight());
            g.drawLine(0, (n * 10), (int) size.getWidth(), (n * 10));
        }*/
    }
        
}
