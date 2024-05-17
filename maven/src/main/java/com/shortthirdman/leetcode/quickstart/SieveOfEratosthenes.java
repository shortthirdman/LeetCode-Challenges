package com.shortthirdman.leetcode.quickstart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X.
 * The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <br/><br/>
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers.
 * The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * 
 * @author shortthirdman
 * @version 1.0.0
 */
public class SieveOfEratosthenes {

	/**
	 * Calculate the number of elements of an array that are not divisors of each element.
	 * @param array
	 * @return 
	 */
	public int[] countNonDivisible(int[] array) {
	    int N = array.length;
	    int[] result = new int[N];
	    int[] occurrences = new int[2 * N + 1]; // Handle values up to 2 * N

	    // Count occurrences of each value in A
	    for (int value : array) {
	        occurrences[value]++;
	    }

	    // Calculate non-divisors for each element
	    for (int i = 0; i < N; i++) {
	        int count = 0;
	        // First, handle divisors up to the square root
	        int limit = (int) Math.sqrt(array[i]);
	        for (int j = 1; j <= limit; j++) {
	            if (array[i] % j == 0) {
	                count += occurrences[j];
	                if (j * j != array[i]) { // Update count for the corresponding divisor above the square root
	                    count += occurrences[array[i] / j];
	                }
	            }
	        }
	        // Handle the divisor equal to the square root if it exists
	        if (limit * limit == array[i]) {
	            count += occurrences[limit];
	        }
	        // Finally, subtract total divisors from total elements
	        result[i] = N - count;
	    }

	    return result;
	}
	
	/**
	 * Count the semiprime numbers in the given range [a..b]
	 * @param N
	 * @param P
	 * @param Q
	 * @return
	 */
	public int[] countSemiprimes(int N, int[] P, int[] Q) {
		// Precompute primes and semiprimes up to N
        boolean[] isPrime = sieveOfEratosthenes(N);
        int[] semiPrimes = calculateSemiPrimesCount(N, isPrime);

        // Answer queries efficiently using precomputed data
        int[] answers = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            answers[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];
        }

        return answers;
	}
	
	/**
	 * Efficiently generate primes using the Sieve of Eratosthenes
	 * @param N
	 * @return
	 */
	private boolean[] sieveOfEratosthenes(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
	
	/**
	 * Precompute the count of semiprimes up to each number
	 * @param N
	 * @param isPrime
	 * @return
	 */
	private int[] calculateSemiPrimesCount(int N, boolean[] isPrime) {
        int[] semiPrimes = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; j * i <= N; j++) {
                    if (isPrime[j]) {
                        semiPrimes[i * j]++;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            semiPrimes[i] += semiPrimes[i - 1];
        }

        return semiPrimes;
    }
	
	/**
	 * Count the semiprime numbers in the given range [a..b]
	 * @param N
	 * @param P
	 * @param Q
	 * @return
	 */
	public int[] countSemiPrimes(int N, int[] P, int[] Q) {
		//make size N+1 so will have direct mapping from array index
	    boolean [] arePrimes = new boolean[N+1];

	    arePrimes[0] = false; //0 is never prime
	    arePrimes[1] = false; //1 is never prime
		for (int i = 2; i < arePrimes.length; i++) {
			arePrimes[i] = true;
		}

		int nSquareRoot = (int) Math.sqrt(N);
		for (int i = 2; i <= nSquareRoot; i++) {
			if (arePrimes[i]) {
				// start checking from i^2 because lower numbers will have already been checked
				// keep checking very multiple of i
				for (int j = i * i; j <= N; j += i) {
					arePrimes[j] = false;
				}
			}
		}

	    List<Integer> primesList = new ArrayList<>();
		for (int i = 2; i < arePrimes.length; i++) {
			if (arePrimes[i]) {
				primesList.add(i);
			}
		}
		int[] primes = primesList.stream().mapToInt(i -> i).toArray();

		int[] semiPrimes = new int[N + 1];

	    //populate semi primes set in order
	    //reference: https://codesays.com/2014/solution-to-count-semiprimes-by-codility/
		for (int i = 0; i < primes.length - 1; i++) {
			if (primes[i] * primes[i] > N) {
				continue;
			}
			semiPrimes[primes[i] * primes[i]] = 1; // square of the prime
			for (int j = i + 1; j < primes.length; j++) {
				if (primes[i] * primes[j] > N) {
					break; // semi primes are larger than N so can stop calculating them
				}
				semiPrimes[primes[i] * primes[j]] = 1;
			}
		}
	   
		for (int i = 1; i < semiPrimes.length; i++) {
			semiPrimes[i] += semiPrimes[i - 1];
		}
	   
		int[] results = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			results[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];
		}

		return results;
	}
}
