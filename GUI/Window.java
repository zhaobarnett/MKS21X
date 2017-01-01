import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{

    private Container pane;
    private JButton b1;
    private JButton b2;
    private JTextField t;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window() {
     this.setTitle("My first GUI");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());
    
     b1 = new JButton("Convert F to C");
     b1.addActionListener(this);
     b1.setActionCommand("FtoC");
     
     b2 = new JButton("Convert C to F");
     b2.addActionListener(this);
     b2.setActionCommand("CtoF");
     
     t = new JTextField(12);
     
     pane.add(t);
     pane.add(b1);
     pane.add(b2);
 }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("FtoC")){
	    String s = t.getText();
	    double d = Double.parseDouble(s);
	    s = Double.toString(tempConverter.FtoC(d));
	    t.setText(s);
	}
	if(event.equals("CtoF")){
	    String s = t.getText();
	    double d = Double.parseDouble(s);
	    s = Double.toString(tempConverter.CtoF(d));
	    t.setText(s);
	}
    }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window g = new Window();
     g.setVisible(true);
  }
}
