
import java.util.UUID;

public final class Conta {

    /**
     * Classe que representa um cliente associado a uma conta bancária.
     */
    public static class Cliente {

        private String nome;
        private boolean ativo;

        /**
         * Construtor da classe Cliente.
         *
         * @param nome Nome do cliente.
         */
        public Cliente(String nome) {
            this.nome = nome;
            this.ativo = true;
        }

        /**
         * Obtém o nome do cliente.
         *
         * @return Nome do cliente.
         */
        public String getNome() {
            return nome;
        }

        /**
         * Define o nome do cliente.
         *
         * @param nome Nome do cliente.
         */
        public void setNome(String nome) {
            this.nome = nome;
        }

        /**
         * Verifica se o cliente está ativo.
         *
         * @return {@code true} se o cliente estiver ativo, caso contrário
         * {@code false}.
         */
        public boolean getAtivo() {
            return ativo;
        }

        /**
         * Define o status ativo do cliente.
         *
         * @param ativo {@code true} para ativar o cliente, {@code false} para
         * desativar.
         */
        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }
    }

    private String numero;
    private String agencia;
    private Cliente cliente;
    private double saldo;

    /**
     * Construtor da classe Conta.
     *
     * @param numero Número da conta.
     * @param agencia Número da agência.
     * @param cliente Cliente associado à conta.
     */
    public Conta(String numero, String agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = 450.0;
        this.cliente = cliente;
    }

    /**
     * Obtém o número da conta.
     *
     * @return Número da conta.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o número da conta.
     *
     * @param numero Número da conta.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtém o número da agência.
     *
     * @return Número da agência.
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * Define o número da agência.
     *
     * @param agencia Número da agência.
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * Obtém o cliente associado à conta.
     *
     * @return Cliente associado à conta.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o cliente associado à conta.
     *
     * @param cliente Cliente associado à conta.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtém o saldo da conta.
     *
     * @return Saldo da conta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Define o saldo da conta.
     *
     * @param saldo Saldo da conta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private boolean validValor(double valor) {
        return valor > 0;
    }

    private boolean hasSaldo(double valor) {
        return saldo >= valor;
    }

    /**
     * Deposita um valor na conta.
     *
     * @param valor Valor a ser depositado.
     */
    public void depositar(double valor) {
        if (!validValor(valor)) {
            System.out.println("Valor de depósito inválido.");
            return;
        }

        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    /**
     * Realiza um saque na conta.
     *
     * @param valor Valor a ser sacado.
     */
    public void sacar(double valor) {
        if (!validValor(valor)) {
            System.out.println("Valor inválido para saque.");
        } else if (!hasSaldo(valor)) {
            System.out.println("Saldo insuficiente para saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    /**
     * Gera uma cobrança Pix com um valor especificado.
     *
     * @param valor Valor da cobrança Pix.
     */
    public void pix(double valor) {
        if (!validValor(valor)) {
            System.out.println("Valor inválido para cobrança Pix.");
            return;
        }

        String chavePix = UUID.randomUUID().toString();
        System.out.println("Cobrança Pix gerada com sucesso!");
        System.out.println("Valor: R$" + valor);
        System.out.println("Chave Pix: " + chavePix);
    }
}