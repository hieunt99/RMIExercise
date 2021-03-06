package com.hieutn;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalcClient {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(5000);
            CalcInterface stub = (CalcInterface) registry.lookup("calc");

            System.out.println("Tong 12 + 45 =  " + stub.getSum(12,45));
            System.out.println("Tich 12 + 45 =  " + stub.getMul(12,45));

            System.out.println("Pair Tong 22 + 45 =  " + stub.getSum(22,45));
            System.out.println("Pair Tich 22 + 45 =  " + stub.getMul(22,45));

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
