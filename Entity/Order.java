package Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import Entity.EnumClasses.OrderStatus;
import Entity.EnumClasses.PaymentMethod;

public class Order {
	
	private int orderId;
	private String orderName;
	private LocalDate orderedDate;
	private double orderPrice;
	private OrderStatus orderStatus;
	private List<Address> orderDeliAddress;
	private PaymentMethod orderPaymentType;
	
	public Order(int orderId, String orderName, LocalDate orderedDate, double orderPrice, OrderStatus orderStatus,
			List<Address> orderDeliAddress, PaymentMethod orderPaymentType) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderedDate = orderedDate;
		this.orderPrice = orderPrice;
		this.orderStatus = orderStatus;
		this.orderDeliAddress = orderDeliAddress;
		this.orderPaymentType = orderPaymentType;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<Address> getOrderDeliAddress() {
		return orderDeliAddress;
	}
	public void setOrderDeliAddress(List<Address> orderDeliAddress) {
		this.orderDeliAddress = orderDeliAddress;
	}
	public PaymentMethod getOrderPaymentType() {
		return orderPaymentType;
	}
	public void setOrderPaymentType(PaymentMethod orderPaymentType) {
		this.orderPaymentType = orderPaymentType;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderDeliAddress, orderId, orderName, orderPaymentType, orderPrice, orderStatus,
				orderedDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderDeliAddress, other.orderDeliAddress) && orderId == other.orderId
				&& Objects.equals(orderName, other.orderName) && orderPaymentType == other.orderPaymentType
				&& Double.doubleToLongBits(orderPrice) == Double.doubleToLongBits(other.orderPrice)
				&& orderStatus == other.orderStatus && Objects.equals(orderedDate, other.orderedDate);
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderedDate=" + orderedDate
				+ ", orderPrice=" + orderPrice + ", orderStatus=" + orderStatus + ", orderDeliAddress="
				+ orderDeliAddress + ", orderPaymentType=" + orderPaymentType + "]";
	}
}
