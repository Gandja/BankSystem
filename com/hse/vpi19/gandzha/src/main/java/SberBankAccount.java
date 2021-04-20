public class SberBankAccount implements BankAccount{

    private double number;
    private double money;

    public SberBankAccount(double number, double money) {
        this.number = number;
        this.money = money;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
