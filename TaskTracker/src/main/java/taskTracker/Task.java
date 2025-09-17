package taskTracker;

import com.google.gson.Gson;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Task {
    private String id;
    private String description;
    private Status status;
    private String createdAt;
    private String updatedAt;

    public Task(String createdAt, String description, String id, Status status, String updatedAt) {
        this.createdAt = now();
        this.description = description;
        this.id = id;
        this.status = Status.to_do;
    }

    public enum Status {
        to_do , in_progress, done
    }

    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = now();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.updatedAt = now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    private static final Gson gson = new Gson();

    public String toJson() {
        return gson.toJson(this);
    }

    public static Task fromJson(String json) {
        return gson.fromJson(json, Task.class);
    }

    @Override
    public String toString() {
        return String.format("Task{id='%s', description='%s', status='%s', createdAt='%s', updatedAt='%s'}",
                id, description, status, createdAt, updatedAt);
    }
}
