package com.resume.constructor.pdf;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import com.resume.constructor.pdf.parser.TemplateParser;
import com.resume.constructor.user.UserService;
import com.resume.constructor.user.dto.UserAllDataDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
@AllArgsConstructor
public class PdfByTemplateExporter {

    private final UserService userService;
    private final TemplateParser templateParser;

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);

        UserAllDataDto allDataOfCurrentUser = userService.getAllDataOfCurrentUser();
        String html = templateParser.parseThymeleafTemplate(allDataOfCurrentUser);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }

}
