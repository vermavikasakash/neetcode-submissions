class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode sorted = null;

        for (ListNode list : lists) {
            sorted = merge(sorted, list);
        }

        return sorted;
    }

    private ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        // Append remaining nodes
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}