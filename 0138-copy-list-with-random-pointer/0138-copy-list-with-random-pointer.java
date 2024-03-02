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
    public Node copyRandomList(Node head) {
        //brute force
        HashMap<Node,Node> hm = new HashMap<>();
        Node temp = head;
        
        //first iteration for inserting deep nodes of every node in the hashmap.    
        while(temp != null){
            Node newNode = new Node(temp.val);
            hm.put(temp,newNode);
            temp = temp.next;
        }
        Node t = head;
        
        //second iteration for linking next and random pointer as given question.
        while(t != null){
            Node node = hm.get(t);
            node.next = (t.next != null) ? hm.get(t.next) : null;
            node.random = (t.random != null) ? hm.get(t.random) : null;
            t = t.next;
        }
        return hm.get(head);
    }
}