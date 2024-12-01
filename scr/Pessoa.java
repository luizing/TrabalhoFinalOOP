public abstract class Pessoa {
	protected String Nome;

	public Pessoa () {
	}
	
	public Pessoa(String Nome) {
		this.Nome = Nome;
	}
    
	public String getNome() {	
		return Nome;
	}

    public void setNome(String nome){
        this.Nome = nome;
    }

}
