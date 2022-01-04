public class MainClient {
    public static void main(String[] args) {
        System.out.println("client");
        Client client = new Client(4444);
        client.Connection();
    }
}