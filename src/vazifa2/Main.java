package vazifa2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    static Path path = Path.of("file2/a.txt");
    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    1. Login
                    2. Register
                    """);
            switch (Input.Int("tanlang -> ")) {
                case 1 -> login();
                case 2 -> register();
            }
        }
    }

    public static void login() {
        String phone = Input.Str("Telefon raqamni kiriting: ");
        String password = Input.Str("Parolni kiriting: ");
        for (User user : users) {
            if (user.getPassword().equals(password)&&user.getPhone().equals(password)){

            }else {
                System.out.println("Parol yokiy login xato !!!");
            }
        }
    }

    public static void register() {
        String phone = Input.Str("Telefon raqamni kiriting:");
        while (!phone.matches("\\+998\\d{9}")) {
            System.out.println("Siz tel nomerni xato kiritdingiz, iltimos qayta urinib ko'ring!");
            phone = Input.Str("Telefon raqamni kiriting:");
        }
        String password = Input.Str("Parol kiriting:");
        Map<Integer, String> zoneMap = Map.of(
                1, "Asia/Tashkent",
                2, "Asia/Samarkand",
                3, "Europe/Moscow",
                4, "America/New_York",
                5, "Europe/London"
        );

        System.out.println("Hududingizni tanlang:");
        zoneMap.forEach((key, value) -> System.out.printf("%d. %s%n", key, value.split("/")[1])); // Faqat shahar nomini ko'rsatish
        int selectedZone = Input.Int("tanlang -> ");
        ZoneId zoneId = ZoneId.of(zoneMap.get(selectedZone));
        User user = new User(phone,password,zoneId);
        users.add(user);
        System.out.println("Ro'yxatdan o'tish muvaffaqiyatli amalga oshirildi!");
    }

}
