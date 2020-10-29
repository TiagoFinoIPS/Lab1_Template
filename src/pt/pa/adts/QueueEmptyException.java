package pt.pa.adts;

public class QueueEmptyException extends Throwable {
    public QueueEmptyException() {
        super("Erro: A lista está vazia.");
    }
}
