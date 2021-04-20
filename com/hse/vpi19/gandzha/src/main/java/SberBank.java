import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SberBank implements Bank {

    private String name = "Sberbank";
    private CopyOnWriteArrayList<Transaction> transactions = new CopyOnWriteArrayList<>();

    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println("Transaction id");
            System.out.println(t.getId());
            System.out.println("From bank account number");
            System.out.println( t.getFromAccount().getName());
            System.out.println("To bank account number ");
            System.out.println(t.getToAccount().getName());
            System.out.println(t.getTransferStatus());
            System.out.println("Balance");
            System.out.println(t.getMoney() + "$");
            System.out.println();
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
}
