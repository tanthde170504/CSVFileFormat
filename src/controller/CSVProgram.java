package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CSVProgram {

    //Validation val = new Validation();
    //--------------------------------------------------
    //List of Customer
    public static ArrayList<Customer> customerList;

    public CSVProgram(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public CSVProgram() {
        this.customerList = new ArrayList<Customer>();
    }

    public void readFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(",");
                if (arr.length == 5) {
                    Customer s = new Customer(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4]);
                    customerList.add(s);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String formatString(String s) {
        String arrS[] = s.trim().split(" ");
        String t = "";
        for (String string : arrS) {
            if (!string.isEmpty()) {
                t = t + string.trim() + " ";
            }
        }
        return t.trim();
    }

    public String formatAddress(String s) {
        String[] arrS = s.split("-");
        String t ="";
        for (String string : arrS) {
            if (!string.isEmpty()) {
                t = t + formatString(string) + " - ";
            }
        }
        int temp = t.lastIndexOf(" - ");
        return t.substring(0, temp);
    }

    public void format(ArrayList<Customer> c, int i) {
        if (i == 1) {
            for (Customer customer : c) {
                customer.setAddress(formatAddress(customer.getAddress()));
            }
        } else {
            for (Customer customer : c) {
                customer.setName(formatString(customer.getName()));
            }
        }
    }

    public void format(int i) {
        format(customerList, i);
    }

    public boolean saveFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Customer t : this.customerList) {
                String line = t.getId() + "," + t.getName() + "," + t.getGmail() + "," + t.getPhone() + "," + t.getAddress();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
