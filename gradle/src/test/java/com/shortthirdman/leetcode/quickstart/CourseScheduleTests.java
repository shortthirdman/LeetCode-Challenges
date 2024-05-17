package com.shortthirdman.leetcode.quickstart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTests {

    CourseSchedule app;

    @BeforeEach
    public void setup() {
        app = new CourseSchedule();
    }

    @Test
    void testNoCoursesNoPrerequisites() {
        assertTrue(app.canFinishCoursesByBFS(0, new int[][]{}));
    }

    @Test
    void testSomeCoursesNoPrerequisites() {
        assertTrue(app.canFinishCoursesByBFS(3, new int[][]{}));
    }

    @Test
    void testNoCoursesWithPrerequisites() {
        assertTrue(app.canFinishCoursesByBFS(0, new int[][]{{1, 0}, {2, 1}}));
    }

    @Test
    void testAllCoursesWithSatisfiedPrerequisites() {
        assertTrue(app.canFinishCoursesByBFS(3, new int[][]{{1, 0}, {2, 1}}));
    }

    @Test
    void testCyclesInPrerequisites() {
        assertFalse(app.canFinishCoursesByBFS(3, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    void testMultiplePrerequisiteChains() {
        assertTrue(app.canFinishCoursesByBFS(5, new int[][]{{1, 0}, {2, 1}, {3, 2}, {4, 3}}));
    }

    @Test
    void testCoursesWithMultiplePrerequisites() {
        assertTrue(app.canFinishCoursesByBFS(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }

    @Test
    void testDuplicatePrerequisites() {
        assertTrue(app.canFinishCoursesByBFS(4, new int[][]{{1, 0}, {2, 0}, {1, 0}, {3, 1}}));
    }

    @Test
    void testNullPrerequisitesArray() {
        assertThrows(IllegalArgumentException.class, () -> app.canFinishCoursesByBFS(3, null));
    }

    @Test
    public void testCanFinishCoursesByDFS_NoPrerequisites() {
        int[][] prerequisites = {};
        boolean result = app.canFinishCoursesByDFS(3, prerequisites);
        assertTrue(result);
    }

    @Test
    public void testCanFinishCoursesByDFS_AllPrerequisitesMet() {
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        boolean result = app.canFinishCoursesByDFS(4, prerequisites);
        assertTrue(result);
    }

    @Test
    public void testCanFinishCoursesByDFS_SomePrerequisitesMet() {
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> app.canFinishCoursesByDFS(3, prerequisites));
    }

    @Test
    public void testCanFinishCoursesByDFS_PrerequisitesLoop() {
        int[][] prerequisites = {{1, 0}, {2, 1}, {0, 2}};
        boolean result = app.canFinishCoursesByDFS(3, prerequisites);
        assertFalse(result);
    }

    @Test
    public void testCanFinishCoursesByDFS_EmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> app.canFinishCoursesByDFS(3, null));
    }

    @Test
    public void testCanFinishCoursesByDFS_NoCourses() {
        int[][] prerequisites = {};
        boolean result = app.canFinishCoursesByDFS(0, prerequisites);
        assertTrue(result);
    }

    @Test
    void testFindOrderWithNoPrerequisites() {
        int numCourses = 5;
        int[][] prerequisites = {};
        int[] expected = {0, 1, 2, 3, 4};
        assertArrayEquals(expected, app.findOrder(numCourses, prerequisites));
    }

    @Test
    void testFindOrderWithPrerequisites() {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, app.findOrder(numCourses, prerequisites));
    }

    @Test
    void testFindOrderWithIncompletePrerequisites() {
        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 0}, {0, 1}};
        int[] expected = {};
        assertArrayEquals(expected, app.findOrder(numCourses, prerequisites));
    }

    @Test
    void testFindOrderWithCircularDependencies() {
        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}, {0, 2}};
        int[] expected = {};
        assertArrayEquals(expected, app.findOrder(numCourses, prerequisites));
    }

    @Test
    void testFindOrderWithNullPrerequisites() {
        int numCourses = 3;
        int[][] prerequisites = null;
        assertThrows(IllegalArgumentException.class, () -> app.findOrder(numCourses, prerequisites));
    }
}
