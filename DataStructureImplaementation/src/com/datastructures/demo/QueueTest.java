package com.datastructures.demo;

import com.datastructures.Queue;
import com.datastructures.impl.QueueImpl;

public class QueueTest {

  public static void main(String[] args) {
    Queue myQueue = new QueueImpl();
    myQueue.enqueue("1");
    myQueue.enqueue("2");
    myQueue.enqueue("3");
    myQueue.enqueue("4");
    myQueue.enqueue("5");
    myQueue.print();
    myQueue.dequeue();
    System.out.println("Post Dequeue");
    myQueue.print();
    System.out.println("Front: "+myQueue.front()+" Size: "+myQueue.size()+", isEmpty: "+ myQueue.isEmpty());
    System.out.println("Post Enque");
    myQueue.enqueue("6");
    myQueue.print();
  }

}
