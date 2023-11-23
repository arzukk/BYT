package Byt5.Mediator;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        ClientConcrete client = new ClientConcrete(mediator, "client");
        ClientConcrete client1 = new ClientConcrete(mediator, "client1");
        ClientConcrete client2 = new ClientConcrete(mediator, "client2");
        ClientConcrete client3 = new ClientConcrete(mediator, "client3");

        mediator.addClient(client);
        mediator.addClient(client1);
        mediator.addClient(client2);
        mediator.addClient(client3);

        client.send("client speaking");
        client1.send("client1 speaking");
        client2.send("client2 speaking");
        client3.send("client3 speaking");


    }
}
