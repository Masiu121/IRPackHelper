package com.Maksuu121.IRPackHelper;

import jdk.jfr.internal.tool.Main;

import java.io.File;
import java.util.Scanner;

public class IRPackHelper {

    static File file;
    static Scanner scanner;
    static boolean exit;

    public static void main(String[] args) {
        initializeProgram();
        while(!exit) {
            mainMenu();
        }
    }

    private static void initializeProgram() {
        file = null;
        scanner = new Scanner(System.in);
        exit = false;
    }

    private static void mainMenu() {
        System.out.println("Welcome to the Immersive Railroading pack helper!");
        System.out.println("1. Create new pack");
        System.out.println("2. Choose existing pack");
        System.out.println("3. Exit");

        print("Choose number: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                newPack();
                break;
            case 2:
                existingPack();
                break;
            case 3:
                exit = true;
                break;
            default:
                printLn("\nYou have to choose a number between 1 - 3");
                break;
        }
    }

    private static void newPack() {
        print("Pack directory: ");
        file = new File(scanner.nextLine());
        if(!file.isDirectory()) {
            boolean dirCreated = file.mkdir();
            if (dirCreated)
                printLn("Directory successfully created!");
            else
                printLn("Can't create directory");
        }
    }

    private static void existingPack() {
        print("Pack directory: ");
        file = new File(scanner.nextLine());

        if(!file.isDirectory()) {
            printLn("Directory does not exist, or it's invalid! (Pack has to be unpacked)");
            file = null;
        }
    }

    private static void printLn(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
