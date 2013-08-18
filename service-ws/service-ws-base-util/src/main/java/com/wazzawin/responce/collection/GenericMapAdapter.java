package com.wazzawin.responce.collection;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public class GenericMapAdapter<K, V> extends XmlAdapter<GenericMapType<K, V>, Map<K, V>> {

    @Override
    public Map<K, V> unmarshal(GenericMapType<K, V> v) throws Exception {
        HashMap<K, V> map = new HashMap<K, V>();

        for (GenericEntryType<K, V> entryType : v.getEntry()) {
            map.put(entryType.getKey(), entryType.getValue());
        }
        return map;
    }

    @Override
    public GenericMapType<K, V> marshal(Map<K, V> v) throws Exception {
        GenericMapType<K, V> mapType = new GenericMapType<K, V>();

        for (Map.Entry<K, V> entry : v.entrySet()) {
            GenericEntryType<K, V> entryType = new GenericEntryType<K, V>();
            entryType.setKey(entry.getKey());
            entryType.setValue(entry.getValue());
            mapType.getEntry().add(entryType);
        }
        return mapType;
    }
}
