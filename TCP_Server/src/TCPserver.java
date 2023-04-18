import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver  {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6888);

        while (true) {
            server.accept();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(server.accept().getInputStream()));
            String message = buffer.readLine();
            System.out.println(message);
            buffer.close();
        }
    }
}
