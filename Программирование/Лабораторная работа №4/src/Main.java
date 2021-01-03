import errors.IncorrectNumberOfBabysittersException;

public class Main {

    public static void main(String[] args) {
        Shorties.MainHero pulka = new Shorties.MainHero();  // Создание экземпляра статического вложенного класса
        pulka.setName("Пулька");
        Doctor medunica = new Doctor();
        medunica.setName("Медуница");
        Babysitter[] babysitters = new Babysitter[3];
        for (int i = 0; i < babysitters.length; i++) {
            babysitters[i] = new Babysitter();
            babysitters[i].setName(Integer.toString(i+1));
        }
        Shorties friend1 = new Shorties();
        friend1.setName("Друг 1");
        Shorties friend2 = new Shorties();
        friend2.setName("Друг 2");

        Adventure.Time time = new Adventure().new Time();  // Создание экземпляра нестатического вложенного класса

        // Создание и реализация анонимного класса
        Adventure end = new Adventure() {
            public void go() {
                System.out.println("\n\tКОНЕЦ!");
            }
        };

        try {
            Adventure life = new Adventure(friend1, friend2, medunica, pulka, babysitters, time);

            life.go();

            // Использование анонимного класса
            end.go();

        } catch (IncorrectNumberOfBabysittersException e) {
            System.err.println("Вы создали более 3-х нянечек - " + e.getActualNumber());
        }
    }
}
