package evaluationstask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DynamicEmailsCreator {

    public static void main(String[] args) {
        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Example";
        System.out.println((new DynamicEmailsCreator()).solution(S, C));
    }
    public String solution(String S, String C) {
        final String[] users = S.split(";");
        final HashMap<String, Integer> emails = new LinkedHashMap<>();

        String emailPattern = "@" + C.toLowerCase() + ".com>";
        for (String user : users) {
            String newEmailUser = "";
            final String[] namesAndSurname = user.toLowerCase().trim().split(" ");

            if (namesAndSurname.length == 2) {
                if (namesAndSurname[1].contains("-"))
                    namesAndSurname[1] = namesAndSurname[1].replace("-", "");
                newEmailUser = namesAndSurname[1].concat("_").concat(namesAndSurname[0]);
            }

            if (namesAndSurname.length == 3) {
                if (namesAndSurname[2].contains("-"))
                    namesAndSurname[2] = namesAndSurname[2].replace("-", "");
                newEmailUser = namesAndSurname[2].concat("_").concat(namesAndSurname[0]);
            }

            final Integer userOccurences = emails.getOrDefault(newEmailUser, 0);
            if (userOccurences > 0) {
                String oldUser = newEmailUser;
                newEmailUser = newEmailUser.concat(String.valueOf(emails.get(newEmailUser) + 1));
                emails.computeIfPresent(oldUser, (key, val) -> val + 1);
            }
            emails.put(newEmailUser, 1);
        }

        List<String> result = new ArrayList(emails.keySet());
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < users.length; i++)
            stringBuilder.append(users[i].trim()).append(" <").append(result.get(i)).append(emailPattern).append("; ");

        String response = stringBuilder.toString();
        return response.substring(0, response.length() - 2);
    }

}
