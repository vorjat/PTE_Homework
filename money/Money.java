package money;

import java.util.HashMap;

class Money {
	private double fAmount;
	private Currency fCurrency;

	public Money(double amount, Currency currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	public double getAmount() {
		return fAmount;
	}

	public Currency getCurrency() {
		return fCurrency;
	}

	private void setAmount(double a) {
		this.fAmount = a;
	}

	public Money add(Money m) {
		if (this.getCurrency().getName().equals(m.getCurrency().getName())) {
			return new Money(getAmount() + m.getAmount(), this.getCurrency());
		} else {
			double thisInDollars = this.getAmount() * this.getCurrency().getRate();
			double mInDollars = m.getAmount() * m.getCurrency().getRate();
			double calculatedAmount = (thisInDollars + mInDollars) / this.getCurrency().getRate();
			return new Money(calculatedAmount, this.getCurrency());
		}
	}

	public Money subtract(Money m) {
		Money tempM = m;
		tempM.setAmount(m.getAmount() * -1);
		return this.add(tempM);
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;
		return a.getCurrency().getName().equals(getCurrency().getName()) && getAmount() == a.getAmount();
		//return a.getCurrency().getName().equals(getCurrency().getName());
		}
		return false;
		
	}

	public Money multiply(double i) {
		double temp = this.getAmount() * i;
		Money tempMoney = new Money(temp, this.getCurrency());
		return tempMoney;
	}

	public double calcDollarValue() {
		return this.getAmount() * this.getCurrency().getRate();
	}

	public boolean equalsValue(Money m) {
		return calcDollarValue() == m.calcDollarValue();
	}
}