package java.blatt13;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by micha on 12.01.2017.
 */
public class Farbwahl extends JFrame {
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JPanel colorPanel;
    private JPanel mainPanel;

    public Farbwahl() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

        ChangeListener listener = (e)-> colorPanel.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));
        slider1.addChangeListener(listener);
        slider2.addChangeListener(listener);
        slider3.addChangeListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new Farbwahl();

    }
}
