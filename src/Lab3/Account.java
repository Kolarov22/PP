package Lab3;

public abstract class Account {
    private String IBAN;
    private int ammount;

    public Account(String IBAN, int ammount) {
        this.IBAN = IBAN;
        this.ammount = ammount;
    }

    public abstract boolean withdraw(int ammount);

    public void deposit(int ammount){
        if(ammount > 0){
            this.setAmmount(ammount + this.getAmmount());
        }
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
}
