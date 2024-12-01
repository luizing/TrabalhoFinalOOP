public class Funcionario extends Pessoa {
	private String numeroCracha;
	private double salario;
	
	private void cracha() {
		System.out.printf("Nº do seu Crachá: ", numeroCracha);
	}
	public void setNumerocracha(String cracha) {
		this.numeroCracha = cracha;
	}
	public String getNumerocracha() {
		return numeroCracha;
	}
	public void setSalario(double salario){
		this.salario = salario;
	}
	public double getSalario(){
		return this.salario;
	}
}
