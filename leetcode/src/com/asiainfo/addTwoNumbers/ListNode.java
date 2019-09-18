package com.asiainfo.addTwoNumbers;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = solution.addTwoNumbers(l1, l2);
		System.out.println(l3.val);
		System.out.println(l3.next.val);
		System.out.println(l3.next.next.val);
	}
}

/**
 * 输入 （2 -> 4 ->3）+ （5 -> 6 ->4）
 * 输出 （7 -> 0 ->8）
 * 原因 342+465 = 807
 * @author yl_bu
 *
 */
class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode currListNode  = new ListNode(0);
		//ListNode l1 = l1;
		//ListNode l2 = l2;
		ListNode curr = currListNode;
		int flag = 0;
		while (l1 != null || l2 != null) {
			int x = null != l1 ? l1.val : 0;
			int y = null != l2 ? l2.val : 0;
			//System.out.println("x" + x);
			//System.out.println("y" + y);
			int val = x+ y + flag;
			if (val >= 10) {
				val = val - 10;
				flag = 1;
			}else {
				flag = 0;
			}
			curr.next = new ListNode(val);
			curr = curr.next;
			//currListNode.val = val;
			//System.out.println(currListNode.val);
			//currListNode.next = new ListNode(0);
			//currListNode = currListNode.next;
			if (null != l1) {
				l1 = l1.next;
			}
			if (null != l2) {
				l2 = l2.next;
			}
		}
		if (flag > 0) {
			curr.next = new ListNode(flag);
		}
		return currListNode.next;
	}
}
