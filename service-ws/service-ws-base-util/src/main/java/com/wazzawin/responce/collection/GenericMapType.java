package com.wazzawin.responce.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public class GenericMapType<K, V> {

    private List<GenericEntryType<K, V>> entry = new ArrayList<GenericEntryType<K, V>>();

    public GenericMapType() {
    }

    public GenericMapType(Map<K, V> map) {
        for (Map.Entry<K, V> e : map.entrySet()) {
            entry.add(new GenericEntryType<K, V>(e));
        }
    }

    public List<GenericEntryType<K, V>> getEntry() {
        return entry;
    }

    public void setEntry(List<GenericEntryType<K, V>> entry) {
        this.entry = entry;
    }
}
