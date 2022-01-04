import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection extends Thread{

    private Socket soket;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ClientConnection(Socket soket) throws IOException {
        this.soket = soket;
        objectInputStream = new ObjectInputStream(this.soket.getInputStream());
        objectOutputStream = new ObjectOutputStream(this.soket.getOutputStream());
        System.out.println(this.soket.toString());
        start();
    }

    public void run() {
        try {
            while (true) {
                System.out.print("Client: ");
                String clientMessage = (String) objectInputStream.readObject();
                System.out.println(clientMessage);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            System.out.println("Send to: " + this.soket.toString());
            System.out.println(message);
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}