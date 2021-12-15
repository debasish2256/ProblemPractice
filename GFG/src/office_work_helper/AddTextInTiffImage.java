package com.highradius.supportportal.action;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.highradius.common.util.HRCLog;
import com.highradius.common.util.HRCLogFactory;
import com.itextpdf.awt.geom.IllegalPathStateException;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.UnitValue;

public class AddTextInTiffImage {
	static String sourcePath="C:\\Users\\debasish.mahana\\Downloads\\DownloadZIp";
	static String outputPath="C:\\Users\\debasish.mahana\\Downloads\\CommentInTiff\\"; 

	
	static final File odir = new File(outputPath);
    static final File sdir = new File(sourcePath);
	public static final Logger LOGGER =  LogManager.getLogger(AddTextInTiffImage.class);

    static final String[] EXTENSIONS = new String[]{
    		"tif"
    };
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
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
    
 	
    private static int imageCoordinateHelper(double imageSize, int startCoordinate) {
		return (int) ((((imageSize/startCoordinate)*10))/10);
	}   
    
    private static void addTestInTiffImage(String[] text,String type, File source, File destination) throws IOException {

//    		text = (text.length==0 || text==null) ? new String[] {""} : text ;

    		BufferedImage image=ImageIO.read(source);
    		int imageType="tif".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;

    		BufferedImage bold=new BufferedImage(image.getWidth(),image.getHeight(),imageType);

    		Graphics2D w = (Graphics2D) bold.getGraphics();

    		w.drawImage(image, 1,2,null);
    		AlphaComposite alpha=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f);

    		w.setComposite(alpha);
    		w.setColor(Color.RED);
    		w.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));

    		/*int centerX = (image.getWidth()-(int) rect.getWidth())/2;
			int centerY = image.getHeight()/2;*/


    		int X=image.getWidth()/imageCoordinateHelper(image.getWidth(),100);
    		int Y=image.getHeight()/imageCoordinateHelper(image.getHeight(),300);
    		
    		for(String s:text) {
    			w.drawString(s,X,Y);
    			Y+=30;
    		}

    		ImageIO.write(bold, type,destination);

    		w.dispose();
		
	}
	
    
    public static void main(String[] args) throws Exception {

    	if (sdir.isDirectory() && odir.isDirectory()) { 
    		for (final File f : sdir.listFiles(IMAGE_FILTER)) {
    			
    			String text="HRC First Line\nHRC Second Line\nHRC Third Line";
    			
    			String[] textArray = text.split("\n");

    			try {
    				File dpath=new File(odir+File.separator+f.getName());
    				String[] d=f.getName().split(File.separator+".");
    				if((d[d.length-2].charAt(d[d.length-2].length()-1))=='B') 
    					addTestInTiffImage(textArray,d[d.length-1],f,dpath);
    				else
    					addTestInTiffImage(new String[] {""},d[d.length-1],f,dpath);
    			} catch (final Exception e) {
    				LOGGER.error("Exception in :", e);
    			}
    		}
			PDFCreation.convertTIFToPDF(outputPath,"Final_Pdf_Creaion.pdf");
    	}
    }
}