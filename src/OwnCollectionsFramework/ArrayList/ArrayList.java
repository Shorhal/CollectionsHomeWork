package OwnCollectionsFramework.ArrayList;

import OwnCollectionsFramework.CollectionList;
import OwnCollectionsFramework.LinkedList.LinkedList;
import OwnCollectionsFramework.LinkedList.Node;

import java.util.Comparator;
import java.util.List;

public class ArrayList<Item> extends CollectionList<Item> {
    private Object[] items;
    private int capacity;
    private final static int DEFAULT_CAPACITY = 10;
    private final static int REACH_FACTOR = 2;
    private final static float LOAD_FACTOR = 0.75F;
    private int size = 0;


    /**
     * Constructors
     */
    public ArrayList() {
        items = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public ArrayList(Item ... items) {
        this.capacity = DEFAULT_CAPACITY;
        this.items = items;
    }

    public ArrayList(ArrayList<Item> list) {
        System.arraycopy(list, 0, items, 0, list.length());
    }

    public ArrayList(LinkedList<Item> items) {
        this.items = new Object[DEFAULT_CAPACITY];
        Node<Item> current = items.getHead();

        while (current != null) {
            items.add(current.getValue());
            current = current.getNext();
        }


    }

    /**
     *
     * @param index
     * @return item bt index
     */
    public Item get(int index) {
        return (Item) items[index];
    }


    @Override
    public void set(int index, Item o) {
        if (items[index] == null && o != null) {
            items[index] = o;
            size++;
        } else {
            items[index] = o;
        }

    }


    public void add(Item item) {
        if ((float) items.length / capacity >= LOAD_FACTOR) {
            Object[] temp = new Object[capacity * REACH_FACTOR];
            System.arraycopy(items, 0, temp, 0, items.length);
            items = temp;
            this.set(size, item);
        } else {
            this.set(size, item);
            this.size++;
        }

    }

    public void addAll(Item... args) {
        for (Item item : args) {
            add(item);
        }
    }

    @Override
    public void remove(int index) {
        if (items[index] != null) {
            items[index] = null;
            size--;
        }

    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
    }


    public static <T> void bubbleSort(ArrayList<T> list, Comparator<? super T> comparator) {
        System.out.println("Sorting...");
        for (int i = 0; i < list.length() - 1; i++) {
            for(int j = 0; j < list.length() - i - 1; j++) {
                if(comparator.compare(list.get(j), list.get(j+1)) > 0) {
                    T swap = list.get(j);
                    list.set(j,  list.get(j+1));
                    list.set(j+1, swap);
                }
            }
        }
    }

}
