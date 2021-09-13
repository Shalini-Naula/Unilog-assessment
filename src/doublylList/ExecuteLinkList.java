package doublylList;

public class ExecuteLinkList {

	/** Initialize your data structure here. */
	Node head;
	Node tail;
	int size;

	public static void main(String args[]) {
		MyLinkedList list = new MyLinkedList();
		//out put after all add method [10,50,80,5,20]
		list.addAtIndex(0,5);
		System.out.println(list);
		list.addAtHead(10);
		System.out.println(list);
		list.addAtTail(20);
		System.out.println(list);
		list.addAtIndex(1,50);
		System.out.println(list);
		list.addAtIndex(2, 80);

		list.toString();
		System.out.println(list);

		// output after all remove method [50,80]
		list.removeHead();
		System.out.println(list);
		list.removeAtIndex(2);
		System.out.println(list);
		list.removeTail();
		System.out.println(list);

		// output for position 80 is 1
		System.out.println(list.findPosition(80));
		
		
	}
}