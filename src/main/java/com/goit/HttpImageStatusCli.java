package com.goit;

import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter status code: ");
        String code = scanner.nextLine();
        try {

            new HttpStatusImageDownloader().downloadStatusImage(Integer.parseInt(code));
        }catch (NumberFormatException e){
            System.out.println("Please enter valid number");
        }catch (Exception e){
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
