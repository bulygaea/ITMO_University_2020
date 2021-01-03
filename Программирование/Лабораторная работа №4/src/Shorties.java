import errors.IncorrectMainHeroNameException;

public class Shorties extends Man {

    public static class MainHero extends Shorties implements Moodable {
        private States state;

        public void giveRequiments(Executorable e, String s) {
            e.obey(s);
        }

        public void calm() {
            if (getState() == States.CALM) return;
            setState(States.CALM);
            System.out.println(getName() + " успокоился");
        }

        public void angry() {
            if (getState() == States.CALM) {
                setState(States.ANGRY);
                System.out.println(getName() + " разолился");
            }
        }

        @Override
        public void setState(States s) {
            state = s;
        }

        @Override
        public States getState() {
            return state;
        }

        public void visit(Man m) {
            if (m == null) {
                setState(States.NOTVISITED);
                System.out.println(getName() + " никто не навестил ");
                angry();
            } else {
                setState(States.VISITED);
                System.out.println(getName() + " навестил " + m.getName());
            }

        }

        @Override
        public void setName(String name) {
            if (!name.equals("Пулька"))
                throw new IncorrectMainHeroNameException(name);
            super.setName(name);
        }
    }

}