package com.shortthirdman.leetcode.quickstart;

import java.util.*;

/**
 * <b>Minimum Cost to Hire K Workers</b><br/>
 * There are N workers. The i-th worker has a quality[i] and a minimum wage expectation wage[i].<br/>
 *
 * Now we want to hire exactly K workers to form a paid group. When hiring a group of K workers, we must pay them according to the following rules:<br/>
 * 1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.<br/>
 * 2. Every worker in the paid group must be paid at least their minimum wage expectation.<br/>
 *
 * Return the least amount of money needed to form a paid group satisfying the above conditions.<br/>
 *
 * @author shortthirdman
 */
public class HireWorkersMinimumWage {

	public static class Worker {
		private int quality;
	    private int wage;
	    private double ratio;

	    public Worker(int quality, int wage, double ratio) {
	        this.quality = quality;
	        this.wage = wage;
	        this.ratio = ratio;
	    }

	    public Worker(int quality, int wage) {
	        this.quality = quality;
	        this.wage = wage;
	        this.ratio = ((double) wage) / quality;
	    }

	    public int getQuality() {
	        return quality;
	    }

	    public void setQuality(int quality) {
	        this.quality = quality;
	    }

	    public int getWage() {
	        return wage;
	    }

	    public void setWage(int wage) {
	        this.wage = wage;
	    }

	    public double getRatio() {
	        return ratio;
	    }

	    public void setRatio(double ratio) {
	        this.ratio = ratio;
	    }

	    @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("Worker{");
	        sb.append("quality=").append(quality);
	        sb.append(", wage=").append(wage);
	        sb.append(", ratio=").append(ratio);
	        sb.append('}');
	        return sb.toString();
	    }
	}

	public double minCostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Worker> list = new ArrayList<>();
        for (int i = 0; i < wage.length; i++) {
            list.add(new Worker(quality[i], wage[i]));
        }
        Comparator<Worker> comp = Comparator.comparing(Worker::getRatio);
        Collections.sort(list, comp);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        double result = Integer.MAX_VALUE;

        try {
            for (Worker w : list) {
                sum += w.getQuality();
                q.offer(-w.getQuality());

                if (q.size() > K) {
                    int extra = q.poll();
                    sum += extra;
                }

                if (q.size() == K) {
                    result = Math.min(result, sum * w.getRatio());
                }
            }
        } catch (NullPointerException npe) {
            System.err.println("Error while in polling in priority queue");
            npe.printStackTrace();
        }

        return result;
    }
}
