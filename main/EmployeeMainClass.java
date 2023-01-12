package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import Entity.Address;
import Entity.Employee;

public class EmployeeMainClass {

	private static List<Address> addressList = new ArrayList<>();
	
	private static List<String> skillSetList = new ArrayList<>();
	
	private static Map<Integer,String> empPerformanceMap = new HashMap<>();
	
	private static List<Employee> empList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		//creating a list of address
		addressListCreation();
		
		//creating list of skill sets
		skillSetListCreation();
		
		//creating map about emp performance
		empPerformanceMapCreation();
		
		//creating list of employees
		empListCreation();
		
		getEmpNameInUpperCase(empList);
		
		getEmpNameWithDelimiter(empList);
		
		getEmpWithHighestSalary(empList);
		
		getEmpWithLowestSalary(empList);
		
		getEmpNameWithHighestSalary(empList);
		
		getEmpWithMinimumSalary(empList);
		
		getEmpNameWithMaxAge(empList);
		
		getEmpNameWithMinAge(empList);
		
		numbOfMaleAndFemale(empList);
		
		getEmpCountInEachDept(empList);
		
		printDeptNames(empList);
		
		getAvgOfMaleFemale(empList);
		
		getEmpOfHighestPaid(empList);
		
		getEmpJoinedAfter2023(empList);
		
		getAvgSalaryOfEachDept(empList);
		
		getYoungEmpFromDev(empList);
		
		getEmpCountFromHR(empList);
		
		getAvgSalaryOfMaleAndFemale(empList);
		
		getEmpNameFromEachDept(empList);
		
		getAvgAndTotalSalary(empList);
		
		separateEmp(empList);
		
		getOldestEmpDetail(empList);
		
		getSecondHighestSalary(empList);
		
		getEmpDetailsOfThreeHighestSalary(empList);
		
		getHighestSalaryFromEachDept(empList);
	}
	
	//Question 1- Return employee names in upper case
	private static void getEmpNameInUpperCase(List<Employee> empList) {
		empList
		.stream()
		.map(e -> e.getEmpName().toUpperCase())
		.collect(Collectors.toList())
		.forEach(e -> System.out.println(e));
	}
		
	//Question 2-Return employee names joining with a delimiter ","
	private static void getEmpNameWithDelimiter(List<Employee> empList) {
		String nameListWithDelimiter = empList
			.stream()
			.map(e -> e.getEmpName())
			.collect(Collectors.joining(","));
		System.out.println(""+nameListWithDelimiter);
	}
		
	//Question 3-Return employee object with highest salary
	private static void getEmpWithHighestSalary(List<Employee> empList) {
		Optional<Employee> empWithHighSalary = empList
				.stream()
				.max((e1,e2) -> (int)e1.getEmpSalary()-(int)e2.getEmpSalary());
		//Optional<Employee> empMaxSalary =empList.stream().max(Comparator.comparing(Employee::getEmpSalary));
		System.out.println(""+empWithHighSalary);
	}
		
	//Question 4-Return employee object with minimum salary
	private static void getEmpWithLowestSalary(List<Employee> empList) {
		Optional<Employee> empWithMinSalary = empList
				.stream()
				.min((e1,e2) -> (int)e1.getEmpSalary() - (int)e2.getEmpSalary());
		//Optional<Employee> empMaxSalary =empList.stream().min(Comparator.comparing(Employee::getEmpSalary));
		System.out.println(""+empWithMinSalary);
	}
	
	//Question 5-Return employee name with maximum salary
	private static void getEmpNameWithHighestSalary(List<Employee> empList) {
		Optional<Employee> empWithMaxSalary = empList
				.stream()
				.max(Comparator.comparing(Employee::getEmpSalary));
		Employee empWithHighSalary = empWithMaxSalary.get();
		//Optional<Employee> empMaxSalary =empList.stream().min(Comparator.comparing(Employee::getEmpSalary));
		System.out.println(""+empWithHighSalary.getEmpName());
	}
		
	//Question 6-Return employee name with minimum salary
	private static void getEmpWithMinimumSalary(List<Employee> empList) {
		Optional<Employee> empWithMinSalary = empList
				.stream()
				.min(Comparator.comparing(Employee :: getEmpSalary));
		if(empWithMinSalary.isPresent()) {
			Employee empWithLowestSalary = empWithMinSalary.get();
			System.out.println(""+empWithLowestSalary.getEmpName());
		}
	}
	
	//Question 7-Return employee name with maximum age
	private static void getEmpNameWithMaxAge(List<Employee> empList) {
		Optional<Employee> empMaxAge = empList
				.stream()
				.max(Comparator.comparing(Employee :: getEmpAge));
		if(empMaxAge.isPresent()) {
			Employee empHigherAge = empMaxAge.get();
			System.out.println(""+empHigherAge.getEmpName()+"="+empHigherAge.getEmpAge());
		}
	}
	
	//Question 8-Return employee name with minimum age
	private static void getEmpNameWithMinAge(List<Employee> empList) {
		Optional<Employee> empWithMinAge = empList
				.stream()
				.min(Comparator.comparing(Employee :: getEmpAge));
		if(empWithMinAge.isPresent()) {
			Employee empWithLowAge = empWithMinAge.get();
			System.out.println(""+empWithLowAge.getEmpName()+"="+empWithLowAge.getEmpAge());
		}
	}
	
	//Question 9-How many male and female employees are there 
	private static void numbOfMaleAndFemale(List<Employee> empList) {
		Map<String,Long> empGenderDetail = empList
				.stream()
				.collect(Collectors.groupingBy(Employee :: getEmpGender,Collectors.counting()));
		System.out.println(empGenderDetail);
	}
	
	//Question 10-Return employee count in each department
	private static void getEmpCountInEachDept(List<Employee> empList) {
		Map<String,Long> empCountWithDept = empList
				.stream()
				.collect(Collectors.groupingBy(Employee :: getEmpDept,Collectors.counting()));
		System.out.println(empCountWithDept);
	}
	
	//Question 11-Print the name of all departments in the organization
	private static void printDeptNames(List<Employee> empList) {
		 //Set<String> empDeptSet = empList.stream().map(e-> e.getEmpDept()).collect(Collectors.toSet());
		 //empList.stream().map(e -> e.getEmpDept()).distinct().forEach(e -> System.out.println(e));
		 empList.stream().map(Employee :: getEmpDept).distinct().forEach(System.out :: println);
		 //System.out.println(""+empDeptSet);
	}
	
	//Question 12-What is the average age of male and female employees
	private static void getAvgOfMaleFemale(List<Employee> empList) {
		//double maleAvgAge = empList.stream().filter(e->e.getEmpGender().equals("Male")).mapToInt(e -> e.getEmpAge()).summaryStatistics().getAverage();
		//double femaleAvgAge = empList.stream().filter(e->e.getEmpGender().equals("Female")).mapToInt(e -> e.getEmpAge()).summaryStatistics().getAverage();
		//System.out.println("Average age of male employees:" + maleAvgAge);
		//System.out.println("Average age of female employees:" + femaleAvgAge);
		Map<String,Double> empAvgAgeMap = empList
				.stream()
				.collect(Collectors.groupingBy(Employee :: getEmpGender,Collectors.averagingInt(Employee :: getEmpAge)));
		System.out.println("Average age of male and female employees:" + empAvgAgeMap);
	}
	
	//Question 13-Get details of highest paid employee in organization
	private static void getEmpOfHighestPaid(List<Employee> empList) {
		Optional<Employee> empHghSalary = empList
				.stream()
				.max(Comparator.comparing(Employee :: getEmpSalary));
		System.out.println("Highest paying employee:"+ empHghSalary);
	}
	
	//Question 14-Get employee name who joined after 2022
	private static void getEmpJoinedAfter2023(List<Employee> empList) {
		empList.stream()
					.filter(e -> e.getEmpJoiningDate()
					.isAfter(LocalDate.of(2022,12,31))).map(e->e.getEmpName())
					.forEach(System.out::println);
	}
	
	//Question 15-count the number of employees in each department
	private static void getAvgSalaryOfEachDept(List<Employee> empList) {
		Map<String,Double> empAvgSalary = empList
				.stream()
				.collect(Collectors.groupingBy(Employee :: getEmpDept,Collectors.averagingDouble(Employee :: getEmpSalary)));
		System.out.println(""+empAvgSalary);
	}
	
	//question 16-Find employee detail who is youngest in "Development" department
	private static void getYoungEmpFromDev(List<Employee> empList) {
		Optional<Employee> empDevDept = empList.stream().filter(e -> e.getEmpDept().equals("Development")).min(Comparator.comparing(Employee :: getEmpAge));
		System.out.println(""+empDevDept);
	}
	
	//Question 17-How many male and female employees in HR team
	private static void getEmpCountFromHR(List<Employee> empList) {
		Map<String,Long> empCountFromHRmap = empList
				.stream()
				.filter(e -> e.getEmpDept().equals("HR"))
				.collect(Collectors.groupingBy(Employee :: getEmpGender,Collectors.counting()));
		System.out.println(""+empCountFromHRmap);
	}
	
	//Question 18-Avg salary of male and female employees
	private static void getAvgSalaryOfMaleAndFemale(List<Employee> empList) {
		Map<String,Double> avgSalryOfMaleAndFemale = empList
				.stream()
				.collect(Collectors.groupingBy(Employee :: getEmpGender,Collectors.averagingDouble(Employee :: getEmpSalary)));
		System.out.println(""+avgSalryOfMaleAndFemale);
	}
	
	//Question 19-List down the names of all employees in each department
	private static void getEmpNameFromEachDept(List<Employee> empList) {
		/*
		 * Map<String,List<Employee>> empDept =
		 * empList.stream().collect(Collectors.groupingBy(Employee :: getEmpDept));
		 * Set<Entry<String,List<Employee>>> empSet = empDept.entrySet();
		 * for(Entry<String,List<Employee>> entryLoop: empSet) {
		 */
			System.out.println("----------------------------------------------");
//			System.out.println("Employee in "+ entryLoop.getKey());
//			for(Employee empLoop:entryLoop.getValue()) {
//				System.out.println("\n----------------------------------------------");
//				System.out.println(entryLoop.getValue());
//			}
//		}
		System.out.println(empList
		.stream()
		.collect(Collectors.groupingBy( Employee :: getEmpDept, Collectors.mapping(Employee::getEmpName,Collectors.toList()))));
	}
	
	//Question 20-Avg salary and total salary of all employees 
	private static void getAvgAndTotalSalary(List<Employee> empList) {
		DoubleSummaryStatistics avgAndTotalSalary = empList.stream().collect(Collectors.summarizingDouble(Employee :: getEmpSalary));
		System.out.println("Total= "+ avgAndTotalSalary.getSum()+"Average="+ avgAndTotalSalary.getAverage());
	}
	
	//Question 21-Separate the employees who are younger or equal to 25 yrs and older than 25 yrs
	private static void separateEmp(List<Employee> empList) {
		Map<Boolean,List<Employee>> empMap = empList.stream().collect(Collectors.partitioningBy(e -> e.getEmpAge() > 25));
		Set<Entry<Boolean,List<Employee>>> empEntrySet = empMap.entrySet();
		for(Entry<Boolean,List<Employee>> entryLoop : empEntrySet) {
			if(entryLoop.getKey())
				System.out.println("--Employees age greater than 25--");
			else
				System.out.println("--Employees age lesser or equal to 25--");
			for(Employee empYoun : entryLoop.getValue()) {
				System.out.println("\n"+empYoun);
			}
		}
	}
	
	//Question 22-who is the oldest employee, what is his age and which department
	private static void getOldestEmpDetail(List<Employee> empList) {
		Optional<Employee> empMaxAge = empList.stream().max(Comparator.comparing(Employee :: getEmpAge));
		if(empMaxAge.isPresent()) {
			Employee empMaxAgeDetails = empMaxAge.get();
			System.out.println("Oldest employee :" +empMaxAgeDetails+"Age is:" + empMaxAgeDetails.getEmpAge() +"Department is:"+ empMaxAgeDetails.getEmpDept());
		}
	}
	
	//Question 23-Find employee details of second highest salary
	private static void getSecondHighestSalary(List<Employee> empList) {
		empList
		.stream()
		.sorted((e1,e2) -> (int)e2.getEmpSalary() - (int)e1.getEmpSalary())
		.skip(1)
		.limit(1)
		.collect(Collectors.toList())
		.forEach(e -> System.out.println("Second highest salary="+ e)); 
	}
	
	//Question 24-Find 1st three employee details based on highest salary
	private static void getEmpDetailsOfThreeHighestSalary(List<Employee> empList) {
		empList.stream().sorted((e1,e2) -> (int)e2.getEmpSalary()- (int)e1.getEmpSalary()).limit(3).collect(Collectors.toList()).
		forEach(e -> System.out.println("Employee details of first three highest salaried employee: " + e));
	}
	
	//Question 25-find the highest salary in each department
	private static void getHighestSalaryFromEachDept(List<Employee> empList) {
		Map<String,List<Employee>> empSalaryMap = empList.stream().collect(Collectors.groupingBy(Employee :: getEmpDept));
		Set<Entry<String,List<Employee>>> empSalarySet = empSalaryMap.entrySet();
		for(Entry<String,List<Employee>> empLoop: empSalarySet) {
			System.out.println("The highest salary in"+ empLoop.getKey() +"department is");
			List<Employee> empDetail = empLoop.getValue();
			System.out.println(empDetail.stream().max((e1,e2) -> (int)e1.getEmpSalary() - (int)e2.getEmpSalary()));
		}
	}
	
	//creating a list of address
	private static void addressListCreation() {
		//Adding Address - Flat no.,city,state,pincode
		addressList.add(new Address("B100","Trichy","TamilNadu","450022"));
		addressList.add(new Address("107","Salem","TamilNadu","600100"));
		addressList.add(new Address("427/2","Panipat","Haryana","100100"));
		addressList.add(new Address("G40","Bhopal","Madhyapradesh","500444"));
		addressList.add(new Address("32E","Chennai","TamilNadu","200100"));
	}
	
	//creating list of skill sets
	private static void skillSetListCreation() {
		skillSetList.add("JAVA");
		skillSetList.add("Accounting");
		skillSetList.add("Data science");
		skillSetList.add("Cloud computing");
	}
	
	//creating map about emp performance
	private static void empPerformanceMapCreation() {
		empPerformanceMap.put(100,"Good");
		empPerformanceMap.put(103,"Fair");
		empPerformanceMap.put(102,"Good");
		empPerformanceMap.put(104,"Good");
		empPerformanceMap.put(101,"Fair");
		empPerformanceMap.put(105,"Fair");
		empPerformanceMap.put(106,"Fair");
		empPerformanceMap.put(107,"Good");
		empPerformanceMap.put(109,"Fair");
		empPerformanceMap.put(108,"Better");
		empPerformanceMap.put(110,"Fair");
	}
	
	private static void empListCreation() {
		//Adding employee details -
		empList.add(new Employee(100,"Anuj",32,750000.00,"Accounts","Male",LocalDate.of(2022,2,02),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(101,"Reshma",38,1000000.00,"HR","Female",LocalDate.of(2022,8,22),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(102,"Rohit",44,1900000.00,"Development","Male",LocalDate.of(2023,1,02),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(103,"Shreya",27,450000.00,"Accounts","Female",LocalDate.of(2022,12,20),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(104,"Revi",33,950000.00,"Testing","Male",LocalDate.of(2022,11,8),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(105,"Basha",42,980000.00,"Development","Male",LocalDate.of(2022,12,28),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(106,"Sneha",50,3200000.00,"Testing","Female",LocalDate.of(2023,1,8),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(107,"Esther",22,345000.00,"HR","Female",LocalDate.of(2022,8,18),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(108,"Neha",39,1100000.00,"Accounts","Female",LocalDate.of(2023,1,28),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(109,"Riyaz",58,5500000.00,"Development","Male",LocalDate.of(2022,11,8),skillSetList,addressList,empPerformanceMap));
		empList.add(new Employee(110,"Suraj",25,987000.00,"Testing","Male",LocalDate.of(2022,05,8),skillSetList,addressList,empPerformanceMap));
	}
}
