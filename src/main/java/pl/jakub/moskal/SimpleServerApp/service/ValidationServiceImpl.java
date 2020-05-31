package pl.jakub.moskal.SimpleServerApp.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final static String phoneRegex = "(?<!\\w)(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)";

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }
}
