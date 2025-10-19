package Lab3;

public class CreditAccount extends Account{
    private int maxCredit;

    public CreditAccount(String IBAN, int ammount, int maxCredit) {
        super(IBAN, ammount);
        this.maxCredit = maxCredit;
    }

    @Override
    public boolean withdraw(int ammount) {
        int currentFunds = this.getAmmount() + this.getMaxCredit();
        if(ammount > currentFunds){
            return false;
        }

        int remainingMoney = currentFunds - ammount;
        this.setAmmount(remainingMoney);
        return true;
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(int maxCredit) {
        this.maxCredit = maxCredit;
    }
}
