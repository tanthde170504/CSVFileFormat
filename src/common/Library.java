package common;

import java.util.ArrayList;
import java.util.Scanner;
//import model.User;

public class Library {

    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }
}
