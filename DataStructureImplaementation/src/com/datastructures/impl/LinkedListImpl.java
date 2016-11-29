package com.datastructures.impl;

import com.datastructures.LinkedList;

/**
 * This is a simple linked list implementation in java.
 * <p/>
 * 
 * @author aryancodify
 *
 */
public class LinkedListImpl implements LinkedList {

  private Element first;
  private int count;

  public LinkedListImpl() {
    this.first = null;
    this.setCount(0);
  }

  @Override
  public Object addElementAtEnd(Object o) throws Exception {
    Element currentElement = null;
    Element newElement = null;
    if (first == null) {
      first = new Element(o, null);
      newElement = first;
    } else {
      currentElement = returnLast(first);
      newElement = new Element(o, null);
      currentElement.setNext(newElement);
    }
    this.count++;
    return newElement.getData();
  }

  @Override
  public Object deleteLast() throws Exception {
    Element previous = returnPreviousToIndex(this.count - 1, this.first);
    Element last = previous.getNext();
    Element lastCopy;
    if (last == null) {
      throw new Exception();
    } else {
      lastCopy = new Element(last.getData(), last.getNext());
      last = null;
      previous.setNext(null);
      this.count--;
    }
    return lastCopy;
  }

  @Override
  public Object getElementAtLocation(int index) throws Exception {
    if (index > this.count - 1) {
      throw new Exception();
    }
    int start = 0;
    Element currentElement = first;
    while (start++ < index) {
      currentElement = currentElement.getNext();
    }
    return currentElement.getData();
  }

  @Override
  public Object deleteAtIndex(int index) throws Exception {
    if (index > this.count - 1) {
      throw new Exception();
    }
    Element previousElement = returnPreviousToIndex(index, this.first);
    Element deletedCopy = null;
    if (previousElement == null) {
      deletedCopy = this.first;
      this.first = this.first.getNext();
    } else {
      Element toBeDeleted = previousElement.getNext();
      deletedCopy = new Element(toBeDeleted.getData(), toBeDeleted.getNext());
      previousElement.setNext(toBeDeleted.getNext());
      toBeDeleted = null;
    }
    this.count--;
    return deletedCopy.getData();
  }

  @Override
  public int getSize() {
    return this.count;
  }

  @Override
  public void printList() throws Exception {
    if (first == null) {
      throw new Exception();
    }
    int index = 0;
    Element currentElement = first;
    while (currentElement != null) {
      System.out.println("Index: " + index + ", Data: " + currentElement.getData().toString());
      currentElement = currentElement.getNext();
      index++;
    }
  }

  private static Element returnLast(Element first) {
    if (first == null) {
      return null;
    }
    while (first.getNext() != null) {
      first = first.getNext();
    }
    return first;
  }

  private static Element returnPreviousToIndex(int index, Element first) {
    if (index == 0)
      return null;
    int start = 1;
    Element previousElement = first;
    while (start++ < index) {
      previousElement = previousElement.getNext();
    }
    return previousElement;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public static class Element {
    private Object data;
    private Element next;

    public Object getData() {
      return data;
    }

    public void setData(Object data) {
      this.data = data;
    }

    public Element getNext() {
      return next;
    }

    public void setNext(Element next) {
      this.next = next;
    }

    public Element(Object data, Element next) {
      super();
      this.data = data;
      this.next = next;
    }

  }

  @Override
  public Object addElementAtIndex(Object o, int index) throws Exception {
    if (index > this.count - 1) {
      throw new Exception();
    }
    Element previousElement = returnPreviousToIndex(index, this.first);
    Element toBeDisplaced = previousElement.getNext();
    Element newElement = new Element(o, toBeDisplaced);
    previousElement.setNext(newElement);
    this.count++;
    return newElement.getData();
  }

}
