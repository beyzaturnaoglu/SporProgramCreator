import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Functions programFunction = new Functions();
            Coach coach1 = new Coach("coach1Name", "coach1Surname", "coach1@mail.com", "coach1");
            Coach coach2 = new Coach("coach2Name", "coach2Surname", "coach2@mail.com", "coach2");

            Costumer costumer1 = new Costumer("costumer1Name", "costumer1Surname", "costurmer1@mail.com", "costumer1",
                    coach2, 20, 170, 70);
            Costumer costumer2 = new Costumer("costumer2Name", "costumer2Surname", "costurmer2@mail.com", "costumer2",
                    coach1, 25, 165, 85);
            programFunction.allCostumers.add(costumer1);
            programFunction.allCostumers.add(costumer2);

            coach1.getCostumers().add(costumer2);
            coach2.getCostumers().add(costumer1);

            programFunction.allCoachs.add(coach1);
            programFunction.allCoachs.add(coach2);

            while (true) {
                System.out.println("1- Kayit Ol\n2- Giris Yap\n3- Cikis yap");
                int secim = scanner.nextInt();
                scanner.nextLine(); // Yeni satır karakterini tüket

                switch (secim) {
                    case 1:
                        programFunction.Register(scanner, programFunction.allCoachs, programFunction.allCostumers);
                        break;
                    case 2:
                        UserBase user = programFunction.LogInBase(scanner, programFunction.allCostumers,
                                programFunction.allCoachs);

                        if (user != null) {
                            if (user instanceof Coach) {
                                Coach coach = (Coach) user;
                                programFunction.CoachOperation(scanner, coach);


                            } else if (user instanceof Costumer) {
                                Costumer costumer = (Costumer) user;
                                programFunction.CostumerOperations(scanner, costumer);
                            }
                        }
                        break;
                    case 3:
                        programFunction.Exit();
                        break;
                    default:
                        System.out.println("Gecersiz deger.");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
