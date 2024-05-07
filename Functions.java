import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions {
    public List<Costumer> allCostumers;
    public List<Coach> allCoachs;
    public List<Exercises> allExercises;

    Functions() {
        allCostumers = new ArrayList<>();
        allCoachs = new ArrayList<>();
        allExercises = new ArrayList<>();
        BenchPress benchPress = new BenchPress(0, 0, 0);
        Deadlifts deadlifts = new Deadlifts(0, 0, 0);
        Squats squats = new Squats(0, 0, 0);
        Weightlifting weightlifting = new Weightlifting(0, 0, 0);
        allExercises.add(benchPress);
        allExercises.add(deadlifts);
        allExercises.add(squats);
        allExercises.add(weightlifting);
    }

    public void Register(Scanner scanner, List<Coach> allCoachs, List<Costumer> allCostumers) {
        System.out.print("Ad: ");
        String name = scanner.next();
        System.out.print("Soyad: ");
        String surname = scanner.next();
        System.out.print("Mail: ");
        String mail = scanner.next();
        System.out.print("Sifre: ");
        String password = scanner.next();
        System.out.print("Yas: ");
        int age = scanner.nextInt();
        System.out.print("Boy: ");
        float tall = scanner.nextFloat();
        System.out.print("Kilo: ");
        float weight = scanner.nextFloat();

        Coach selectedCoach = SelectByIndex(scanner, allCoachs, allCoachs.get(0));

        Costumer costumer = new Costumer(name, surname, mail, password, selectedCoach, age, tall, weight);
        allCostumers.add(costumer);

        selectedCoach.getCostumers().add(costumer);
        System.out.println("Kullanici basariyla olusturuldu.");
    }

    public Coach SelectByIndex(Scanner scanner, List<Coach> allCoachs, Coach coach) {
        while (coach != null) {
            ListAllCoach(allCoachs);
            System.out.print("Koc sec (Index): ");
            int selectedCoachIndex = scanner.nextInt();

            if (selectedCoachIndex >= 0 && selectedCoachIndex < allCoachs.size()) {
                return allCoachs.get(selectedCoachIndex);
            } else {
                System.out.println("Gecersiz index. Lütfen dogru bir index girin.");
            }
        }
        return null;
    }

    public Costumer SelectByIndex(Scanner scanner, List<Costumer> allCostumers, Costumer costumer) {
        while (costumer != null) {
            ListAllCostumer(allCostumers);
            System.out.print("Musteri sec (Index): ");
            int selectedCostumerIndex = scanner.nextInt();

            if (selectedCostumerIndex >= 0 && selectedCostumerIndex < allCoachs.size()) {
                return allCostumers.get(selectedCostumerIndex);
            } else {
                System.out.println("Gecersiz index. Lütfen dogru bir index girin.");
            }
        }
        return null;
    }

    public Exercises SelectByIndex(Scanner scanner, List<Exercises> allExercises, Exercises exercises) {
        while (exercises != null) {
            ListAllExercises(allExercises);
            System.out.print("Egzersiz sec (Index): ");
            int selectedExercisesIndex = scanner.nextInt();

            if (selectedExercisesIndex >= 0 && selectedExercisesIndex < allCoachs.size()) {
                return allExercises.get(selectedExercisesIndex);
            } else {
                System.out.println("Gecersiz index. Lütfen dogru bir index girin.");
            }
        }
        return null;
    }

    public void ListAllCoach(List<Coach> allCoachs) {
        for (Coach coach : allCoachs) {
            System.out.println("Koc listesi:" + coach.getName());
        }
    }

    public void ListAllCostumer(List<Costumer> allCostumers) {
        for (Costumer costumer : allCostumers) {
            System.out.println("Musteri listesi:" + costumer.getName());
        }
    }

    public void ListAllExercises(List<Exercises> allExercises) {
        for (Exercises exercises : allExercises) {
            System.out.println("Musteri listesi:" + exercises.getExercisesName());
        }
    }

    public Coach LogInCoach(String mail, String password, List<Coach> allCoachs) {

        for (Coach coach : allCoachs) {
            if (coach.getMail().equals(mail) && coach.getPassword().equals(password)) {
                System.out.println("Giriş başarılı! Hoş geldiniz, " + coach.getName());
                return coach;
            }
        }
        return null;
    }

    public Costumer LogInCostumer(String mail, String password, List<Costumer> allCostumers) {

        for (Costumer costumer : allCostumers) {
            if (costumer.getMail().equals(mail) && costumer.getPassword().equals(password)) {
                // Kullanıcı doğrulandı
                System.out.println("Giriş başarılı! Hoş geldiniz, " + costumer.getName());
                return costumer;
            }
        }
        return null;
    }

    public UserBase LogInBase(Scanner scanner, List<Costumer> allCostumers, List<Coach> allCoachs) {
        while (true) {
            System.out.print("Mail: ");
            String mail = scanner.next();
            System.out.print("Sifre: ");
            String password = scanner.next();

            Costumer costumer = LogInCostumer(mail,password, allCostumers);

            if (costumer != null) {
                return costumer;
            }
            else {
                Coach coach = LogInCoach(mail, password, allCoachs);
                if (coach != null) {
                    return coach;
                }
            }
            System.out.println("Boyle bir kullanici bulunamadi.");

        }
    }

    public Exercises CreateBenchPress(Scanner scanner) {
        System.out.print("Set sayisi: ");
        int setCount = scanner.nextInt();
        System.out.print("Tekrar sayisi: ");
        int repeadCount = scanner.nextInt();
        System.out.print("Agirlik: ");
        int weight = scanner.nextInt();
        BenchPress benchPress = new BenchPress(repeadCount, setCount, weight);
        return benchPress;
    }

    public Exercises CreateDeadLift(Scanner scanner) {
        System.out.print("Set sayisi: ");
        int setCount = scanner.nextInt();
        System.out.print("Tekrar sayisi: ");
        int repeadCount = scanner.nextInt();
        System.out.print("Agirlik: ");
        int weight = scanner.nextInt();
        Deadlifts benchPress = new Deadlifts(repeadCount, setCount, weight);
        return benchPress;
    }

    public Exercises CreateSquats(Scanner scanner) {
        System.out.print("Set sayisi: ");
        int setCount = scanner.nextInt();
        System.out.print("Tekrar sayisi: ");
        int repeadCount = scanner.nextInt();
        System.out.print("Agirlik: ");
        int weight = scanner.nextInt();
        Squats benchPress = new Squats(repeadCount, setCount, weight);
        return benchPress;
    }

    public Exercises CreateWeightLifting(Scanner scanner) {
        System.out.print("Set sayisi: ");
        int setCount = scanner.nextInt();
        System.out.print("Tekrar sayisi: ");
        int repeadCount = scanner.nextInt();
        System.out.print("Agirlik: ");
        int weight = scanner.nextInt();
        Weightlifting benchPress = new Weightlifting(repeadCount, setCount, weight);
        return benchPress;
    }

    public void CoachOperation(Scanner scanner, Coach coach) {
        boolean isCoachOperationContinue = true;
        while (isCoachOperationContinue) {
            System.out.println(
                    "1- Musteri secim ekranina git\n2- Kendi musterilerimin bilgilerini yazdir\n3-Geri don\n4- Cikis yap");
            int secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    Costumer selectedCostumer = SelectByIndex(scanner, coach.getCostumers(), coach.getCostumers().get(0));
                    if (selectedCostumer != null) {
                        Boolean isExerciseSetContinue = true;
                        while (isExerciseSetContinue) {
                            System.out.println("1- Musteriye egzersiz ekle\n2- Geri don");
                            secim = scanner.nextInt();
                            switch (secim) {
                                case 1:
                                    Exercises selectedExercises = SelectByIndex(scanner, allExercises, allExercises.get(0));
                                    if (selectedExercises != null) {
                                        if (selectedExercises instanceof BenchPress) {
                                            Costumer.CostumerOperations.getExercises().add(CreateBenchPress(scanner));
                                        } else if (selectedExercises instanceof Deadlifts) {
                                            Costumer.CostumerOperations.getExercises().add(CreateDeadLift(scanner));
                                        } else if (selectedExercises instanceof Squats) {
                                            Costumer.CostumerOperations.getExercises().add(CreateSquats(scanner));
                                        } else if (selectedExercises instanceof Weightlifting) {
                                            Costumer.CostumerOperations.getExercises().add(CreateWeightLifting(scanner));
                                        }
                                        break;
                                    }
                                    System.out.println("Boyle bir egzersiz bulunamadi");
                                    break;
                                case 2:
                                    isExerciseSetContinue = false;
                                    break;
                                default:
                                    System.out.println("Gecersiz deger");
                                    break;
                            }
                        }

                    }
                    break;
                case 2:
                    for (Costumer costumer : coach.getCostumers()) {
                        costumer.PrintCustomerInfo();
                        costumer.ListMyExercises();
                    }
                    break;
                case 3:
                    isCoachOperationContinue = false;
                    break;
                case 4:
                    Exit();
                    break;
                default:
                    System.out.println("Gecersiz deger");
                    break;
            }
        }

    }

    public void CostumerOperations(Scanner scanner, Costumer costumer) {
        boolean isCostumerOperationContinue = true;
        while (isCostumerOperationContinue) {
            System.out.println(
                    "1- Bilgilerimi goster\n2- Egzersizlerimi yazdir\n3-Geri don\n4- Cikis yap");
            int secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    costumer.PrintCustomerInfo();
                    break;
                case 2:
                    costumer.ListMyExercises();
                    break;
                case 3:
                    isCostumerOperationContinue = false;
                    break;
                case 4:
                    Exit();
                    break;
                default:
                    System.out.println("Gecersiz deger.");
                    break;
            }
        }
    }

    public void Exit() {
        System.out.println("Cikis yapiliyor...");
        System.exit(0);
    }
}
