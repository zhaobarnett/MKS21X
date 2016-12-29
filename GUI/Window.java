import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{
 private Container pane;
 private JButton b;
 private JLabel l;
 private JTextField t;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window() {
     this.setTitle("My first GUI");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    
     b = new JButton("Convert");
     l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
     t = new JTextField(12);
     
     pane.add(l);
     pane.add(b);
     pane.add(t);
 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window g = new Window();
     g.setVisible(true);
  }
}
