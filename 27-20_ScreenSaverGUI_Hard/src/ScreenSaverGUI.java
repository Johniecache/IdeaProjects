import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Screen Saver GUI class sets a timer, num_lines, random object, and input_lines.
 * will draw random lines "num_lines" times in a JFrame window.
 */
public class ScreenSaverGUI extends JFrame{
    private Timer timer; // initiating new timer object
    private int num_lines = 100; // default number of lines to be drawn on screen
    private Random r = new Random(); // new random object initiated
    private JTextField input_lines; // initializing text field where input will go
    private JButton stop_button; // button to stop the repaint after delayed time
    private JPanel input_frame; // new frame to hold the input text box and button
    private Paint paint_frame; // new frame to hold the lines that will be displayed on screen

    /**
     * default constructor for the ScreenSaverGUI.
     * sets the layout, handler, input_lines, and textbox
     */
    public ScreenSaverGUI(){

        super("Screen Saver GUI"); // title of the window
        setLayout(new BorderLayout()); // makes the window better visually by organizing it

        ScreenSaverGUIHandler handler = new ScreenSaverGUIHandler(); // new handler object initialized

        input_lines = new JTextField(String.valueOf(num_lines), 10); // assigns input lines to the input from inputLines text box, has a width of 5 across on the screen
        input_lines.addActionListener(handler); // assigns a new "action listener" to input lines to handle the input and what to do with it

        stop_button = new JButton("Click to stop repainting"); // text in the button object
        stop_button.addActionListener(handler); // adds the button to the action listener to see if input is applied

        input_frame = new JPanel(); // new empty default window from JFrame
        input_frame.add(new JLabel("Enter number of lines: ")); // text box to the left of the input_lines to prompt user
        input_frame.add(input_lines); // adds the text box to the window when created
        input_frame.add(stop_button); // add the stop button to the window

        this.add(input_frame,BorderLayout.NORTH); // sets the input frame to the top of the instance window

        paint_frame = new Paint(); // new window from the inherited class paint
        this.add(paint_frame, BorderLayout.CENTER); // sets the new paint frame to the center of the instance window

        timer = new Timer(1000, handler); // initializing timer with delay set
        timer.start(); // starting timer object

    } // end of ScreenSaverGUI constructor

    /**
     * ScreenSaverGUIHandler is the "handler" or "action listener" for the ScreenSaverGUI
     * this will grab input from the user and then send those inputs to the program to do computation.
     */
    private class ScreenSaverGUIHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){ // method to handle inputs

            if(e.getSource() == timer){ // timer object starts
                repaint(); // calls repaint method to randomly set lines and color
            }

            if(e.getSource() == input_lines){ // if input lines is edit (input is entered)
                try{
                    if(Integer.parseInt(input_lines.getText())>100000){ // if the number of input lines is over 100000
                        input_lines.setText("100000"); // set the input lines to 100000, so that I don't brick my computer
                    }
                    num_lines = Integer.parseInt(input_lines.getText()); // turn the string input to an integer
                    repaint(); // repaint with new input number
                } catch (NumberFormatException ex){ // catch any non integers
                    input_lines.setText("Not valid input."); // if not an integer then tell user
                }
            }

            if(e.getSource() == stop_button){ // checks if button has been pressed
                if(timer.isRunning()){ // if timer is currently running, stop it
                    timer.stop(); // stop timer from counting
                    stop_button.setText("Click to start repainting"); // change text in button box
                }
                else{ // if timer is not currently running then start it
                    timer.start(); // start timer to continue counting
                    stop_button.setText("Click to stop repainting"); // change text in button box
                }
            }
        }
    } // end of ScreenSaverGUIHandler class

    /**
     * Paint class with one method that displays lines to the screen
     */
    private class Paint extends JPanel {

        /**
         * Paint method
         * @param g the specified Graphics window
         */
        @Override
        public void paint(Graphics g) { // graphics is abstract class that allows for drawing on a window
            super.paint(g); // pass input to component which is abstract and is graphical representation that can be displayed on screen
            Graphics2D g2d = (Graphics2D) g; // Graphics2D extends graphics such that it only takes an into account 2d space instead of 3d and/or other things not needed for 2d graphics

            int width = 1920 / 2; // calculating width of a standard monitor
            int height = 1080 / 2; // calculating height of standard monitor

            g2d.clearRect(0, 0, 1920, 1080); // clear the window from previous drawn lines

            int x,y,z,n; // initializing variables

            for (int i = 0; i < num_lines; i++) { // loop through number of input lines
                x = r.nextInt(width); // random width length start position
                y = r.nextInt(height); // random height length start position
                z = r.nextInt(width); // random width length ending position
                n = r.nextInt(height); // random height length ending position

                g2d.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))); // set the instance line color as a random color in RGB

                g2d.drawLine(x, y, z, n); // drawn lines of random colors with random start and end position that where initialized earlier
            }
        } // end of paint method override

    } // end of Paint class

} // end of ScreenSaverGUI class

