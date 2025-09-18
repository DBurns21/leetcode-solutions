class TaskManager {
    //A task consists of its id and the priority it holds
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
        //in order to get its position in the tree we compare the priority of a and b and then return the difference
        //of the prioritys if they aren't equal. If two tasks have the same priority we then go off of the size of the id
        taskQueue = new TreeMap<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a. priority;
            }
            return b.taskId - a.taskId;
        });
        
        taskToPriority = new HashMap<>();

        for (int i = 0; i < tasks.size(); ++i) {
            //could've used a enhanced for loop but its pretty much just the same as this anyways just like one line less
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
        //we get the old task and priority so that we can remove it after we get the necessary info first
        int oldPriority = taskToPriority.get(taskId);
        Task oldTask = new Task(taskId, oldPriority);
        int userId = taskQueue.get(oldTask);

        taskQueue.remove(oldTask);
        taskQueue.put(new Task(taskId, newPriority), userId);
        taskToPriority.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        //if the hashmap is empty than they is nothing to return
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

        //the task at the top of taskQueue is the task with the highest priority of any user
        Task topTask = taskQueue.firstKey();
        //we need to store userId so that we can return it after removing it from the hashmap
        int userId = taskQueue.get(topTask);

        //since we are doing the task we have to remove it from the queue and hashmap
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