package futureman.articles.dataAccessObjectImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import futureman.articles.Artikel;
import futureman.articles.clothes.Jacke;
import futureman.articles.clothes.Jeans;
import futureman.articles.clothes.Kleidungstueck;
import futureman.articles.shoes.Schuhe;
import futureman.dataAccessObjektInterface.ArticlesDAO;;


public class JasonDAOProvider implements ArticlesDAO{

	public String _destpath;
	public String _filename;
	
	public JasonDAOProvider(String destPath, String filename) {
		_destpath = destPath;
		_filename = filename;
	}
	
	@Override
	public void saveArticle(Artikel art) {
		
		if(Files.exists(Paths.get(_destpath))) {
			try {
				if(Files.notExists(Paths.get(_destpath + "/" + _filename))) {
					writeToFile(Files.createFile( Paths.get(_destpath + "/" + _filename)), art);
				}else{
					writeToFile(Paths.get(_destpath, "/", _filename).toAbsolutePath(), art);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new PathDoesNotExistException(Paths.get(_destpath));
		}	
	}
	@Override
	public void deleteArticle(int artikelID) {
		if(Files.notExists(Paths.get(_destpath))) {
			throw new PathDoesNotExistException(Paths.get(_destpath));
		}
		if(Files.notExists(Paths.get(_destpath, "/", _filename))) {
			throw new FileDoesNotExistException(Paths.get(_destpath, "/", _filename));
		}
			Path tmpFilePath = Paths.get(_destpath, "/", "tmp.txt");
			Path destFilePath = Paths.get(_destpath, "/", _filename);
			Artikel[] read;
			
			File tmpFile = tmpFilePath.toFile();
			if(tmpFile.exists()) {
				tmpFile.delete();
			}
			try {
				Files.createFile(tmpFilePath);
				read = readFromFile(destFilePath);
				for(int i = 0; i < read.length; i++) {
					if(read[i] == null) {
						continue;
					}
					if(read[i].getArtikelID() != artikelID) {
						writeToFile(tmpFilePath, read[i]);
					}
				}
				if(Paths.get(_destpath, "/", "dump.txt").toFile().exists()) {
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
	
	@Override
	public Artikel loadArticle(int artikelID) {
		if(Files.notExists(Paths.get(_destpath))) {
			throw new PathDoesNotExistException(Paths.get(_destpath));
		}
		if(Files.notExists(Paths.get(_destpath, "/", _filename))) {
			throw new FileDoesNotExistException(Paths.get(_destpath, "/", _filename));
		}
		try {
			Artikel[] read = readFromFile(Paths.get(_destpath, "/",_filename).toRealPath());
			for(int i = 0; i < read.length; i++) {
				if(read[i] == null) {
					continue;
				}
				if(read[i].getArtikelID() == artikelID) {
					return read[i];
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	private Artikel[] readFromFile(Path pathToFile) {
		if(pathToFile == null) {
			throw new NullPointerException("Cannot opperate without a path reference!");
		}
		try {
			BufferedReader rdr = Files.newBufferedReader(pathToFile);
			ObjectMapper mapper = new ObjectMapper();
			String line = null;
			StringBuffer buff = new StringBuffer();
			while( (line = rdr.readLine()) != null) {
				buff.append(line);
				buff.append("\n");
			}
			String[] readElements = buff.toString().split("\n");
			Artikel[] artikel = new Artikel[readElements.length];
			for(int i = 0; i < readElements.length; i++) {
				artikel[i]= parseElement(readElements[i]);
			}
			return artikel;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Artikel parseElement(String readElement) {
		
		Artikel a = null;
		ObjectMapper mapper = new ObjectMapper();
		Class[] classes = {Jeans.class, Jacke.class, Kleidungstueck.class ,Schuhe.class};
		
		for(int i = 0; i < classes.length; i++) {
			try {
				a = (Artikel) mapper.readValue(readElement, classes[i]);
				return a;
			} catch (IOException ide) {
				a = null;
			}
		}
			
		return a;
	}
	
	private void writeToFile(Path pathToFile, Artikel art) {
		if(pathToFile == null) {
			throw new NullPointerException("Cannot opperate without a path reference!");
		}
		try {
			BufferedWriter bw = Files.newBufferedWriter(pathToFile,StandardOpenOption.APPEND);
			bw.write(createJSONSTring(art));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	



}
