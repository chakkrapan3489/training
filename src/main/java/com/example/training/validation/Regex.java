package com.example.training.validation;

import com.example.training.exception.BaseException;
import com.example.training.exception.StudentException;
import com.example.training.model.StudentRequestDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Regex {

    public void checkFormat(StudentRequestDTO request) throws BaseException {

        Pattern namePattern = Pattern.compile("[^A-Za-z]");
        Matcher nameMatcher = namePattern.matcher(request.getName());
        boolean nameMatchFound = nameMatcher.find();
        if (nameMatchFound) {
            throw StudentException.NameFormatException(request.getName());
        }

        Pattern gradePattern = Pattern.compile("[ABCDF][+-]?$");
        Matcher matcher = gradePattern.matcher(request.getGrade());
        boolean matchFound = matcher.find();
        if (!matchFound) {
            throw StudentException.GradeFormatException(request.getGrade());
        }

        Pattern genderPattern = Pattern.compile("[MF]");
        Matcher genderMatcher = genderPattern.matcher(request.getGender());
        boolean genderMatchFound = genderMatcher.find();
        if (!genderMatchFound) {
            throw StudentException.GenderFormatException(request.getGender());
        }
    }
}
