package control;

import Services.Service;
import control.Login;
import model.Angajat;
import model.Concurent;
import model.Concurs;
import repository.AngajarRepo;
import repository.ConcurentRepo;
import repository.ConcursRepo;
import repository.InscrisiRepo;

import java.util.Scanner;

public class Menu {

    private static Boolean login = Boolean.FALSE;
    static AngajarRepo aRepo = new AngajarRepo();
    static Login loginCheck = new Login();
    static ConcurentRepo concurentRepo = new ConcurentRepo();

    public static void run() {

        String name;
        String password;

        Scanner inName = new Scanner(System.in);
        System.out.println("Name: ");
        name = inName.nextLine();

        Scanner inPass = new Scanner(System.in);
        System.out.println("Password:");
        password = inPass.nextLine();

        if (aRepo.check(name, password) == true) {
            System.out.println("Good Username or Password");
            menu2();
        } else {
            System.out.println("Invalid Username or Password");
        }
    }

    public static void menu2() {
        ConcursRepo concursRepo =new ConcursRepo();
         Service service=new Service();
        String menu = "Choose an option \n" +
                "1: Inscrie un nou concurent \n" +
                "2: Afiseaza conurenti din anumit proba \n" +
                "3: Afiseaza conurentii din categorie de varsta \n" +
                "0: Exit \n";
        System.out.print(menu);
        int choice;
        Scanner inChoice = new Scanner(System.in);
        System.out.println("Choice: ");
        choice = inChoice.nextInt();

        if (choice == 1) {
            int age;
            String concurentName;
            Scanner inName= new Scanner(System.in);
            System.out.println("Nume  Concurent: ");
            concurentName = inName.nextLine();

            Scanner inAge = new Scanner(System.in);
            System.out.println("Varsta: ");
            age = inAge.nextInt();
            Concurent concurent = new Concurent(concurentName,age);
            //concursRepo.afiseazaProbaNume();

            String numeProba;
            Scanner innumeProba = new Scanner(System.in);
            System.out.print("Nume Proba: ");
            numeProba=innumeProba.nextLine();

            service.addNewConcurent(concurentName,numeProba,age);
            System.out.println(service.showAllConcurenti());
        } else if (choice == 2){
            String numeProba;
            Scanner innumeProba = new Scanner(System.in);
            System.out.print("Nume Proba: ");
            numeProba=innumeProba.nextLine();

            System.out.print(service.searchByProba(numeProba));
        }else if (choice == 3){
            String numeCat;
            Scanner inCat = new Scanner(System.in);
            System.out.print("Nume Categorie: ");
            numeCat=inCat.nextLine();
            System.out.print(service.searchByCategory(numeCat));
        }else if (choice == 0){
            System.exit(0);
        }else
            menu2();

    }


}

