package assignment;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * @author jaswanthjerripothula
 */
public class Server{
    protected static Arithmetic arith; 
    public Server() {
    }
    public void start() throws Exception{
    	 InetAddress ip = InetAddress.getLocalHost();
    	// Step 1 : Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] buf = null;
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;
        System.out.println("Server Connected by the client .....Server Running ");
        while (true)
        {
            // Step 2 : create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(receive, receive.length);
            // Step 3 : receive the data in byte buffer.
            ds.receive(DpReceive);
         // Exit the server if the client sends "bye"
            if (data(receive).toString().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
            String[] _data = data(receive).toString().split(" ");
            System.out.println(_data[0]);
          double result = 0.0;
            double operand1  = Double.valueOf(_data[0]);
            String operator  = _data[1];
            double operand2  = Double.valueOf(_data[2]);
            switch(operator) {
            	case "+" : 
            		result = (operand1 + operand2);
            		break;
            	case "-" : 
            		result = (operand1 - operand2);
            		break;
            	case "*" : 
            		result = (operand1 * operand2);
            		break;
            	case "/" : 
            		result = (operand1 / operand2);
            		break;
            }
            buf = (result+"").getBytes();
            System.out.println(buf);
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 4321);
            ds.send(DpSend);
            // Clear the buffer after every message.
            receive = new byte[65535];
            buf = new byte[65535];
        }
      }
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
    public static void main(String ...args) throws Exception {
    	Server s = new Server();
    	s.start();
    }
}
