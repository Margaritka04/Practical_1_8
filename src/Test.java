import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Car> list = new ArrayList<>();

    public static void main(String[] args) {
        Test test = new Test();
        list.add(new Car("Volvo s90", 2015, "x001xx"));
        list.add(new Car("Lada Vesta", 2020, "x002xx"));
        list.add(new Car("Kia Rio", 2012, "x003xx"));
        while (true){
            System.out.println("Введите 1, если хотите добавить новый автомобиль, введите 2, если хотите удалить автомобиль по его серийному номеру, введите 3, если хотите удалить весь список автомобилей, введите 4, если хотите закончить работу: ");
            switch (scanner.nextLine()) {
                case ("1"):
                    test.newCar();
                    test.showList();
                    break;
                case ("2"):
                    test.deleteCar();
                    test.showList();
                    break;
                case ("3"):
                    test.deleteAll();
                    break;
                case ("4"):
                    return;
            }
        }
    }
    public void newCar (){
        Iterator<Car> iterator = list.iterator();
        System.out.println("Введите модель автомобиля: ");
        String model = scanner.nextLine();
        System.out.println("Введите год выпуска автомобиля: ");
        String year = scanner.nextLine();
        System.out.println("Введите серийный номер автомобиля: ");
        String number = scanner.nextLine();
        while (iterator.hasNext()) {
            Car c = iterator.next();
            if (c.getNumber().compareTo(number) == 0) {
                System.out.println("Такой серийный номер уже существует, введите другой");
                number = scanner.nextLine();
            }
        }

        list.add(new Car(model, Integer.parseInt(year), number));
    }

    public void deleteCar (){
        Iterator<Car> iterator = list.iterator();
        System.out.println("ВВедите серийный номер автомибиля, который хотите удалить: ");
        String number = scanner.nextLine();
        while (iterator.hasNext()) {
            Car c = iterator.next();
            if (c.getNumber().equals(number)) {
                iterator.remove();
            }
        }
    }

    public void deleteAll (){
        list.clear();
    }
    public void showList(){
        for (Car c: list){
            System.out.println(c.getModel() + ", " + c.getYear() + ", " + c.getNumber());
        }
    }
}
