package com.datastructures;

public interface LinkedList {

  Object addElementAtEnd(Object o) throws Exception;

  Object getElementAtLocation(int index) throws Exception;

  Object deleteAtIndex(int index) throws Exception;

  Object addElementAtIndex(Object o, int index) throws Exception;

  Object deleteLast() throws Exception;

  int getSize();

  void printList() throws Exception;

}
