import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{

public static void main(String[] args){
      
       try{
       Socket client = new Socket("localhost",8000);
     
       BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
          String message = null;

       while ((message = in.readLine()) !=null){
       System.out.println("Server" + message);

       }


      PrintWriter out = new PrintWriter(client.getOutputStream());
      out.println("This message is from the client");
       out.close();
       }catch(IOException err){


       }
       

       
    
}

}