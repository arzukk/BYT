package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
	}


	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SweBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException {
		SweBank.openAccount("John");
		assertTrue(SweBank.accountlist.containsKey("John"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(500, SEK));
		assertEquals(75, SweBank.getBalance("Ulrika").intValue());
	}


	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Bob", new Money(200, SEK));
		assertEquals(-30, SweBank.getBalance("Bob").intValue());
	}


	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		assertEquals(150, SweBank.getBalance("Bob").intValue());
	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.transfer("Ulrika", DanskeBank, "Gertrud", new Money(100, SEK));
		assertEquals(-15, SweBank.getBalance("Ulrika").intValue());
		assertEquals(15, DanskeBank.getBalance("Gertrud").intValue());
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Bob", "payment1", 2, 1, new Money(500, SEK), DanskeBank, "Gertrud");
		SweBank.tick();
		assertEquals(-75, SweBank.getBalance("Bob").intValue());
		assertEquals(75, DanskeBank.getBalance("Gertrud").intValue());
	}
}
