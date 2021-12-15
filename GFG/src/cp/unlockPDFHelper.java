package com.highradius.cp;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;

/**
 @author debasish.mahana
 **/

public class unlockPDFHelper {
	private final static void unlockPDF(File OUTPUT_FOLDER, String[] EXTENSIONS)
			throws IOException, NullPointerException {
		// extension filter
		final FilenameFilter PDF_FILTER = new FilenameFilter() {
			@Override
			public boolean accept(final File dir, final String name) {
				for (final String ext : EXTENSIONS) {
					if (name.endsWith("." + ext)) {
						return (true);
					}
				}
				return (false);
			}
		};
		System.out.print("Enter PDF Password....: ");
		@SuppressWarnings("resource")
		final byte[] OWNERPASS = new Scanner(System.in).next().getBytes();
		if (OUTPUT_FOLDER.exists() && OUTPUT_FOLDER.isDirectory()) {
			File outputDir = new File(OUTPUT_FOLDER + File.separator + "Output");
			if (!outputDir.exists())
				outputDir.mkdirs();
			for (File file1 : OUTPUT_FOLDER.listFiles(PDF_FILTER)) {
				PdfDocument pdfDocument=null;
				try {
					pdfDocument = new PdfDocument(
							new PdfReader(file1.getAbsolutePath(), new ReaderProperties().setPassword(OWNERPASS)),
							new PdfWriter(outputDir + File.separator + file1.getName()));
					pdfDocument.close();
				} catch (Exception e) {
					System.err.println("Error Occured...." + e);
				}
			}
			System.out.println("Unlocked PDF Saved Successfully....");
		}
	}

	public static void main(String[] args) throws Exception {
		final File REQ_WORKING_DIR = new File("C:\\Users\\debasish.mahana\\Desktop\\PdfUnlockHelper");
		final String[] EXTENSIONS = new String[] { "pdf", "PDF" };
		unlockPDF(REQ_WORKING_DIR, EXTENSIONS);
	}
}