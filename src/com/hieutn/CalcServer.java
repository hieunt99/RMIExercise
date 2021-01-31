package com.hieutn;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalcServer implements CalcInterface {

    private static final long serialVersionUID = 1L;

    protected CalcServer() {
    }

    public static void main(String[] args) {
        try {
            CalcServer server = new CalcServer();
            CalcInterface stub = (CalcInterface) UnicastRemoteObject.exportObject(server, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("calc", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }


    @Override
    public int getSum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int getMul(int a, int b) throws RemoteException {
        return a * b;
    }
}
