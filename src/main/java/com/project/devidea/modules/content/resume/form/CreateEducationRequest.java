package com.project.devidea.modules.content.resume.form;

import com.project.devidea.api.Request;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateEducationRequest extends Request {

    @NotEmpty
    private String schoolName;
    @NotEmpty
    private String major;
    @NotNull
    private LocalDate entranceDate;
    @NotNull
    private LocalDate graduationDate;
    private double score;
    private String degree;

    @Builder
    public CreateEducationRequest(@NotEmpty String schoolName, @NotEmpty String major, @NotNull LocalDate entranceDate, @NotNull LocalDate graduationDate, double score, String degree) {
        this.schoolName = schoolName;
        this.major = major;
        this.entranceDate = entranceDate;
        this.graduationDate = graduationDate;
        this.score = score;
        this.degree = degree;
    }
}