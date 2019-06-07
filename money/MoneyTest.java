package money;


import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyTest {
	private Currency CHF;
	
	@BeforeEach
	public void setUp() throws Exception {
		CHF = new Currency("CHF", 1);
	}
	
	@Test
	public void testSimpleAdd() {
		Money m12CHF = new Money(12, CHF); //
		Money m14CHF = new Money(14, CHF);
		Money expected = new Money(26, CHF);
		Money result = m12CHF.add(m14CHF); //
		assertTrue(expected.equals(result)); //
		}

	@Test
	public void testEquals() {
		Money m12CHF = new Money(12, CHF);
		Money m14CHF = new Money(14, CHF);

		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, CHF));
		assertTrue(!m12CHF.equals(m14CHF));
		}

}