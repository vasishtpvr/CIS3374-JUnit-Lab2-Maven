package com.lab2.transit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)

public class FareCalculatorTest {
	
	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;
	private	static	final	double	DELTA	=	1e-15;
	    
	
	public FareCalculatorTest(double expected,int age,String time,boolean isHoliday){
		this.expected=expected;
		this.age=age;
		this.time=time;
		this.isHoliday=isHoliday;
	}
	
	@Parameters
	public static Collection<Object[]> testParams(){
		return Arrays.asList(new Object[][]{
				{0.0,5,"10:00",false},{2.5,6,"10:00",false},{0.0,65,"10:00",false}
				,{2.5,64,"10:00",false},{2.5,70,"7:00",false},{0.0,75,"6:59",false},{0.0,80,"9:01",false},{2.5,80,"9:00",false},{0.0,80,"7:30",true},{0.0,85,"8:00",true}});
		}

	@Test
	public void calculateFareTest(){
		assertEquals(expected,FareCalculator.calculateFare(age,time,isHoliday),DELTA);
				}
	
	
	

}
