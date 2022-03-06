package com.example.app.cache.factory;

import com.example.app.cache.Cache;
import com.example.app.cache.data.HashMapStorage;
import com.example.app.cache.evictionPolicy.LRUEvictionPolicy;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<>(new HashMapStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
    }

}