package money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

public class MoneyTest3 {

	private Money testMoney1;
	private Money testMoney2;
	private Currency PLN;
	private Currency USD;
	private Currency EUR;
	
	@BeforeEach
	public void setUp() throws Exception {
		PLN = new Currency ("PLN", 0.26);
		USD = new Currency("USD", 1.);
		EUR = new Currency ("EUR", 1.14);
		testMoney1 = new Money(1, PLN);
	}

	@Test
	public void multiplyByTwoTest() {
		testMoney2 = new Money(2, PLN);

		//assertEquals(testMoney1.multiply(2), testMoney2);
		assertTrue(testMoney1.multiply(2).equals(testMoney2));
	}

	@Test
	public void multiplyByFractionTest() {
		testMoney2 = new Money(3.5, PLN);

		assertTrue(testMoney1.multiply(3.5).equals(testMoney2));
	}
	
	@Test
	public void addCurrencies() {
		testMoney1 = new Money(10, USD);
		testMoney2 = new Money(10, PLN);
		Money testMoney3 = new Money(1, PLN);
		Money expected = new Money(12.6, USD);
		assertTrue(testMoney1.add(testMoney2).equals(expected));
		expected = new Money(11, PLN);
		assertTrue(testMoney2.add(testMoney3).equalsValue(expected));
	}
	
	@Test
	public void addCurrenciesNoDollars() {
		testMoney1 = new Money(100, PLN);
		testMoney2 = new Money(2, EUR);
		Money expected = new Money(108.76923076923077, PLN);
		assertTrue(testMoney1.add(testMoney2).equals(expected));
	}
	
	@Test
	public void subtractDifferentCurrencies() {
		testMoney1 = new Money(10, USD);
		testMoney2 = new Money(10, PLN);
		Money expected = new Money(7.4, USD);
		assertTrue(testMoney1.subtract(testMoney2).equals(expected));
	}
	
	@Test
	public void compareCurrencies() {
		testMoney1 = new Money(0.26, USD);
		testMoney2 = new Money(10, PLN);
		Money testMoney3 = new Money(1, PLN);
		
		assertFalse(testMoney1.equalsValue(testMoney2));
		assertTrue(testMoney1.equalsValue(testMoney3));
	}
	
	@Test void compareMoneyWithNotMoney() {
		assertNotEquals(testMoney1, 3);
	}
	
}
