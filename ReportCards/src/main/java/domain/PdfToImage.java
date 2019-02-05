package domain;
//see link at https://gist.github.com/liashchynskyi/094ec0fe009a2cf5822c1c92ae277724 & https://technology.amis.nl/2008/11/28/java-generating-pdf-and-previewing-it-as-an-image-itext-and-pdf-renderer/
//jar files @ http://www.java2s.com/Code/Jar/p/Downloadpdfrendererjar.htm
//http://www.java2s.com/Code/Jar/i/Downloaditextpdf510jar.htm


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import javax.swing.*;

public class PdfToImage {
    public PdfToImage() {
    }

    private static ByteArrayOutputStream createPDF() throws DocumentException,
            MalformedURLException,
            IOException {
        Document doc = new Document();
        ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
        PdfWriter docWriter = null;
        docWriter = PdfWriter.getInstance(doc, baosPDF);
        doc.open();
        URL imageUrl = new URL("https://i.imgur.com/GGBYtr9.jpg");
        com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imageUrl);

        image.scaleToFit(300,100);
        image.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
        doc.add(image);
        doc.add(new Paragraph("This special PDF document was created on " +
                new java.util.Date()));

        doc.close();
        docWriter.close();
        return baosPDF;
    }

    public static void previewPDFDocumentInImage() throws IOException {
        ByteBuffer buf = null;

        try {
            buf = ByteBuffer.wrap(createPDF().toByteArray());
        } catch (DocumentException e) {
        }
        // use the PDF Renderer library on the buf which contains the in memory PDF document
        PDFFile pdffile = new PDFFile(buf);
        PDFPage page = pdffile.getPage(1);

        //get the width and height for the doc at the default zoom
        Rectangle rect =
                new Rectangle(0, 0, (int)page.getBBox().getWidth(), (int)page.getBBox().getHeight());

        //generate the image
        Image img = page.getImage(rect.width, rect.height, //width & height
                rect, // clip rect
                null, // null for the ImageObserver
                true, // fill background with white
                true) // block until drawing is done
                ;

        //show the image in a frame
        JFrame frame = new JFrame("My incredible PDF document");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    PdfToImage.previewPDFDocumentInImage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}



