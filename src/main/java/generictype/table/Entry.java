package generictype.table;

public class Entry<K,V extends Comparable<V>> implements Comparable<Entry<K,V>>{

    private K key;
    private V value;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }


    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{key=" + key + ", value=" + value +"},";
    }

    @Override
    public int compareTo(Entry<K,V> o) {
        return this.getValue().compareTo(o.getValue());
    }
}
