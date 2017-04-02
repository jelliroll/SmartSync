package model;

/**
 * Created by trev on 4/1/17.
 */
public class AuthPOJO {


    private String googleId;

    private long sessionId;

    private int role;

    public AuthPOJO(String googleId, long sessionId, int role) {
        this.googleId = googleId;
        this.sessionId = sessionId;
        this.role = role;

    }

    public String getGoogleId() {
        return googleId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "AuthPOJO{" +
                "\n\tgoogleId=" + googleId + "\"" +
                ",\n\tsessionId=" + sessionId +
                ",\n\tisAdmin=" + role +
                "\n}";
    }


}
