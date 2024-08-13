package vn.edu.giadinh.tasksmanagement.models;

import vn.edu.giadinh.tasksmanagement.enums.TaskProgress;
import vn.edu.giadinh.tasksmanagement.enums.TaskStatus;

public class Task {
    // Inner classes:
    public static class Builder {
        private int id;
        private String title;
        private String description;
        private TaskStatus status;
        private TaskProgress progress;
        private String responsibility;
        private String tester;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder status(TaskStatus status) {
            this.status = status;
            return this;
        }

        public Builder progress(TaskProgress progress) {
            this.progress = progress;
            return this;
        }

        public Builder responsibility(String responsibility) {
            this.responsibility = responsibility;
            return this;
        }

        public Builder tester(String tester) {
            this.tester = tester;
            return this;
        }

        public Task build() {
            return new Task(id, title, description, status, progress, responsibility, tester);
        }
    }

    // Static methods:
    public static Builder builder() {
        return new Builder();
    }

    // Fields:
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskProgress progress;
    private String responsibility;
    private String tester;

    // Constructors:
    public Task() {
    }

    public Task(int id, String title, String description, TaskStatus status, TaskProgress progress, String responsibility, String tester) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.progress = progress;
        this.responsibility = responsibility;
        this.tester = tester;
    }

    // Getters / setters:
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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskProgress getProgress() {
        return progress;
    }

    public void setProgress(TaskProgress progress) {
        this.progress = progress;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }
}
