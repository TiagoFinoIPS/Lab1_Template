package pt.pa.adts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueueLinkedListTest {

    private Queue<Integer> queue;

    @BeforeEach
        public void setUp() { queue = new QueueLinkedList<>(10); //Implementação tipo A
    }

    @Test
    void enqueue() throws QueueFullException, QueueEmptyException {

        try {
            queue.enqueue(111);
        } catch (QueueFullException E) {
            E.printStackTrace();
        }
        assertEquals(111, queue.front());
        assertEquals(1, queue.size());
    }

    @Test
    void enqueuelistaCheia() throws QueueFullException, QueueEmptyException {

        try {
            queue.enqueue(111);
            queue.enqueue(222);
            queue.enqueue(333);
            queue.enqueue(444);
            queue.enqueue(555);
            queue.enqueue(666);
            queue.enqueue(777);
            queue.enqueue(888);
            queue.enqueue(999);
            queue.enqueue(000);
            assertThrows(QueueFullException.class, () -> queue.enqueue(123));

        } catch (QueueFullException E) {
            E.printStackTrace();
        }

    }

    @Test
    void dequeue() throws QueueFullException, QueueEmptyException {

        try {
            queue.enqueue(111);
            queue.enqueue(222);
            queue.dequeue();
        } catch (QueueEmptyException E) {
            E.printStackTrace();
        }
        assertEquals(222, queue.front());
        assertEquals(1, queue.size());
    }

    @Test
    void dequeueListaVazia() throws QueueEmptyException {


        try {
            queue.dequeue();
        }catch (QueueEmptyException E) {
            E.printStackTrace();
        }
        assertThrows(QueueEmptyException.class, () -> queue.dequeue());

    }

    @Test
    void front() throws QueueFullException, QueueEmptyException {

        queue.enqueue(111);
        queue.enqueue(222);
        queue.enqueue(333);
        assertEquals(111, queue.front());
    }

    @Test
    void frontListaVazia() throws QueueEmptyException {


            assertEquals(true, queue.isEmpty());
            try {
                queue.front();
            }catch (QueueEmptyException E) {
                E.printStackTrace();
            }
            assertThrows(QueueEmptyException.class, () -> queue.dequeue());
    }

    @Test
    void size() throws QueueFullException {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(6, queue.size());
    }

    @Test
    void isEmpty() throws QueueFullException, QueueEmptyException {


        queue.enqueue(111);
        assertEquals(false, queue.isEmpty());
        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    void clear() throws QueueFullException {

        queue.clear();
        assertEquals(0, queue.size());
        assertEquals(true, queue.isEmpty());
    }
}