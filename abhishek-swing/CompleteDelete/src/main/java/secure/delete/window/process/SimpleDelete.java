/**
 * 
 */
package secure.delete.window.process;

import java.io.File;

/**
 * @author abhishekJava
 *
 */
public class SimpleDelete implements Delete{

	@Override
	public void delete(String file) {
		File path = new File(file);
		if (path.exists()) {
			if (path.isDirectory()) {
				File[] files = path.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						delete(files[i].getAbsolutePath());
					} else {
						files[i].delete();
					}
				}
			}
		}
		path.delete();		
	}

}
