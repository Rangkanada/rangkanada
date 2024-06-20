package kbkm.th2023.limbonganready.model;


public class Notifikasi {
    private int id;
    private String title;
    private String description;
    private String name;
    private String time;
    private String type;
    private String message;
    private String createdAt;
    private String updatedAt;
    private int notificationId;
    private int userId;
    private String readAt;
    private String email;
    private String emailVerifiedAt;
    private String password;
    private String rememberToken;

    // Constructors

    public Notifikasi(int id, String title, String description, String name, String time, String type, String message, String createdAt, String updatedAt, int notificationId, int userId, String readAt, String email, String emailVerifiedAt, String password, String rememberToken) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.name = name;
        this.time = time;
        this.type = type;
        this.message = message;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.notificationId = notificationId;
        this.userId = userId;
        this.readAt = readAt;
        this.email = email;
        this.emailVerifiedAt = emailVerifiedAt;
        this.password = password;
        this.rememberToken = rememberToken;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReadAt() {
        return readAt;
    }

    public void setReadAt(String readAt) {
        this.readAt = readAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }
}