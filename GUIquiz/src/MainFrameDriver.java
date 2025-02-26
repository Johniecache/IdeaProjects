import javax.swing.JFrame;

public class MainFrameDriver
{
    public static void main(String[] args)
    {
        MainFrame textFieldFrame = new MainFrame();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(200, 350);
        textFieldFrame.setVisible(true);
    }
}

