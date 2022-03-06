package com.example.app.cache;

import com.example.app.cache.data.Storage;
import com.example.app.cache.evictionPolicy.EvictionPolicy;
import com.example.app.cache.exception.InvalidStateException;
import com.example.app.cache.exception.KeyNotFoundException;
import com.example.app.cache.exception.StorageFullException;

import java.util.Objects;

public class Cache<Key, Value> {
    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage storage, EvictionPolicy evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public Value get(final Key key) {
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (KeyNotFoundException keyNotFoundException) {
            System.out.println("Hit a cache miss  for key " + key);
        }
        return null;
    }

    public void put(final Key key, final Value value) {
        try {
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException storageFullException) {
            System.out.println("Got storage full! Trying to evict");

            Key keyToBeRemoved = evictionPolicy.keyToEvict();
            if (Objects.isNull(keyToBeRemoved)) {
                throw new InvalidStateException("Invalid State! No storage space left and no keys to evict");
            }

            storage.remove(keyToBeRemoved);
            System.out.println("Evicting key " + keyToBeRemoved);
            put(key, value);
        }
    }
}