package com.Strack_Queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRU_cache {
    public static class LRUCache {
        private Deque<Integer> dq;
        private HashSet<Integer> hs;
        private final int CACHE_SIZE;

        LRUCache(int capacity) {
            dq = new LinkedList<>();
            hs = new HashSet<>();
            CACHE_SIZE = capacity;
        }

        public void process(int name) {
            if (!hs.contains(name)) {
                if (dq.size()==CACHE_SIZE) {
                    int el = dq.removeLast();
                    hs.remove(el);
                }
            }
            else {
                dq.remove(name);
            }
            dq.push(name);
            hs.add(name);
        }

        public void display() {
            Iterator<Integer> itr = dq.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.process(1);
        cache.process(2);
        cache.process(3);
        cache.process(1);
        cache.process(4);
        cache.process(5);
        cache.display();

    }
}
