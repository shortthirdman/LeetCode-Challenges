package com.shortthirdman.leetcode.quickstart;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeFactoryTest {

	List<Employee> employees = null;

	@BeforeEach
	public void setUp() {
		employees = new ArrayList<>();
		employees.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employees.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employees.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employees.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employees.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employees.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employees.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employees.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employees.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employees.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employees.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employees.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employees.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employees.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employees.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employees.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employees.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	}
	
	@Test
	public void test_countFemaleMale() {
		Map<String, Long> expectedCount = Stream.of(
				new SimpleEntry<>("Male", 11L),
				new SimpleEntry<>("Female", 6L)
			).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
		
		Map<String, Long> actualCount = EmployeeFactory.getMaleFemaleCount(employees);

        assertEquals(actualCount, expectedCount);
	}

	@Test
	public void test_departmentNames() {
		List<String> expectedNames = Arrays.asList("HR", "Sales And Marketing", "Infrastructure", "Product Development", "Security And Transport", "Account And Finance");
		
		List<String> actualNames = EmployeeFactory.getDepartmentName(employees);
		
		assertEquals(expectedNames, actualNames);
		
		assertTrue(expectedNames.size() == actualNames.size() && expectedNames.containsAll(actualNames) && actualNames.containsAll(expectedNames));
	}

	@Test
	public void test_calculateAgeByGender() {
		Map<String, Double> expectedAges = Stream.of(new Object[][] {
			{ "Male", 30.181818181818183 },
			{ "Female", 27.166666666666668 }
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (Double) data[1]));
		
		Map<String, Double> actualAges = EmployeeFactory.averageAgeByGender(employees);
		
		assertTrue(expectedAges.size() == actualAges.size() && expectedAges.equals(actualAges));
	}

	@Test
	public void test_getEmployeeNames() {
		List<String> expectedNames = Arrays.asList("Iqbal Hussain","Amelia Zoe", "Nitin Joshi", "Nicolus Den", "Ali Baig");
		
		List<String> actualNames = EmployeeFactory.getEmployeeNames(employees, 2015);
		
		assertEquals(expectedNames, actualNames);
		
		assertTrue(expectedNames.size() == actualNames.size() && expectedNames.containsAll(actualNames) && actualNames.containsAll(expectedNames));
	}

	@Test
	public void test_countEmployeesByDept() {
		Map<String, Long> expectedCounts = Stream.of(
				new SimpleEntry<>("Product Development", 5L),
				new SimpleEntry<>("Security And Transport", 2L),
				new SimpleEntry<>("Sales And Marketing", 3L),
				new SimpleEntry<>("Infrastructure", 3L),
				new SimpleEntry<>("HR", 2L),
				new SimpleEntry<>("Account And Finance", 2L)
		).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
		
		Map<String, Long> actualCounts = EmployeeFactory.countByDepartment(employees).stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		assertEquals(expectedCounts, actualCounts);
		assertAll("Maps are equal",
				() -> assertEquals(expectedCounts.size(), actualCounts.size(), "Map sizes are not equal"),
				() -> expectedCounts.forEach((key, value) ->
						assertTrue(actualCounts.containsKey(key) && actualCounts.get(key).equals(value),
								"Map values are not equal for key: " + key)));
	}

	@Test
	@DisplayName(value = "Calculate average salary")
	public void test_calculateAvgSalary() {
		Map<String, Double> expectedAverages = Stream.of(
				new SimpleEntry<>("Product Development", 31960.0),
				new SimpleEntry<>("Security And Transport", 10750.25),
				new SimpleEntry<>("Sales And Marketing", 11900.166666666666),
				new SimpleEntry<>("Infrastructure", 15466.666666666666),
				new SimpleEntry<>("HR", 23850.0),
				new SimpleEntry<>("Account And Finance", 24150.0)
		).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
		
		Map<String, Double> actualAverages = EmployeeFactory.averageSalaryByDept(employees)
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        assertEquals(expectedAverages, actualAverages);
		assertAll("Maps are equal",
				() -> assertEquals(expectedAverages.size(), actualAverages.size(), "Map sizes are not equal"),
				() -> expectedAverages.forEach((key, value) ->
						assertTrue(actualAverages.containsKey(key) && actualAverages.get(key).equals(value),
								"Map values are not equal for key: " + key)));
	}

	@Test
	@DisplayName(value = "Get oldest employee")
	public void test_getOldestEmployee() {
		Employee expectedEmployee = Employee.builder()
				.id(166)
				.name("Iqbal Hussain")
				.age(43)
				.department("Security And Transport")
				.gender("Male")
				.yearOfJoining(2016)
				.salary(10500.0)
				.build();
		Employee actualEmployee = EmployeeFactory.oldestEmployee(employees);
		assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(expectedEmployee);
	}

	@Test
	@DisplayName(value = "Get employee salary")
	public void test_getEmployeesSalary() {
		DoubleSummaryStatistics actualStats = EmployeeFactory.getEmployeeSalary(employees);
		assertEquals(21141.235294117647, actualStats.getAverage(), 0);
		assertEquals(359401.0, actualStats.getSum(), 0);
	}

	@Test
	public void test_getSeniorMostEmployee() {
		Employee expectedEmployee = Employee.builder()
				.id(177)
				.name("Manu Sharma")
				.age(35)
				.gender("Male")
				.department("Account And Finance")
				.yearOfJoining(2010)
				.salary(27000.0)
				.build();
		Employee actualEmployee = EmployeeFactory.seniorMostEmployee(employees);
		assertThat(actualEmployee).usingRecursiveComparison().isEqualTo(expectedEmployee);
	}
}
