package com.example.app.cache.data;

import com.example.app.cache.exception.KeyNotFoundException;
import com.example.app.cache.exception.StorageFullException;

import java.util.HashMap;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {

    private final HashMap<Key, Value> storage;
    private final int capacity;

    public HashMapStorage(int capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) {
        if (isFull())
            throw new StorageFullException("Capacity Reached");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) {
        keyExist(key);
        storage.remove(key);
    }

    @Override
    public Value get(Key key) {
        keyExist(key);
        return storage.get(key);
    }

    private boolean isFull() {
        return storage.size() == capacity;
    }

    private boolean isEmpty() {
        return storage.isEmpty();
    }

    public void keyExist(Key key) {
        if (storage.isEmpty() || !storage.containsKey(key)) {
            throw new KeyNotFoundException("Key is not present in cache");
        }
    }
}
