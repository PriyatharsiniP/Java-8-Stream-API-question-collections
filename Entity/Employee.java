package Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Employee {
	
	private int empId;
	private String empName;
	private int empAge;
	private double empSalary;
	private String empDept;
	private String empGender;
	private LocalDate empJoiningDate;
	private List<String> empSkillset;
	private List<Address> empAddrList;
	private Map<Integer,String> empPerformance;
	
	public Employee(int empId, String empName, int empAge, double empSalary, String empDept, String empGender,
			LocalDate empJoiningDate, List<String> empSkillset, List<Address> empAddrList,
			Map<Integer, String> empPerformance) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
		this.empDept = empDept;
		this.empGender = empGender;
		this.empJoiningDate = empJoiningDate;
		this.empSkillset = empSkillset;
		this.empAddrList = empAddrList;
		this.empPerformance = empPerformance;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public LocalDate getEmpJoiningDate() {
		return empJoiningDate;
	}
	public void setEmpJoiningDate(LocalDate empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}
	public List<String> getEmpSkillset() {
		return empSkillset;
	}
	public void setEmpSkillset(List<String> empSkillset) {
		this.empSkillset = empSkillset;
	}
	public List<Address> getEmpAddrList() {
		return empAddrList;
	}
	public void setEmpAddrList(List<Address> empAddrList) {
		this.empAddrList = empAddrList;
	}
	public Map<Integer, String> getEmpPerformance() {
		return empPerformance;
	}
	public void setEmpPerformance(Map<Integer, String> empPerformance) {
		this.empPerformance = empPerformance;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empAddrList, empAge, empDept, empGender, empId, empJoiningDate, empName, empPerformance,
				empSalary, empSkillset);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empAddrList, other.empAddrList) && empAge == other.empAge
				&& Objects.equals(empDept, other.empDept) && Objects.equals(empGender, other.empGender)
				&& empId == other.empId && Objects.equals(empJoiningDate, other.empJoiningDate)
				&& Objects.equals(empName, other.empName) && Objects.equals(empPerformance, other.empPerformance)
				&& Double.doubleToLongBits(empSalary) == Double.doubleToLongBits(other.empSalary)
				&& Objects.equals(empSkillset, other.empSkillset);
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ ", empDept=" + empDept + ", empGender=" + empGender + ", empJoiningDate=" + empJoiningDate
				+ ", empSkillset=" + empSkillset + ", empAddrList=" + empAddrList + ", empPerformance=" + empPerformance
				+ "]";
	}
}
