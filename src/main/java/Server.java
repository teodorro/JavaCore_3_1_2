import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8645;
        ServerSocket serverSocket = new ServerSocket(port); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accepted");

        out.println("What is your name?");
        final String name = in.readLine();
        out.println("What is your age?");
        int age = Integer.parseInt(in.readLine());

        if (age < 18){
            out.println(String.format("=== %s, go look for a sandpit, your port is %d ===", name, clientSocket.getPort()));
        }
        else if (age >= 18){
            out.println(String.format("%s, you wanna smth hot, yeah?) (yes/no)", name));
            String answer = in.readLine();
            if ("yes".equals(answer)){
                out.println(String.format("%s, see pornhub.com, your port is %d", name, clientSocket.getPort()));
            }
            else if ("no".equals(answer)){
                out.println("Oh no! Bye-bye");
            }
            else{
                out.println(String.format("go fuck yourself, %s", name));
            }
        }
        else out.println(String.format("%s, get lost pls, your port is %d. Bye", name, clientSocket.getPort()));

    }

}
