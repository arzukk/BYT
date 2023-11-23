package Byt5.Mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator implements IMediator {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void sendMessage(String message, Client client) {
        for (Client cli : clients) {
            if (cli != client) {
                cli.receive(message);
            }
        }
    }
}
