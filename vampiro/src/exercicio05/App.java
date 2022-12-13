package exercicio05;
public class App {
    public static void main(String[] args) throws Exception {
        Vampiro numVamp = new Vampiro();
        for (int numeroVampiro = 1000; numeroVampiro < 10000; numeroVampiro++) {
            if (numVamp.numeroVampiro(numeroVampiro)){
                System.out.println(numVamp.getNumVampiro());
            }
        }
    }
}
