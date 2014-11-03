package solver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
* Created by Richard Harrington on 4/8/2014.
*/
public interface FileIO {
	public InputStream readAsset(String fileName) throws IOException;

	public InputStream readFile(String fileName) throws IOException;

    public OutputStream writeFile(String fileName) throws IOException;
}

