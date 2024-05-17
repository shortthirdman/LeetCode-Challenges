package com.shortthirdman.leetcode.quickstart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class DevGeniousFactoryTests {

	@Test
	public void maxDistinctCount_successfulCase() {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 4, 5, 6, 7 };
		int k = 2;
		int expected = 5;

		int actual = DevGeniousFactory.getMaximumDistinctCount(a, b, k);

		assertEquals(expected, actual);
	}

	@Test
	public void maxDistinctCount_failedCase() {
		int[] a = { 1, 1, 1, 4, 5 };
		int[] b = { 2, 2, 5, 6, 7 };
		int k = 2;

		assertThrows(NullPointerException.class, () -> DevGeniousFactory.getMaximumDistinctCount(a, b, k));
	}
	
	@Test
	public void evenNumbers_successfulCase() {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);

		List<Integer> expected = Arrays.asList(10, 8, 98, 32);
		
		List<Integer> actual = DevGeniousFactory.evenNumber(list);
		
		assertEquals(expected, actual);
		
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	@Test
	public void numbersStarting_successfulCase() {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		
		List<Integer> expected = Arrays.asList(10, 15);
		
		List<Integer> actual = DevGeniousFactory.numbersStartingWithOne(list);
		
		assertEquals(expected, actual);
		
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	@Test
	public void duplicateElements_successfulCase() {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		
		Set<Integer> expected = Stream.of(98, 15).collect(Collectors.toCollection(HashSet::new));
		
		Set<Integer> actual = DevGeniousFactory.duplicateElements(list);
		
		assertEquals(expected, actual);
		
		assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
	}
	
	@Test
	public void firstRepeatedCharacter_successfulCase() {
		String srcText = "Java Articles are Awesome";
		
		Character expected = 'a';
		
		Character actual = DevGeniousFactory.firstRepeatedCharacter(srcText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void firstNonRepeatedCharacter_successfulCase() {
		String srcText = "Java Articles are Awesome";
		
		Character expected = 'j';
		
		Character actual = DevGeniousFactory.firstNonRepeatedCharacter(srcText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void firstElement_successfulCase() {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		
		int expected = 10;
		
		int actual = DevGeniousFactory.findFirstElement(list);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void maxElement_successfulCase() {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		
		int expected = 98;
		
		int actual = DevGeniousFactory.findMaxElement(list);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void containsDuplicateItem_successfulCase() {
		int[] firstNumbers = { 1, 2, 3, 1 };
		int[] secondNumbers = { 1, 2, 3, 4 };
		
		boolean firstExpected = true;
		boolean secondExpected = false;
		
		boolean firstActual = DevGeniousFactory.containsDuplicate(firstNumbers);
		boolean secondActual = DevGeniousFactory.containsDuplicate(secondNumbers);
		
		assertEquals(firstExpected, firstActual);
		
		assertEquals(secondExpected, secondActual);
	}
	
	@Test
	public void findCountOfChars_successfulCase() {
		String srcText = "string data to count each character";
		
		Map<String, Long> expected = Stream.of(
				new SimpleEntry<>("s", 1L),
				new SimpleEntry<>("t", 5L),
				new SimpleEntry<>("r", 3L),
				new SimpleEntry<>("i", 1L),
				new SimpleEntry<>("n", 2L),
				new SimpleEntry<>("g", 1L),
				new SimpleEntry<>(" ", 5L),
				new SimpleEntry<>("d", 1L),
				new SimpleEntry<>("a", 5L),
				new SimpleEntry<>("o", 2L),
				new SimpleEntry<>("c", 4L),
				new SimpleEntry<>("u", 1L),
				new SimpleEntry<>("e", 2L),
				new SimpleEntry<>("h", 2L)
			).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
		
		Map<String, Long> actual = DevGeniousFactory.findCharacterCount(srcText);
		
		assertTrue(expected.equals(actual));
	}
}
