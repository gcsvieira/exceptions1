package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawalException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Account account1 = new Account(8000, "Conta 1", 500.00, 250.00);
        Account account2 = new Account(8000, "Conta 1", 250.00);
        Double withdraw;

        System.out.println(account1);
        System.out.println(account2);

        try {

            System.out.println("Digite um valor para saque conta 1: ");
            withdraw = Double.parseDouble(scan.nextLine());
            account1.withdraw(withdraw);

            System.out.println("Digite um valor para saque conta 2: ");
            withdraw = Double.parseDouble(scan.nextLine());
            account2.withdraw(withdraw);

        } catch (WithdrawalException e) {
            System.out.println("Erro na hora de efetuar o saque: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado. Contate um adm.");
        }

        System.out.println(account1);
        System.out.println(account2);

        scan.close();
    }
}
