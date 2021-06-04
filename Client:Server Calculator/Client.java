package assignment;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author jaswanthjerripothula
 */
public class Client{
    protected static Arithmetic arith; 
    public Client() {
    }
    
    @SuppressWarnings("deprecation")
	public void start() throws Exception{
        DatagramSocket cds = new DatagramSocket(4321);
    	Scanner sc = new Scanner(System.in);
        // Step 1:Create the socket object for carrying the data.
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
        byte[] receive = new byte[65535];
        // loop while user not enters "bye"
        while (true)
        {
            System.out.println("Enter operand1 operator operand2");
            String inp = sc.nextLine();
            // convert the String input into the byte array.
            buf = inp.getBytes();
            // Step 2 : Create the datagramPacket for sending the data.
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
            // Step 3 : invoke the send call to actually send the data.
            ds.send(DpSend);
            DatagramPacket DpReceive = null;
            DpReceive = new DatagramPacket(receive, receive.length);
            // Step 3 : receive the data in byte buffer.
            cds.receive(DpReceive);
            String _data = data(receive).toString();
            System.out.println("The calculator result :: " +_data);
            // break the loop if user enters "bye"
            if (inp.equals("bye"))
                break; 	
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
    	Client c = new Client();
    	c.start();
    }
}
