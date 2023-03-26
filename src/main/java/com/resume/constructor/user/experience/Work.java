package com.resume.constructor.user.experience;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String jobTitle;

    @NotBlank
    private String company;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    private String participation;

    @Builder.Default
    private Boolean isCurrent = false;

    @JsonIgnoreProperties("userWorks")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = UserPersonalEntity.class, fetch = FetchType.EAGER)
    private UserPersonalEntity user;

    @Column(name = "user_id")
    private Long userId;

}
