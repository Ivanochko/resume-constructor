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
        context.setVariable("location", allDataOfCurrentUser.getLocation());
        context.setVariable("phoneNumber", allDataOfCurrentUser.getPhoneNumber());
        context.setVariable("summary", allDataOfCurrentUser.getSummary());
        context.setVariable("contacts", allDataOfCurrentUser.getContacts());
        context.setVariable("works", allDataOfCurrentUser.getWorks());
        context.setVariable("educations", allDataOfCurrentUser.getEducations());
        context.setVariable("courses", allDataOfCurrentUser.getCourses());
        context.setVariable("skills", allDataOfCurrentUser.getSkills());

        return templateEngine.process("templates/main-template", context);
    }

}
