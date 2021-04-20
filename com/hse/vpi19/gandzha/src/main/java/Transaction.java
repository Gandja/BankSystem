import java.util.UUID;

public class Transaction implements Transactional {

    private UUID id;
    private Account fromAccount;
    private Account toAccount;
    private double money;
    private TransferStatus transferStatus;

    public Transaction(UUID id, Account fromAccount, Account toAccount, double money) {
        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.money = money;
    }

    @Override
    public void transfer() {
        double moneyFromAccount = fromAccount.getBankAccount().getMoney();
        double moneyToAccount = toAccount.getBankAccount().getMoney();
        if (moneyFromAccount >= money) {
            moneyFromAccount -= money;
            moneyToAccount += money;
            fromAccount.getBankAccount().setMoney(moneyFromAccount);
            toAccount.getBankAccount().setMoney(moneyToAccount);
            transferStatus = TransferStatus.SUCCESS;
        } else {
            transferStatus = TransferStatus.CANCELED;
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(TransferStatus transferStatus) {
        this.transferStatus = transferStatus;
    }
}
