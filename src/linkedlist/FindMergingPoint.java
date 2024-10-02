package linkedlist;

// program to find the merging point of two linked lists
public class FindMergingPoint {

	// calculate length difference of lists and iterate on longer list with
	// till the difference. iterate both of them together and stop at
	// matching node
	public static void Solution1(LinkedList list1, LinkedList list2) {
		int length1 = 0;
		int length2 = 0;
		ListNode temp1 = list1.head;
		ListNode temp2 = list2.head;
		while (temp1 != null) {
			temp1 = temp1.next;
			length1++;
		}
		while (temp2 != null) {
			temp2 = temp2.next;
			length2++;
		}

		int difference = length1 - length2;
		temp1 = list1.head;
		temp2 = list2.head;
		if (difference > 0) {
			while (difference != 0) {
				difference--;
				temp1 = temp1.next;
			}
		} else if (difference < 0) {
			while (difference != 0) {
				difference++;
				temp2 = temp2.next;
			}
		}

		while (temp1 != null && temp2 != null) {
			if (temp1 == temp2) {
				System.out.println("Merge at : " + temp1.data);
				return;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		System.out.println("Non Merging lists");
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(3);
		list1.insertAtEnd(4);
		list1.insertAtEnd(5);

		ListNode thirdNodeOfList1 = null;
		ListNode temp = list1.head;
		int i = 0;
		while (i < 3 && temp.next != null) {
			temp = temp.next;
			i++;
		}
		thirdNodeOfList1 = temp;

		LinkedList list2 = new LinkedList();
		list2.insertAtEnd(9);
		list2.insertAtEnd(8);
		temp = list2.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = thirdNodeOfList1;

		System.out.println("List 1 : " + list1.toString());
		System.out.println("List 2 : " + list2.toString());

		// ----- PROBLEM SETUP DONE -----

		Solution1(list1, list2);
	}

}
