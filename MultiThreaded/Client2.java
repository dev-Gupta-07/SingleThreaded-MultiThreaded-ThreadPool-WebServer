
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class Client2 {
    public Runnable getRunnable() {
       return new Runnable(){
           @Override
           public void run() {
               int port=8010;
               try{
               InetAddress address=InetAddress.getLocalHost();
               Socket socket=new Socket(address,port);
               try(
               PrintWriter toSocket=new PrintWriter(socket.getOutputStream(),true);
               BufferedReader fromSocket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
               ){
               toSocket.println("Hello Server");
               
               String line=fromSocket.readLine();
               System.out.println("Response from the socket is " +line);
               }catch( Exception ex){
                ex.printStackTrace();
               }
            }catch(
                Exception ex
            ){
                ex.printStackTrace();

            }
           }
       };
    }

    public static void main (String[] args) {
        Client2 client = new Client2();
        for(int i=0;i<100;i++){
            try{
                Thread  thread=new Thread(client.getRunnable());
                thread.start();

            }catch (Exception ex){
                ex.printStackTrace();
                return;
            }
        }
    }
}
