
import java.util.Scanner;

public class App {

    private static final double CHEQUE_ESPECIAL = 1000.0;
    private static final Scanner scanner = new Scanner(System.in);

    private static String validarEntrada(String mensagem, int tamanho) {
        String entrada;
        do {
            System.out.print(mensagem);
            entrada = scanner.nextLine();

            if (entrada.length() == tamanho && entrada.matches("\\d+")) {
                return entrada;
            }

            System.out.println("Entrada inválida. Deve conter exatamente " + tamanho + " dígitos.");
        } while (true);
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema bancário!");

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        String agencia = validarEntrada("Digite o número da agência (4 dígitos): ", 4);
        String numeroConta = validarEntrada("Digite o número da conta (6 dígitos): ", 6);

        Conta.Cliente cliente = new Conta.Cliente(nomeCliente);
        Conta conta = new Conta(numeroConta, agencia, cliente);

        System.out.println("\nInformações da Conta:");
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Conta: " + conta.getNumero());
        System.out.println("Cliente: " + conta.getCliente().getNome());
        System.out.println("Saldo: " + conta.getSaldo());

        Menu menu = new Menu();
        menu.addOption("Depositar", () -> {
            System.out.println("Digite o valor a ser depositado: ");
            double valorDeposito = scanner.nextDouble();
            scanner.nextLine();
            conta.depositar(valorDeposito);
        });
        menu.addOption("Sacar", () -> {
            System.out.println("Digite o valor que deseja sacar: ");
            double valorSaque = scanner.nextDouble();
            scanner.nextLine();
            conta.sacar(valorSaque);
        });
        menu.addOption("Consultar saldo", () -> System.out.println("Seu saldo é: " + conta.getSaldo()));
        menu.addOption("Cheque Especial", () -> {
            System.out.println("Seu saldo é: " + conta.getSaldo());
            System.out.println("Seu limite de cheque especial é: " + CHEQUE_ESPECIAL);
        });
        menu.addOption("Boleto", ()
                -> System.out.println("Funcionalidade de Boleto ainda não implementada.")
        );
        menu.addOption("Pix de recebimento", () -> {
            System.out.println("Digite o valor a ser cobrado: ");
            double valorPix = scanner.nextDouble();
            scanner.nextLine();
            conta.pix(valorPix);
        });
        menu.addOption("Sair", menu::exit);

        menu.show();
    }
}
