package banco;
class conta{

    String nome_titular;
    int numero;
    String agencia;
    double saldo = 100;
    String data_abertura;
    String data_atual;

    public conta (String nome_titular, int numero, String agencia, double saldo, String data_abertura, String data_atual){
        this.nome_titular = nome_titular;
        this. numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.data_abertura = data_abertura;
        this.data_atual = data_atual;
    }

    public String returnTitular() {
        return this.nome_titular;
    }

    public int returnNumero() {
        return this.numero;
    }

    public String returnAgencia() {
        return this.agencia;
    }

    public double returnSaldo() {
        return this.saldo;
    }

    public String returnDataAbertura() {
        return this.data_abertura;
    }

    public void sacar(double saque){
        if (saque <= this.saldo && saque > 0){
            this.saldo = this.saldo - saque;
            System.out.println("Você sacou "+saque+" reais seu saldo atual é de "+this.saldo+" reais");
        }
            else{
                System.out.println("Saque inválido.");
            }
    }

    public void depositar( double deposito){
        if (saldo > 0){
            this.saldo = this.saldo + deposito;
            System.out.println("Você depositou "+deposito+" reais seu saldo atual é de "+this.saldo+" reais");
        }
            else{
                System.out.println("Depósito inválido.");
            }

    }

    public void calculaRendimento(double meses){
        this.saldo =((this.saldo * 0.13)/100) * meses + this.saldo;
    }

}