package com.shortthirdman.leetcode.quickstart;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are <code>n</code> cities connected by <code>m</code> flights.
 * Each flight starts from city <code>u</code> and arrives at <code>v</code>
 * with a price <code>w</code>.
 * <br><br>
 * Now given all the cities and flights, together with starting city <code>src</code>
 * and the destination <code>dest</code>,
 * your task is to find the cheapest price from <code>src</code> to <code>dest</code>
 * with up to <code>k</code> stops.
 * If there is no such route, output -1.
 * 
 * @author shortthirdman
 * @category LeetCode
 * 
 */
public class CheapestFlightsKStops {

	public int findCheapestPrice(int n, int[][] flights, int src, int dest, int K) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new HashMap<>());
		}

		for (int[] f : flights) {
			map.get(f[0]).put(f[1], f[2]);
		}

		Queue<int[]> priority = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		priority.add(new int[] { 0, src, -1 });

		while (!priority.isEmpty()) {
			int[] ff = priority.poll();
			int fare = ff[0], dst = ff[1], stop = ff[2];
			if (dst == dest) {
				return fare;
			}
			if (stop < K) {
				Map<Integer, Integer> temp = map.getOrDefault(dst, new HashMap<>());
				for (int cc : temp.keySet()) {
					priority.add(new int[] { fare + temp.get(cc), cc, stop + 1 });
				}
			}
		}
		return -1;
	}
}
