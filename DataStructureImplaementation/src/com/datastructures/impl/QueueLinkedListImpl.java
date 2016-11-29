package com.datastructures.impl;

import com.datastructures.LinkedList;
import com.datastructures.Queue;

public class QueueLinkedListImpl implements Queue {

  private LinkedList linkedList = new LinkedListImpl();
  
  @Override
  public boolean enqueue(Object o) throws Exception {
    return (linkedList.addElementAtEnd(o)==null)?false:true;
  }

  @Override
  public Object dequeue() throws Exception {
    return linkedList.deleteAtIndex(0);
  }

  @Override
  public int size() {
    return linkedList.getSize();
  }

  @Override
  public Object front() throws Exception {
    return linkedList.getElementAtLocation(0);
  }

  @Override
  public boolean isEmpty() {
    return linkedList.getSize()==0?true:false;
  }

  @Override
  public void print() throws Exception {
    linkedList.printList();
  }

}
