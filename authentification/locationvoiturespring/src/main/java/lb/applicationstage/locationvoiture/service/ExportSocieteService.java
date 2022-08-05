package lb.applicationstage.locationvoiture.service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lb.applicationstage.locationvoiture.entities.Societe;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import java.util.stream.Stream;
@Service
public class ExportSocieteService   {
    public static ByteArrayInputStream societeExport(List<Societe> societes) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Liste des Societes", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(5);


            Stream.of("nom", "adresse", "email", "tel", "site").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                header.setBackgroundColor(BaseColor.BLUE);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            for (Societe societe : societes) {
                PdfPCell NomCell = new PdfPCell(new Phrase(societe.getNom()));
                NomCell.setPaddingLeft(1);
                NomCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                NomCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(NomCell);


                PdfPCell adresseCell = new PdfPCell(new Phrase(societe.getAdresse()));
                adresseCell.setPaddingLeft(1);
                adresseCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                adresseCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(adresseCell);


                PdfPCell emailCell = new PdfPCell(new Phrase(societe.getEmail()));
                emailCell.setPaddingLeft(1);
                emailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                emailCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(emailCell);

                PdfPCell telCell = new PdfPCell(new Phrase(societe.getTel()));
                telCell.setPaddingLeft(1);
                telCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                telCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(telCell);

                PdfPCell siteCell = new PdfPCell(new Phrase(societe.getSite()));
                siteCell.setPaddingLeft(1);
                siteCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                siteCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(siteCell);
            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }


    public static  ByteArrayInputStream societeExportExcel(List<Societe> societes) throws IOException {
       String[] columns={"nom","adresse","email","tel","site"};
        try(Workbook workbook=new XSSFWorkbook();
        ByteArrayOutputStream out=new ByteArrayOutputStream();){
            CreationHelper creationHelper=workbook.getCreationHelper();

            Sheet sheet = workbook.getSheet("societes");
          sheet.autoSizeColumn(columns.length);
              Font headerFont=workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            CellStyle cellStyle=workbook.createCellStyle();
            cellStyle.setFont(headerFont);
            Row headerRow =sheet.createRow(columns.length);
            for(int col=0;col<columns.length;col++){
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(cellStyle);

            }
           CellStyle cellStyle1=workbook.createCellStyle();
            cellStyle1.setDataFormat(creationHelper.createDataFormat().getFormat("#"));

            int rowIndex=1;
            for (Societe societe:societes)
            {

           Row row= sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(societe.getNom());
                row.createCell(1).setCellValue(societe.getAdresse());
                row.createCell(2).setCellValue(societe.getEmail());
                row.createCell(3).setCellValue(societe.getTel());
                row.createCell(4).setCellValue(societe.getSite());
            }
            workbook.write(out);
            return  new ByteArrayInputStream(out.toByteArray());


        }
    }


}

