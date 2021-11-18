// Yihan Wang
// ID: 202054602
// email: Y.Wang437@lse.ac.uk

public class Queue {

    private Queue.Item tail = null;
    private Queue.Item start = null;

    private class Item {
        int value;
        Queue.Item next;
    }

    public void enqueue(int x) {
        Item newItem = new Item();
        newItem.value = x;
        newItem.next = null;
        if (start == null) {
            start = newItem;
        }
        else {
            tail.next = newItem;
        }
        tail = newItem;
    }

    public int dequeue() {
        if (start == null) {
            return -1;
        }
        else {
            int x = start.value;
            start = start.next;
            return x;
        }
    }

    public String toString() {
        String s = "";
        for (Queue.Item e = start; e != null; e = e.next) {
            s += e.value + " -> ";
        }
        s += "null";
        return s;
    }


    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < args.length; i++) {
            int x = Integer.parseInt(args[i]);
            if (x > 0) {
                System.out.println("enqueue " + x);
                queue.enqueue(x);
            }
            else if (x < 0) {
                x = queue.dequeue();
                if (x < 0)
                    System.out.println("dequeue not possible: queue empty");
                else
                    System.out.println("dequeue " + x);
            }
            else { // x==0
                System.out.println(queue.toString());
            }
        }
    }
}
