import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
public static void main(String[]args){
   try{
    //server connection and acceptance
      ServerSocket server = new ServerSocket(8000);
      System.out.println("Connection Established");
      Socket communication = server.accept();
      System.out.println("Client accepted");

      // sending message
       BufferedReader in = new BufferedReader(new InputStreamReader(communication.getInputStream()));
      PrintWriter out = new PrintWriter(communication.getOutputStream());
      BufferedReader any = new BufferedReader(new InputStreamReader(System.in));

      //String message
      String msg = null;
      while ((msg = any .readLine()) !=null) {
    
            out.println(msg);
            if("/exit".equals(msg)){
                break;
            }
            out.close();
        
      }
      
      
     // receiving message
     Runnable obj = ()->{
        try {
        
      
        String message = null;
        while (( message = in.readLine()) != null){
            System.out.println("Client: " +message);
        }

       communication.close();
    }
       catch (IOException e){

       
          }

     };
      Thread t1 = new Thread(obj);
      t1.start();
   } catch (IOException e ){

   }

}

}