//Step 1: Create Remote Interface
//gom co class RmiClient, RmiServer, Weather,WeatherImp, WeatherInterface
package RmiMath;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WeatherInterface extends Remote{
    public Weather getWeather() throws RemoteException;
}
