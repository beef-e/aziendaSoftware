import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class Task {
	Date dataScadenza;
	boolean critico;
	Dipendente dipendenteAssegnato;
	boolean completato;

	public Task(){

	}
	
	public void setup(){
		System.out.println("Inserire Data di scadenza con formato dd MM yyyy");
		Scanner dmil=new Scanner(System.in);
		Scanner mMil=new Scanner(System.in);
		Scanner ymil=new Scanner(System.in);
		int y, m, d;
		d=dmil.nextInt();
		m=mMil.nextInt();
		y=ymil.nextInt();
		Calendar myDate=Calendar.getInstance();
		myDate.set(Calendar.DAY_OF_MONTH, d);
		myDate.set(Calendar.MONTH, (m-1));
		myDate.set(Calendar.YEAR, y);
		SimpleDateFormat DateFormat= new SimpleDateFormat("dd/MM/yy");
		this.dataScadenza=myDate.getTime();
		
		System.out.println("Selezionare dipendente assegnato selezionando il numero corrispondente");
		for (int i = 0; i < Project.dipendenteArrayList.size(); i++) {
			Dipendente dipendente=Project.dipendenteArrayList.get(i);
			System.out.print((i+1));
			System.out.print(dipendente.nome);
			System.out.print(" "+dipendente.cognome);
			System.out.print("\n");
		}
		System.out.print(">>>");
		Scanner indice=new Scanner(System.in);
		int index=indice.nextInt();
		dipendenteAssegnato=Project.dipendenteArrayList.get(index-1);


		System.out.println("Questa task è una task di importanza critica?");
		System.out.println("1. Sì");
		System.out.println("2. No");
		Scanner criticy=new Scanner(System.in);

		switch (criticy.nextInt()){
			case 1:
				critico=true;
				break;

			case 2:

			default:
				critico=false;
				break;
		}

		completato=false;
	}

	public void taskHandling(){
		System.out.println("Quale azione si desidera effettuare con la task selezionata?");
		System.out.println("1. Contrassegna come completato");
		System.out.println("2. Contrassegna come critico");
		System.out.println("3. Esci\n");
		int val=0;
		if (critico) val+=1;
		if (completato) val+=2;
		switch (val) {
			case 0 ->
					System.out.println("La Task selezionata è attualmente non completata e di importanza non critica");
			case 1 -> System.out.println("La Task selezionata è attualmente non completata, ma di importanza critica");
			case 2 -> System.out.println("La Task selezionata è stata completata con una importanza non critica");
			case 3 -> System.out.println("La Task selezionata è stata completata con una importanza critica");
			default -> System.out.println("Qualcosa è andato storto nella lettura della Task");
		}

		System.out.print(">>>");
		Scanner numero=new Scanner(System.in);
		int risposta=numero.nextInt();

		switch (risposta) {
			case 1 -> {
				completato = true;
				System.out.println("Task contrassegnata come completata");
			}
			case 2 -> {
				critico = true;
				System.out.println("Task contrassegnata come critica");
			}
			default -> System.out.println("Nessuna modifica effettuata");
		}
	}
}
