package com.shortthirdman.leetcode.quickstart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * <b>Course Schedule<b/><br/>
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1].
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?<br/>
 *
 * For example, given 2 and [[1,0]], there are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.<br/>
 *
 * For another example, given 2 and [[1,0],[0,1]], there are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * @author shortthirdman
 */
public class CourseSchedule {

    /**
     * breath-first search
     * @param numCourses number of courses
     * @param prerequisites number of pre-requisites for each course
     * @return
     */
    public boolean canFinishCoursesByBFS(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if (numCourses == 0 || len == 0) {
            return true;
        }

        // Counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        // Store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }

        // number of courses that have no prerequisites
        int numNoPre = queue.size();

        while (!queue.isEmpty()) {
            int top = queue.remove();
            for (int i = 0; i < len; i++) {
                // if a course's prerequisite can be satisfied by a course in queue
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }

    /**
     * depth-first search
     * @param numCourses number of courses
     * @param prerequisites number of pre-requisites for each course
     * @return
     */
    public boolean canFinishCoursesByDFS(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        //track visited courses
        int[] visit = new int[numCourses];

        // use the map to store what courses depend on a course
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for (int[] a : prerequisites) {
            if (map.containsKey(a[1])) {
                map.get(a[1]).add(a[0]);
            } else {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canFinishDFS(map, visit, i))
                return false;
        }

        return true;
    }

    private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {
        if (visit[i] == -1) {
            return false;
        }
        if (visit[i] == 1) {
            return true;
        }

        visit[i] = -1;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (!canFinishDFS(map, visit, j))
                    return false;
            }
        }

        visit[i] = 1;

        return true;
    }

    /**
     * Valid sequence of courses
     * @param numCourses number of courses
     * @param prerequisites number of pre-requisites for each course
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        //if there is no prerequisites, return a sequence of courses
        if (len == 0) {
            int[] res = new int[numCourses];
            for (int m = 0; m < numCourses; m++) {
                res[m] = m;
            }
            return res;
        }

        //records the number of prerequisites each course (0,...,numCourses-1) requires
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        //stores courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }

        int numNoPre = queue.size();

        //initialize result
        int[] result = new int[numCourses];
        int j = 0;

        while (!queue.isEmpty()) {
            int c = queue.remove();
            result[j++] = c;

            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == c) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }

            }
        }

        //return result
        if (numNoPre == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
