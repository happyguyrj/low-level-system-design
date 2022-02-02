package com.example.app.cache;

import com.example.app.cache.data.HashMapStorage;
import com.example.app.cache.evictionPolicy.LRUEvictionPolicy;

public class CacheDemo {

    public static Cache<String, Integer> cache = new Cache(new HashMapStorage<String, Integer>(3), new LRUEvictionPolicy<String>());

    public static void main(String[] args) {
        cache.put("Rahul", 1);
        cache.put("Jain", 2);
        cache.put("Mr", 0);

        System.out.println(cache.get("Rahul"));

        cache.put("Rahul", 4);
        System.out.println(cache.get("Rahul"));
    }
}
