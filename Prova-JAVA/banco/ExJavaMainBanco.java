package banco;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.math.BigDecimal;
import java.text.ParseException;

public class ExJavaMainBanco{

    public static void main(String[] args) throws ParseException{
        try {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira os dados da sua conta:");

        System.out.println("Digite o nome da agência bancaria: ");
        String agencia = sc.nextLine();

        System.out.println("Nome do titular: ");
        String nome = sc.nextLine();

        System.out.println("Número da conta:");
        int numero = sc.nextInt();
        
        Scanner s = new Scanner(System.in);
        System.out.println("Insira a data de abertura da sua conta neste formato = DD/MM/AAAA: ");
        String data_abertura = s.nextLine();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = df.parse(data_abertura);
        
        Date data_atual = new Date();
        String data_atual_df = df.format(data_atual);

        final double MES_EM_MILISEGUNDOS = 30.0 * 24.0 * 60.0 * 60.0 * 1000.0;
        double numero_meses = (double)((data_atual.getTime() - dt.getTime())/MES_EM_MILISEGUNDOS);

        conta conta1 = new conta(nome,numero,agencia,100,data_abertura,data_atual_df);
        
        System.out.println("Sua conta foi criada a "+numero_meses+" meses.\nSeu saldo inicial era de "+conta1.returnSaldo()+" reais.");

        conta1.calculaRendimento(numero_meses);

        System.out.println("Escolha uma das opções: \n1- Consultar saldo atual\n2- Saque\n3- Depósito\n4- Sair");
        int opc = sc.nextInt();

        switch(opc){
            case 1:
            System.out.println("Seu saldo atual é de: R$ "+conta1.returnSaldo());
            break;
        
            case 2:
            System.out.println("Digite a quantidade que deseja sacar:");
            double saque = s.nextDouble();

            conta1.sacar(saque);

            break;

            case 3:
            System.out.println("Digite a quantidade que deseja depositar:");
            double deposito = s.nextDouble();

            conta1.depositar(deposito);

            break;

            case 4:
            System.out.println("Volte sempre!");
            System.exit(0);
            break;
        }

        
        } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
}