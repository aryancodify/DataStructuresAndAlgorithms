package com.datastructures;

public interface Queue {
  public boolean enqueue(Object o) throws Exception;
  public Object dequeue() throws Exception;
  public int size();
  public Object front() throws Exception;
  public boolean isEmpty();
  public void print() throws Exception;
}
