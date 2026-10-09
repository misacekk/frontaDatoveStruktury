import java.util.Scanner;

public class Fronta {
    Scanner sc = new Scanner(System.in);

    private int kapacita = 20;
    private Zak[] fronta = new Zak[kapacita];
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public void zvetsitKapacitu() {
        int novaKapacita = kapacita * 2;
        Zak[] novaFronta = new Zak[novaKapacita];

        for (int i = 0; i < size; i++) {
            novaFronta[i] = fronta[(front + i) % kapacita];
        }

        this.fronta = novaFronta;
        this.kapacita = novaKapacita;
        this.front = 0;
        this.rear = size - 1;

        System.out.println("Kapacita fronty byla navýšena na: " + kapacita);
    }

    public void pridatZaka(Zak zak) {
        if (size >= kapacita) {
            throw new FullFrontaException("Fronta je plná. Nelze přidat žáka: " + zak.getCeleJmeno());
        }
        rear = (rear + 1) % kapacita;
        fronta[rear] = zak;
        size++;
        System.out.println("Žák " + zak.getCeleJmeno() + " se zařadil do fronty.");
    }

    public Zak obslouzitZaka() {
        if (size == 0) {
            throw new EmptyFrontaException("Fronta je prázdná");
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
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        System.out.println("Žáci ve frontě (" + size + "/" + kapacita + ")");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % kapacita;
            System.out.println((i + 1) + ". " + fronta[index].getCeleJmeno());
        }
    }

    public Zak nakouknoutNaDalsiho() {
        if (size == 0) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }
        Zak dalsiNaRade = fronta[front];

        System.out.println("Nakouknutí na dalšího: " + dalsiNaRade.getCeleJmeno() + " Chod: " + dalsiNaRade.getCisloChodu());
        return dalsiNaRade;
    }

    public Zak nakouknoutDoFronty() {
        if (size == 0) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        System.out.println("Zadejte příjmení žáka.");
        String hledanePrijmeni = sc.nextLine();

        for (int i = 0; i < size; i++) {
            int index = (front + i) % kapacita;

            if (hledanePrijmeni.equalsIgnoreCase(fronta[index].getSurname())) {
                System.out.println("Žák s daným příjmením byl nalezen.");
                System.out.println(fronta[index].getCeleJmeno());
                return fronta[index];
            }
        }

        System.out.println("Žák s daným příjmením nebyl nalezen.");
        return null;
    }

    public int getKapacita() {
        return kapacita;
    }

    public int getSize() {
        return size;
    }
}