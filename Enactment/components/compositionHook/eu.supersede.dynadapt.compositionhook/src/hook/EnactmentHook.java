package hook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import eu.supersede.dynadapt.enactor.package1.Enactor;

public class EnactmentHook implements IEnactmentHook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnactmentHook main_class=new EnactmentHook();
		
		//calling the Enactor component to get the cURL code to be injected to the system using ProcessBuilder as a hook (see above)
		Enactor enactor_code=new Enactor();		
		ArrayList<String> code_to_be_enacted=enactor_code.getEnactmentCode();
		main_class.injectAddaptation(code_to_be_enacted);
	}

	@Override
	public String injectAddaptation(ArrayList<String> adaptation) {
		
		//this version of process builder is working fine (used before to create an appropriate process builder)
		//String s1="http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/format/";
		//String s2="{steps: [{ type: 'REST-GET', url: 'https://nike.erd.siemens.at/supersede/s0/', callback: \\\"function cb(jsonRequest, jsonReponse){ var reqRes = null; for(var i=0; i ^< jsonReponse.length;i++) { jsonResponse[i]['WIND_DIRECTION'] = jsonResponse[i]['WINDDIR']; delete jsonResponse[i]['WINDDIR']; }; reqRes = JSON.stringify(jsonResponse); return [ 'CONTINUE', reqRes]; }  \\\"}]}";
		//ProcessBuilder builder = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", s1 , "-XPOST", "-d", s2);
		
		ProcessBuilder builder = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", adaptation.get(0) , "-XPOST", "-d", adaptation.get(1));
		builder.redirectErrorStream(true);
		Process p=null;
		try {
			p = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//printing out the output received as a result of calling the corresponding REST function from cURL
		StringBuilder sb = new StringBuilder();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line=null;
		int linenum = 0;
		while (true) {
		    linenum++;
		    try {
				line = r.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    if (line == null) {
		        break;
		    }
		    sb.append(line);
		}
		System.out.println(sb);
	    
	    
		return null;
	}

}
