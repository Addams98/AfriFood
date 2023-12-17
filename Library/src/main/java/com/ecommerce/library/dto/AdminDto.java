package com.ecommerce.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    @Size(min = 3, max = 10, message = "Le nombre caractères doit etre entre 3 et 10")
    private String firstName;

    @Size(min = 3, max = 10, message = "Le nombre caractères doit etre entre 3 et 10")
    private String lastName;

    private String username;

    @Size(min = 5, max = 10, message = "Le mot de passe doit contenir au minimum 5 caractères et aux maximum 10")
    @Pattern.List({
            @Pattern(regexp = "(?=.*[0-9]).+", message = "Le mot de passe doit contenir au moins un chiffre"),
            @Pattern(regexp = "(?=.*[a-z]).+", message = "Le mot de passe doit contenir au moins une lettre minuscule"),
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Le mot de passe doit contenir au moins une lettre majuscule."),
            @Pattern(regexp = "(?=.*[@#$%^&+=]).+", message = "Le mot de passe doit contenir au moins un caractère spécial")
    })
    private String password;

    private String repeatPassword;

    // Custom Validation Annotation
    @Documented
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = {})
    public @interface StrongPassword {
        String message() default "Mot de passe invalide";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
}
