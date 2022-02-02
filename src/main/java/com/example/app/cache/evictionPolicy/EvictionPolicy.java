package com.example.app.cache.evictionPolicy;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    void evictKey();

    Key evict();

}
