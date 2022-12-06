
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Project {
	static ArrayList <Dipendente> dipendenteArrayList=new ArrayList<Dipendente>();
	static ArrayList<Milestone> milestoneArrayList = new ArrayList<Milestone>();

	public Project(){

	}

	public float percentualeCompletamento(){
		System.out.println("Si è scelto di visualizzare l'avanzmaneto del progetto selezionato");
		int iniziale=milestoneArrayList.size();
		int nuovo=0;
		for (int i = 0; i < iniziale; i++) {
			if (milestoneArrayList.get(i).completed==true){
				nuovo+=1;
			}
		}
		float percentuale=nuovo/iniziale;
		percentuale=percentuale*100;
		return percentuale;
	}

	public void inizializzazione(){

		System.out.println("Benvenuti.\nInserire numero di Dipendenti assegnati al progetto");
		Scanner ndip=new Scanner(System.in);
		int numeroDipendenti= ndip.nextInt();
		for (int i = 0; i < numeroDipendenti; i++) {
			Dipendente dipendente1=new Dipendente();
			dipendente1.setup();
			dipendenteArrayList.add(dipendente1);
		}

		System.out.print("\nAdesso Inserire il numero di Milestones del progetto\nMilestones>>>");
		Scanner nmil=new Scanner(System.in);
		int nMilestones= nmil.nextInt();

		for (int i = 0; i < nMilestones; i++) {

			Milestone milestone1=new Milestone();
			System.out.print("Inserire Nome e cognome del dipendente " +(i+1));
			milestone1.setup();
			//DateFormat dd;
			System.out.println(milestone1.dataScadenza);
			milestoneArrayList.add(milestone1);
		}


		//Milestone.setup();
	}
}
