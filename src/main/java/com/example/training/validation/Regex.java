package com.example.training.validation;

import com.example.training.exception.GenderFormatException;
import com.example.training.exception.GradeFormatException;
import com.example.training.exception.NameFormatException;
import com.example.training.model.StudentRequestDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Regex {

    public void checkFormat(StudentRequestDTO request) {

        Pattern namePattern = Pattern.compile("[^A-Za-z]");
        Matcher nameMatcher = namePattern.matcher(request.getName());
        boolean nameMatchFound = nameMatcher.find();
        if (nameMatchFound) {
            throw new NameFormatException(request.getName());
        }

        Pattern gradePattern = Pattern.compile("[ABCDF][+-]?$");
        Matcher matcher = gradePattern.matcher(request.getGrade());
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw new GradeFormatException(request.getGrade());
        }

        Pattern genderPattern = Pattern.compile("[MF]");
        Matcher genderMatcher = genderPattern.matcher(request.getGender());
        boolean genderMatchFound = genderMatcher.find();
        if (!genderMatchFound) {
            throw new GenderFormatException(request.getGender());
        }
    }
}
