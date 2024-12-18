package vazifa2;

import java.time.ZoneId;

public class User {
    private String phone;
    private String password;
    private ZoneId zoneId;

    public User(String phone, String password, ZoneId zoneId) {
        this.phone = phone;
        this.password = password;
        this.zoneId = zoneId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public static User fromString(String data) {
        String[] parts = data.split(",");
        return new User(parts[0], parts[1], ZoneId.of(parts[2]));
    }
}
