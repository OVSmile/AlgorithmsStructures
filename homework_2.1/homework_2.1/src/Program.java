import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {
        LinkedList<Employee> linkedList = new LinkedList<>();
        linkedList.addFirst(new Employee("AAAA", 40));
        linkedList.addFirst(new Employee("BBB", 41));
        linkedList.addFirst(new Employee("CC", 33));
        linkedList.addFirst(new Employee("BBB", 41));
        linkedList.addFirst(new Employee("BBB", 55));
        linkedList.addFirst(new Employee("BBB", 21));
        linkedList.addFirst(new Employee("BBB", 33));
        linkedList.addFirst(new Employee("DDDDD", 24));


        linkedList.contains(new Employee("DDDDD", 24));
        System.out.println(linkedList);
        System.out.println();
        //ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 5, 10, 11));
        //System.out.println(arrayList);

        /*Employee[] array1 = new Employee[] {new Employee("AAAA", 40),
                new Employee("BBB", 41),
                new Employee("CC", 33)};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));*/



        System.out.println();
        linkedList.sort(new EmployeeComparator(SortType.Ascending));
        System.out.println(linkedList);

        System.out.println();
        linkedList.sort(new EmployeeComparator(SortType.Descending));
        System.out.println(linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println();
        System.out.println(linkedList);


    }

}