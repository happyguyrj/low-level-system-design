package com.example.app.cache.evictionPolicy;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    @Override
    public void keyAccessed(Key key) {

    }

    @Override
    public void evictKey() {

    }

    @Override
    public Key evict() {
        return null;
    }
}
