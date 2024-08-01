public class SinglyLinkedList {
    private Node head;

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task task1 = new Task("T001", "Design Homepage Layout", "Pending");
        Task task2 = new Task("T002", "Implement User Authentication", "In Progress");
        Task task3 = new Task("T003", "Deploy Application to Production", "Completed");
        Task task4 = new Task("T004", "Write Unit Tests", "In Progress");        

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(task4);

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task T003:");
        Task searchResult = taskList.searchTask("T003");
        System.out.println(searchResult != null ? searchResult : "Task not found");

        System.out.println("\nDeleting Task T002:");
        taskList.deleteTask("T002");
        taskList.traverseTasks();
    }
}
