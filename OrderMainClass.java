package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Entity.Address;
import Entity.Order;
import Entity.EnumClasses.PaymentMethod;
import Entity.EnumClasses.OrderStatus;

public class OrderMainClass {

	public static void main(String[] args) {
		
		//creating a list of address
		List<Address> addressList = new ArrayList<>();
		//Adding Address - Flat no.,city,state,pincode
		addressList.add(new Address("B100","Trichy","TamilNadu","450022"));
		addressList.add(new Address("107","Salem","TamilNadu","600100"));
		addressList.add(new Address("427/2","Panipat","Haryana","100100"));
		addressList.add(new Address("G40","Bhopal","Madhyapradesh","500444"));
		addressList.add(new Address("32E","Chennai","TamilNadu","200100"));
		
		//creating list of orders
		List<Order> orderList = new ArrayList<>();
		//Adding orders - orderId,orderName,orderedDate,orderPrice,orderStatus,orderAddress,orderPaymentMethod
		orderList.add(new Order(1,"T-shirt",LocalDate.of(2023,01,20),1200.0,OrderStatus.DISPATCHED,addressList,PaymentMethod.UPI));
		orderList.add(new Order(2,"Jeans",LocalDate.of(2023,01,25),4300.0,OrderStatus.CANCELLED,addressList,PaymentMethod.CARD));
		orderList.add(new Order(3,"Trousers",LocalDate.of(2023,02,12),2200.0,OrderStatus.ORDERED,addressList,PaymentMethod.CASH_ON_DELIVERY));
		orderList.add(new Order(4,"Makeup-Kit",LocalDate.of(2023,02,04),1500.0,OrderStatus.ORDERED,addressList,PaymentMethod.CASH_ON_DELIVERY));
		orderList.add(new Order(5,"HairSpray",LocalDate.of(2023,02,20),760.0,OrderStatus.DISPATCHED,addressList,PaymentMethod.UPI));
		orderList.add(new Order(6,"PressureCokker",LocalDate.of(2023,01,01),1599.50,OrderStatus.DELIVERED,addressList,PaymentMethod.CARD));
		orderList.add(new Order(7,"RemoteCar",LocalDate.of(2023,01,06),1785.25,OrderStatus.DELIVERED,addressList,PaymentMethod.UPI));
		
		//Question 1-Return list of orders with ordered date before feb 12th
		List<Order> orderListBfrDate = orderList
				.stream()
				.filter(o -> o.getOrderedDate().isBefore(LocalDate.of(2023,02,12)))
				.collect(Collectors.toList());
		System.out.println("Orders ordered before Feb 12th:"+ orderListBfrDate);
		
		//Question 2-Return the sum of prices of all orders
		double sumOfPrices = orderList
				.stream()
				.mapToInt(o -> (int)o.getOrderPrice())
				.summaryStatistics()
				.getSum();
		System.out.println("Sum of prices of all orders:" + sumOfPrices);
		
		//Question 3-Give the list of orders whose status is delivered
		List<Order> deliveredOrders = orderList 
				 .stream() 
				 .filter(o -> o.getOrderStatus().name().equalsIgnoreCase("DELIVERED")) .collect(Collectors.toList());
		System.out.println("Delivered orders:" + deliveredOrders);
		
	}

}
