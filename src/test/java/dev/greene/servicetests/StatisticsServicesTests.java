package dev.greene.servicetests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import dev.greene.entities.ManagerTotals;
import dev.greene.services.StatisticsServices;
import dev.greene.services.StatisticsServicesImpl;

public class StatisticsServicesTests {
	
	public static StatisticsServices ss = StatisticsServicesImpl.getStatisticsServices();
	
	@Test
	public void TotalsTest() {
		List <ManagerTotals> totals = ss.getTotalPerManager();
		for (ManagerTotals entry : totals)  
            System.out.println(entry); 
	}
	
	@Test
	public void AverageTest() {
		System.out.println(ss.getAverageSize());
	}
	
	@Test
	public void ApprovedTest() {
		System.out.println(ss.getApproved());
	}
	
	@Test
	public void DeniedTest() {
		System.out.println(ss.getDenied());
	}

	@Test
	public void getMostTest() {
		System.out.println(ss.getMost());
	}
	@Test
	public void getStats() {
		System.out.println(ss.populateAll());
	}

}
