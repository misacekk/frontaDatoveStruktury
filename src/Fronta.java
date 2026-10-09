public class Fronta {
    private final int kapacita = 20;
    private Zak[] fronta = new Zak[kapacita];
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public void pridatZaka(Zak zak) {
        if (size >= kapacita) {
            System.out.println("Fronta je plná. Nelze přidat žáka: "+zak.getCeleJmeno());
            return;
        }
        rear = (rear + 1) % kapacita;
        fronta[rear] = zak;
        size++;
        System.out.println("Žák " + zak.getCeleJmeno() + " se zařadil do fronty.");
    }

    public Zak obslouzitZaka() {
        if (size == 0) {
            System.out.println("Fronta je prázdná.");
            return null;
        }
        Zak obslouzeny = fronta[front];
        fronta[front] = null;
        front = (front + 1) % kapacita;
        size--;

        System.out.println("Obsloužen žák: " + obslouzeny.getCeleJmeno());
        return obslouzeny;
    }

    public void vypisFrontu() {
        if (size == 0) {
            System.out.println("Fronta je prázdná.");
            return;
        }

        System.out.println("Žáci ve frontě (" + size + "/" + kapacita + ")");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % kapacita;
            System.out.println((i + 1) + ". " + fronta[index].getCeleJmeno());
        }
    }

    public Zak nakouknoutNaDalsiho() {
        if (size == 0) {
            System.out.println("Fronta je prázdná.");
            return null;
        }
        Zak dalsiNaRade = fronta[front];

        System.out.println("Nakouknutí na dalšího: " + dalsiNaRade.getCeleJmeno() + " Chod: "+dalsiNaRade.getCisloChodu());
        return dalsiNaRade;
    }

    public int getKapacita() {
        return kapacita;
    }

    public int getSize() {
        return size;
    }
}