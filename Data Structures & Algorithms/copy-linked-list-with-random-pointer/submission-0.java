/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void insertInBetween(Node head){
        Node temp = head;
        while(temp!=null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }
    }

    public void connectRandom(Node head){
        Node temp = head;
        while(temp!=null){
            Node copy = temp.next;

            if(temp.random!=null){
                copy.random = temp.random.next;
            }else{
                copy.random = null;
            }
            

            temp = copy.next;
        }
        
    }

    public Node connectNext(Node head){
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp = head;
        while(temp!=null){
            Node copy = temp.next;
           res.next = copy;
           temp.next = copy.next;

           
           temp = temp.next;
           res = res.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;

        insertInBetween(head);
        connectRandom(head);
        return connectNext(head);
    }
}
