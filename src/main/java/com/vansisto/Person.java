package com.vansisto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(".*@.{2,}\\..{2,}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
