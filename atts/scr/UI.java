import javax.swing.JOptionPane;
public class UI {
	public static void main(String[] args) {
		while(true) {
		int Cliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Nº do Cliente que deseja visualizar"));
		//chamar o metodo para escolher o cliente baseado na resposta do JOptionPane
		System.out.println("Cliente Nº "+Cliente);
		int Continue = JOptionPane.showConfirmDialog(null, "Deseja continuar vendo clientes?","",JOptionPane.YES_NO_OPTION);
		if(Continue==JOptionPane.YES_OPTION) {	
		} else {
			break;
		}
		
		}
		
	}
}