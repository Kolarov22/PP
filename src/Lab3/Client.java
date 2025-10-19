package Lab3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private LocalDate bday;
    private String CNP;
    private Address address;
    private List<Account> accountList = new ArrayList<>();

    public Client(String name, LocalDate bday, String CNP) {
        this.name = name;
        this.bday = bday;
        this.CNP = CNP;
    }

    public void addAccount(Account a){
        accountList.add(a);
    }

    public boolean removeAccount(String IBAN){
        for(Account a : accountList){
            if(a.getIBAN().equals(IBAN)){
                accountList.remove(a);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
