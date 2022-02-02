package com.example.app.cache.evictionPolicy;

import com.example.app.cache.domain.DoublyLinkedList;
import com.example.app.cache.domain.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private final Map<Key, DoublyLinkedListNode<Key>> map;
    private final DoublyLinkedList<Key> dll;

    public LRUEvictionPolicy() {
        map = new HashMap<>();
        dll = new DoublyLinkedList<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if ((map.containsKey(key))) {
            dll.detachNode(map.get(key));
            dll.insertNodeAtEnd(map.get(key));
            return;
        }
        final DoublyLinkedListNode<Key> doublyLinkedListNode = dll.insertElementAtEnd(key);
        map.put(key, doublyLinkedListNode);
    }

    @Override
    public Key evictKey() {
        final DoublyLinkedListNode<Key> lruNode = dll.getFirstNode();

        if (Objects.isNull(lruNode))
            return null;

        dll.detachNode(lruNode);
        map.remove(lruNode.getElement());

        return lruNode.getElement();
    }

    @Override
    public Key keyToEvict() {
        return dll.getFirstNode().getElement();
    }
}
