package com.example.app.cache.evictionPolicy;

import com.example.app.cache.domain.node.DoubleLinkedList;
import com.example.app.cache.domain.node.FrequencyNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private final Map<Key, Integer> counts = new HashMap<>();
    private final TreeMap<Integer, DoubleLinkedList<Key>> frequencies = new TreeMap<>();

    public LFUEvictionPolicy() {
    }

    @Override
    public void keyAccessed(Key key) {
        int frequency = counts.get(key);
        frequencies.get(frequency).remove(new FrequencyNode<>(key));
        removeIfListEmpty(frequency);
        frequencies.computeIfAbsent(frequency + 1, k -> new DoubleLinkedList()).add(new FrequencyNode<>(key));

        counts.put(key, frequency + 1);
    }

    private void removeIfListEmpty(int frequency) {
        if (frequencies.get(frequency).size() == 0) {
            frequencies.remove(frequency);
        }
    }

    @Override
    public Key evictKey() {
        int lowestCount = frequencies.firstKey();
        FrequencyNode<Key> nodeToDelete = frequencies.get(lowestCount).head();
        frequencies.get(lowestCount).remove(nodeToDelete);

        Key keyToDelete = nodeToDelete.key();
        removeIfListEmpty(lowestCount);
        counts.remove(keyToDelete);
        return keyToDelete;
    }

    @Override
    public Key keyToEvict() {
        int lowestCount = frequencies.firstKey();
        return frequencies.get(lowestCount).head().key();
    }
}
