package RMI;
//gom co class RMIServer, RMIClient, IMath, Demo
import java.rmi.Naming;
public class RMIClient {
    public static void main(String[] args) {
        try {
            IMath imath = (IMath) Naming.lookup("rmi://localhost:5000/MyServices");
            int rs = imath.add(2, 4);
            System.out.println("Result: " + rs);
        } catch (Exception e) {
        }
    }
}
