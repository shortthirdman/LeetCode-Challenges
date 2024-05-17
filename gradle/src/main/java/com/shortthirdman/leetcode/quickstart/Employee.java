package com.shortthirdman.leetcode.quickstart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;
	private double salary;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", name=").append(name).append(", age=").append(age)
				.append(", gender=").append(gender).append(", department=").append(department)
				.append(", yearOfJoining=").append(yearOfJoining).append(", salary=").append(salary).append("]");
		return builder.toString();
	}
}
