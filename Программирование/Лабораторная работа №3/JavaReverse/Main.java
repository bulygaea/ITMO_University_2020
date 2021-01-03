public class Main {

    public static void main(String[] args) {
        MainHero pulka = new MainHero();
        pulka.setName("Пулька");
        Doctor medunica = new Doctor();
        medunica.setName("Медуница");
        Babysitter babysitter1 = new Babysitter();
        babysitter1.setName("1");
        Babysitter babysitter2 = new Babysitter();
        babysitter2.setName("2");
        Babysitter babysitter3 = new Babysitter();
        babysitter3.setName("3");
        Shorties friend1 = new Shorties();
        friend1.setName("Друг 1");
        Shorties friend2 = new Shorties();
        friend2.setName("Друг 2");

        Adventure life = new Adventure(friend1, friend2, medunica, pulka, babysitter1, babysitter2, babysitter3);
        life.go();
    }
}
