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

        public int kthFromLast(int k){
            Node fast = head, slow = head;

            for(int i=0; i<k; i++){
                fast = fast.next;
            }
            while(fast != tail){
                fast = fast.next;
                slow = slow.next;
            }
            return slow.data;
        }

        public int mid(){
            Node slow=head, fast=head;

            while(fast!=null || fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        public LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2){
            Node c1 = l1.head;
            Node c2 = l2.head;
            LinkedList dummy = new LinkedList();

            while (c1!=null && c2!=null){
                if(c1.data < c2.data){
                    dummy.addLast(c1.data);
                    c1=c1.next;
                }else{
                    dummy.addLast(c2.data);
                    c2=c2.next;
                }
            }

            while(c1!=null){
                dummy.addLast(c1.data);
                c1=c1.next;
            }
            while(c2!=null){
                dummy.addLast(c2.data);
                c2=c2.next;
            }
            return dummy;
        }

        // merge sort of a linked list:
        public Node midNode(Node head, Node tail){
            Node f = head, s = head;

            while(f != tail && f.next != tail){
                f = f.next.next;
                s = s.next;
            }
            return s;
        }
        public LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList bl = new LinkedList();
                bl.addLast(head.data);
                return bl;
            }
            Node mid = midNode(head, tail);
            LinkedList one = mergeSort(head, mid);
            LinkedList two = mergeSort(mid.next, tail);

            return mergeTwoSortedLists(one, two);
        }

        // remove duplicates in a sorted linked list
        public void removeDuplicates(){
            LinkedList res = new LinkedList();

            while(this.size() > 0){
                int val = this.getFirst();
                this.removeFirst();

                if(res.size()==0 || val!=res.tail.data){
                    res.addLast(val);
                }
            }
            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }

        public int length(LinkedList node){
            Node cur = head;
            int len = 0;
            while(cur != null){
                cur = cur.next;
                len++;
            }
            return len;
        }

        public void kReverse(int k){
            Node oh = null, ot = null, th = null, tt = null;
            Node cur = head;

            int len = size;
            while(cur != null){

            }
        }

    }

    public static void main(String[] args) {
        
    }
}