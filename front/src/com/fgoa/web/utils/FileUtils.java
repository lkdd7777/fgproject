package com.fgoa.web.utils;

import com.woo.jfinal.exception.BizException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.commons.lang.StringUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

public class FileUtils {
	public static void unZip(File file, String extraDirectory)
			throws IOException {
		ZipFile zipFile = null;
		InputStream fis = null;
		FileOutputStream fos = null;
		byte[] buffer = new byte['?'];
		int readLen = 0;
		if (!new File(extraDirectory).exists()) {
			mkDirs(extraDirectory);
		}
		try {
			zipFile = new ZipFile(file, "gbk");

			Enumeration<ZipEntry> entries = zipFile.getEntries();
			while (entries.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) entries.nextElement();
				if (zipEntry.isDirectory()) {
					String directoryPath = zipEntry.getName();
					String directoryName = directoryPath.substring(0,
							directoryPath.length() - 1);

					mkDirs(extraDirectory + File.separator + directoryName);
				} else {
					String entryName = zipEntry.getName();
					File entryFile = new File(extraDirectory + File.separator
							+ entryName);

					String parentPath = entryFile.getParent();
					mkDirs(parentPath);
					entryFile.createNewFile();
					fis = zipFile.getInputStream(zipEntry);
					fos = new FileOutputStream(entryFile);
					while ((readLen = fis.read(buffer)) > 0) {
						fos.write(buffer, 0, readLen);
					}
				}
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			}
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
			zipFile.close();
		}
	}

	public static void mkDirs(String dirPath) {
		if (StringUtils.isBlank(dirPath)) {
			throw new BizException("������������������");
		}
		File f = new File(dirPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	public static void deleteDir(String dirPath) {
		if (StringUtils.isBlank(dirPath)) {
			throw new BizException("������������������");
		}
		File f = new File(dirPath);
		if (f.exists()) {
			deleteAllFiles(f);
		}
	}

	public static void deleteAllFiles(File file) {
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				deleteAllFiles(child);
			}
		}
		file.delete();
	}

	public static void saveFile(String destPath, File file) throws Exception {
		org.apache.commons.io.FileUtils.copyFile(file, new File(destPath));
	}
}
