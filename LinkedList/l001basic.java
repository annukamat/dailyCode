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

        // size of the linkedlist
        public int size(){
            return size;
        }

        // display a linkedlist
        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data + " ");
            }
        }

        // remove first from linkedlist
        public void removeFirst(){
            if(size == 0) System.out.println("List is empty");
            else if(size == 1){
                head = tail = null;
                size--;
            }else{
                head = head.next;
                size--;
            }
        }

        public int getFirst(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else return head.data;
        }

        public int getLast(){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else return tail.data;
        }

        public int getAt(int idx){
            if(size == 0){
                System.out.println("List is empty");
                return -1;
            }else if(idx<0 || idx>=size){
                System.out.println("Invalid argument");
                return -1;
            }else {
                Node temp = head;
                for(int i=0; i<idx; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }

    }

    public static void main(String[] args) {
        
    }
}