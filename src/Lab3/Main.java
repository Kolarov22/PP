package Lab3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Michael", LocalDate.of(2002, 10, 27), "12345");
        Address address1 = new Address("Pitesti", 27, "Calea Bucuresti");
        client1.setAddress(address1);
        Account account1 = new DebitAccount("RO2710", 1000);
        client1.addAccount(account1);

        Client client2 = new Client("Andreea", LocalDate.of(2003, 5, 15), "67890");
        Address address2 = new Address("Bucharest", 15, "Splaiul Independentei");
        client2.setAddress(address2);
        Account account2 = new CreditAccount("RO3050", 1000, 500);
        client2.addAccount(account2);

        System.out.println("Lab3.Client 1: " + client1.getName() + ", Lab3.Address: " + client1.getAddress().getCity() + ", Lab3.Account IBAN: " + account1.getIBAN() + ", Balance: " + account1.getAmmount());
        System.out.println("Lab3.Client 2: " + client2.getName() + ", Lab3.Address: " + client2.getAddress().getCity() + ", Lab3.Account IBAN: " + account2.getIBAN() + ", Balance: " + account2.getAmmount());

        System.out.println("Withdraw status: " + client1.getAccountList().get(0).withdraw(200) + "\nNew balance: " + client1.getAccountList().get(0).getAmmount());
        System.out.println("Withdraw status: " + client2.getAccountList().get(0).withdraw(2000) + "\nNew balance: " + client2.getAccountList().get(0).getAmmount());

    }
}
