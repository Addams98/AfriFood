package com.ecommerce.library.dto;

import com.ecommerce.library.model.City;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @Size(min = 3, max = 10, message = "Le prénom contient de 3 à 10 caractères")
    private String firstName;

    @Size(min = 3, max = 10, message = "Le nom  contient de 3 à 10 caractères")
    private String lastName;
    private String username;
    @StrongPassword
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$",
            message = "Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre et un caractère spécial")
    @Size(min = 3, max = 15, message = "Le mot de passe contient 3 à 15 caractères")
    private String password;

    @Size(min = 10, max = 15, message = "Le numéro de téléphone contient 10 à 15 caractères")

    private String phoneNumber;

    private String address;
    private String confirmPassword;
    private City city;
    private String image;
    private String country;
    // Custom Validation Annotation

    public @interface StrongPassword {
    }

}
