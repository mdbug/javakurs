package java.blatt13.Schiebepuzzle;

import javax.swing.*;

/**
 * Created by micha on 12.01.2017.
 */
public class Schiebepuzzle extends JFrame {
    private final int W = 4;
    private final int H = 4;
    private JButton[][] buttons;
    private JPanel pane;


    public Schiebepuzzle() {
        pane = new JPanel();
        pane.setLayout(null);
        buttons = new JButton[H][W];
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                int x = i * 4 + j + 1;
                if (x == W * H)
                    break;
                buttons[i][j] = new JButton(String.valueOf(x));
                buttons[i][j].setBounds(j*100, i*100, 100, 100);
                pane.add(buttons[i][j]);
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pane);
        setSize(W*100, H*100 + 30);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new Schiebepuzzle();

    }
}
