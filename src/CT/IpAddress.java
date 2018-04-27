package CT;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IpAddress{

  
  public static InetAddress getLocalAddress() throws SocketException
  {
    Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
    while( ifaces.hasMoreElements() )
    {
      NetworkInterface iface = ifaces.nextElement();
      Enumeration<InetAddress> addresses = iface.getInetAddresses();

      while( addresses.hasMoreElements() )
      {
        InetAddress addr = addresses.nextElement();
        if( addr instanceof Inet4Address && !addr.isLoopbackAddress() )
        {
          return addr;
        }
      }
    }

    return null;
  }




	public static String main() throws SocketException
	{
		String ip="";
		if(ip==null){
			ip="127.0.0.1";
		}else{
				ip=getLocalAddress()+"";
				ip=ip.replaceAll("/","");
		}
			return ip;
	
	}
	public static void main(String[] args) throws SocketException
	{
		System.out.println(main());
	}

}