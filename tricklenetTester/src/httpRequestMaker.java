/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

/**
 *
 * @author Jayesh
 */
class HttpRequest{


}

class SimpleThread extends Thread {
int start=0;
int End =0;
  public SimpleThread(int Start,int end){
            start=Start;
            End =end;
            start();
  }
    public void run(){
	
         try{
            System.out.println("Start Time :  "+ Calendar.getInstance().getTimeInMillis()); 
            
               for(int i=start;i<End;i++){
                try {
                   
                        URL url;
                        String username="user"+i;
                        String email="jayeshdalwadi2007@gmail.com"+i;

                        String newbody ="{\"login\":\""+username+"\",\"currentBalance\":\"1\",\"password\":\"123\",\"email\":\""+email+"\",\"name\":\"jayesh\",\"street1\":\"baroda\",\"street2\":\"baroda\",\"city\":\"baroda\",\"state\":\"gujarat\",\"zipCode\":\"390002\",\"country\":\"india\",\"phone\":\"9924482015\"}";

                        // Send data

                        url = new URL("http://localhost:8080/tricklenet/rest/t-user/register_user");
                        URLConnection conn = url.openConnection();
                        conn.setRequestProperty("Content-Type", "application/json");
                        conn.setDoOutput(true);
                        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                        wr.write(newbody);
                        wr.flush();

                        // recive  data

                        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String line;
                        while ((line = rd.readLine()) != null) {
                         //  System.out.println(line+"no : "+i);
                    }
                    wr.close();
                    rd.close();
                    }catch(Exception ex) {
                        System.out.println("Exception cought:\n"+ ex.toString());
                    }
         }
         System.out.println("End Time : "+ Calendar.getInstance().getTimeInMillis()); 
         
         
         }catch(Exception e){
               System.out.println("Exception cought:\n"+ e.toString());  
         }
    }
 }

class result {
     void testdata(int value,int value2){
         
            System.out.println("start value : "+value +"  End value "+ value2);
     
     }

}
public class httpRequestMaker {
     
     public static void main(String[] args) {

     int totalnumber=10000; //number of request 
     int thread =10;		//number of concurent request
     int  start = 0;
     int avg =totalnumber/thread;
     
     result r1=new result(); 
         for(int i=0;i<thread;i++)
         {
            int[] ans = new int[thread];
            start = totalnumber;
            ans[i]=totalnumber-avg;
            totalnumber=ans[i];
            r1.testdata(totalnumber,start);
            new SimpleThread(totalnumber,start);
         
         }
         
     }    
}
