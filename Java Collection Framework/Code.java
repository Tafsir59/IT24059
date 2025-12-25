package src;

import java.util.*;

public class AssignmentSolutions {

    public static void main(String[] args) {
        System.out.println("====== TASK 1: Kth Smallest Element ======");
        task1_findKthSmallest();

        System.out.println("\n====== TASK 2: Word Frequency TreeMap ======");
        task2_wordFrequency();

        System.out.println("\n====== TASK 3: Queue & Stack using PriorityQueue ======");
        task3_pqImplementations();

        System.out.println("\n====== TASK 4: Student TreeMap ======");
        task4_studentMap();

        System.out.println("\n====== TASK 5: LinkedList Equality Check ======");
        task5_linkedListEquality();

        System.out.println("\n====== TASK 6: Employee HashMap ======");
        task6_employeeMap();
    }

    public static void task1_findKthSmallest() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(12, 3, 5, 7, 19, 1));
        int k = 2;

        System.out.println("Input List: " + numbers);
        System.out.println("Finding " + k + "-th smallest element...");

        if (k > numbers.size() || k <= 0) {
            System.out.println("Invalid k value");
            return;
        }

        Collections.sort(numbers);

        int result = numbers.get(k - 1);
        System.out.println("The " + k + "-th smallest element is: " + result);
    }

    public static void task2_wordFrequency() {
        String text = "hello world hello java world code code code";
        System.out.println("Input Text: \"" + text + "\"");

        Map<String, Integer> wordCounts = new TreeMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies (Sorted Alphabetically):");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static class PQNode<T> {
        T data;
        int insertionOrder;

        public PQNode(T data, int insertionOrder) {
            this.data = data;
            this.insertionOrder = insertionOrder;
        }
    }

    public static void task3_pqImplementations() {
        System.out.println("--- Implementing Stack (LIFO) via PriorityQueue ---");
        
        PriorityQueue<PQNode<String>> pqStack = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.insertionOrder, a.insertionOrder)
        );

        int order = 0;
        pqStack.add(new PQNode<>("First", order++));
        pqStack.add(new PQNode<>("Second", order++));
        pqStack.add(new PQNode<>("Third", order++));

        while (!pqStack.isEmpty()) {
            System.out.println("Popped: " + pqStack.poll().data);
        }

        System.out.println("--- Implementing Queue (FIFO) via PriorityQueue ---");

        PriorityQueue<PQNode<String>> pqQueue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.insertionOrder, b.insertionOrder)
        );

        order = 0;
        pqQueue.add(new PQNode<>("First", order++));
        pqQueue.add(new PQNode<>("Second", order++));
        pqQueue.add(new PQNode<>("Third", order++));

        while (!pqQueue.isEmpty()) {
            System.out.println("Dequeued: " + pqQueue.poll().data);
        }
    }

    static class Student {
        String name;
        String major;

        public Student(String name, String major) {
            this.name = name;
            this.major = major;
        }

        @Override
        public String toString() {
            return "[Name: " + name + ", Major: " + major + "]";
        }
    }

    public static void task4_studentMap() {
        TreeMap<Integer, Student> studentMap = new TreeMap<>();

        studentMap.put(103, new Student("Alice", "Computer Science"));
        studentMap.put(101, new Student("Bob", "Mathematics")); 
        studentMap.put(102, new Student("Charlie", "Physics"));

        System.out.println("Student Directory (Sorted by ID):");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void task5_linkedListEquality() {
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> list3 = new LinkedList<>(Arrays.asList("A", "B", "D"));

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);

        System.out.println("Is List 1 equal to List 2? " + areLinkedListsEqual(list1, list2));
        System.out.println("Is List 1 equal to List 3? " + areLinkedListsEqual(list1, list3));
    }

    public static <T> boolean areLinkedListsEqual(LinkedList<T> l1, LinkedList<T> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }

        Iterator<T> it1 = l1.iterator();
        Iterator<T> it2 = l2.iterator();

        while (it1.hasNext() && it2.hasNext()) {
            T val1 = it1.next();
            T val2 = it2.next();

            if (!Objects.equals(val1, val2)) {
                return false;
            }
        }
        return true;
    }

    public static void task6_employeeMap() {
        HashMap<String, String> employeeDeptMap = new HashMap<>();

        employeeDeptMap.put("E001", "HR");
        employeeDeptMap.put("E005", "IT");
        employeeDeptMap.put("E002", "Finance");
        employeeDeptMap.put("E010", "Marketing");

        System.out.println("Employee Department Map:");
        employeeDeptMap.forEach((id, dept) -> {
            System.out.println("Emp ID: " + id + ", Dept: " + dept);
        });
        
        String searchId = "E005";
        if(employeeDeptMap.containsKey(searchId)) {
             System.out.println("\nLooking up " + searchId + ": Works in " + employeeDeptMap.get(searchId));
        }
    }
}
