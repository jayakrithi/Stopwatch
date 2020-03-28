import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.text.LayoutQueue;

import javafx.scene.layout.FlowPane;

class Reminder extends JFrame {
    int sec = 0;
    int x = 0;
    int y = 0;
    Timer timer = new Timer();
    SetTimer s = new SetTimer(sec);
    Reminder r;
    ShowNumber num = new ShowNumber(x, y);
    Button start , stop ;
    
    
    public Reminder() {
        start = new Button("Start");
       // start.setMaximumSize(new Dimension(70,70));
        stop = new Button("Stop");
      
        setLayout(new FlowLayout());
        add(start);
        add(stop);
        
    }

    public int runtimer(){
        
        timer.schedule(new TimerTask(){
            public void run(){
                s.calculate(sec);
                System.out.println(sec);
                sec++;
               // 
            }
        },0,1000);
        return s.calculate(sec);
    }

    
    public void paint(Graphics g) {
        
        // Background Window
             
       
       // num.number(g, 300, 200, r.runtimer());
        Thread t = new Thread() {
            public void run() {
               int sec =0;
                try{

                for(;;) {
                g.setColor(Color.BLACK);
                g.fillRect(70, 100, 600, 350);
                
                num.number(g, 220, 200, s.calculate(sec/10));
                num.number(g, 300, 200, s.calculate(sec%10));
                sleep(1000);
                sec++;
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                           
        }
        }; 
        t.run();
        
    }
    
 
    public static void main(String[] args) {
        Reminder r = new Reminder();
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(900, 500);
        r.setTitle("Timer");
        r.runtimer();
        r.setVisible(true);
    
        
    }
  
}