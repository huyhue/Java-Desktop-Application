package RmiMath;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface MathServices extends Remote {

    public double add(double a, double b) throws RemoteException;

    public double sub(double a, double b) throws RemoteException;

    public double mul(double a, double b) throws RemoteException;

    public double div(double a, double b) throws RemoteException;
}

class Mathematician extends UnicastRemoteObject implements MathServices {

    public Mathematician() throws RemoteException {
    
    };
    
    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double sub(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double mul(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double div(double a, double b) throws RemoteException {
        return a / b;
    }

}
