/**
 * l001basic
 */
import java.io.*;
import java.util.*;
public class l001basic {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        // size of the linkedlist
        public int size(){
            return size;
        }

        // add the node to last
        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        // display a linkedlist
        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data + " ");
            }
        }

    }

    public static void main(String[] args) {
        
    }
}