import errors.IncorrectNumberOfBabysittersException;

public class Adventure<leg> {
    private int k = 0;

    private Time time;
    private Shorties friend1;
    private Shorties friend2;
    private Doctor medunica;
    private Shorties.MainHero pulka;
    private Babysitter[] babysitters;

    private final Leg leg = new Leg();

    public Adventure() {}

    public Adventure(Shorties friend1, Shorties friend2, Doctor medunica, Shorties.MainHero pulka, Babysitter[] babysitters, Time time) throws IncorrectNumberOfBabysittersException {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.medunica = medunica;
        this.pulka = pulka;
        this.babysitters = babysitters;
        if (babysitters.length != 3)
            throw new IncorrectNumberOfBabysittersException(babysitters.length);
        this.time = time;
    }

    public void go() {
        babysitters[0].setState(States.CALM);
        babysitters[1].setState(States.NOTWATCHING);
        babysitters[2].setState(States.NOTREAD);
        leg.setLegState(LegStates.NOTHURTS);
        while (true) {

            if (k % 8 == 0) {
                time.setTime(Times.MORNING);
                System.out.println("\n\tУТРО");
            } else if (k % 8 == 2) {
                time.setTime(Times.AFTERNOON);
                System.out.println("\n\tДЕНЬ");
            } else if (k % 8 == 3) {
                time.setTime(Times.EVENING);
                System.out.println("\n\tВЕЧЕР");
            } else if (k % 8 == 6) {
                time.setTime(Times.NIGHT);
                System.out.println("\n\tНОЧЬ");
            }

            if (time.getTime() != Times.NIGHT) {
                if (time.getTime() == Times.MORNING) {
                    pulka.giveRequiments(babysitters[0], "искать по городу Бульку");
                    pulka.calm();
                }

                if (time.getTime() == Times.AFTERNOON) {
                    babysitters[0].setState(States.TIRED);
                }

                if (babysitters[0].getState() == States.TIRED) {
                    pulka.say("Где мой Булька?!");
                    pulka.angry();
                    babysitters[0].scream();
                    babysitters[0].setState(States.CALM);
                }

                if ((babysitters[1].getState() == States.NOTWATCHING) & (time.getTime() == Times.MORNING)) {
                    babysitters[1].watch(new Shorties[]{friend1, friend2});
                }

                if ((k % 8 == 0) | (k % 8 == 2) | (k % 8 == 3) | (k % 8 == 6)) {
                    babysitters[1].say("Малыши в порядке!");
                }

                if (babysitters[2].getState() == States.NOTREAD) {
                    pulka.giveRequiments((Executorable) babysitters[2], "читать сказки");
                    babysitters[2].setState(States.READ);
                }

                if (babysitters[2].getState() == States.READ) {
                    pulka.say("Сказка не интересная!");
                    pulka.say("Читайте другую сказку!!!");
                    babysitters[2].setState(States.NOTREAD);
                }


                pulka.visit(null);
                if ((pulka.getState() == States.VISITED) | (pulka.getState() == States.NOTVISITED)) {
                    pulka.setState(States.ANGRY);
                }

                pulka.visit(friend1);
                if (pulka.getState() == States.VISITED) {
                    pulka.say("Вы мешаете мне слушать сказки!!!");
                    pulka.setState(States.ANGRY);
                }

                if (pulka.getState() == States.ANGRY) {
                    medunica.say("Пулька стал в двадцать раз хуже Ворчуна и Пилюлькина, вместе взятых..");
                }

                if ((leg.getLegState() == LegStates.NOTHURTS) & (time.getTime() == Times.AFTERNOON)) {
                    medunica.say("Ты можешь погулять немного");
                }

                if ((leg.getLegState() == LegStates.NOTHURTS) & (time.getTime() == Times.EVENING)) {
                    leg.setLegState(LegStates.HURTS);
                    medunica.say("Возвращайся обратно!");
                    pulka.say("Нет! Не хочу возвращаться!!!");
                }
            } else if (k % 8 == 6) {
                System.out.println("Медуница сидит у постели больного целую ночь, не смыкая глаз");
            }

            if (k > 22) {
                break;
            }
            k++;
        }
    }

    public class Time {
        private Times time;

        public Time() {
        }

        public void setTime(Times s) {
            time = s;
        }

        public Times getTime() {
            return time;
        }

    }
}
