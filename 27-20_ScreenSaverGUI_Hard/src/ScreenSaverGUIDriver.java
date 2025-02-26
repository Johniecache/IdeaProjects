import javax.swing.*;
import java.awt.*;

/**
 * Main Class that sets and shows the window of the ScreenSaverGUI
 */
public class ScreenSaverGUIDriver {
    public static void main(String[] args){
        int w = 1920 / 2; // center of 1920x1080 screen width wise
        int h = 1080 / 2; // center of 1920x1080 screen height wise

        int cw = 1920 / 4; // should center the center of window to center of screen width wise
        int ch = 1080 / 4; // should center the center of window to center of screen height wise

        ScreenSaverGUI window = new ScreenSaverGUI(); // new window object
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if the X is hit then close window
        window.setSize(w,h); // setting size of the window to previously initialized variables
        window.setLocation(cw,ch); // setting center of screen to previously initialized variables
        window.setVisible(true); // setting the window to be seen by user
    }
}
