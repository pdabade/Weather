package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote{
	<T> T executeTask(Task<T> t) throws RemoteException;

	String[] getWeatherData(String zip, String city, String date)throws RemoteException;

}
