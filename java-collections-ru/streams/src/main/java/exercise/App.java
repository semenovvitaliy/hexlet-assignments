package exercise;

import java.util.List;

// BEGIN
class App {

    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(str -> getFreeHosts().contains(str.split("@")[1]))
                .count();
    }

    public static List<String> getFreeHosts() {
        return List.of("yandex.ru", "hotmail.com", "gmail.com");
    }
}
// END
