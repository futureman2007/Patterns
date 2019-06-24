package futureman.articles.dataAccessObjectImpl;

import java.nio.file.Path;

public class PathDoesNotExistException extends RuntimeException {

	public PathDoesNotExistException(String path) {
		super(path + " could not be found on this system!");
	}
	public PathDoesNotExistException(Path path) {
		super(path.toString() + " could not be found on this system!");
	}
	
}
