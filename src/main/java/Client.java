import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8645;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader( new
                     InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println(in.readLine());
            String name = "Vasya";
            System.out.println(name);
            out.println(name);
            System.out.println(in.readLine());
            String age = "22";
            System.out.println(age);
            out.println(age);
            System.out.println(in.readLine());
            String hot = "yes";
            System.out.println(hot);
            out.println(hot);
            System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
