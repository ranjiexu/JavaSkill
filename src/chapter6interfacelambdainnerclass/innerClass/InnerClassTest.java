package chapter6interfacelambdainnerclass.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 一个简单的内部类测试
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(10000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    private class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}


/**
 *
 * ReflectionTest 分析出来的内部类的结构
 *
 * private class chapter6.innerClass.TalkingClock$TimePrinter extends java.lang.Object
 * {
 *
 *  private chapter6.innerClass.TalkingClock$TimePrinter(chapter6.innerClass.TalkingClock);
 *  chapter6.innerClass.TalkingClock$TimePrinter(chapter6.innerClass.TalkingClock, chapter6.innerClass.TalkingClock$1);
 *
 *  public void actionPerformed(java.awt.event.ActionEvent);
 *
 *  final chapter6.innerClass.TalkingClock this$0
 * }
 **/