/*
 * Classe que representa uma tarefa.
 * Importa duas classes da biblioteca padrão Java:
 * - ArrayList: estrutura de Lista dinâmica para armazenar tarefas
 * - Scanner: para ler a entrada do usuário pelo teclado
 *
 *
 * */

import java.util.ArrayList;
import java.util.Scanner;


// Define uma classe que representa uma tarefa
class Tarefa {
    // Atributos (variáveis internas da classe)
    int id; // Identificador único da tarefa
    String descricao; // Texto que descreve a tarefa
    boolean concluida; // Se a tarefa foi concluida (true ou false)

    // Construtor: cria uma nova tarefa com ID e descrição
    public Tarefa (int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = false;// Toda nova tarefa começa como "nãoconcluida"
    }

    // Método que define como a tarefa será exibida como texto
    public String toString() {
        return id + ". " + descricao + (concluida ? " [Concluída]" : " [Pendente]");

    }
}

// Classe principal que executa o programa
public class ToDoApp{
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);
        // Cria uma lista que armazenará todas as tarefas
        ArrayList<Tarefa> list = new ArrayList<>();
        // Variável que controla o próximo ID a ser atribuído a uma tarefa nova
        int proximoId = 1;
        // Variável de controle do laço principal (enquanto true, o programa roda)
        boolean rodando = true;

        // Início do laço principal que mostra o menu até o usuário decidir sair
        while (rodando) {
            System.out.println("\n========= MENU TO-DO =====");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Lista tarefas");
            System.out.println("3 - Marcar como concluída");
            System.out.println("4 - Remover tarefa ");
            System.out.println("5 - Sair");
            // Pede a escolha do usuário e lê um número inteiro
            System.out.println("Escolha uma opção");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer (evita bug de pulo Leitura)

            // Estrutura switch que decide qual ação executar com base na opção
            switch (opcao){
                case 1:
                    // Adiciona uma nova tarefa
                    System.out.println("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine(); // Lê a descrição
                    Tarefa nova = new Tarefa(proximoId++, descricao);// Cria nova tarefa com ID automático
                    list.add(nova);// Adiciona à lista
                    System.out.println("Tarefas adicionada.");
                    break;

                case 2:
                    // Lista todas as tarefas na tela
                    System.out.println("\nTarefas: ");
                    for (Tarefa t : list) { // Para cada tarefa na lista
                        System.out.print(t); // Imprime a tarefa (usa toString)
                    }
                    break;

                case 3:
                // Marca uma tarefa como concluída
                System.out.print("Digite o ID da tarefa a concluir: ");
                int idConcluir = scanner.nextInt(); // Lê o ID
                    for (Tarefa t : list) {//Procura a tarefa com esse ID
                        if (t.id == idConcluir) {
                            t.concluida = true; // Marca como concluída
                            System.out.println("Tarefa marcada como concluida");
                            break; // Sai do loop após marcar
                        }
                    }
                    break;

                case 4:
                    // Remover uma tarefa da lista
                    System.out.println("Digite o ID da tarefa a remover: ");
                    int idRemover = scanner.nextInt();
                    list.removeIf(t -> t.id == idRemover);
                    System.out.println("Tarefa removida.");
                    break;

                case 5:
                    // Sai do programa
                    rodando = false; // Altera o controle do laço
                    System.out.println("Saindo...");
                    break;

                default:
                    // Caso o usuário digite uma o´ção inválida
                    System.out.println("Opção invalida.");

            }


        }
        scanner.close();
    }

}