package com.resume.constructor.user.education;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.resume.constructor.user.personal.UserPersonalEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String degree;

    @Min(1950)
    @Max(2100)
    private Integer yearOfGraduation;

    private String placeOfGraduation;

    @JsonIgnoreProperties("userEducations")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = UserPersonalEntity.class, fetch = FetchType.EAGER)
    private UserPersonalEntity user;

    @Column(name = "user_id")
    private Long userId;

}
