import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.*;


public class TCPClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Socket s = new Socket("localhost",6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("Hello server!");
		dos.flush();
		dos.close();
	}

}
