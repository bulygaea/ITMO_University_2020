public class Doctor extends Man implements Executorable {

    public void obey(String requirements) {
        System.out.printf("Медуница выполняла требование \"%s\"\n",
                requirements);
    }
}