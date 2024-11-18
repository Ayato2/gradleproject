package pl.edu.pjatk.gradleprojekt.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PDFService {

    public byte[] generateCapybaraPdf(String name, String color) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(100, 700);

        contentStream.showText("Capybara Information");
        contentStream.newLineAtOffset(0, -20);

        contentStream.showText("Name: " + name);
        contentStream.newLineAtOffset(0, -20);

        contentStream.showText("Color: " + color);

        contentStream.endText();
        contentStream.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();

        return baos.toByteArray();
    }
}
