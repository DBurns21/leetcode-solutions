class TaskManager {
    class Task {
        int taskId;
        int priority;

        Task(int taskId, int priority) {
            this.taskId = taskId;
            this.priority = priority;
        }
    }


    private TreeMap<Task, Integer> taskQueue;
    private Map<Integer, Integer> taskToPriority;


    public TaskManager(List<List<Integer>> tasks) {
        taskQueue = new TreeMap<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a. priority;
            }
            return b.taskId - a.taskId;
        });
        
        taskToPriority = new HashMap<>();

        for (int i = 0; i < tasks.size(); ++i) {
            List<Integer> current = tasks.get(i);
            int userId = current.get(0);
            int taskId = current.get(1);
            int priority = current.get(2);

            taskQueue.put(new Task(taskId, priority), userId);
            taskToPriority.put(taskId, priority);     
        }
        
    }
    
    public void add(int userId, int taskId, int priority) {
        taskQueue.put(new Task(taskId, priority), userId);
        taskToPriority.put(taskId, priority);
    }
    
    public void edit(int taskId, int newPriority) {
        int oldPriority = taskToPriority.get(taskId);
        Task oldTask = new Task(taskId, oldPriority);
        int userId = taskQueue.get(oldTask);

        taskQueue.remove(oldTask);
        taskQueue.put(new Task(taskId, newPriority), userId);
        taskToPriority.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        if (!taskToPriority.containsKey(taskId)) {
            return;
        }

        int priority = taskToPriority.get(taskId);

        taskQueue.remove(new Task(taskId, priority));
        taskToPriority.remove(taskId);
    }
    
    public int execTop() {
        if (taskQueue.isEmpty()) {
            return -1;
        }

        Task topTask = taskQueue.firstKey();
        int userId = taskQueue.get(topTask);

        taskQueue.remove(topTask);
        taskToPriority.remove(topTask.taskId);

        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */