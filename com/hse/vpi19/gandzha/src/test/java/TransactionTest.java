import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    @Test
    public void transferTest() {

        BankAccount bankAccount1 = new SberBankAccount(new Random().nextDouble(), 800);
        BankAccount bankAccount2 = new SberBankAccount(new Random().nextDouble(), 1000);

        Account account1 = new SberAccount(bankAccount1, UUID.randomUUID().toString());
        Account account2 = new SberAccount(bankAccount2, UUID.randomUUID().toString());

        Transaction transaction1 = new Transaction(UUID.randomUUID(), account1, account2, 300);
        Transaction transaction2 = new Transaction(UUID.randomUUID(), account2, account1, 600);

        transaction1.transfer();
        transaction2.transfer();

        assertEquals(1100, bankAccount1.getMoney());
        assertEquals(700, bankAccount2.getMoney());

    }
}
