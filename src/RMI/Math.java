package RMI;
//gom co class Math, Calculator, Strategy
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//Server side
public class Math extends UnicastRemoteObject implements Compute {

    public Math() throws RemoteException {
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            Math math = new Math();
            System.out.println("Server is ready...");
            LocateRegistry.createRegistry(1985);
            Registry registry = LocateRegistry.getRegistry(1985);
            registry.bind("math", math);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (AlreadyBoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("Server is closed.");
    }

    @Override
    public String deploy(Strategy strategy) throws RemoteException {
        return strategy.getName();
    }

}
