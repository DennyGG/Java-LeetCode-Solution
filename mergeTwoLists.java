package testLeet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 */
public class mergeTwoLists {
	public static void main(String[] args) {
		mergeTwoLists mtl = new mergeTwoLists();
		mtl.doit();
	}

//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public void doit() {
//		ListNode list1 = new ListNode(1);
		ListNode list1 = null;
		list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		System.out.println(list1.next.next.next == null);
		showListNode(list1);
		// [1,2,4]
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		showListNode(list2);
		// [1,3,4]
//		showListNode(arrayToListNode(new int[] {4,5,6,7,8}));

//		this.mergeTwoLists1(list1, list2);
//		showListNode(this.mergeTwoLists1(list1, list2));
//		showListNode(this.mergeTwoLists2(list1, list2));
		System.out.println("mergeTwoLists3 [1,2,4] [1,3,4]");
		showListNode(this.mergeTwoLists3(list1, list2));
		System.out.println();
		System.out.println("mergeTwoLists3 {1,1,2,7,8} {1,2,3,4,9}");
		ListNode list4 = arrayToListNode(new int[] {1,1,2,7,8});
		ListNode list5 = arrayToListNode(new int[] {1,2,3,4,9});
		showListNode(this.mergeTwoLists3(list4, list5));
	}

	public void showListNode(ListNode list) {
		ListNode temp = list;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public ListNode arrayToListNode(int[] intArray) {
		ListNode listNode = new ListNode(intArray[0]);
		ListNode temp1 = listNode;
		for (int i = 1; i < intArray.length; i++) {
			ListNode temp2 = new ListNode(intArray[i]);
			temp1.next = temp2;
			temp1 = temp2;
		}
		return listNode;
	}

	public ListNode arrayListToListNode(List<Integer> intList) {
		ListNode listNode = new ListNode(intList.get(0));
		ListNode temp1 = listNode;
		for (int i = 1; i < intList.size(); i++) {
			ListNode temp2 = new ListNode(intList.get(i));
			temp1.next = temp2;
			temp1 = temp2;
		}
		return listNode;
	}

	public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		List<Integer> arrayList = new ArrayList<>();
		while (list1 != null) {
			arrayList.add(list1.val);
			list1 = list1.next;
		}
		while (list2 != null) {
			arrayList.add(list2.val);
			list2 = list2.next;
		}
		System.out.println(arrayList);
		Collections.sort(arrayList, Comparator.naturalOrder());
		return this.arrayListToListNode(arrayList);
	}

	//遞迴
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}
	public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		ListNode head = null;
		ListNode next = null;
		System.out.println();
		System.out.println("first head");
		showListNode(head);
		//1,2,3   2,6,8
		int i = 0;
		while(list1 != null || list2 != null) {
			ListNode smaller = null;
			if(list1==null) {
				smaller = list2;
			}else {
				if(list2==null) {
					smaller = list1;
				}else {
					if(list1.val<list2.val) {
						smaller = list1;
					}else {
						smaller = list2;
					}
				}
			}
			if(i == 0) {
				head = smaller;
				System.out.println();
				System.out.println("i ==0 head");
				showListNode(head);
			}else {
				next.next = smaller;
			}
			if(smaller == list1)list1 = list1.next;
			if(smaller == list2)list2 = list2.next;
			
			next = smaller;
			System.out.println();
			System.out.println("head");
			showListNode(head);
			System.out.println();
			System.out.println("next");
			showListNode(next);
			System.out.println();
			System.out.println("smaller");
			showListNode(smaller);
			System.out.println();
			i++;
		}
		return head;
	}
}
