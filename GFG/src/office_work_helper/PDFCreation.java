package com.highradius.supportportal.action;

import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.awt.geom.IllegalPathStateException;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TabAlignment;
import com.itextpdf.layout.property.UnitValue;

/**
 * @author debasish.mahana
 **/

public class PDFCreation {
	private static final Logger LOGGER = LogManager.getLogger(PDFCreation.class);
	public static final String REQ_WORKING_DIR = "C:\\Users\\debasish.mahana\\Downloads\\DownloadZIp";
	private static final String OUTPUT_PDF = "Final_Pdf_Creaion.pdf";
	private static AreaBreak pageBreak = new AreaBreak(AreaBreakType.NEXT_PAGE);

	// closing Resource
	protected static void closeResources(Closeable... resources) {
		for (Closeable closable : resources) {
			try {
				if (closable != null) {
					closable.close();
				}
			} catch (Exception e) {
				// Nothing to do
			}
		}
	}

	// slicing text
	private static final String textSlicing(String text1, int begIndex, int endIndex) {
		return (text1.substring(begIndex, endIndex));
	}

	// array with extensions
	private static final String[] EXTENSIONS = new String[] { "tif","PNG","png","tiff" };

	// extension filter
	private static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
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

	public final static void convertTIFToPDF(String REQ_WORKING_DIR, String PDFName) throws IOException {

		// LOGGER.debug("Tiff to PDF conversion started..");
		System.out.println("Tif to PDF Conversion Started...");

		File workingDirectory = new File(String.valueOf(REQ_WORKING_DIR));

		if (workingDirectory.exists() && workingDirectory.isDirectory()) {
			ArrayList<String> filenames = new ArrayList<>();
			for (File file1 : workingDirectory.listFiles(IMAGE_FILTER)) {
				filenames.add(file1.getName());
			}
			File outputPDFFile = null;
			File outputDir = null;
			outputDir = new File(workingDirectory + File.separator + "Output");
			if (!outputDir.exists())
				outputDir.mkdirs();
			outputPDFFile = new File(outputDir + File.separator + String.valueOf(PDFName));
			try {
				PdfDocument pdfDocumentWriter = new PdfDocument(new PdfWriter(String.valueOf(outputPDFFile)));
    			PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
				Document document = new Document(pdfDocumentWriter);
				try {
					for (int i = 0; i < filenames.size(); i = i + 2) {
						String[] d = filenames.get(i).split(File.separator + ".");
						if (textSlicing(filenames.get(i), 0, d[d.length - 2].length() - 1).equalsIgnoreCase(textSlicing(filenames.get(i + 1), 0, d[d.length - 2].length() - 1))) {
							String IMG1 = (new StringBuilder()).append(workingDirectory).append(File.separator + filenames.get(i)).toString();
							String IMG2 = (new StringBuilder()).append(workingDirectory).append(File.separator + filenames.get(i + 1)).toString();

							Table table = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth().setHeight(5000);

							table.setWidth(UnitValue.createPercentValue(100));	

							Image img1 = new Image(ImageDataFactory.create(IMG1));
							Image img2 = new Image(ImageDataFactory.create(IMG2));
							
							//Only For A4
							img1=(img1.getImageHeight()>=2000) ? img1.setRotationAngle(1.5708):img1;
							img2=(img2.getImageHeight()>=2000) ? img2.setRotationAngle(1.5708):img2;

							Cell cell_1= new Cell().add(img1.setAutoScale(true));
							table.addCell(cell_1.setHeight(330));

							Cell cell_2= new Cell().add(img2.setAutoScale(true));
							table.addCell(cell_2.setHeight(330));
							
							Paragraph p = new Paragraph().setFont(font);
							p.addTabStops(new TabStop(275, TabAlignment.LEFT));
							p.setMarginLeft(20).setMarginTop(15);

							p.add("Deposit Date: "+filenames.get(i));
							p.add(new Tab());
							p.add("R/T: "+filenames.get(i+1)+"\n");
							////////////////////Break///////////////////////
							p.add("LockBox: ");
							p.add(new Tab());
							p.add("Account Number: "+"\n");
							////////////////////Break///////////////////////
							p.add("Batch: ");
							p.add(new Tab());
							p.add("Check Number: "+"\n");
							////////////////////Break///////////////////////
							p.add("Transaction: ");
							p.add(new Tab());
							p.add("Amount: "+"\n");

							table.addCell(p);    					
							document.add(table);
							if(i==filenames.size()-2)	break;
							document.add(pageBreak);
						}
					}
				} finally {
					LOGGER.debug("Closing Resources...");
					closeResources(document, pdfDocumentWriter);
				}
				System.out.println("PDF Created Successfully " + workingDirectory + File.separator
						+ outputPDFFile);
			} catch (Exception e) {
				LOGGER.error("Failed to convert TIF Image Files to PDF" + e.getMessage(), e);
				throw e;
			}
		}else {
			throw new IllegalPathStateException();
		}
	}

	// main
	public static void main(String[] args) throws Exception {
		convertTIFToPDF(REQ_WORKING_DIR, OUTPUT_PDF);
    	System.out.println("PDF Saved SuccessFully");  
	}
}
