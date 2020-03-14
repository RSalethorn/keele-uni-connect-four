/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4;

import java.awt.Color;

/**
 *
 * @author w8g33
 */
public class Player {
    private Color colour;
    
    public Player(String stringColour) {
        colour = stringToColour(stringColour);
    }
    
    public Color getColour() {
        return colour;
    }
    
    public Color stringToColour(String stringColour) {
        Color returnColour = null;
        switch(stringColour) {
            case "Red":
                returnColour = new Color(255, 0, 0);
            case "Green":
                returnColour = new Color(0, 255, 0);
            case "Yellow":
                returnColour = new Color(255, 255, 0);
            case "Blue":
                returnColour = new Color(0, 0, 255);
        }
        return returnColour;
    }
}
