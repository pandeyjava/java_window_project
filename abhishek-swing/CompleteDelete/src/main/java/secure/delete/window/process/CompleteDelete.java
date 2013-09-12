package secure.delete.window.process;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.SecureRandom;
import java.util.Date;

public class CompleteDelete implements Delete
{
	@Override
	public void delete(String file) throws IOException {
		File path = new File(file);
		if (path.exists()) {
			if (path.isDirectory()) {
				File[] files = path.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						delete(files[i].getAbsolutePath());
					} else {
						fileCourept(files[i]);
					}
				}
			}
			fileCourept(path);

		}

	}

	private void fileCourept(File file) throws IOException {
		System.out.println(file.getName());
		if (file.exists()) {
			long length = file.length();
			SecureRandom random = new SecureRandom();
			RandomAccessFile raf = new RandomAccessFile(file, "rws");
			raf.seek(0);
			raf.getFilePointer();
			byte[] data = new byte[1024];
			int pos = 0;
			while (pos < length) {
				random.nextBytes(data);
				raf.write(data);
				pos += data.length;
			}
			raf.close();
			file.renameTo(new File(System.getProperty("java.io.tmpdir")+new Date().getTime()));
			file.delete();
		}

	}

}
