package Byt5.Mediator;

public class ClientConcrete extends Client{

    public ClientConcrete(IMediator iMediator, String name) {
        super(iMediator, name);
    }
        @Override
        public void send(String message) {
            System.out.println(name + "'s message: " + message);
            iMediator.sendMessage(message, this);
        }

        @Override
        public void receive(String message) {
            System.out.println(name + " received a message: " + message);
        }
    }
