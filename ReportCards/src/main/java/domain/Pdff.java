
package domain;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import database.MySqlConnection;

import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//import javax.swing.text.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author LAVI
 */
public class Pdff {
    public Pdff(String myClass, String section) {
        {
            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            try {
                PdfWriter.getInstance(document, new FileOutputStream("ReportCards.pdf"));
                document.open();

            } catch (Exception ex) {
                Logger.getLogger(Pdff.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = MySqlConnection.getConnection();
                Statement stmt = con.createStatement();
                String query = "use userreport";
                stmt.executeUpdate(query);
                String q = "SELECT c_id FROM class WHERE class = ? and `section`= ?;";
                PreparedStatement prep = con.prepareStatement(q);
                prep.setInt(1,Integer.parseInt(myClass));
                prep.setString(2,section);
                ResultSet rs1 = prep.executeQuery();
                rs1.next();
                String cid = rs1.getString("c_id");
                String sid[] = new String[20];
                String marks[] = new String[20];
                int k = 0;
                String sname[] = new String[20];
                String studname[] = new String[27];
                for (int i = 1; i <= 27; i++)

                {

                    for (int r = 0; r < 27; r++) {
                        int s = r + 1;
                        query = "select name from students_details " +
                                "inner join students on students_details.stud_id = students.stud_id where students.stud_id=" + s+" and c_id =+"+cid;
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            studname[r] = rs.getString("name");
                        }
                        System.out.println(studname[r]);

                    }
                    query = "select c_id from students where stud_id=" + i + "";
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        cid = rs.getString("c_id");
                    }
                    System.out.println(cid);
                    query = " select * from marks where stud_id=" + i + "";
                    rs = stmt.executeQuery(query);
                    k = 0;
                    while (rs.next()) {
                        marks[k] = rs.getString("marks");
                        System.out.println(marks[k]);
                        k++;
                    }
                    query = "select * from class_subject_map where c_id=" + cid + "";
                    rs = stmt.executeQuery(query);
                    k = 0;
                    int length = 0;
                    while (rs.next()) {
                        sid[k] = rs.getString("sub_id");
                        length++;
                        k++;
                    }
                    System.out.println(length);

                    for (k = 0; k < length; k++) { //System.out.println(k);
                        // int j=Integer.parseInt(sid[k]);
                        //System.out.println(sid[k]);
                        query = "select * from subject where sub_id=" + sid[k];
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            sname[k] = rs.getString("subname");
                        }

                        System.out.println(sname[k]);
                    }
                    int j;
                    float percentage = 0;
                    String grade = null;
//                    query = "select percentage , grade from percentage where stud_id=" + i;
//                    rs = stmt.executeQuery(query);
//                    while (rs.next()) {
//                        percentage = rs.getFloat("percentage");
//                        grade = rs.getString("grade");
//                    }

                    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    Chunk chunk = new Chunk("Name: " + studname[i - 1] + "\n \n ", font);
                    Paragraph clas = new Paragraph("Class:");
                    clas.setAlignment(Element.ALIGN_LEFT);
                    Paragraph sec = new Paragraph("Section:");
                    sec.setAlignment(Element.ALIGN_RIGHT);

                    PdfPTable table = new PdfPTable(new float[]{7, 7});

                    try {
                        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                        document.add(new Paragraph("\n \n \n \n \n "));
                        document.add(chunk);
                        document.add(clas);
                        document.add(sec);
                        document.add(new Paragraph("\n \n \n \n"));
                        table.addCell("Subject");
                        table.addCell("Marks");
                        table.setHeaderRows(1);
                        PdfPCell[] cells = table.getRow(0).getCells();
                        for (j = 0; j < cells.length; j++) {
                            cells[j].setBackgroundColor(BaseColor.GRAY);
                        }
                        for (k = 0; k < length; k++) {
                            table.addCell(sname[k]);
                            table.addCell(marks[k]);
                        }
                        document.add(table);
                        document.add(new Paragraph("\n \n"));
                        Paragraph percent = new Paragraph("percentage:" + percentage);
                        percent.setAlignment(Element.ALIGN_LEFT);
                        document.add(percent);
                        Paragraph grad = new Paragraph("Grade:" + grade);
                        grad.setAlignment(Element.ALIGN_RIGHT);
                        document.add(grad);
                        document.add(new Paragraph("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n"));


                    } catch (Exception ex) {
                        Logger.getLogger(Pdff.class.getName()).log(Level.SEVERE, null, ex);
                    }


                }
                document.close();
            } catch (Exception eee) {
                eee.printStackTrace();
            }


        }

    }
//
//    public static void main(String st[]) throws FileNotFoundException {
//
//    }

}
