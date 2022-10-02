package hu.nye.progtech.money;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MoneyTest {

    private static final Currency HUF = Currency.getInstance("HUF");
    private static final Currency USD = Currency.getInstance("USD");

    @Mock
    private Bank bank;

    private Money underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Money(10, HUF);
    }

    @Test
    public void testAddShouldConvertAdditionalMoneyAddItToCurrentValueAndReturnNewMoneyObject() {
        // given
        Money addition = new Money(10, USD);
        given(bank.getExchangeRate(USD, HUF)).willReturn(new BigDecimal(2));

        // when
        Money result = underTest.add(addition, bank);

        // then
        Money expected = new Money(30, HUF);
        assertEquals(expected, result);
        assertNotSame(underTest, result);
    }

    @Test
    public void testToStringShouldFormatCorrectly(){
        Money testMoney = new Money(10, HUF);
        String outputString = "Money{value=10, currency=HUF}";
        assertEquals(testMoney.toString(), outputString);
    }

    @Test
    public void testTwoInstancesOfMoneyWithSameCurrencyShouldReturnSameCurrency(){
        Money money1 = new Money(1000, HUF);
        Money money2 = new Money(5000, HUF);
        assertEquals(money1.getCurrency(),money2.getCurrency());
    }

    @Test
    public void testTwoInstancesOfMoneyShouldNotHaveTheSameHashCode(){
        Money money1 = new Money(60000, HUF);
        Money money2 = new Money(100, USD);
        assertNotEquals(money1.hashCode(),money2.hashCode());
    }

    @Test
    public void testInstanceOfMoneyShouldBeEqualToItself() {
        Money money = new Money(1000, HUF);
        assertTrue(money.equals(money));
    }

    @Test
    public void testInstanceOfMoneyShouldNotBeEqualToNullObjectOrDifferentClass() {
        Money money = new Money(1000, HUF);
        Product product = new Product("product",new Money(1000,HUF));
        assertFalse(money.equals(null));
        assertFalse(money.equals(product));
    }

    @Test
    public void testTwoInstancesOfMoneyWithDifferentAmountOfMoneyShouldNotBeEqual() {
        Money money1 = new Money(60000, HUF);
        Money money2 = new Money(10000, HUF);
        assertFalse(money1.equals(money2));
    }

    @Test
    public void testTwoInstancesOfMoneyWithSameAmountOfMoneyShouldBeEqual() {
        Money money1 = new Money(10000, HUF);
        Money money2 = new Money(10000, HUF);
        assertTrue(money1.equals(money2));
    }
}
