
public class questions {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/987683011/
    ListNode th = null, tt = null;
    public int length(ListNode node){
        ListNode cur = node;
        int len = 0;
        while(cur!=null){
            cur = cur.next;
            len++;
        }
        return len;
    }
    public void addFirst(ListNode node){
        if(th==null){
            th=node;
            tt=node;
        }else{
            node.next=th;
            th=node;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;

        int len = length(head);
        ListNode oh = null, ot = null;
        ListNode cur = head;
        while(len >= k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode forw = cur.next;
                cur.next = null;
                addFirst(cur);
                cur=forw;
            }

            if(oh==null){
                oh=th;
                oh=tt;
            }else{
                ot.next=th;
                ot=tt;
            }
            th=tt=null;
            len-=k;
        }
        ot.next=cur;
        return oh;
    }

    public static void main(String[] args) {
        
    }
    
}
