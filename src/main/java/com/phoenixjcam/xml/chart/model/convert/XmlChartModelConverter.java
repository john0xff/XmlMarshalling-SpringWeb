package com.phoenixjcam.xml.chart.model.convert;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class XmlChartModelConverter
{
	// main root of XML
	@XmlRootElement(name = "Orders")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Orders
	{
		@XmlElement(name = "Order")
		public List<Order> orders;

		public List<Order> getOrders()
		{
			return orders;
		}

		public void setOrders(List<Order> order)
		{
			this.orders = order;
		}

	}

	// content root elements
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Order
	{
		@XmlElement(name = "Date")
		private String date;

		@XmlElement(name = "Quantity")
		private int quantity;

		@XmlElement(name = "Description")
		private String description;

		public Order()
		{
		}

		public Order(String date, int quantity, String description)
		{
			this.date = date;
			this.quantity = quantity;
			this.description = description;
		}

		public String getDate()
		{
			return date;
		}

		public void setDate(String date)
		{
			this.date = date;
		}

		public int getQuantity()
		{
			return quantity;
		}

		public void setQuantity(int quantity)
		{
			this.quantity = quantity;
		}

		public String getDescription()
		{
			return description;
		}

		public void setDescription(String description)
		{
			this.description = description;
		}
	}

}
