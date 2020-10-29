package pt.pa.adts;

/**
 * Esta classe trata-se de um algoritmo FIFO que recorre a um trailer e um header. <br>
 * Esta contém todas as funcionalidades de uma linked list como métodos. <br>
 *
 * @param <T> O tipo de elemento da lista
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;
    private int capacity;

    public QueueLinkedList(int capacity) {

        this.trailer = new Node(null, null, null);
        this.header = new Node(null, null, this.trailer);
        this.trailer.prev = this.header;
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Este método existe para colocar novos elementos no fim da lista
     * Se não houver mais memória disponível é lançada uma excepção
     * Complexidade: O(1)
     * @param e  Elemento a ser adicionado á lista
     */
    @Override
    public void enqueue(T e) throws QueueFullException {

        try {

            if(size+1 > capacity) throw new QueueFullException();

            Node prev = trailer.prev;

            Node newNode = new Node(e, prev, trailer);

            prev.next = newNode;

            trailer.prev = newNode;

            size++;

        }catch (Exception E)
        {
            throw new QueueFullException();
        }
    }

    /**
     * Este método existe para remover elementos do ínicio da lista
     * Se a lista estiver vazia é lançada uma excepção
     * Complexidade: O(1)
     * @return      O elemento removido da lista
     */
    @Override
    public T dequeue() throws QueueEmptyException {

        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        else {
            Node n = header.next; //Guardar o node a ser retirado
            header.next = n.next; //Junta o header ao seguinte na lista para remover o "Front"
            header.next.prev = header; //Junta o "Front" ao header novamente
            size--;

            return n.element;
        }
    }

    /**
     * Este método existe para retornar o elemento no ínicio da lista
     * Se a lista estiver vazia é lançada uma excepção
     * Complexidade: O(1)
     * @return      O elemento na frente da lista
     */
    @Override
    public T front() throws QueueEmptyException {

        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        else {
            return header.next.element;
        }

    }

    /**
     * Este método existe para retornar o número de elementos na lista
     * Complexidade: O(1)
     * @return      O número de elementos na lista
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Este método verifica se a lista se encontra vazia ou não
     * Complexidade: O(1)
     * @return      Retorna true se a lista estiver vazia e false se tiver elementos
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Este método existe para limpar todos os elementos da lista
     * Complexidade: O(1)
     */
    @Override
    public void clear() {

        trailer.next = header;
        header.prev = trailer;
        size = 0;


    }

    /**
     * Esta classe interna define os Nodulos que fazem parte da lista da classe. <br>
     */
    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
