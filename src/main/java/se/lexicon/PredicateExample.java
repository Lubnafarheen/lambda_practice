package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateExample {
    static List<Car> carList = new ArrayList<>();

    public static List<Car> findBy(Predicate<Car> parameter) {
        List<Car> temp = new ArrayList<>();
        for (Car element : carList) {
            if (parameter.test(element)) {
                temp.add(element);
            }
        }
        return temp;
    }

    public static Car findOne(Predicate<Car> parameter) {
        for (Car element : carList) {
            if (parameter.test(element)) {
                return element;
            }
        }
        return null;
    }

    public static String map(Predicate<Car> parameter, Function<Car, String>convert){
        return convert.apply(findOne(parameter));
    }

    public static void main(String[] args) {
        Car bmw = new Car("BMW", 56000);
        Car polestar = new Car("Polestar", 76900);
        carList.add(bmw);
        carList.add(polestar);
        List<Car> modelInfo = findBy(car -> car.getModel().equals("BMW"));
        System.out.println(modelInfo);
        List<Car> priceInfo = findBy(car -> car.getPrice() > 70000);
        System.out.println(priceInfo);
        Car result =findOne(car -> car.getPrice()<100000);
        System.out.println(result);
    }
}

class Car {
    private final String model;
    private final double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
