import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner leitura = new Scanner(System.in);
        String cep;
        boolean permanecerMenu= true;
        while(permanecerMenu){
            System.out.println("1- Pesquisar localidade por cep");
            System.out.println("2- Visualizar as pesquisas feitas");
            System.out.println("0- Sair");
            System.out.print("escolher uma opcão ");
            opcao = leitura.nextInt();
            switch (opcao){
                case 1:
                    leitura.nextLine();
                    System.out.println("PESQUISAR A LOCALIDADE POR CEP");
                    System.out.print("Digite o seu cep ");
                    cep = leitura.nextLine();

                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 0:
                    System.out.println("0");
                    permanecerMenu=false;
                    break;
                default:
                    System.out.println("opção errada tente novamente");
            }
        }

    }
}