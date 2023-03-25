import java.awt.print.Book;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));

        List<Integer> temp = list.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(temp);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "nitin", "IT"));
        employees.add(new Employee(2, "nitika", "Finance"));
        employees.add(new Employee(3, "Alok", "Finance"));

        Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting()));

        map.forEach((k, v) -> {
            System.out.println("Department Name = " + k + " has employees as = " + v);
        });

        int[][] array = new int[][]{{1, 2}, {3, 4}, {5, 6}};

        // Java 8
        int[] arr2 = Stream.of(array).filter(x->x[0]>x[1]).flatMapToInt(IntStream::of).toArray();

        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list1 = new ArrayList<>();
        list1.add(o1);
        list1.add(o2);

        Set<String> filteredBooks = list1.stream()
                .map(Developer::getBook)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        System.out.println(filteredBooks);

        String item =  filteredBooks.stream().filter(x->x.contains("Edition")).findFirst().get();
        System.out.println(item);

        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 77, 6, 5));
        int num = list3.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(num);

    }
}

class Employee {
    public int id;
    public String name;
    public String departmentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee(int id, String name, String departmentName) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
    }

}

class Developer {

    private Integer id;
    private String name;
    private Set<String> book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
}