package com.datastructures.impl;

import com.datastructures.Queue;

public class QueueImpl implements Queue {

  private Object[] queueArray;
  private int front;
  private int rear;


  public QueueImpl() {
    queueArray = null;
    front = -1;
    rear = -1;
  }

  @Override
  public boolean enqueue(Object o) {
    if (queueArray == null) {
      queueArray = new Object[2];
      front = 0;
      rear = 1;
      queueArray[front] = o;
      return true;
    } else if (size() == (queueArray.length - 1)) {
      growQueue();
    }
    queueArray[rear] = o;
    rear = (rear + 1) % queueArray.length;
    return true;
  }

  @Override
  public Object dequeue() {
    Object copy = queueArray[front];
    queueArray[front] = null;
    front = (front + 1) % queueArray.length;
    return copy;
  }

  @Override
  public int size() {
    return queueArray != null ? (queueArray.length - front + rear) % queueArray.length : 0;
  }

  @Override
  public Object front() {
    return queueArray[front];
  }

  @Override
  public boolean isEmpty() {
    if (front == rear) {
      return true;
    }
    return false;
  }

  private void growQueue() {
    Object[] newQueueArray = new Object[queueArray.length * 2];
    if (rear > front) {
      for (int i = front, j = 0; i < rear; i++, j++) {
        newQueueArray[j] = queueArray[i];
      }
    } else {
      int j = 0;
      for (int i = front; i < queueArray.length; i++, j++) {
        newQueueArray[j] = queueArray[i];
      }
      for (int i = 0; i < rear; i++, j++) {
        newQueueArray[j] = queueArray[i];
      }
    }
    queueArray = newQueueArray;
  }

  @Override
  public void print() {
    if (rear > front) {
      for (int i = front, j = 0; i < rear; i++, j++) {
        System.out.println("position: " + j + ", member: " + queueArray[i]);
      }
    } else {
      int j = 0;
      for (int i = front; i < queueArray.length; i++, j++) {
        System.out.println("position: " + j + ", member: " + queueArray[i]);
      }
      for (int i = 0; i < rear; i++, j++) {
        System.out.println("position: " + j + ", member: " + queueArray[i]);
      }
    }
  }
}
