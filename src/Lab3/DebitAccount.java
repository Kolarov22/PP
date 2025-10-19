package Lab3;

public class DebitAccount extends Account{
    public DebitAccount(String IBAN, int ammount) {
        super(IBAN, ammount);
    }

    @Override
    public boolean withdraw(int ammount) {
        if(ammount > this.getAmmount()){
            return false;
        }

        int remainingMoney = this.getAmmount() - ammount;
        this.setAmmount(remainingMoney);

        return true;
    }
}
