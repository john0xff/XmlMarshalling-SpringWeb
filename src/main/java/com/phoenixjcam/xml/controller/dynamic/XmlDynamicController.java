package com.phoenixjcam.xml.controller.dynamic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phoenixjcam.xml.chart.model.XmlChartModel;
import com.phoenixjcam.xml.chart.model.convert.XmlChartModelConverter;
import com.phoenixjcam.xml.chart.service.XmlChartService;

@Controller
public class XmlDynamicController
{
	@Autowired
	private XmlChartService chartService;

	@RequestMapping(value = "/dynamicXml", method = RequestMethod.GET)
	public ModelAndView getJqxJsonTest()
	{
		ModelAndView modelAndView = new ModelAndView("dynamicSource/dynamicChartXml");

		return modelAndView;
	}

	/**
	 * get data form data base and convert it to XML file
	 * @return
	 */
	@RequestMapping(value = "/dynamicXmlFile", method = RequestMethod.GET, produces = "application/xhtml+xml")
	@ResponseBody
	public XmlChartModelConverter.Orders getDynamicJsonFile()
	{
		List<XmlChartModel> list = chartService.getAllCharts();

		XmlChartModelConverter.Orders orders = new XmlChartModelConverter.Orders();
		orders.setOrders(new ArrayList<XmlChartModelConverter.Order>());

		XmlChartModelConverter.Order order;

		for (XmlChartModel xmlChartModel : list)
		{
			order = new XmlChartModelConverter.Order();
			
			order.setDate(xmlChartModel.getDate());
			order.setQuantity(xmlChartModel.getQuantity());
			order.setDescription(xmlChartModel.getDescription());

			orders.getOrders().add(order);
		}

		return orders;
	}
	
	// - ------------------ TEST of basic XML marshalling

	@RequestMapping(value = "/dynamicXmlFileCoffee", method = RequestMethod.GET, produces = "application/xhtml+xml")
	@ResponseBody
	public Coffee getJqxChartTest2()
	{
		Coffee c = new Coffee();

		c.setName("123");
		c.setQuality(1);

		return c;
	}

	@XmlRootElement(name = "coffee")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Coffee
	{
		@XmlElement(name = "name")
		String name;

		@XmlElement(name = "quality")
		int quality;

		public Coffee()
		{
		}

		public Coffee(String name, int quality)
		{
			this.name = name;
			this.quality = quality;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public int getQuality()
		{
			return quality;
		}

		public void setQuality(int quality)
		{
			this.quality = quality;
		}

	}
}
