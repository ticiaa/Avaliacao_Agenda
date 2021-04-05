package Programa;

import Classes.Contact;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int totalvector = 0;
        int opt = -1;

        Scanner read = new Scanner(System.in);

        System.out.println("Quatidade de contatos a serem cadastrados:");
        totalvector = read.nextInt();
        read.nextLine();

        Contact[] contacts = new Contact[totalvector];

        while (opt != 0) {
            showMenu();
            opt = read.nextInt();
            read.nextLine();

            switch (opt) {
            case 0:
                End();
                return;
            case 1:
                register(totalvector, read, contacts);
                break;

            case 2:
                ShowList(totalvector, contacts);
                break;

            case 3:
                SearchbyName(totalvector, read, contacts);
                break;

            case 4:
                SearchbyCode(totalvector, read, contacts);
                break;

            }
        }
        read.close();
    }

    // #region métodos

    private static void register(int totalvector, Scanner read, Contact[] contacts) {
        for (int i = 0; i < totalvector; i++) {

            Contact contact = new Contact();
            System.out.println("\nPara cadastrar um contato digite as seguintes informações: ");
            System.out.println("Nome: ");
            contact.setName(read.next());
            System.out.println("Número: ");
            contact.setNumber(read.next());
            System.out.println(
                    "\nA seguir, insira um idCode (serial numérico de identificação) para atribuí-lo ao seu contato: \nidCode serve como atalho para localizar seus contatos.");
            System.out.println("\nidCode: ");
            contact.setCode(read.nextInt());
            System.out.println("Contato salvo com sucesso!");
            read.nextLine();
            contacts[i] = contact;
        }
    }

    private static void End() {
        System.out.println("Encerrado");
    }

    private static void SearchbyCode(int totalvector, Scanner read, Contact[] contacts) {
        System.out.println("Informe o códico a ser localizado: ");
        int s_code = read.nextInt();

        for (int i = 0; i < totalvector; i++) {
            if (contacts[i].getCode() == s_code) {
                System.out.println("Contato localizado: ");
                System.out.printf("\nidCode: %s \nNome: %s - Número: %s", contacts[i].getCode(), contacts[i].getName(),
                        contacts[i].getNumber());
                break;
            } else {
                if (contacts[i].getCode() != s_code) {
                    System.out.println("Código não compatível.");
                }
            }
        }
    }

    private static void SearchbyName(int totalvector, Scanner read, Contact[] contacts) {
        System.out.println("Informe o nome a ser localizado: ");
        String s_name = read.next();

        for (int i = 0; i < totalvector; i++) {
            if (contacts[i].getName().equals(s_name)) {
                System.out.printf("Contato localizado: ");
                System.out.printf("\nNome: %s \nNúmero: %s - idCode: %s", contacts[i].getName(),
                        contacts[i].getNumber(), contacts[i].getCode());
                break;
            } else {
                if (contacts[i].getName() != s_name) {
                    System.out.println("Nome não encontrado.");
                }
            }
        }
    }

    private static void ShowList(int totalvector, Contact[] contacts) {
        System.out.println("Lista de contatos: ");
        for (int i = 0; i < totalvector; i++) {
            System.out.println("_____________________________");
            System.out.println("Nome: " + contacts[i].getName());
            System.out.println("Número: " + contacts[i].getNumber());
            System.out.println("idCode: " + contacts[i].getCode());
        }
    }

    private static void showMenu() {
        System.out.println("\n_____________________________");
        System.out.println("1 - Criar novo contato");
        System.out.println("2 - Exibir lista de contatos");
        System.out.println("3 - Pesquisar por nome");
        System.out.println("4 - Pesquisar por idCode");
        System.out.println("0 - Sair");
        System.out.println("\nDigite a opção desejada: ");
    }

    // #endregion

}
