import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ControleMembre implements AfficheEntrer {
	Scanner scan;
	BaseDonnerMembre base;
	ServiceChocAn service;
	serviceComptable servi;
	GererChaineEntier gerer;

	public String Entrer2,Entrer3,Entrer4,Entre5,Entre6,commentaires;
	public int Entrer1;

	public ControleMembre(){

		scan=new Scanner(System.in);
		base=new BaseDonnerMembre();
		service=new ServiceChocAn();
		servi=new serviceComptable();
		gerer=new GererChaineEntier();

	}


	@Override
	public void Entrer() throws IOException {

		do{
			System.out.println("Identification Membre");
			System.out.println("Pour recevoir de service ChocAn");
			base.open("ChocMembre.dat");
			Entrer1=scan.nextInt();
			boolean etat=base.verifier(Entrer1);
			if(etat){

				int position = base.find(Entrer1);
				Membres memb;
				if (position >= 0){

					memb = base.read(position);

					System.out.println("Membre Valide");

				}

				else{
					if(!etat){
						System.out.println("numero invalide");
					}
					else if(servi.suspendre()){
						System.out.println("Membre Suspendu");
						System.out.println("C'est-à-dire le membre n'a payé ses frais de membre pour au moins un mois");
					}
					System.out.println("Essayer encore? (Y/N) ");
					String reponse = scan.next();
					if (reponse.equalsIgnoreCase("N")) { break; }

				}

			}

		} while(!base.verifier(Entrer1));
	}

	@Override
	public void afficher() throws IOException {
		Entrer(); // Verifier membre
		if(base.verifier(Entrer1)){
			System.out.println("Entrer 1 pour la facturation");
			System.out.println("1:Facture");

			Entrer1=scan.nextInt();
			switch(Entrer1) {
			case 1:
				Formulaire();
				break;
			default:
				System.out.println("Option invalide");
				break;

			}

		}

	}

	@Override
	public void Formulaire() throws IOException {
		base.open("rapportMembre.txt");
		String data;

		System.out.println("Date de Service");
		data = scan.next();
		if (gerer.verifierDate(data) ) {
			System.out.println("Code de service");
			data = scan.next();
			//if(data != service.getNomService()) {
				//System.out.println("code de service inexistant");
				//return;
			//}
		}

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();

		// Données pour l'enregistrement

		String actualDate = df.format(calobj.getTime());
		String serviceDate = data;
		System.out.println("Entrer numero Fournisseur");
		int numeroFourni = gerer.keyVoulu(9, "");

		int numeroMemb = gerer.keyVoulu(9, "Entrer numero membre");
		String nomDuServ =gerer.nomVoulu(20, "Entrer nom du service");

		int codeService=gerer.keyVoulu(5, "Entrer Code de service");


		System.out.println("Faire un commentaire de service fourni");
		commentaires = scan.next();

		double montant=gerer.numeroVoulu(999.9, "Entrer montant a  payer");
		service.setFraisDeService(montant);

		base.open("Enregistrement.dat");
		int n = base.find(numeroFourni);
		if (n==-1) {n=0;}

		base.write(n, actualDate, serviceDate, numeroFourni, numeroMemb, nomDuServ,codeService, commentaires,montant);

	}


}
