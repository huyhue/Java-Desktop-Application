package RMI;
//gom co  5 class EmpDB + EmpDBImp + ConnectDB + ClientDB + ServerDB
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerDB {
    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1098/EmpServer";
        EmpDBImp server;
        try {
            server = new EmpDBImp();
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
