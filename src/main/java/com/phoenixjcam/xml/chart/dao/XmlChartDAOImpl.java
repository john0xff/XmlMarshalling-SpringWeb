package com.phoenixjcam.xml.chart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenixjcam.xml.chart.model.XmlChartModel;

@Repository
public class XmlChartDAOImpl implements XmlChartDAO
{
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<XmlChartModel> getAllCharts()
	{
		return getCurrentSession().createQuery("from XmlChartModel").list();
	}

}
