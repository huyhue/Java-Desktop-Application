//Step 2: Implement the Remote Interface
//gom co class RmiClient, RmiServer, Weather,WeatherImp, WeatherInterface
package RmiMath;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WeatherImpl extends UnicastRemoteObject implements WeatherInterface{
    Weather weather;

    public WeatherImpl(Weather weather) throws RemoteException{
        this.weather = weather;
    }
    
    public Weather getWeather() throws RemoteException {
        return weather;
    }

}
