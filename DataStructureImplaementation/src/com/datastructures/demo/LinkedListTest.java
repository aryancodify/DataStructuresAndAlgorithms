package com.datastructures.demo;

import com.datastructures.LinkedList;
import com.datastructures.impl.LinkedListImpl;

public class LinkedListTest {
  public static void main(String[] args) throws Exception {
    LinkedList myList = new LinkedListImpl();
    myList.addElementAtEnd("1");
    myList.addElementAtEnd("2");
    myList.addElementAtEnd("3");
    myList.addElementAtEnd("4");
    myList.addElementAtEnd("5");
    
    //System.out.println("Linked List Size: "+ myList.getSize());
    // myList.printList();
    //myList.deleteAtIndex(2);
    //myList.printList();
    System.out.println(myList.getElementAtLocation(2));
    myList.addElementAtIndex("6", 2);
    myList.printList();
    myList.deleteLast();
    myList.printList();
  }
}
