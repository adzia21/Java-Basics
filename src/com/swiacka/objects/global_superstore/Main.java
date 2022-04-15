package com.company.objects.global_superstore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.*;


public class Main {

    static final String SALES = "com/company/objects/global_superstore/resources/sales.csv"; //Use backslash Windows users

    static double furniture = 0;
    static double technology = 0;
    static double supplies = 0;
    static double average = 0;


    public static void main(String[] args) {

        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());

            int numberThreads = Runtime.getRuntime().availableProcessors();

            ExecutorService executor = Executors.newFixedThreadPool(numberThreads);

            Future<Double> future = executor.submit( () -> average(path, "Furniture"));
            Future<Double> future2 = executor.submit( () -> average(path, "Technology"));
            Future<Double> future3 =  executor.submit( () -> average(path, "Office Supplies"));
            Future<Double> future4 = executor.submit( () -> average = totalAverage(path));


//            FutureTask<Double> future = new FutureTask<>(() -> average(path, "Furniture"));
//            Thread thread2 = new Thread(future);
//
//            FutureTask<Double> future2 = new FutureTask<>(() -> average(path, "Technology"));
//            Thread thread3 = new Thread(future2);
//
//            FutureTask<Double> future3 = new FutureTask<>(() -> average(path, "Office Supplies"));
//            Thread thread4 = new Thread(future3);
//
//            FutureTask<Double> future4 = new FutureTask<>(() -> average = totalAverage(path));
//            Thread thread5 = new Thread(future4);


//            thread2.start();
//            thread3.start();
//            thread4.start();
//            thread5.start();

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");
            String name = scan.nextLine();
//                            thread2.join();
//                thread3.join();
//                thread4.join();
//                thread5.join();
            try {

                furniture = future.get();
                technology = future2.get();
                supplies = future3.get();
                average = future4.get();
                executor.shutdown();



                System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
                System.out.println("Average Furniture Sales: " + furniture);
                System.out.println("Average Technology Sales: " + technology);
                System.out.println("Average Office Supplies Sales: " + supplies);
                System.out.println("Total Average: " + average);

                scan.close();

            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    {

    }

    public static Double average(Path path, String category) {
        try {
            return Files.lines(path)
                    .skip(1)
                    .map((line) -> line.split(","))
                    .filter((values) -> values[0].equals(category))
                    .mapToDouble((values) -> Double.parseDouble(values[1]) * Double.parseDouble(values[2]))
                    .average().getAsDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }


    public static Double totalAverage(Path path) {
        try {
            return Files.lines(path)
                    .skip(1)
                    .map((line) -> line.split(","))
                    .mapToDouble((values) -> Double.parseDouble(values[1]) * Double.parseDouble(values[2]))
                    .average().getAsDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }




}
