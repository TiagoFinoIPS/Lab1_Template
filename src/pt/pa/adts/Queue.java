package pt.pa.adts;

/**
 * TODO: Fornecer documentação da interface.
 *
 * @param <T>
 */
public interface Queue<T> {


    /**
     * Este método existe para colocar novos elementos no fim da lista
     * Se não houver mais memória disponível é lançada uma excepção
     * Complexidade: O(1)
     * @param e  Elemento a ser adicionado á lista
     */
    void enqueue(T e) throws QueueFullException;

    /**
     * Este método existe para remover elementos do ínicio da lista
     * Se a lista estiver vazia é lançada uma excepção
     * Complexidade: O(1)
     * @return      O elemento removido da lista
     */
    T dequeue() throws QueueEmptyException;

    /**
     * Este método existe para retornar o elemento no ínicio da lista
     * Se a lista estiver vazia é lançada uma excepção
     * Complexidade: O(1)
     * @return      O elemento na frente da lista
     */
    T front() throws QueueEmptyException;

    /**
     * Este método existe para retornar o número de elementos na lista
     * Complexidade: O(1)
     * @return      O número de elementos na lista
     */
    int size();

    /**
     * Este método verifica se a lista se encontra vazia ou não
     * Complexidade: O(1)
     * @return      Retorna true se a lista estiver vazia e false se tiver elementos
     */
    boolean isEmpty();

    /**
     * Este método existe para limpar todos os elementos da lista
     * Complexidade: O(1)
     */
    void clear();

}
