package ru.otus.oop.atm.impl;

import ru.otus.oop.atm.impl.money.cell.FiftyMoneyCell;
import ru.otus.oop.atm.interfaces.MoneyCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyCellImplTest {
    @Test
    void canGetMoneyTest() throws Exception {
        MoneyCell cell = new FiftyMoneyCell(10);
        assertFalse(cell.canGet(10));

        assertTrue(cell.canPut(10));

        cell.putMoney(10);
        assertTrue(cell.canGet(10));
    }
}
