package com.resume.constructor.api;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.lowagie.text.DocumentException;
import com.resume.constructor.pdf.PdfByTemplateExporter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users/export")
public class ExportController {

    private final PdfByTemplateExporter pdfExporter;

    @GetMapping("/current")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String currentDateTime = LocalDateTime.now().format(dateFormatter);

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        pdfExporter.export(response);
    }

}
