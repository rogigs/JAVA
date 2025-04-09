import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    private Conta conta;
    private Conta.Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Conta.Cliente("João Silva");
        conta = new Conta("12345-6", "001", cliente);
    }

    @Test
    public void testGetNumero() {
        assertEquals("12345-6", conta.getNumero());
    }

    @Test
    public void testSetNumero() {
        conta.setNumero("54321-0");
        assertEquals("54321-0", conta.getNumero());
    }

    @Test
    public void testGetAgencia() {
        assertEquals("001", conta.getAgencia());
    }

    @Test
    public void testSetAgencia() {
        conta.setAgencia("002");
        assertEquals("002", conta.getAgencia());
    }

    @Test
    public void testGetCliente() {
        assertEquals(cliente, conta.getCliente());
    }

    @Test
    public void testSetCliente() {
        Conta.Cliente novoCliente = new Conta.Cliente("Maria Oliveira");
        conta.setCliente(novoCliente);
        assertEquals(novoCliente, conta.getCliente());
    }

    @Test
    public void testGetSaldo() {
        assertEquals(450.0, conta.getSaldo());
    }

    @Test
    public void testSetSaldo() {
        conta.setSaldo(1000.0);
        assertEquals(1000.0, conta.getSaldo());
    }

    @Test
    public void testDepositarValorValido() {
        conta.depositar(100.0);
        assertEquals(550.0, conta.getSaldo());
    }

    @Test
    public void testDepositarValorInvalido() {
        conta.depositar(-50.0);
        assertEquals(450.0, conta.getSaldo());
    }

    @Test
    public void testSacarValorValido() {
        conta.sacar(100.0);
        assertEquals(350.0, conta.getSaldo());
    }

    @Test
    public void testSacarValorInvalido() {
        conta.sacar(-50.0);
        assertEquals(450.0, conta.getSaldo());
    }

    @Test
    public void testSacarSaldoInsuficiente() {
        conta.sacar(500.0);
        assertEquals(450.0, conta.getSaldo());
    }

    @Test
    public void testPixValorValido() {
        conta.pix(100.0);
        assertEquals(450.0, conta.getSaldo());
    }

    @Test
    public void testPixValorInvalido() {
        conta.pix(-50.0);
        assertEquals(450.0, conta.getSaldo());
    }
}