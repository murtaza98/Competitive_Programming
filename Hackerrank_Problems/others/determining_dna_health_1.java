// done w/o AHO copario algo, using only TRIE and creating all substring of d and chekingg in trie

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private Node root;
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;

    private static class IndexHealth {
        final int index;
        final int health;

        private IndexHealth(int index, int health) {
            this.index = index;
            this.health = health;
        }
    }

    private static class Node {
        Node[] children = new Node[26];
        final char letter;
        List<IndexHealth> idxHealth;

        private Node(char letter) {
            this.letter = letter;
        }

        private void addHealth(int index, int health) {
            if (idxHealth == null) {
                idxHealth = new ArrayList<>();
            }
            idxHealth.add(new IndexHealth(index, health));
        }

        private long getHealth(int first, int last) {
            if (idxHealth == null) {
                return 0;
            }
            long health = 0;
            for (IndexHealth ih : idxHealth) {
                if (first <= ih.index && ih.index <= last) {
                    health += ih.health;
                }
            }
            return health;
        }
    }

    private void createTrie(String[] genes, int[] health) {
        root = new Node('\u0000');
        for (int i = 0; i < genes.length; i++) {
            addString(genes[i], i, health[i]);
        }
    }

    private void addString(String s, int index, int health) {
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node(c);
            }
            node = node.children[idx];
        }
        node.addHealth(index, health);
    }

    private void calculateHealth(int first, int last, String d) {
        int step = 0;
        long total = 0;
        while (step < d.length()) {
            Node node = root;
            for (int i = step; i < d.length(); i++) {
                char c = d.charAt(i);
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    break;
                }
                node = node.children[idx];
                total += node.getHealth(first, last);
            }
            step++;
        }
        min = Math.min(min, total);
        max = Math.max(max, total);
    }

    private void printResult() {
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] genes = new String[n];
        for (int genes_i = 0; genes_i < n; genes_i++) {
            genes[genes_i] = in.next();
        }
        int[] health = new int[n];
        for (int health_i = 0; health_i < n; health_i++) {
            health[health_i] = in.nextInt();
        }
        int s = in.nextInt();
        Solution sol = new Solution();
        sol.createTrie(genes, health);
        for (int a0 = 0; a0 < s; a0++) {
            int first = in.nextInt();
            int last = in.nextInt();
            String d = in.next();
            sol.calculateHealth(first, last, d);
        }
        sol.printResult();
        in.close();
    }
}