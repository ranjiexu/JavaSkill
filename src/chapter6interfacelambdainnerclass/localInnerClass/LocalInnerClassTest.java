package chapter6interfacelambdainnerclass.localInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 局部内部类测试
 */
public class LocalInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(10000, true);

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}

class TalkingClock {

    public TalkingClock() {
    }

    public void start(int interval, boolean beep) {
        /**
         * 局部内部类
         */
        class TimePrinter implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}


/**
 ReflectionTest 分析出来的局部内部类的结构

 class chapter6.localInnerClass.TalkingClock$1TimePrinter extends java.lang.Object
 {

 chapter6.localInnerClass.TalkingClock$1TimePrinter(chapter6.localInnerClass.TalkingClock, boolean);

 public void actionPerformed(java.awt.event.ActionEvent);

 final boolean val$beep
 final chapter6.localInnerClass.TalkingClock this$0
 }
 **/