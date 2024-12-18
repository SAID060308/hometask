package vazifa2;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Post {
    private String title;
    private ZonedDateTime zonedDateTime;

    public Post(String title, ZonedDateTime zonedDateTime) {
        this.title = title;
        this.zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }


    @Override
    public String toString() {
        return title + "," + zonedDateTime;
    }

}
