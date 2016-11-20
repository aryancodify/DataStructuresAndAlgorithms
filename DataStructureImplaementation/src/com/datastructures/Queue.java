package com.datastructures;

public interface Queue {
  public boolean enqueue(Object o);
  public Object dequeue();
  public int size();
  public Object front();
  public boolean isEmpty();
  public void print();
}
