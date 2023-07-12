package com.Hashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Implementation {

    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            public HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<HMNode>[] buckets;

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int n) {
            buckets = new LinkedList[n];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFn(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % buckets.length;
        }

        private void put(K key, V value) {
            int bIdx = hashFn(key);
            int dlIdx = getIndexWithinBucket(key, bIdx);

            if (dlIdx == -1) {
                HMNode newNode = new HMNode(key, value);
                buckets[bIdx].add(newNode);
                size++;
            } else {
                HMNode updateNode = buckets[bIdx].get(dlIdx);
                updateNode.value = value;
            }
            double lambda = size * 1.0 / buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }

        private void rehash() {
            LinkedList<HMNode>[] copyBucket = buckets;
            initbuckets(copyBucket.length * 2);
            size = 0;
            for (int i = 0; i < copyBucket.length; i++) {
                for (HMNode node : copyBucket[i]) {
                    put(node.key, node.value);
                }
            }
        }

        private int getIndexWithinBucket(K key, int bi) {
            int di = 0;
            for (HMNode node : buckets[bi]) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private boolean containsKey(K key) {
            int bIdx = hashFn(key);
            int dlIdx = getIndexWithinBucket(key, bIdx);

            if (dlIdx == -1) {
                return false;
            } else {
                return true;
            }
        }

        private V get(K key) {
            int bi = hashFn(key);
            int di = getIndexWithinBucket(key, bi);

            if (di == -1) {
                return null;
            } else {
                HMNode reqNode = buckets[bi].get(di);
                return reqNode.value;
            }
        }

        private V remove(K key) {
            int bi = hashFn(key);
            int di = getIndexWithinBucket(key, bi);

            if (di == -1) {
                return null;
            } else {
                HMNode reqNode = buckets[bi].remove(di);
                size--;
                return reqNode.value;
            }
        }

        private int size() {
            return size;
        }

        private ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<HMNode> bucket : buckets) {
                for (HMNode node : bucket) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap();

        String str = sc.nextLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keySet());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = sc.nextLine();
        }
    }


}
