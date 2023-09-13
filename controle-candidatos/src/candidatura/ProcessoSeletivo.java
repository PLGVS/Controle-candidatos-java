package candidatura;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo{
    public static void main(String[] args) {
        String [] candidatosContratados = new String[5];
        System.out.println("---------- Processo seletivo ----------");
        selecaoCandidatos(candidatosContratados);
        System.out.println("---------- Ligando para os candidatos ----------");
        ligarParaCandidatos(candidatosContratados);
    }

    static void selecaoCandidatos(String[] candidatosContratados){
        String [] candidatos = {"Felipe","Márcia","Julia","Paulo","Augusto","Mônica","Fabrício","Mirela","Daniela","Jorge"};     
        int i = 0;
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou um salário no valor de R$" + salarioPretendido);

            if (salarioBase >= salarioPretendido && i < 5){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!\n");
                candidatosContratados[i] = candidato;
                candidatosSelecionados++;
                i++;
            }
            else{
                System.out.println("O candidato " + candidato + " não foi selecionado para a vaga!\n");
            }

            candidatoAtual++;
        }

        System.out.println("Candidatos contratados: " + Arrays.toString(candidatosContratados));
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"Felipe","Márcia","Julia","Paulo","Augusto"};
        System.out.println("Candidatos selecionados: ");

        for (String candidato : candidatos){
            System.out.println("Os candidatos selecionado foram: " + candidato);
        }
        }

    static void ligarParaCandidatos(String[] candidatosContratados){
        boolean atendeu = false;
        for (String candidato : candidatosContratados){
            int ligacoes = 1;
            if (candidato == null){
                break;
            }
            while (ligacoes <= 3){
                atendeu = new Random().nextInt(3) == 1;
                if (atendeu == true){
                    System.out.println("Conseguimos contato com " + candidato + " após " + ligacoes + " tentativas");
                    break;
                }
                else if (ligacoes == 3 && atendeu == false){
                    System.out.println("Não conseguimos contato com " + candidato);
                }
                ligacoes++;
            }
        }
    }
}
