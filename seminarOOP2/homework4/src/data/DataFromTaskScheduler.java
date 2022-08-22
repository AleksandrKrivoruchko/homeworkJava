package data;

import java.time.LocalDateTime;

public class DataFromTaskScheduler extends Task{
    private static int id = 1;
    private LocalDateTime taskAddedTime;
    private LocalDateTime deadlineTask;
    private String fullName;

    public DataFromTaskScheduler(String task,
                                 LocalDateTime taskAddedTime,
                                 LocalDateTime deadlineTask,
                                 String fullName, Level level) {
        super(level, id, task);
        setTaskAddedTime(taskAddedTime);
        setDeadlineTask(deadlineTask);
        setFullName(fullName);
        id++;
    }

    public DataFromTaskScheduler(String task,
                                 LocalDateTime taskAddedTime,
                                 LocalDateTime deadlineTask,
                                 String fullName) {
        this(task, taskAddedTime, deadlineTask, fullName, Level.LOW);
    }

    public DataFromTaskScheduler(String task,
                                 LocalDateTime deadlineTask,
                                 String fullName, Level level) {
        this(task, LocalDateTime.now(), deadlineTask, fullName, level);
    }

    public DataFromTaskScheduler(String task,
                                 LocalDateTime deadlineTask,
                                 String fullName) {
        this(task, LocalDateTime.now(), deadlineTask, fullName, Level.LOW);
    }

    public LocalDateTime getTaskAddedTime() {
        return taskAddedTime;
    }

    public void setTaskAddedTime(LocalDateTime taskAddedTime) {
        this.taskAddedTime = taskAddedTime;
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
        MyDateTime tmpAdd = new MyDateTime(taskAddedTime);
        MyDateTime tmpD = new MyDateTime(deadlineTask);
        return String.format("id: %d\nadded: %s %s\ndeadline: %s %s\nfull name: %s\n %s",
                idTask, tmpAdd.getDate(), tmpAdd.getTime(),
                tmpD.getDate(), tmpD.getTime(), fullName, task);
    }
}
