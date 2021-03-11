import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author judelin et Edicson
 *
 */
public class ControlerFournisseur implements AfficheEntrer{
	Scanner scan;
	BaseDonnerFournisseur base;
	BaseDonnerMembre base2;
	ControleMembre membres;
	Fournisseur fourni;
	Membres memb;
	ServiceChocAn service;
	/**
	 * 
	 */
	public ControlerFournisseur(){

		scan=new Scanner(System.in);
		base=new BaseDonnerFournisseur();
		membres=new ControleMembre();
		//service=new ServiceChocAn();
	}

	public String Entrer4,Entre5,Entre6,commentaires;
	public int Entrer1,Entrer2;
	public double Entrer3;


	@Override
	public void Entrer() throws IOException {

		do{
			System.out.println("Identification Fournisseur");
			base.open("ChocFournisseur.dat");
			try {
				Entrer1=scan.nextInt();
			}catch(InputMismatchException e){
				System.out.println(Entrer1);
				System.out.println("erreur entrer un chiffre");
				continue;
			}

			if(base.verifier(Entrer1)){

				int position = base.find(Entrer1);
				if (position >= 0)
				{
					fourni = base.read(position);

					System.out.println("Fournisseur accrédité");
				}

			}else {
				System.out.println("Le fournisseur n'existe pas");
				System.out.println("Essayer encore? (Y/N) ");
				String reponse = scan.next();
				if (reponse.equalsIgnoreCase("N")) { break; }
			};

		} while(!base.verifier(Entrer1));

	}

	@Override
	public void afficher() throws IOException {
		Entrer(); // verification de fournisseur

		if(base.verifier(Entrer1)){

			System.out.println("1:Service Membre");
			System.out.println("2:Repertoire Fournisseurs");
			System.out.println("3:Totaliser les frais de paiements");

			boolean done=true; char entre=' ';

			Entrer2=scan.nextInt();




			switch(Entrer2){
			case 1:
				membres.afficher(); // verification du membre
				break;
			case 2:
				System.out.println(" Repertoire Fournisseurs consulter les services et les codes dans un fichier");
				RepertoirFournisseur fourn=new RepertoirFournisseur();
				break;
			case 3:


				System.out.println("Entrer le montant qu'on doit te payer");
				Entrer3=scan.nextDouble();
				fourni=new Fournisseur();
				fourni.setMontant(Entrer3);
				break;

			}
		}


	}

	@Override
	public void Formulaire() throws IOException {
		String data;}


}
