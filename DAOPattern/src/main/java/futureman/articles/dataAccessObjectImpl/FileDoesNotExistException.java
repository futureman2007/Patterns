package futureman.articles.dataAccessObjectImpl;

import java.nio.file.Path;

public class FileDoesNotExistException extends RuntimeException{

	public FileDoesNotExistException(String path) {
		super(path + " could not be found on this system!");
	}
	public FileDoesNotExistException(Path path) {
		super(path.toString() + " could not be found on this system!");
	}
}
