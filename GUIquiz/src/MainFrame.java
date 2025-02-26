import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JButton calculate;


    private final JTextField int1;
    private final JTextField int2;
    private final JTextField result;

    public MainFrame(){
        super("Add Two Integers");
        setLayout(new FlowLayout());

        label1 = new JLabel("Enter int1: ");
        add(label1);
        int1 = new JTextField(15);
        add(int1);

        label2 = new JLabel("Enter int2: ");
        add(label2);
        int2 = new JTextField(15);
        add(int2);

        label3 = new JLabel("Result of sum: ");
        add(label3);

        result = new JTextField(15);
        result.setEditable(false);
        add(result);

        calculate = new JButton("calculate");
        add(calculate);

        MainFrameHandler handler = new MainFrameHandler();
        int1.addActionListener(handler);
        int2.addActionListener(handler);
        calculate.addActionListener(handler);

    }


    private class MainFrameHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            try{
                int num1 = Integer.parseInt(int1.getText());
                int num2 = Integer.parseInt(int2.getText());

                int sum = num1 + num2;
                result.setText(String.valueOf(sum));
            } catch (NumberFormatException e){
                result.setText("Invalid input");
            }

        }
    }
}




