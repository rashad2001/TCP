import org.omg.CORBA.portable.OutputStream;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPclient  {
    public static void main(String[] args) throws Exception {

    Socket connectionToServer = new Socket("localhost", 6888);
    DataOutputStream data = new DataOutputStream(connectionToServer.getOutputStream());
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    String message = buffer.readLine();

    buffer.close();


    }

}
