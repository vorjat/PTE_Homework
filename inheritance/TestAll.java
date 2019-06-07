package inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestAll {
	private Employee employee;
	private Manager manager;
	
	@BeforeEach
	public void setUp() throws Exception {
		employee = new Employee("Jan Kowalski", 10000, 2015, 12, 1 );
		manager = new Manager("Piotr Nowak", 30000, 2010, 6, 15 );
	}
	
	@Test
	public void getsOfEmployeeTest() {
		assertEquals(employee.getName(), "Jan Kowalski");
		assertTrue(employee.getSalary()==10000);
		GregorianCalendar calendar = new GregorianCalendar(2015, 11, 1);
		Date date = calendar.getTime();
		assertEquals(employee.getHireDay(), date);
	}
	@Test
	public void raiseSalaryTest() {
		employee.raiseSalary(50);
		assertTrue(employee.getSalary()==15000);
	}
	@Test
	public void raiseSalaryByMinusTest() {
		employee.raiseSalary(-50);
		assertTrue(employee.getSalary()==5000);
	}
	
	@Test
	public void getsOfManagerTest() {
		assertEquals(manager.getName(), "Piotr Nowak");
		assertTrue(manager.getSalary()==30000);
		GregorianCalendar calendar = new GregorianCalendar(2010, 5, 15);
		Date date = calendar.getTime();
		assertEquals(manager.getHireDay(), date);
	}
	
	@Test
	public void raiseManagerSalaryTest() {
		manager.raiseSalary(10);
		assertTrue(manager.getSalary()==33000);
	}
	
	@Test
	public void bonusTest() {
		manager.setBonus(5000);
		assertTrue(manager.getBonus()==5000);
	}
}
