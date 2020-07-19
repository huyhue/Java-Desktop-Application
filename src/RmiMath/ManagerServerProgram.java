package RmiMath;
//gom co: EmployeeMngInterface + EmployeeServer + ManagerClient + ManagerServerProgram
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ManagerServerProgram {
    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1098/EmployeeService";
        String filename = "D://employee.txt";
        EmployeeServer server = null;
        try {
            server = new EmployeeServer(filename);
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
