package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depostiShouldIncreseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
		
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectValue = 100.0;
		Account acc = AccountFactory.createAccount(expectValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
		
	}
	
	@Test
	public void fullWithdrawShouldClearBalance() {
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullwithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
		
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500.0);
		
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldTrhowExceptionWhenSufficientBalance() {
			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
		});
		
	}

}
