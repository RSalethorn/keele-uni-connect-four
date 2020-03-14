/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author w8g33
 */
public class Piece {
    private Player player;
    
    public Piece(Player piecePlayer) {
        player = piecePlayer;
    }
    
    public void render(Graphics g, int x, int y) {
        g.setColor(player.getColour());
        g.fillOval(x, y, 100, 100);
    }
}
