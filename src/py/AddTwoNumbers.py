"""
Description

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        sentinel = current = ListNode()
        carry = 0
        while l1 is not None and l2 is not None:
            total = carry + l1.val + l2.val
            current.next = ListNode(total % 10)
            current = current.next
            carry = total // 10
            l1 = l1.next
            l2 = l2.next
        remain = l1 or l2
        while remain is not None:
            total = carry + remain.val
            current.next = ListNode(total % 10)
            current = current.next
            carry = total // 10
            remain = remain.next
        if carry > 0:
            current.next = ListNode(carry)
        return sentinel.next
            