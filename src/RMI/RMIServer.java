package RMI;
//gom co class RMIServer, RMIClient, IMath, Demo
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5000);
            Naming.bind("rmi://localhost:5000/MyServices", new MathObject());
            System.out.println("Server start !!!");
        } catch (Exception e) {
        }
    }
}
