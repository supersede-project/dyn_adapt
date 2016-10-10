package hook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import eu.supersede.dynadapt.enactor.package1.Enactor;

public class EnactmentHook implements IEnactmentHook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnactmentHook main_class=new EnactmentHook();
		Enactor enactor_code=new Enactor();
		String code_to_be_enacted=enactor_code.getEnactmentCode();
		main_class.enactAddaptation(code_to_be_enacted);
	}

	@Override
	public String enactAddaptation(String adaptation) {
		// TODO Auto-generated method stub
						
		ProcessBuilder builder = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", "http://localhost:4567/adapt/https://nike.erd.siemens.at/supersede/format/", "-XPOST", "-d", "{steps: [{ type: 'REST-GET', url: 'https://nike.erd.siemens.at/supersede/s0/', callback: \\\"function cb(jsonRequest, jsonReponse){ var reqRes = null; for(var i=0; i ^< jsonReponse.length;i++) { jsonResponse[i]['WIND_DIRECTION'] = jsonResponse[i]['WINDDIR']; delete jsonResponse[i]['WINDDIR']; }; reqRes = JSON.stringify(jsonResponse); return [ 'CONTINUE', reqRes]; }  \\\"}]}");
		
		//ProcessBuilder builder1 = new ProcessBuilder("curl", "-k", "-i", "-H", "Content-Type: application/json", "http://localhost:4567/relay/https://nike.erd.siemens.at/supersede/format/");
		//ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", curl);
		
		builder.redirectErrorStream(true);
		Process p=null;
		try {
			p = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
