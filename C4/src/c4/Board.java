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
import java.util.ArrayList;

/**
 *
 * @author w8g33
 */
public class Board {
    private int turnNo;
    private Piece[][] boardArray;
    private Player[] players;
    private C4.Canvas game;
    //Add game as a attribute - private C4 game;
    
    //Add another parameter for whether each player is AI
    public Board(C4.Canvas gameContext, String player1Colour, String player2Colour) {
        game = gameContext;
        players = new Player[2];
        players[0] = new Player(player1Colour);
        players[1] = new Player(player2Colour);
        boardArray = new Piece[7][7];
        for (int nx = 0; nx < 7; nx++) {
            for (int ny = 0; ny < 7; ny++) {
                boardArray[nx][ny] = null;
            }
        }
        boardArray[2][2] = new Piece(players[1]);
    }
    
    public void takeTurn(int selectedColumn) {
        if (turnNo == 0) {
            turnNo = 1;
        } else if (turnNo == 1) {
            turnNo = 0;
        }
        for (int n = 0; n < 7; n++) {
            System.out.print("For loop");
            int slot = 6 - n;
            System.out.print(slot);
            if (boardArray[selectedColumn][slot] != null) {
                System.out.print("Place found");
                boardArray[selectedColumn][6-n] = new Piece(players[turnNo]);
            }
        }
        System.out.println(boardArray);
    }
    
    public void render(Graphics g, int selectedColumn) {
        //Print columns and rows
        g.setColor(new Color(0, 0, 102));
        Dimension size = game.getSize();
        for (int n = 0; n < 7; n++) {
            g.drawLine(0, (size.height/7)*n, size.width, (size.height/7)*n);
            g.drawLine((size.width/7)*n, 0, (size.width/7)*n, size.height);
        }
        //Print hovering piece
        g.fillOval((size.width/7)*selectedColumn, 0, 100, 100);
        
        //Print pieces on the board
        for (int nx = 0; nx < 7; nx++) {
            for (int ny = 0; ny < 7; ny++) {
                if (boardArray[nx][ny] != null) {
                    boardArray[nx][ny].render(g, (size.width/7)*nx, (size.height/7)*ny);
                }
            }
        }
    }
        
}
