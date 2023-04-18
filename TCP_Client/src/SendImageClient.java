import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class SendImageClient {
    public static void main(String[] args) throws Exception {

        stack();

    }
    public static void stack()throws Exception{
        Socket socket = new Socket("localhost", 13085);
        OutputStream outputStream = socket.getOutputStream();

        BufferedImage image = ImageIO.read(new File("D:\\profile_picture.jpg"));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);

        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        outputStream.write(size);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
        System.out.println("Flushed: " + System.currentTimeMillis());

        Thread.sleep(120000);
        System.out.println("Closing: " + System.currentTimeMillis());
        socket.close();
    }

    public void sendBytes() throws Exception{

        Socket socket = new Socket("localhost",6888);
        BufferedImage image = ImageIO.read(new File("C:\\Users\\HP\\OneDrive - ADA University\\Pictures\\profile_picture.jpg"));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",output);

    }
}
