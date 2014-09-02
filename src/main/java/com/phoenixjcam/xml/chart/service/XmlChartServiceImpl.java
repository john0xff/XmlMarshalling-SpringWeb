package com.phoenixjcam.xml.chart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenixjcam.xml.chart.dao.XmlChartDAO;
import com.phoenixjcam.xml.chart.model.XmlChartModel;

@Service
@Transactional
public class XmlChartServiceImpl implements XmlChartService
{
	@Autowired
	private XmlChartDAO xmlChartDAO;

	@Override
	public List<XmlChartModel> getAllCharts()
	{
		return xmlChartDAO.getAllCharts();
	}

}
