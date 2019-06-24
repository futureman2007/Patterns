package futureman.articles.dataAccessObjectImpl;

import java.io.BufferedReader;
import futureman.articles.clothes.*;
import futureman.articles.shoes.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import futureman.articles.Artikel;
import futureman.dataAccessObjektInterface.OrteDAO;
import futureman.ort.Ort;
import futureman.articles.*;
public class JsonDAOOrtProvider implements OrteDAO {

	//für die zukunft: da hier eigendlich zu 99 prozent code aus JsonDaoProvider kopiert und verändert wurde,
	// wäre es besser, dafür separate Klassen zu schreiben (Schreibe mit Jason in file, teste ob file existiert etc.)
	// das dann am besten noch generalisiert, sodass ich nur auf das bereits implementierte verweisen kann.
	
	public String _destpath;
	public String _filename;

	public JsonDAOOrtProvider(String destpath, String filename) {
		_destpath = destpath;
		_filename = filename;
	}
	
	public void saveNewOrt(Ort ort) {
		if (Files.exists(Paths.get(_destpath))) {
			try {
				if (Files.notExists(Paths.get(_destpath + "/" + _filename))) {
					writeToFile(Files.createFile(Paths.get(_destpath + "/" + _filename)), ort);
				} else {
					writeToFile(Paths.get(_destpath, "/", _filename).toAbsolutePath(), ort);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new PathDoesNotExistException(Paths.get(_destpath));
		}
	}

	@Override
	public Ort loadOrt(int ortsId) {
		if (Files.notExists(Paths.get(_destpath))) {
			throw new PathDoesNotExistException(Paths.get(_destpath));
		}
		if (Files.notExists(Paths.get(_destpath, "/", _filename))) {
			throw new FileDoesNotExistException(Paths.get(_destpath, "/", _filename));
		}
		try {
			Ort[] read = readFromFile(Paths.get(_destpath, "/", _filename).toRealPath());
			for (int i = 0; i < read.length; i++) {
				if (read[i] == null) {
					continue;
				}
				if (read[i].get_ortsId() == ortsId) {
					return read[i];
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Ort findfreeOrt() {
		if (Files.notExists(Paths.get(_destpath))) {
			throw new PathDoesNotExistException(Paths.get(_destpath));
		}
		if (Files.notExists(Paths.get(_destpath, "/", _filename))) {
			throw new FileDoesNotExistException(Paths.get(_destpath, "/", _filename));
		}
		Ort[] orte = readFromFile(Paths.get(_destpath, "/", _filename));
		for(int i = 0; i < orte.length; i++) {
			if(orte[i].get_artikel() == null) {
				return orte[i];
			}
		}
		return null;
	}
	@Override
	public void deleteOrt(int ortsId) {

		if (Files.notExists(Paths.get(_destpath))) {
			throw new PathDoesNotExistException(Paths.get(_destpath));
		}
		if (Files.notExists(Paths.get(_destpath, "/", _filename))) {
			throw new FileDoesNotExistException(Paths.get(_destpath, "/", _filename));
		}
		Path tmpFilePath = Paths.get(_destpath, "/", "OrtTmp.txt");
		Path destFilePath = Paths.get(_destpath, "/", _filename);
		Ort[] read;

		File tmpFile = tmpFilePath.toFile();
		if (tmpFile.exists()) {
			tmpFile.delete();
		}
		try {
			Files.createFile(tmpFilePath);
			read = readFromFile(destFilePath);
			for (int i = 0; i < read.length; i++) {
				if (read[i] == null) {
					continue;
				}
				if (read[i].get_ortsId() != ortsId) {
					writeToFile(tmpFilePath, read[i]);
				}
			}
			if (Paths.get(_destpath, "/", "dump.txt").toFile().exists()) {
				Files.delete(Paths.get(_destpath, "/", "dump.txt"));
			}

			Files.move(destFilePath, Paths.get(_destpath, "/", "dump.txt"));
			Files.delete(Paths.get(_destpath, "/", "dump.txt"));

			Files.move(tmpFilePath, Paths.get(_destpath, "/", _filename), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeToFile(Path pathToFile, Ort ort) {
		if (pathToFile == null) {
			throw new NullPointerException("Cannot opperate without a path reference!");
		}
		try {
			BufferedWriter bw = Files.newBufferedWriter(pathToFile, StandardOpenOption.APPEND);
			bw.write(createJSONSTring(ort));
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String createJSONSTring(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Ort[] readFromFile(Path pathToFile) {
		if (pathToFile == null) {
			throw new NullPointerException("Cannot opperate without a path reference!");
		}
		try {
			BufferedReader rdr = Files.newBufferedReader(pathToFile);
			ObjectMapper mapper = new ObjectMapper();
			String line = null;
			StringBuffer buff = new StringBuffer();
			while ((line = rdr.readLine()) != null) {
				buff.append(line);
				buff.append("\n");
			}
			
			String[] readElements = buff.toString().split("\n");
			Ort[] orte = new Ort[readElements.length];
			for (int i = 0; i < readElements.length; i++) {
				orte[i] = parseElement(readElements[i]);
			}
			return orte;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private Ort parseElement(String readElement) {

		Ort a = null;
		Artikel art = null;
		ObjectMapper mapper = new ObjectMapper();
		
		
		
//		Class[] classes = {Jeans.class, Jacke.class, Kleidungstueck.class ,Schuhe.class};
//	
//		String[] split = readElement.split("[\\{\\}]");
//		StringBuffer buff = new StringBuffer();
//		for(int i = 0; i < split.length; i++) {
//			buff.append("\\{");
//			buff.append(split[i]);
//			buff.append("\\}");;
//			split[i] = buff.toString();
//			for(int j = 0; j < classes.length; j++) {
//				try {
//					art = (Artikel) mapper.readValue(split[i], classes[j]);
//				}catch(IOException e) {
//					
//				}
//			}
			
		}
		
		try {
			a = mapper.readValue(readElement, Ort.class);
		} catch (IOException e) {
			return null;
		}
		return a;
	}

	
}