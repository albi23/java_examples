package generictype.table;

import java.util.ArrayList;
import java.util.List;

public class Table<K,V extends Comparable<V>> implements BaseAddObject<K,V>, BaseGetObject<K,V>, BaseRemoveObject<K>{

    private List<Entry<K,V>> entries;

    public Table(){
        this.entries = new ArrayList<>();
    }

    @Override
    public void  addValue(K key, V value) {
        this.entries.add(new Entry<>(key,value));
    }

    @Override
    public V getValue(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        for (Entry<K,V> entry: entries) {
            if (entry.getKey() == key) {
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+
                "{entries=[" + this.getEntriesData(this.entries) +
                "]}";
    }

    private String getEntriesData( List<Entry<K,V>> entries ){
        StringBuilder sb = new StringBuilder();
        for (Entry entry: entries) sb.append(entry.toString());
        return sb.toString().substring(0,sb.length()-1);
    }
}
