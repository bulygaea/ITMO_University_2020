import errors.IncorrectMainHeroNameException;

public class Man {
    private String name;

    /*@Override
    public String toString() {
        return "Hello, " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return Objects.equals(name, man.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name+"5");
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Создание и реализация локального класса
    public void say(String s) {
        class TextSaying {
            public final String t = getName() + " говорит: \"" + s + "\"";
        }

        System.out.println(new TextSaying().t);
    }
}