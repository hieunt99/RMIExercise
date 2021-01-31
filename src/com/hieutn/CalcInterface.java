package com.hieutn;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcInterface extends Remote {

    int getSum(int a, int b) throws RemoteException;

    int getMul(int a, int b) throws RemoteException;

    Pair getSumMul() throws RemoteException;
}
