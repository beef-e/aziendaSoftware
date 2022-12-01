
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Project {
	int numeroDipendenti;
	static ArrayList<Milestone> milestoneArrayList = new ArrayList<Milestone>();

	public Project(){

	}

	public float percentualeCompletamento(){
		float percentuale=0; //momentaneo
		return percentuale;
	}

	public void inizializzazione(){
		System.out.println("Benvenuti.\nInserire numero di Dipendenti assegnati al progetto");
		Scanner ndip=new Scanner(System.in);
		numeroDipendenti=ndip.nextInt();

		System.out.print("\nAdesso Inserire il numero di Milestones del progetto\nMilestones>>>");
		Scanner nmil=new Scanner(System.in);
		int nMilestones= nmil.nextInt();
		//Scanner ntask=new Scanner(System.in);

		for (int i = 0; i < nMilestones; i++) {

			Milestone milestone1=new Milestone();
			//DateFormat dd;
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
			milestoneArrayList.add(milestone1);
			milestone1.dataScadenza=myDate.getTime();
		}


		//Milestone.setup();
	}
}
