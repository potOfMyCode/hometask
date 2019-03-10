package pack;

public interface RegexContainer {
    String REGEX_FIRSTNAME = "^[A-Z][a-z]{1,20}$";
    String REGEX_LASTNAME = "^[A-Z][a-z]{1,20}$";
    String REGEX_FIRSTNAME_UA = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_LASTNAME_UA = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_LOGIN = "[A-Za-z]+[_0-9]*";
    String REGEX_PASSWORD = "[A-Za-z0-9_]{6,10}";
}
