import java.awt.Color;
import java.awt.Frame;


public class MultiFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f1 = new MyFrame(100, 100, 200, 200, Color.BLUE);
		MyFrame f2 = new MyFrame(300, 100, 200, 200, Color.YELLOW);
		MyFrame f3 = new MyFrame(100, 300, 200, 200, Color.GREEN);
		MyFrame f4 = new MyFrame(300, 300, 200, 200, Color.MAGENTA);
	}
}

class MyFrame extends Frame{
	static int id = 0;
	public MyFrame(int x,int y, int w, int h, Color color) {
		// TODO Auto-generated constructor stub
		super("MyFrame" + (++id));
		setBackground(color);
		setLayout(null);
		setBounds(x,y,w,h);
		setVisible(true);
	}
}
