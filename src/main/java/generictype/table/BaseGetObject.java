package generictype.table;

public interface BaseGetObject<K,V> {

    default V getValue(K key){return null;}
}
