package Entity;

import java.util.Objects;

public class Address {
	
	private String flatNo;
	private String city;
	private String state;
	private String pincode;
	
	public Address(String flatNo, String city, String state, String pincode) {
		super();
		this.flatNo = flatNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, flatNo, pincode, state);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(flatNo, other.flatNo)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(state, other.state);
	}
	@Override
	public String toString() {
		return "Address [flatNo=" + flatNo + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
}
