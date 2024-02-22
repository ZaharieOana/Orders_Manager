package BusinessLogic.Validators;

import Model.Clients;

import java.util.regex.Pattern;

public class EmailValidator implements Validator<Clients>{
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\.][a-zA-Z0-9]+";

    /**
     * Pentru un client dat, metoda verifica prin regex daca emailul are structura necasara: string@string.string
     * @param client clientul pentru care se face verificarea email-ului
     */
    @Override
    public void validate(Clients client) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (!pattern.matcher(client.getEmail()).matches()) {
            throw new IllegalArgumentException("Email is not a valid email!");
        }
    }
}
