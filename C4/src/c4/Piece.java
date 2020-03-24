/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author w8g33
 */
public class Piece {
    private Player player;
    private boolean isEmpty;
    
    public Piece(Player piecePlayer) {
        player = piecePlayer;
        isEmpty = false;
    }
    
    public Piece() {
        isEmpty = true;
    }
    
    public boolean getIsEmpty() {
        return isEmpty;
    }
    public void render(Graphics g, int x, int y, Dimension size) {
        if (isEmpty == false) {
            g.setColor(player.getColour());
            //System.out.println(player.getColour());
            g.fillOval(x, y, size.height/7, size.height/7);
        }
    }
}
