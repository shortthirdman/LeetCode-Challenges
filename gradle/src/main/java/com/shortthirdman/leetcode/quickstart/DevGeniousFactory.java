package com.shortthirdman.leetcode.quickstart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DevGeniousFactory {
	
	public static int getMaximumDistinctCount(int[] a, int[] b, int k) {
        Map<Integer, Integer> aCount = countFrequencies(a);
        Map<Integer, Integer> bCount = countFrequencies(b);

        int maxDistinctCount = aCount.size();

        for (int i = 0; i < k; i++) {
            int minAElement = aCount.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
            int maxBElement = bCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

            if (bCount.get(maxBElement) > aCount.get(minAElement)) {
                aCount.put(minAElement, aCount.get(minAElement) + 1);
                aCount.put(maxBElement, aCount.get(maxBElement) - 1);
                bCount.put(maxBElement, bCount.get(maxBElement) + 1);
                bCount.put(minAElement, bCount.get(minAElement) - 1);

                maxDistinctCount = Math.max(maxDistinctCount, aCount.size());
            }
        }

        return maxDistinctCount;
    }
	
	private static Map<Integer, Integer> countFrequencies(int[] arr) {
        return Arrays.stream(arr).boxed()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    }
	
	public static List<Integer> evenNumber(List<Integer> list) {
		return list.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
	}
	
	public static List<Integer> numbersStartingWithOne(List<Integer> list) {
		return list.stream()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
	}
	
	public static Set<Integer> duplicateElements(List<Integer> list) {
		Set<Integer> set = new HashSet<>();
		return list.stream()
				.filter(n -> !set.add(n))
				.collect(Collectors.toSet());
	}
	
	public static int findFirstElement(List<Integer> numbers) {
		int item = numbers.stream()
                .findFirst()
                .get();
		
		return item;
	}
	
	public static int findMaxElement(List<Integer> numbers) {
		int max = numbers.stream()
                	.max(Integer::compare)
                	.get();
		
		return max;
	}
	
	public static Character firstNonRepeatedCharacter(String text) {
		if (text.isEmpty() || text == null) {
			return null;
		}
		
		Character result = text.chars() // Stream of String       
	            .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
	            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
	            .entrySet()
	            .stream()
	            .filter(entry -> entry.getValue() == 1L)
	            .map(entry -> entry.getKey())
	            .findFirst()
	            .get();
		
		return result;
	}
	
	public static Character firstRepeatedCharacter(String text) {
		if (text.isEmpty() || text == null) {
			return null;
		}
		
		Character result = text.chars() // Stream of String       
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
		
		return result;
	}
	
	public static boolean containsDuplicate(int[] nums) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<>(list);

		if (set.size() == list.size()) {
			return false;
		}
		
		return true;
	}
	
	public static Map<String, Long> findCharacterCount(String text) {
		Map<String, Long> countMap = Arrays.stream(text.split(""))
					.map(String::toLowerCase)
					.collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
		return countMap;
	}
}
