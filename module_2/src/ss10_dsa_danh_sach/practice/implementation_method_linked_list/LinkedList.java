package ss10_dsa_danh_sach.practice.implementation_method_linked_list;

public class LinkedList<E> {
    private Node head;
    private int numNodes;
    private Node tail;

    public LinkedList() {
    }

    public LinkedList(Object element) {
        head = new Node(element);
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        if (tail == head) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        numNodes++;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= numNodes) {
            addLast(element);
        } else {
            Node temp = head;
        }
    }

    public E removeFirst() {
        if (numNodes == 0) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null) {
                tail = null;
            }
            return (E) temp.data;
        }
    }

    public E removeLast() {
        if (numNodes == 0) {
            return null;
        } else if (numNodes == 1) {
            Node temp = head;
            head = tail = null;
            numNodes = 0;
            return (E) temp.data;
        } else {
            Node current = head;
            for (int i = 0; i < numNodes - 2; i++) {
                current = current.next;
            }
            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == numNodes - 1) {
            return removeLast();
        } else {
            Node previous = head;
            for (int i = 0; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            numNodes--;
            return (E) current.data;
        }
    }

    public boolean remove(Object element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public E clone() {
        if (numNodes == 0) {
            throw new NullPointerException();
        }
        LinkedList<E> temp = new LinkedList<E>();
        Node tempNode = head;
        temp.addFirst((E) tempNode.data);
        tempNode = tempNode.next;
        while (tempNode != null) {
            temp.addLast((E) tempNode.data);
            tempNode = tempNode.next;
        }
        return (E) temp;
    }

    public boolean contains(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        if (temp.data.equals(element)) {
            return true;
        }
        return false;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        return (E) head;
    }

    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    class Node {
        private Node next;
        public Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
}
