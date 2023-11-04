package controller;

import common.Library;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.Messager;
import view.Menu;

public class CSVManagement extends Menu<String>{
    
    static String[] menu = {"Import CSV", "Format Address","Format Name","Export CSV"};
    private CSVProgram cp= new CSVProgram();
    private Library lib = new Library();

    public CSVManagement() {
        super("==== Format CSV Program ====", menu, "Exit");
    }
    
    @Override
    public void execute(int n) {
        String path;
        switch (n) {
            case 1:
                System.out.println("--------- Import CSV -------");
                path = lib.getString("Enter Path : ");
                cp.readFile(path);
                break;
            case 2:
                System.out.println("-------------- Format Address --------------");
                cp.format(1);
                break;
            case 3:
                System.out.println("-------------- Format Name --------------");
                cp.format(2);
                break;
            case 4:
                System.out.println("-------------- Format Name --------------");
                path = lib.getString("Enter Path : ");
                cp.saveFile(path);
                break;
            default:
                return;
        }
    }
}
//bui   thien  nha
//bui,  thien