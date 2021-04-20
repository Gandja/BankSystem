public class SberAccount implements Account{

    private BankAccount bankAccount;
    private String name;

    public SberAccount(BankAccount bankAccount, String name) {
        this.bankAccount = bankAccount;
        this.name = name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
