// Yihan Wang
// ID: 202054602
// email: Y.Wang437@lse.ac.uk

public class SortedDoublyLinkedList {
    private Item start = null;
    private Item last = null;

    private class Item {
        int value;
        Item next;
        Item prev;
    }


    public void insert(int x) {
        if (start == null) {
            start = new Item();
            start.value = x;
            start.next = null;
            start.prev = null;
            last = start;
        }
        else {
            Item temp = start;
            while (temp.value < x && temp != last) {
                temp = temp.next;
            }

            if (temp == start && temp.value >= x) {
                start.prev = new Item();
                start.prev.value = x;
                start.prev.next = temp;
                start = start.prev;
                return;
            }

            if (temp == last && temp.value < x) {
                temp.next = new Item();
                temp.next.value = x;
                temp.next.prev = temp;
                temp.next.next = null;
                last = temp.next;
                return;
            }

            Item newItem = new Item();
            newItem.value = x;
            newItem.prev = temp.prev;
            temp.prev.next = newItem;
            newItem.next = temp;
            temp.prev = newItem;
        }
    }

    public void delete(int x) {
        Item temp = start;

        if (start == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (start == last && start.value == x && last.value == x) {
            start = null;
            last = null;
            return;
        }

        while (temp != null && temp.value != x) {
            temp = temp.next;
        }

        if (temp == start) {
            start = temp.next;
            start.prev = null;
            if (start.value == x) {
                delete(x);
            }
            return;
        }

        if (temp == last) {
            temp.prev.next = null;
            last = temp.prev;
            if (last.value == x) {
                delete(x);
            }
            return;
        }

        if (temp == null) {
            System.out.println("cannot find the item with value of " + x);
            return;
        }

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        if (temp.next.value == x) {
            delete(x);
        }
    }

    public String toString() {
        String s = "null";
        for (SortedDoublyLinkedList.Item e = start; e != null; e = e.next) {
            if (e != null && e.prev != null && e.next != null) {
                s += e.value + " <-> ";
            }
            else if (e != null && e.prev == null && e.next != null) {
                s += " <- " + e.value + " <-> ";
            }
            else if (e != null && e.prev != null && e.next == null) {
                s += e.value + " -> null";
            }
            else if (e != null && e.prev == null && e.next == null) {
                s += " <- " + e.value + " -> null";
            }
        }
        return s;
    }

    public String reverseString() {
        String s = "null";
        for (SortedDoublyLinkedList.Item e = last; e != null; e = e.prev) {
            if (e != null && e.prev != null && e.next != null) {
                s += " <-> " + e.value;
            }
            else if (e != null && e.prev == null && e.next != null) {
                s += " <-> " + e.value + " -> null";
            }
            else if (e != null && e.prev != null && e.next == null) {
                s += " <- " + e.value;
            }
            else if (e != null && e.prev == null && e.next == null) {
                s += " <- " + e.value + " -> null";
            }
        }
        return s;
    }

    public static void main(String[] args) {
        SortedDoublyLinkedList List = new SortedDoublyLinkedList();
        for (int i = 0; i < args.length; i++) {
            int x = Integer.parseInt(args[i]);
            if (x > 0) {
                System.out.println("insert " + x);
                List.insert(x);
            }
            else if (x < 0) {
                System.out.println("delete " + -x);
                List.delete(-x);
            }
            else if (x == 0) {
                System.out.println(List.toString());
                System.out.println(List.reverseString());
            }
        }
    }
}
