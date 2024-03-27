import java.io.*;
import java.net.*;
import java.nio.Buffer;

class Server
{
    public static void main(String arg[]) throws Exception
    {
        System.out.println("Server of Marvellous chat messenger is running...");
        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Server is in the listening mode at port no : 2100");

        Socket sobj = ssobj.accept();
        System.out.println("Client and Server connection is successful");

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Marvellous Chat Messenger Started");

        String str1, str2;

        while((str1 = br1.readLine())!= null)
        {
            System.out.println("Client says : "+str1);
            System.out.println("Enter Message for client : ");
            str2 = br2.readLine();
            ps.println(str2);
        }
        System.out.println("Thank you for using the chat messenger");
        sobj.close();
        ps.close();
        br1.close();
        br2.close();

    }
}