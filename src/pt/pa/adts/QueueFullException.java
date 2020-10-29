package pt.pa.adts;

public class QueueFullException extends Throwable {
    public QueueFullException() {
        super("Erro: A lista está cheia.");
    }
}
