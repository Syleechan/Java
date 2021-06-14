public interface LinearList {
    boolean add(String e, int index);

    boolean add(String e);

    String remove(int index);

    boolean remove(String e);

    void set(int index, String newValue);

    int indexOf(String e);

    String toString();
}
