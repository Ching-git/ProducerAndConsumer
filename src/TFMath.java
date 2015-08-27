import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TFMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TFFrame().launchFrame();
	}

}

class TFFrame extends Frame {
	TextField num1;
	TextField num2;
	TextField num3;
	public void launchFrame() {
		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(10);
		Label lbplus = new Label("+");
		Button btnEqual = new Button("=");
		btnEqual.addActionListener(new MyMonitor(this));
		setLayout(new FlowLayout());
		add(num1);
		add(lbplus);
		add(num2);
		add(btnEqual);
		add(num3);
		pack();
		setVisible(true);
		this.addWindowListener(new MyMonitor(this));
	}
	
	class MyMonitor extends WindowAdapter implements ActionListener {
		
		TFFrame tf = null;
		public MyMonitor(TFFrame tf){
			this.tf = tf;
		}
		
		public void actionPerformed(ActionEvent e) {
			int num3 = Integer.parseInt(tf.num1.getText()) + Integer.parseInt(tf.num2.getText());
			tf.num3.setText(String.valueOf(num3));
		}
		
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			System.exit(0);
		}
	}
}

