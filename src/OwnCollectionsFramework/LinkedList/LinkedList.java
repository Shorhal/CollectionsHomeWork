package OwnCollectionsFramework.LinkedList;

import OwnCollectionsFramework.ArrayList.ArrayList;
import OwnCollectionsFramework.CollectionList;

import java.util.Comparator;

public class LinkedList<Item> extends CollectionList<Item> {
    protected Node<Item> head;
    protected Node<Item> tail;
    public int size;
    private Node<Item> current = head;



    public Item getCurrent() {
        return current.value;
    }


    public boolean hasNext() {
        return current.next != null;
    }

    public boolean hasPrev() {
        return current.previous != null;
    }


    public LinkedList() {
        this.head = new Node<>();
        tail = new Node<>();
        tail.previous = this.head;
        this.head.next = this.tail;
        this.size++;
    }

    public LinkedList(Item ... items) {
        for(int i = 0; i< items.length; i++) {
            this.add(items[i]);
        }

    }

    public LinkedList(ArrayList<Item> items) {
        if (items.length() == 0) {
            return;
        }


        for (int i = 0; i < items.length(); i++) {
            this.add(items.get(i));
        }
    }

    public Item get(int index) {
        Node<Item> current = this.head;

        if (index == 0) {
            return current.value;
        } else if (index == 1) {
            current = current.next;
            return current.value;
        } else if (index > 1) {
            for (int i = 0; i < index; i++) {
                if (current.next != null) {
                    current = current.next;
                }
            }
        }

        return current.value;
    }

    @Override
    public void set(int index, Item item) {
        current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                current.value = item;
            }
            current = current.next;
            i++;
        }
    }


    public void add(Item item) {
        if (head.value == null) {
            head.value = item;
        } else if (head.next.value == null) {
            head.next.value = item;
        } else {
            Node<Item> newNode = new Node<>(tail, item, tail.next);
            tail.next = newNode;
            tail = newNode;
            size++;
        }

    }


    public void addAll(Item... args) {
        for (Item item : args) {
            add(item);
            size++;
        }
    }

    @Override
    public void remove(int index) {
        Node<Item> current = head;
        for (int i = 0; i < index; i++) {
            if (current.next != null) {
                current = current.next;
            }
        }
        current.previous.next = current.next;
        if (current.next != null) {
            current.next.previous = current.previous;
        }
    }


    public int length() {
        Node<Item> current = head;
        int len = 0;
        while (current != null) {
            current = current.next;
            len++;
        }
        return len;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head.previous = null;
        head.next = tail;
        tail.previous = head;
        tail.next = null;
    }

    public Node<Item> getHead() {
        return head;
    }

    public Node<Item> getTail() {
        return tail;
    }


    public static <T> void bubbleSort(LinkedList<T> list, Comparator<? super T> comparator) {
        System.out.println("Sorting...");

        int len = list.length();
        int itr = 0;
        Node<T> current = list.head;
        Node<T> bubble;
        Node<T> temp;

        while (current != null) {
            bubble = current.next;
            while (bubble != null) {
                //System.out.println(current.value + " -c " + bubble.value+ " -b " + comparator.compare(current.value, bubble.value) + " compare");


                if (comparator.compare(current.value, bubble.value) > 0) {
                    temp = new Node<>(current.previous, current.value, current.next);


                    if(current == list.head) {
                        list.head = bubble;
                    }

                    if(current.next == bubble) {
                        current.next = bubble.next;
                        current.previous = bubble;
                        if(current.next != null) {
                            current.next.previous = current;
                        }

                        bubble.next = current;
                        bubble.previous = temp.previous;
                        if (temp.previous != null) {
                            temp.previous.next = bubble;
                        }
                    } else {
                        current.next = bubble.next;
                        current.previous = bubble.previous;
                        if(current.next != null) {
                            current.next.previous = current;
                        }
                        if(current.previous != null) {
                            current.previous.next = current;
                        }



                        bubble.next = temp.next;
                        bubble.previous = temp.previous;
                        if (temp.previous != null) {
                            temp.previous.next = bubble;

                        }
                        if(temp.next != null) {
                            temp.next.previous = bubble;
                        }
                    }

                    current = bubble;
                    bubble = current.next;


                } else if (bubble != null) {
                    bubble = bubble.next;
                } else if (bubble == null) {
                    break;
                }

            }
            current = current.next;
            itr++;
        }

    }
    //------------------
}
