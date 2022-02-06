import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  static class Person {

      enum Position {
          ENGINEER, DIRECTOR, MANAGER;
      }
      private String name;
      private int age;
      private Position position;
      private int salary;

      public Person(String name, int age, Position position, int salary) {
          this.name = name;
          this.age = age;
          this.position = position;
          this.salary = salary;
      }
  }
  private static void streamSimpleTask(){
      List<Person> personList = new ArrayList<>(Arrays.asList(
              new Person("Ivan",32,Person.Position.DIRECTOR,1000),
              new Person("Vova", 21,Person.Position.MANAGER, 500),
              new Person("Vasia",35,Person.Position.ENGINEER, 700),
              new Person("Seriy", 39, Person.Position.ENGINEER, 900),
              new Person("Sasha", 37,Person.Position.MANAGER,600)
      ));
      List<String> engineersNames = personList.stream()
              .filter(person -> person.position == Person.Position.ENGINEER)
              .sorted((o1, o2) -> o1.age - o2.age)
              .map((Function<Person, String>) person -> person.name)
              .collect(Collectors.toList());
      System.out.println(engineersNames);
      List<Integer> managersAge = personList.stream()
              .filter(person -> person.position == Person.Position.MANAGER)
              .sorted(((o1, o2) -> o1.age - o2.age))
              .map((Function<Person, Integer>) person -> person.age )
              .collect(Collectors.toList());
      System.out.println("Манагерам "+managersAge+" лет");
  }

    public static void main(String[] args) {
        streamSimpleTask();
    }
}
