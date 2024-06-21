package kbkm.th2023.limbonganready.model;

import java.util.Date;

public class Chat {
    private int id;
    private int forum_id;
    private int user_id;
    private String message;
    private String sent_at;
    private String created_at;
    private String updated_at;
    private String user_name;
    private String user_email;

    // Constructors
    public Chat() {
    }

    public Chat(int id, int forum_id, int user_id, String message, String sent_at, String created_at, String updated_at, String user_name, String user_email) {
        this.id = id;
        this.forum_id = forum_id;
        this.user_id = user_id;
        this.message = message;
        this.sent_at = sent_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_name = user_name;
        this.user_email = user_email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForumId() {
        return forum_id;
    }

    public void setForumId(int forum_id) {
        this.forum_id = forum_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentAt() {
        return sent_at;
    }

    public void setSentAt(String sentAt) {
        this.sent_at = sentAt;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String userName) {
        this.user_name = userName;
    }

    public String getUserEmail() {
        return user_email;
    }

    public void setUserEmail(String userEmail) {
        this.user_email = userEmail;
    }
}
