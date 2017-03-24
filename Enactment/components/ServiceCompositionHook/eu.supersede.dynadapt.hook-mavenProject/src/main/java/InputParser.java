
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class InputParser {


	public static final String [] keys = {"Adresse","Bundesland", "Ort" , "PLZ", "klimaaktiv Geb�ude","klimaaktiv Deklaration", "Nutzfl�che", "Objekttyp", "Wohneinheiten/Nutzeinheiten", "Energie und Geb�udetechnik", "Heizlast", "Fern- oder Nahw�rme RH", "Fern- oder Nahw�rme WW", "Art des L�ftungssystems", "Warmwasserbereitung", "OI3 Index (OI3TGH, BGF)", "HFKW freie D�mmstoffe", "HFKW freie Montagesch�ume etc.", "Nachweis f�r Sommertauglichkeit", "Rechtsform", "Baubeginn", "Fertigstellung", "Heizw�rmebedarf (HWB)", "Prim�renergiebedarf (PHPP)", "Firmenname/Name"}; //, "CO2 Emission", "OI3 Index", "Blower Door Test"}; 
	public static void main(String[] args) {
		String pathToFolder = args[0];

		File folder = new File(pathToFolder);
		File [] files = folder.listFiles();

		Hashtable<String, ArrayList<String>> ht = new Hashtable<String, ArrayList<String>>();

		BufferedReader br = null;

		for(int i=0; i < files.length; i++)
		{
			try {
				for(int j = 0; j < keys.length; j++)
				{
					String value = "N/A";
					String sCurrentLine;

					InputStream inStream = new FileInputStream(files[i]);
					InputStreamReader streamReader = new InputStreamReader(inStream, "UTF-8");
					br = new BufferedReader(streamReader);
					while ((sCurrentLine = br.readLine()) != null) {
						if(ht.get(keys[j]) == null)
						{
							ArrayList<String> al = new ArrayList<String>();
							al.add(keys[j]);
							ht.put(keys[j],al);
						}

						if(sCurrentLine.startsWith(keys[j]))
						{
							//String[] tokens = sCurrentLine.substring(keys[j].length() + 1).trim().split("\\s+");
							value = sCurrentLine.substring(keys[j].length() + 1).trim();
							//(ht.get(keys[j])).add(tokens[tokens.length - 1]);						    
							break;
						}						
						
					}
					(ht.get(keys[j])).add(value);
				}

				
				/*int l = (ht.get(keys[0])).size();
				for(int j = 0; j < keys.length; j++)
				{
					if((ht.get(keys[j])).size() != l)
					{
						System.out.println(keys[j] + " -- " + files[i].getAbsolutePath());
						break;
					}
				}*/

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		int count = 0;
		while((ht.get(keys[0])).size() > 0)
		{
			String toPrint = "";
			if(count == 0)
			{
				toPrint = "Filename;";
			}
			else
			{
				toPrint = files[count-1] + ";";
			}
			count++;
			try
			{
				for(int j = 0; j < keys.length; j++)
				{
					toPrint += (ht.get(keys[j])).get(0); 
					if(j < keys.length - 1)
					{
						toPrint += ";"; 
					}
					ht.get(keys[j]).remove(0);
				}				
			}
			catch(Exception e){
				toPrint = e.getMessage();
			}

			System.out.println(toPrint);			

		}
	}

}
