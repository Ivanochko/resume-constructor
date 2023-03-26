package com.resume.constructor.user.personal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.resume.constructor.user.education.Education;
import com.resume.constructor.user.personal.dto.Contact;
import com.resume.constructor.user.personal.dto.Sex;
import com.resume.constructor.user.experience.Work;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class UserPersonalEntity {

    @Id
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String title;

    private String location;

    private String phoneNumber;

    @Column(length = 200, columnDefinition = "text")
    private String summary;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Builder.Default
    @Type(type = "json")
    private List<Contact> contacts = new ArrayList<>();

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private Set<Work> userWorks;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private Set<Education> userEducations;

}
