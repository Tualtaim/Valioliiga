package veikkaus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Veikkaus {

	public static void main(String[] args) throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader("veikkaus.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("oikearivi.txt"));

		String line1 = reader1.readLine();
		String line2 = reader2.readLine();

		List<String> veikkaus = new ArrayList<>();
		List<String> oikeaRivi = new ArrayList<>();
		
		while(line2 != null) {
			oikeaRivi.add(line2);
			line2 = reader2.readLine();
		}
		
		while(line1 != null) {
			veikkaus.add(line1);
			line1 = reader1.readLine();
		}
	
		int pisteet = Pisteet(veikkaus, oikeaRivi);
		System.out.println(pisteet);

		reader1.close();
		reader2.close();
	}
	
		
	//laskee pisteet sarjataulukosta, veikatuista valmentajapotkuista ja Cup-kilpailuista
	public static int Pisteet(List<String> veikkaus, List<String> oikeaRivi) {
		int pisteet=0;
	
		//pisteet sarjataulukosta
		for(int i = 0; i<20; i++) {
			String team = veikkaus.get(i);
			int sijoitus = oikeaRivi.indexOf(team) +1;
			int veikattu = i+1;
			pisteet = pisteet + 20 - Math.abs(sijoitus-veikattu);
		}
		
		//pisteet potkuista ja Cup-kilpailuista
		String potkutVeikkaus=veikkaus.get(27);
		String potkutOikea = oikeaRivi.get(21);
		String liigaCupVeikkaus = veikkaus.get(29);
		String liigaCupVoittaja = oikeaRivi.get(23);
		String faCupVeikkaus = veikkaus.get(31);
		String faCupVoittaja = oikeaRivi.get(25);
		
		if(potkutVeikkaus.equalsIgnoreCase(potkutOikea)){
			pisteet = pisteet + 20;
		}
		if(liigaCupVeikkaus.equalsIgnoreCase(liigaCupVoittaja)){
			pisteet = pisteet + 20;
		}
		if(faCupVoittaja.equalsIgnoreCase(faCupVeikkaus)){
			pisteet = pisteet + 20;
		}

		return pisteet;
	}

}
