package data;

public class Task {
    protected Level level;
    protected String task;
    protected int idTask;

    public Task(Level level, int idTask, String task) {
        this.level = level;
        this.idTask = idTask;
        this.task = task;
    }
    public Level getLevel() {
        return level;
    }

    public String getTask() {
        return task;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }
}
