import java.util.ArrayList;
import java.util.List;

public class Costumer extends UserBase {

    private static int age;
    private static float tall;
    private static float weight;

    private static List<Exercises> myExercises;
    private Coach myCoach;

    Costumer(String name, String surname, String mail, String password, Coach coach, int age, float tall,
            float weight) {
        super(name, surname, mail, password);
        this.myCoach = coach;
        this.age = age;
        this.tall = tall;
        this.weight = weight;
        myExercises = new ArrayList<>();
    }
    public static class CostumerOperations{
        public int getAge() {
            return age;
        }
        public float getTall() {
            return tall;
        }

        public float getWeight() {
            return weight;
        }

        public static List<Exercises> getExercises() {
            return myExercises;
        }

    }
    public static List<Exercises> getExercises() {
        return myExercises;
    }

    public void PrintCustomerInfo() {
        CostumerOperations costumerOperations = new CostumerOperations();
        System.out.println("Customer Information:");
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Mail: " + getMail());
        System.out.println("Age: " + costumerOperations.getAge() );
        System.out.println("Height: " + costumerOperations.getTall());
        System.out.println("Weight: " + costumerOperations.getWeight());
    }

    public void ListMyExercises() {
        if (!(myExercises.isEmpty())){
            for (Exercises exercises : myExercises) {
                System.out.println("Egzersiz adi:" + exercises.getExercisesName());
                System.out.println("Egzersiz set sayisi:" + exercises.getExercisesSetCount());
                System.out.println("Egzersiz tekrar sayisi:" + exercises.getExercisesrepeadCount());
                System.out.println("Egzersiz agirligi sayisi:" + exercises.getExercisesweight());
            }
        }
        else {
            System.out.println("Egzersiziniz yok.");
        }
    }
}
