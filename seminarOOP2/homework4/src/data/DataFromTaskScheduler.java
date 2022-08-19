package data;

import java.time.LocalDateTime;

public class DataFromTaskScheduler {
    private Level level;
    private static int idTask = 0;
    private LocalDateTime taskDefinitionTime;
    private LocalDateTime deadlineTask;
    private String fullName;

    public Level getLevel() {
        return level;
    }

    public DataFromTaskScheduler(LocalDateTime taskDefinitionTime,
                                 LocalDateTime deadlineTask,
                                 String fullName, Level level) {
        setTaskDefinitionTime(taskDefinitionTime);
        setDeadlineTask(deadlineTask);
        setFullName(fullName);
        setLevel(level);
        idTask++;
    }

    public DataFromTaskScheduler(LocalDateTime taskDefinitionTime,
                                 LocalDateTime deadlineTask,
                                 String fullName) {
        this(taskDefinitionTime, deadlineTask, fullName, Level.LOW);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getIdTask() {
        return idTask;
    }

    public LocalDateTime getTaskDefinitionTime() {
        return taskDefinitionTime;
    }

    public void setTaskDefinitionTime(LocalDateTime taskDefinitionTime) {
        this.taskDefinitionTime = taskDefinitionTime;
    }

    public LocalDateTime getDeadlineTask() {
        return deadlineTask;
    }

    public void setDeadlineTask(LocalDateTime deadlineTask) {
        this.deadlineTask = deadlineTask;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return String.format("id: %d\nadded: %s\ndeadline: %s\nfull name: %s",
                idTask, taskDefinitionTime, deadlineTask, fullName);
    }
}
