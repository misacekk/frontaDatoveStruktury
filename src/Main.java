public class Main {
    public static void main(String[] args) {
        Fronta fronta = new Fronta();

        System.out.println();
        fronta.pridatZaka(new Zak("Jakub", "Eismann", 1));
        fronta.pridatZaka(new Zak("Ondra", "Musil", 2));
        fronta.pridatZaka(new Zak("Daniel", "Fuchs", 3));
        System.out.println();
        fronta.vypisFrontu();
        System.out.println();

        fronta.obslouzitZaka();
        System.out.println();
        fronta.vypisFrontu();
        System.out.println();

        for (int i = 1; i <= 18; i++) {
            fronta.pridatZaka(new Zak("Žák " + i, "XXX", 1));
        }
        System.out.println();
        fronta.vypisFrontu();
        System.out.println();

        fronta.nakouknoutNaDalsiho();
        System.out.println();

        fronta.vypisFrontu();
        System.out.println();

        fronta.nakouknoutDoFronty();
        System.out.println();

        fronta.pridatZaka(new Zak("Štěpán", "Andrlík", 3));
        System.out.println();
    }
}