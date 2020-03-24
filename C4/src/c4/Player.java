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
        System.out.println("String Colour: " + stringColour);
        colour = stringToColour(stringColour);
    }
    
    public Color getColour() {
        return colour;
    }
    
    public Color stringToColour(String stringColour) {
        Color returnColour = null;
        if (stringColour == "Red") {
            returnColour = new Color(255, 0, 0);
        } else if (stringColour == "Green") {
            returnColour = new Color(0, 255, 0);
        } else if (stringColour == "Yellow") {
            returnColour = new Color(255, 255, 0);
        } else if (stringColour == "Blue") {
            returnColour = new Color(0, 0, 255);
        }
        return returnColour;
    }
    
}
