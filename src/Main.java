import Estruturas.lukoki.ao.Consumo;
import Estruturas.lukoki.ao.Endereco;
import Estruturas.lukoki.ao.PegarEndecoViaApi;
import Excessoes.erroDeCoonsumo;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner leitura = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
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
                    System.out.print("Digite o seu cep sem o simbolo de traço ");
                    cep = leitura.nextLine();
                    String link = "https://viacep.com.br/ws/"+cep+"/json/";
                    Consumo consumo = new Consumo();
                    try {
                        String response = consumo.consumindoApi(link);
                        PegarEndecoViaApi pegarEndecoViaApi = consumo.converterEmGson(response);
                        Endereco meuEndereco = new Endereco(pegarEndecoViaApi);
                        enderecos.add(meuEndereco);
                        FileWriter escrever = new FileWriter("endereco.json");
                        Gson gson = new Gson();
                        escrever.write(gson.toJson(enderecos));
                        escrever.close();
                    }catch (erroDeCoonsumo e){
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
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