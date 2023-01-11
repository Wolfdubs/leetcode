import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PalindromeProblems {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5; node5.next = node6;
        isSinglyLinkedListAPalindrome(node1);  //list = 1 2 3 4 5 6
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(1);
        node3.next = node7; node7.next = node8; node8.next = node9;
        isSinglyLinkedListAPalindrome(node1);  //list = 1 2 3 3 2 1




        LinkedList<ListNode> nodeList = new LinkedList<>();

    }

    public static class ListNode{
        int value;
        ListNode next;
        ListNode(int value) {this.value=value;}
    }

    //have 2 pointers start at the head (singly linked list cannot access tail)
    //2nd pointer traverses nodes 2x as fast as 1st pointer
    //once 2nd pointer reaches the end, 1st pointer will be halfway
    //reverse the right half
    //reset 2nd pointer to head
    // iterate both pointers at same speed
    // if every node matches, its a palindrome. else is not
    public static boolean isSinglyLinkedListAPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseLinkedListFromHead(slow);
        fast = head;

        while (slow.next != null) {
            if (slow.value != fast.value) {
                System.out.println("LinkedList is not a palindrome");
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("LinkedList is a palindrome");
        return true;
    }


    public static ListNode reverseLinkedListFromHead(ListNode head) {
        ListNode previous = null;
        while (head!=null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }


    public static boolean isIntAPalindrime(int n) {


    }



}
