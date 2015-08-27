import java.io.DataInputStream;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(6666);
		Socket s = ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		System.out.println(dis.readUTF());
		dis.close();
		s.close();
		System.out.println("A client connect!");
	}

}
