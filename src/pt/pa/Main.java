package pt.pa;

import pt.pa.adts.Queue;
import pt.pa.adts.QueueEmptyException;
import pt.pa.adts.QueueFullException;
import pt.pa.adts.QueueLinkedList;

public class Main {

    public static void main(String[] args) throws QueueEmptyException, QueueFullException {

        Queue<Integer> queue = new QueueLinkedList<>(10); //Implementação tipo A


        //Problema: Fila de espera
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.print("Front:");
        System.out.println(" " + queue.front());

        queue.dequeue();
        System.out.print("Front:");
        System.out.println(" " + queue.front());

        System.out.println("Elemento 4 foi adicionado à lista");
        queue.enqueue(4);

        queue.dequeue();
        System.out.print("Front:");
        System.out.println(" " + queue.front());

        System.out.print("Size:");
        System.out.println(" " + queue.size());




    }
}
