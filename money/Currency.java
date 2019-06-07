package money;

import java.util.HashMap;

public class Currency {
	String name;
	double exRateToDollar;
	
	
	
	public Currency(String name, double exRateToDollar) {
		this.name = name;
		this.exRateToDollar = exRateToDollar;
	}
	
	public String getName () {
		return this.name;
	}
	
	public double getRate() {
		return this.exRateToDollar;
	}
}
