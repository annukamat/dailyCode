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

        public void addFirst(int val){
            Node temp = new Node();
            temp.data = val;

            if(size == 0){
                head = tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }
            size++;
        }

        public void addAt(int idx, int val){
            if(idx<0 || idx>size) 
                System.out.println("Invalid Arguments");
            else if(idx==0) addFirst(val);
            else if(idx == size) addLast(val);
            else{
                Node node = new Node();
                node.data = val;

                Node temp = head;

                for(int i=0; i<idx-1; i++){
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;

                size++;
            }

            


        }

        public void removeLast(){
            if(size==0){
                System.out.println("List is empty");
            }else if(size == 1){
                head = tail=null;
                size = 0;
            }else{
                Node temp = head;
            
                for(int i=0; i<size-2; i++){
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;

                size--;
            }
        }

        public void removeAt(int idx){
            if(idx<0 || idx>=size){
                System.out.println("Invalid Arguments");
            }else if(idx==0) removeFirst();
            else if(idx == size-1) removeLast();
            else{
                Node temp = head;
                for(int i=0; i<idx-1; idx++){
                    temp = temp.next;
                }
                Node forw = temp.next;
                temp.next = forw.next;
                forw.next = null;

                size--;
            }
        }

        // reverse a ll data iterative
        public Node getNodeAt(int idx){
            Node temp = head;
            for(int i=0; i<idx; i++){
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI(){
            int li = 0;
            int ri = size-1;

            while(li<ri){
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI(){
            Node cur = head;
            Node prev = null;

            while(cur != null){
                Node forw = cur.next;
                cur.next = prev;
                prev = cur;
                cur = forw;
            }
            // swap head and tail
            Node temp = head;
            head = tail;
            tail = temp;
        }


    }

    public static void main(String[] args) {
        
    }
}