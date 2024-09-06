package OwnCollectionsFramework;

public abstract class CollectionList<Item> {
    protected int size;
    public boolean isSorted;


    public abstract Object get(int index);
    public abstract void set(int index, Item item);
    public abstract void add(Item item);
    public abstract void remove(int index);
    public abstract int length();
    public abstract boolean isEmpty();
    public abstract void clear();

}
