package eu.supersede.dynadapt.modelrepository.manager.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import eu.supersede.dynadapt.modelrepository.model.IModel;

public class ContentFileManager implements IContentFileManager {

	private final String storagePath = "../repository";

	@Override
	public String saveModel(IModel model) throws Exception {
		String path = storagePath 
				+ "/" + model.getClass().getSimpleName()
				+ "/" + model.getValue("systemId");
		String fileName = model.getValue("id") + model.getValue("fileExtension");
		File file = new File(path, fileName);
		file.getParentFile().mkdirs();
		if (!file.exists()) file.createNewFile();
		try(PrintWriter out = new PrintWriter(file)) {
				out.println( model.getValue("modelContent") );
		}
		return path + "/" + fileName;
	}

	@Override
	public String loadModel(String path) throws Exception {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			return null;
		}
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	            if (line != null) sb.append("\n");
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

	@Override
	public void deleteModel(String path) throws Exception {
		File file = new File(path);
		file.delete();
	}
	
	
	
}
