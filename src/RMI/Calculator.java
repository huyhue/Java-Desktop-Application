package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//Client side
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Started client");
        String host = "localhost";
        int post = 1985;
        try {
            Registry registry = LocateRegistry.getRegistry(host, post);
            Compute math = (Compute) registry.lookup("math");
            System.out.println(math.add(3, 4));
            System.out.println(math.add(5, 6));
            
            System.out.println(math.deploy(new Strategy("Ducky")));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } 
        System.out.println("Client is closed");
    }
}
