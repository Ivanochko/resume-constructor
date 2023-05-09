package com.resume.constructor.pdf.parser;

import com.resume.constructor.user.dto.UserAllDataDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Component
@AllArgsConstructor
public class TemplateParser {

    public String parseThymeleafTemplate(UserAllDataDto allDataOfCurrentUser) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("firstName", allDataOfCurrentUser.getFirstName());
        context.setVariable("lastName", allDataOfCurrentUser.getLastName());
        context.setVariable("title", allDataOfCurrentUser.getTitle());
        context.setVariable("summary", allDataOfCurrentUser.getSummary());
        context.setVariable("contacts", allDataOfCurrentUser.getContacts());
        context.setVariable("works", allDataOfCurrentUser.getWorks());
        context.setVariable("educations", allDataOfCurrentUser.getEducations());

        return templateEngine.process("templates/template", context);
    }

}
