import br.com.cit.dojo.diamond.DiamondBuilder;

public class Executor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DiamondBuilder builder = new DiamondBuilder();
        
        System.out.println(builder.build('A') + String.format("%n%n"));
        System.out.println(builder.build('B') + String.format("%n%n"));
        System.out.println(builder.build('C') + String.format("%n%n"));
        System.out.println(builder.build('D') + String.format("%n%n"));
        System.out.println(builder.build('E') + String.format("%n%n"));
        System.out.println(builder.build('J') + String.format("%n%n"));
        System.out.println(builder.build('Z') + String.format("%n%n"));

    }

}
