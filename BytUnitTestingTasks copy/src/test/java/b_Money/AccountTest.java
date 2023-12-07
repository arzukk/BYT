package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}

	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("payment1", 2, 1, new Money(500, SEK), SweBank, "Alice");

		assertTrue(testAccount.timedPaymentExists("payment1"));

		testAccount.removeTimedPayment("payment1");

		assertFalse(testAccount.timedPaymentExists("payment1"));
	}


	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("payment2", 1, 0, new Money(200, SEK), SweBank, "Alice");

		for (int i = 0; i < 3; i++) {
			SweBank.tick();
		}
		assertEquals(1500000, testAccount.getBalance().getAmount().intValue());
	}


	@Test
	public void testAddWithdraw() {
		testAccount.deposit(new Money(50000, SEK));
		assertEquals(1507500, testAccount.getBalance().getAmount().intValue());

		testAccount.withdraw(new Money(20000, SEK));

		assertEquals(1504500, testAccount.getBalance().getAmount().intValue());
	}


	@Test
	public void testGetBalance() {
		testAccount.deposit(new Money(75000, SEK));

		assertEquals(1511250, testAccount.getBalance().getAmount().intValue());
	}

}
