package doublylList;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;


        size = 0;
    }

    /**
     * return size
     */
    public int size() {
        return size;
    }

    /**
     * find node position in a list
     */
    public int findPosition(int data) {
        if (head == null)
            return Integer.MIN_VALUE;
        Node tmp = head;

        int pos = 0;
        while (tmp != null) {
            if (tmp.getData() == data) {
                // return the position if found

                return pos;
            }
            tmp = tmp.getNext();
            pos += 1;

        }
        return Integer.MIN_VALUE;
    }

    /**
     * remove all element from list
     */

    public void clearList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add a node at first
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Add a node of value to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
        size++;

    }

    /**
     * Add a node of value value before the index-th node in the linked list. If
     * index equals to the length of linked list, the node will be appended to the
     * end of linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            int cnt = 0;
            Node curr = head;
            while (cnt < index - 1) {
                cnt++;
                curr = curr.next;
            }
            Node newNode = new Node(val);
            newNode.prev = curr;
            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
            size++;
        }
    }

    /**
     * Delete the index node in the linked list, if the index is valid.
     */
    public void removeAtIndex(int index) {
        if (index < 0 || index > size) {
            return;
        }
        if(index==0)
        	removeHead();
        if(index==size)
		removeTail();

        int cnt = 0;
        Node curr = head;
        while (cnt < index-1) {
            cnt++;
            curr = curr.next;
        }
        Node next = curr.getNext().getNext();
        next.setPrev(curr);
        curr.setNext(next);
        size--;
    }

    /**
     * Remove the head value from the list if list is empty, do nothing
     */
    public int removeHead() {
        if (size == 0)
            return Integer.MIN_VALUE;
        Node curr = head.getNext();
        curr=head;
        head=head.next;
        head.prev=null;
		curr = null;
        size--;
        return head.data;

    }

    /**
     * Remove the tail value from the list if list is empty, do nothing
     */
    public int removeTail() {

        if (size == 0)
            return Integer.MIN_VALUE;
		Node curr = tail;
		tail=tail.prev;
		tail.next=null;
		curr=null;
        size--;
        return tail.getData();

    }

    /**
     * Return list in string form
     */
    public String toString() {
        String result = "[]";
        if (size == 0)
            return result;
        result = "[";
        Node tmp = head;
        while (tmp != null) {
            result += tmp.getData();
            if (tmp.next != null) {
                result += ",";
            }
            tmp = tmp.getNext();
        }
        return result + "]";

    }

}
