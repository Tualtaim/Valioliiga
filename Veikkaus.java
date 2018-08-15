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
		BufferedReader reader3 = new BufferedReader(new FileReader("maaliporssi.txt"));
	
		String line1 = reader1.readLine();
		String line2 = reader2.readLine();
		String line3 = reader3.readLine();
		
		List<String> veikkaus = new ArrayList<>();
		List<String> oikeaRivi = new ArrayList<>();
		List<String> maaliporssi = new ArrayList<>();

		while(line2 != null) {
			oikeaRivi.add(line2);
			line2 = reader2.readLine();
		}
		
		while(line1 != null) {
			veikkaus.add(line1);
			line1 = reader1.readLine();
		}
		while(line3 != null) {
			maaliporssi.add(line3);
			line3 = reader3.readLine();
		}
	
		int pisteet = Pisteet(veikkaus, oikeaRivi);
		System.out.println(pisteet);
		pisteet = pisteet + Maalintekijat(veikkaus, maaliporssi);
		System.out.println(pisteet);

		reader1.close();
		reader2.close();
		reader3.close();
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
	
	public static int Maalintekijat(List<String> veikkaus, List<String> maaliporssi) {
		int pisteet = 0;
		
		String maalintekija1 = veikkaus.get(21);
		String maalintekija2 = veikkaus.get(22);
		String maalintekija3 = veikkaus.get(23);
		String maalintekija4 = veikkaus.get(24);
		String maalintekija5 = veikkaus.get(25);
		
		if(maaliporssi.contains(maalintekija1)) {
			int rivi = maaliporssi.indexOf(maalintekija1);
			String maalit = maaliporssi.get(rivi+1);
			pisteet = pisteet + Integer.parseInt(maalit);			
		}
		if(maaliporssi.contains(maalintekija2)) {
			int rivi = maaliporssi.indexOf(maalintekija2);
			String maalit = maaliporssi.get(rivi+1);
			pisteet = pisteet + Integer.parseInt(maalit);			
		}
		if(maaliporssi.contains(maalintekija3)) {
			int rivi = maaliporssi.indexOf(maalintekija3);
			String maalit = maaliporssi.get(rivi+1);
			pisteet = pisteet + Integer.parseInt(maalit);			
		}
		if(maaliporssi.contains(maalintekija4)) {
			int rivi = maaliporssi.indexOf(maalintekija4);
			String maalit = maaliporssi.get(rivi+1);
			pisteet = pisteet + Integer.parseInt(maalit);			
		}
		if(maaliporssi.contains(maalintekija5)) {
			int rivi = maaliporssi.indexOf(maalintekija5);
			String maalit = maaliporssi.get(rivi+1);
			pisteet = pisteet + Integer.parseInt(maalit);			
		}
		return pisteet;
	}

}
