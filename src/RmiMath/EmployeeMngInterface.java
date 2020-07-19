package RmiMath;
//gom co: EmployeeMngInterface + EmployeeServer + ManagerClient + ManagerServerProgram
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface EmployeeMngInterface extends Remote{
    Vector getInitialData() throws RemoteException;
    boolean saveList(Vector data) throws RemoteException;
}
