import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.UUID;


public class BankSystemTest {

    @Test
    public void testScenario() throws InterruptedException {

        Bank sberBank = new SberBank();

        BankAccount bankAccount1 = new SberBankAccount(new Random().nextDouble(),800);
        BankAccount bankAccount2 = new SberBankAccount(new Random().nextDouble(),1000);
        BankAccount bankAccount3 = new SberBankAccount(new Random().nextDouble(), 2000);

        Account account1 = new SberAccount(bankAccount1, UUID.randomUUID().toString());
        Account account2 = new SberAccount(bankAccount2, UUID.randomUUID().toString());
        Account account3 = new SberAccount(bankAccount3, UUID.randomUUID().toString());

        Transaction transaction1 = new Transaction(UUID.randomUUID(),account1,account2, 300);
        Transaction transaction2 = new Transaction(UUID.randomUUID(),account2,account1,600);
        Transaction transaction3 = new Transaction(UUID.randomUUID(), account1, account3,400);
        Transaction transaction4 = new Transaction(UUID.randomUUID(),account3,account2,200);


        Runnable runnable1 = () -> {
            transaction1.transfer();
            sberBank.getTransactions().add(transaction1);
        };

        Runnable runnable2 = () -> {
            transaction2.transfer();
            sberBank.getTransactions().add(transaction2);
        };

        Runnable runnable3 = () -> {
            transaction3.transfer();
            sberBank.getTransactions().add(transaction3);
        };

        Runnable runnable4 = () -> {
            transaction4.transfer();
            sberBank.getTransactions().add(transaction4);
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        Thread thread4 = new Thread(runnable4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(1500);

        assertEquals(700, bankAccount1.getMoney());
        assertEquals(900, bankAccount2.getMoney());
        assertEquals(2200,bankAccount3.getMoney());

    }
}
