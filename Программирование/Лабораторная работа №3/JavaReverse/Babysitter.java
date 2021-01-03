public class Babysitter extends Man implements Babysitable {
    private States state;

    {
        setState(States.NOTREAD);
    }

    @Override
    public void obey(String requirements) {
        System.out.printf("Нянька %s выполняла требование \"%s\"\n",
                getName(),
                requirements);
    }

    public void watch(Man[] watchee) {
        for (Man m : watchee)
            System.out.printf("Нянька %s наблюдает за \"%s\"\n",
                    getName(),
                    m.getName());
    }


    public void setState(States s) {
        state = s;
    }

    public States getState() {
        return state;
    }

}