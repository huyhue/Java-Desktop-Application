package RMI;
//gom co class RMIServer, RMIClient, IMath, Demo
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface IMath extends Remote{
    public int add(int a, int b) throws RemoteException;
    public int sub(int a, int b) throws RemoteException;
    public int mul(int a, int b) throws RemoteException;
    public int div(int a, int b) throws RemoteException;
}

class MathObject extends UnicastRemoteObject implements IMath{

    public MathObject() throws RemoteException{
        super();
    }
    
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
      
    @Override
    public int sub(int a, int b) throws RemoteException {
       return a-b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        return a*b;
    }

    @Override
    public int div(int a, int b) throws RemoteException {
        return a/b;
    }
    
}
