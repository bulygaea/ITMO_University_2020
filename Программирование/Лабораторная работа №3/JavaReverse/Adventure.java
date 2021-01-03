public class Adventure {

    private Shorties friend1;
    private Shorties friend2;
    private Doctor medunica;
    private MainHero pulka;
    private Babysitter babysitter1;
    private Babysitter babysitter2;
    private Babysitter babysitter3;

    public Adventure(Shorties friend1, Shorties friend2, Doctor medunica, MainHero pulka, Babysitter babysitter1, Babysitter babysitter2, Babysitter babysitter3) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.medunica = medunica;
        this.pulka = pulka;
        this.babysitter1 = babysitter1;
        this.babysitter2 = babysitter2;
        this.babysitter3 = babysitter3;
    }

    public void go() {
        while (true) {
            pulka.giveRequiments(medunica, "искать по городу Бульку");
            pulka.calm();

            babysitter2.watch(new Shorties[]{friend1, friend2});
            babysitter2.say("Малыши в порядке!");

            if (babysitter3.getState() == States.NOTREAD) {
                pulka.giveRequiments(babysitter3, "читать сказки");
                babysitter3.setState(States.READ);
            }

            if (babysitter3.getState() == States.READ) {
                pulka.say("Сказка не интересная!");
                pulka.say("Читайте другую сказку!!!");
            }


            pulka.visit(null);
            if (pulka.getState() == States.VISITED | pulka.getState() == States.NOTVISITED) {
                pulka.setState(States.ANGRY);
            }

            pulka.visit(friend1);
            if (pulka.getState() == States.VISITED) {
                pulka.say("Вы мешаете мне слушать сказки!!!");
                pulka.setState(States.ANGRY);
            }

            if (pulka.getState() == States.ANGRY) {
                medunica.say("Пулька стал в двадцать раз хуже Ворчуна и Пилюлькина, вместе взятых..");
                break;
            }
        }
    }
}