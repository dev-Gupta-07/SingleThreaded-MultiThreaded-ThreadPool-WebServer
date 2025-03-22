import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
public void run()throws Exception{
    int port=8010;
    InetAddress address=InetAddress.getLocalHost();
    Socket socket=new Socket(address,port);
    PrintWriter toSocket=new PrintWriter(socket.getOutputStream(),true);
    BufferedReader fromSocket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    toSocket.println("Hello Server");
    String line=fromSocket.readLine();
    System.out.println("Response from the socket is " +line);
    toSocket.close();
    fromSocket.close();
    socket.close();


}
public static void main(String args[]){
    try{
        Client c=new Client();
        c.run();

    }catch (Exception e){
        e.printStackTrace();
    }
}
}
