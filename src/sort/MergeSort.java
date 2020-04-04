package sort;

/**
 * @Author: xizhong
 * @Date: 2020-4-5 02:10
 */
public class MergeSort {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);

        head.toPrint();

        System.out.println();

        MergeSort m = new MergeSort();
        m.mergeSort(head).toPrint();
    }

    public  Node mergeSort(Node head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node minHead = findMiddle(head);
        return merge(mergeSort(head),mergeSort(minHead));
    }

    private Node merge(Node p, Node q){

        Node dummy = new Node(-1);
        Node result =  dummy;
        while (p!=null && q!=null){
            if(p.data < q.data){
                result.next = p;
                p = p.next;
            }else{
                result.next = q;
                q = q.next;
            }
            result = result.next;
        }
        if(p != null){
            result.next = p;
        }
        if(q != null){
            result.next = q;
        }

        return dummy.next;
    }

    private Node findMiddle(Node head){
        Node first = head;
        Node tail = head;
        while( first.next != null && first.next.next != null ){
            first = first.next.next;
            tail = tail.next;
        }
        head = tail;
        Node minHead = tail.next;
        tail.next = null;
        return minHead;
    }


    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data ;
        }

        void toPrint(){
            Node p = this;
            while (p!=null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
        }
    }

}
