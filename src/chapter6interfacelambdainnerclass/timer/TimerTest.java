package chapter6interfacelambdainnerclass.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 回调
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(10000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
