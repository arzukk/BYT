package Byt5.Mediator;
import lombok.*;

@AllArgsConstructor
abstract class Client {
    protected IMediator iMediator;
    protected String name;

    public abstract void send(String message);

    public abstract void receive(String message);
}

