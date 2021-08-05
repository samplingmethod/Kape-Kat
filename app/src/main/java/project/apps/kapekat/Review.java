package project.apps.kapekat;

import android.media.Image;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Review extends RealmObject {
    @PrimaryKey
    private String uuid;
    private String user_uuid;
    private String review;

    public Review(){
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "uuid='" + uuid + '\'' +
                ", user_uuid='" + user_uuid + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}