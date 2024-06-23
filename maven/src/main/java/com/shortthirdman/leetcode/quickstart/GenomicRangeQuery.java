package com.shortthirdman.leetcode.quickstart;

/**
 * Find the minimal nucleotide from a range of sequence DNA.
 * @author ShortThirdMan
 * @see <a href="https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/">Codility - GenomicRangeQuery</a>
 */
public class GenomicRangeQuery {

    /**
     * @param S
     * @param P
     * @param Q
     * @return
     */
    public int[] findMinimalNucleotide(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] impactFactors = new int[N + 1]; // Prefix sum array for impact factors

        System.out.println("Pre-calculate prefix sum of impact factors for each character");
        for (int i = 0; i < N; i++) {
            impactFactors[i + 1] = impactFactors[i] + getImpactFactor(S.charAt(i));
        }

        int[] results = new int[M];
        for (int i = 0; i < M; i++) {
            System.out.println("Calculate minimal impact factor based on prefix sums");
            results[i] = impactFactors[Q[i] + 1] - impactFactors[P[i]];
        }

        return results;
    }

    private int getImpactFactor(char nucleotide) {
        return switch (nucleotide) {
            case 'A' -> 1;
            case 'C' -> 2;
            case 'G' -> 3;
            case 'T' -> 4;
            default -> throw new IllegalArgumentException("Invalid nucleotide: " + nucleotide);
        };
    }

    /**
     * @param S
     * @param P
     * @param Q
     * @return
     */
    public int[] minimalNucleotideInDNA(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        Node root = buildSegmentTree(S, 0, N - 1); // Build segment tree

        int[] results = new int[M];
        for (int i = 0; i < M; i++) {
            results[i] = querySegmentTree(root, P[i], Q[i]); // Query using segment tree
        }

        return results;
    }

    private Node buildSegmentTree(String S, int start, int end) {
        if (start == end) {
            // Leaf node, store impact factor based on character
            return new Node(getImpactFactor(S.charAt(start)));
        }

        int mid = (start + end) / 2;
        Node left = buildSegmentTree(S, start, mid); // Build left subtree
        Node right = buildSegmentTree(S, mid + 1, end); // Build right subtree

        return new Node(Math.min(left.getValue(), right.getValue())); // Combine minimum impact factors
    }

    private int querySegmentTree(Node node, int queryStart, int queryEnd) {
        if (node == null || queryStart > node.getEnd() || queryEnd < node.getStart()) {
            return Integer.MAX_VALUE; // No overlap, return maximum value
        }

        if (queryStart == node.getStart() && queryEnd == node.getEnd()) {
            return node.getValue(); // Perfect overlap, return node value
        }

        int mid = (node.getStart() + node.getEnd()) / 2;
        int leftMin = querySegmentTree(node.getLeft(), queryStart, Math.min(queryEnd, mid));
        int rightMin = querySegmentTree(node.getRight(), Math.max(queryStart, mid + 1), queryEnd);

        return Math.min(leftMin, rightMin); // Return minimum impact factor from both subtrees
    }
}
