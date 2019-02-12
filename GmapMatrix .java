import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class GmapMatrix {

	public static void main(String[] args) {
		Gmap gmap = new Gmap();
        gmap.getDistance();
		
	}

	
	 public void getDistance() {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter origin address");
		String from = sc.next();
		System.out.println("enter destination address");
		String to = sc.next();
		start(from,to);

		
	}

     public void start(String from,String to)
{
				
		
		
		try {
			URL url = new URL(
					"https://maps.googleapis.com/maps/api/distancematrix/json?origins="+from+"&destinations="+to+"&key=AIzaSyAsdijpn0_XOpdHA7zSPmvUiQPSiYAg5Hs");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			String line = "";
			String outputString="";
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}
			
			System.out.println(outputString);
			
			
			
		} catch (Exception e) {
			System.out.println("Error");
			
			
		}
		
		
	}
}
