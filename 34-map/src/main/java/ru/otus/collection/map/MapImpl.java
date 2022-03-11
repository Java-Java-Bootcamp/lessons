package ru.otus.collection.map;

import java.util.*;

public class MapImpl<K, V> implements Map<K, V> {
    private List<V>[] values = new ArrayList[2];
    private List<K>[] keys = new ArrayList[2];
    private int loadFactor = 0;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V get(Object key) {
        int hc = key.hashCode();
        int index = hc % values.length;

        List<K> keyBucket = keys[index];
        if (keyBucket == null || !keyBucket.contains(key)) {
            return null;
        }

        // если ключ есть
        if (keyBucket.contains(key)) {
            int keyIndex = keyBucket.indexOf(key);
            V value = values[index].get(keyIndex);
            return value;
        }


        return null;
    }

    @Override
    public V put(K key, V value) {
        int hc = key.hashCode();
        int index = hc % values.length;

        List<K> keyBucket = keys[index];

        // если нет хранилища ключей
        if (keyBucket == null) {
            List<K> keysBucket = new ArrayList<>();
            keysBucket.add(key);
            keys[index] = keysBucket;

            List<V> valuesBucket = new ArrayList<>();
            valuesBucket.add(value);
            values[index] = valuesBucket;
            calcLoadFactor();
            return value;
        }

        // если нет ключа
        if (!keyBucket.contains(key)) {
            keyBucket.add(key);
            values[index].add(value);
            calcLoadFactor();
            return value;
        }

        // если есть и ключ и значение
        if (keyBucket.contains(key)) {
            int keyBucketIndex = keyBucket.indexOf(key);
            List<V> bucket = values[index];
            if (bucket.contains(value) && bucket.indexOf(value) == keyBucketIndex) {
                return value;
            }
        }

        // если ключ есть а значение другое
        if (keyBucket.contains(key)) {
            List<V> bucket = values[index];
            int keyBucketIndex = keyBucket.indexOf(key);
            if (!bucket.contains(value)) {
                List<V> temp = new ArrayList<>();
                for (int i = 0; i < bucket.size(); i++) {
                    if (i != keyBucketIndex) {
                        temp.add(bucket.get(i));
                    } else {
                        temp.add(value);
                    }
                }
                values[index] = temp;
                calcLoadFactor();
                return value;
            }
        }

        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    private void resize() {
        if (loadFactor >= 3) {
            List<V>[] tempValues = new ArrayList[keys.length * 2];
            List<K>[] tempKeys = new ArrayList[keys.length * 2];

            for (int i = 0; i < keys.length; i++) {
                List<K> keyBucket = keys[i];
                List<V> valueBucket = values[i];
                for (int j = 0; j < keyBucket.size(); j++) {
                    K key = keyBucket.get(j);
                    V value = valueBucket.get(j);
                    resizedPut(key, value, tempValues, tempKeys);
                }
            }

            values = tempValues;
            keys = tempKeys;
            loadFactor = 0;
            calcLoadFactor();
        }
    }

    private void resizedPut(K key, V value, List<V>[] tempValues, List<K>[] tempKeys) {
        int hc = key.hashCode();
        int index = hc % tempValues.length;

        List<K> keyBucket = tempKeys[index];

        // если нет хранилища ключей
        if (keyBucket == null) {
            List<K> keysBucket = new ArrayList<>();
            keysBucket.add(key);
            tempKeys[index] = keysBucket;

            List<V> valuesBucket = new ArrayList<>();
            valuesBucket.add(value);
            tempValues[index] = valuesBucket;
            return;
        }

        // если нет ключа
        if (!keyBucket.contains(key)) {
            keyBucket.add(key);
            tempValues[index].add(value);
            return;
        }

        // если есть и ключ и значение
        if (keyBucket.contains(key)) {
            int keyBucketIndex = keyBucket.indexOf(key);
            List<V> bucket = tempValues[index];
            if (bucket.contains(value) && bucket.indexOf(value) == keyBucketIndex) {
                return;
            }
        }

        // если ключ есть а значение другое
        if (keyBucket.contains(key)) {
            List<V> bucket = tempValues[index];
            int keyBucketIndex = keyBucket.indexOf(key);
            if (!bucket.contains(value)) {
                List<V> temp = new ArrayList<>();
                for (int i = 0; i < bucket.size(); i++) {
                    if (i != keyBucketIndex) {
                        temp.add(bucket.get(i));
                    } else {
                        temp.add(value);
                    }
                }
                tempValues[index] = temp;
                return;
            }
        }
    }

    private void calcLoadFactor() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null && values[i].size() > loadFactor) {
                loadFactor = values[i].size();
            }
        }
        resize();
    }

    /**
     * Методы ниже имплементировать не надо
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }
}
