import java.io.IOException;
import java.util.*;

/**
 * 
 * @author judelin et Edicson
 *
 */
public class serviceComptable implements AfficherInfo{
	Scanner scan=new Scanner(System.in);
	public double EntrerFrais=0;
	public int entrer;
	BaseDonnerMembre base;

	ServiceChocAn service=new ServiceChocAn();
	final int delaiPaiement=100;
	boolean etat =false;
	/**
	 * 
	 * @return retourne un boolean
	 */
	public boolean suspendre() {
		if(service.getFraisDeService()==0){
			etat=false;
		}
		return etat;
	}

	public boolean retablir() {
		if(service.getFraisDeService()!=0){
			etat=true;
		}
		return etat;
	}
	/**
	 * payer Abonnement de chocAn
	 * @throws IOException
	 */
	public void payerAbonnement() throws IOException {


		boolean sortir = false;
		int numeroMembre=0;

		Membres memb=new Membres();
		base=new BaseDonnerMembre();
		base.open("Enregistrement.dat");
		int position=0;
		do{

			do{
				System.out.println("Entrer le numero du  membre à modifier");
				numeroMembre=scan.nextInt();

				if(base.verifier(numeroMembre)) {
					position = base.find(numeroMembre);

					if (position >= 0) {
						memb = base.read(position); //TODO Il genere EOFException
						break;
					} else {
						System.out.println("Le Membre n'existe pas");
					}
				} else {
					System.out.println("Le membre n'existe pas");
					System.out.println("Essayer encore? (Y/N) ");
					String reponse = scan.next();
					if (reponse.equalsIgnoreCase("N")) { sortir = true; }
				}
			} while(!sortir);

			if(sortir) { break;}

			double value = 0;
			String chaine = "";

			do{

				System.out.println("Entrer le montant");

				int option = scan.nextInt();

				switch(option) {
				case 1:

					System.out.println("Entrez le montant");

					value = scan.nextDouble();
					service.setFraisDeService(value);

					System.out.println("Montant " +service.getFraisDeService() );
					base.write(position, memb);

					break;

				default:
					System.out.println("Pas de modifications");
					break;
				}

				System.out.println("Modifier encore? (Y/N) ");
				String reponse = scan.next();
				if (reponse.equalsIgnoreCase("N")) { sortir = true; }

			}while(!sortir);
			break;
			//int position = base.find(numeroFournisseur);

			//Fournisseur fourni= new Fournisseur();

		}while(!sortir);


	}
	/**
	 * 
	 * @return
	 */
	public double mettreAjour() {



		return 0;
	}



	@Override
	public void affiche() throws IOException {
		System.out.println("Entrer un numero entre 1 a 4 SVP");

		System.out.println("1:Entrer paiment du membre abonné");
		System.out.println("2:Mettre a jour un membre");
		System.out.println("3:Suspendre un membre non payé");
		System.out.println("4:Retablir un membre");


		entrer=scan.nextInt();
		switch(entrer){

		case 1:
			payerAbonnement();
			break;


		case 2:
			mettreAjour();
			break;

		case 3:
			suspendre();
			break;


		case 4:
			retablir();
			break;

		}


	}
}