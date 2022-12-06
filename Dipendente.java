import java.util.Scanner;

public class Dipendente {
	String nome;
	String cognome;

	public Dipendente(){

	}

	public void setup(){
		Scanner nome=new Scanner(System.in);
		Scanner cognome=new Scanner(System.in);
		this.nome=nome.nextLine();
		this.cognome=cognome.nextLine();
	}
}
