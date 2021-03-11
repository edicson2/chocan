import java.util.*;
import java.io.*;

public class operateurs implements interfaceOperateur {

	Scanner scan=new Scanner(System.in);
	int compteur=0;

	BaseDonnerFournisseur base;
	BaseDonnerMembre base1;
	GererChaineEntier gerer=new GererChaineEntier();

	/**
	 * 
	 * @return qui genere un numero membre aleatoire
	 */
	public int genererNumeroMembre(){
		int nombreAlea=980000000+(int)(Math.random()*1000000);
		return nombreAlea;
	}
	/**
	 * 
	 * @return retourne un numero fournisseur
	 */

	public int genererNumeroFournisseur(){
		int nombreAlea=190000000+(int)(Math.random()*1000000);
		return nombreAlea;
	}


	/**
	 * 
	 * @return retourne un table de clef membre
	 * @throws IOException
	 */
	public int [] lireMembre() throws IOException{

		base1=new BaseDonnerMembre();
		base1.open("ChocMembre.dat");

		int key=0;
		long fileSize=base1.getFile().length(); // taille du tableau de registres
		long records=fileSize/12; // quantite de registres dans le tableau
		if (records == 0) {records++;}
		int recordSize = (int) (fileSize/records); // la taille de chaque registre
		int tableSize = (int) (records);
		int [] cle=new int[tableSize]; // le tableau qui va garder les clefs
		base1.getFile().seek(fileSize); // On modifie la fin de l'archive qu'on lit

		for(int i=0; i<fileSize; ++i){
			recordSize *=i; // On change au registre suivant
			key=base1.getFile().readInt();
			cle[i]=key;
			System.out.println(key + "\n");
		}

		return cle;

	}

	/**
	 * 
	 * @return qui retourne un tableau de clef fournisseur
	 * @throws IOException
	 */
	public int[]  lireFournisseur() throws IOException{

		base=new BaseDonnerFournisseur();
		base.open("ChocFournisseur.dat");

		int key=0;
		long fileSize=base.getFile().length(); // taille du tableau de registres
		System.out.println(fileSize);
		fileSize -=1;
		long records=fileSize/12; // quantite de registres dans le tableau
		int recordSize = (int) (fileSize/records); // la taille de chaque registre
		int tableSize = (int) (records);
		int [] cle=new int[tableSize]; // le tableau qui va garder les clefs
		base1.getFile().seek(fileSize); // On modifie la fin de l'archive qu'on lit

		for(int i=0; i<fileSize; ++i){
			recordSize *=i; // On change au registre suivant
			key=base.getFile().readInt();
			cle[i]=key;
			System.out.println(key);
		}

		return cle;

	}
	/**
	 * ajouter un fournisseur dans le centre de données
	 */

	@Override
	public void AjouterDonnerFournisseur() throws IOException{

		base=new BaseDonnerFournisseur();
		base.open("ChocFournisseur.dat");

		boolean sortir = true;
		String date;
		boolean done = false;
		while (!done){
			System.out.println("Inscription Fournisseur");
			int numero=genererNumeroFournisseur();
			System.out.println("Le numero de fournisseur est "+numero);

			//double montant = numeroVoulu(999.99, "Montant");
			String nom = gerer.nomVoulu(13, "Nom");
			String prenom = gerer.nomVoulu(12, "Prenom");
			String ville = gerer.nomVoulu(14, "Ville");
			String province=gerer.nomVoulu(2, "Province");
			String adresse = gerer.nomVoulu(25, "Adresse");

			//double codeDeService = numeroVoulu(5, "Code de service");
			String CodeDePostal = gerer.nomVoulu(5, "Code de postal");


			/*do{
				System.out.println("date du service (JJMMAAAA)");
				date=scan.next();
				if( verifierString(date, 8)){
					try {
						int jour = Integer.parseInt( date.substring(0,2) );
						int mois = Integer.parseInt( date.substring(2,4) );
						int anne = Integer.parseInt( date.substring(4) );
						if (jour > 0 && jour<= 31 && mois > 0 && mois <= 12 
								&& verifierChiffres(anne, 4)) {
							break;
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						System.out.println("Il faut mettre des numeros");
					}
				}
				System.out.println("La date doit avoir le format JJMMAAAA. Reessayez");
				continue;
			}while(sortir);*/


			int position = base.find(numero);
			Fournisseur fourni;
			if (position >= 0)
			{
				fourni = base.read(position);
			}
			else // ajouter un fournisseur
			{
				fourni = new Fournisseur(numero,nom,prenom,ville,province,adresse,CodeDePostal);

				position = base.size();
			}
			base.write(position, fourni);

			System.out.print("Ajouter un nouveau fournisseur? (Y/N) ");

			String input =scan.next();
			if (input.equalsIgnoreCase("N")) { done = true; }
		}
	}



	/**
	 * 
	 * @throws IOException
	 */
	/* Ce methode genere un erreur quand on essaie de lire les donnees d'un fournisseur
	 * Je n'ai pas reussit a l'enlever*/
	public void mettreAJourFournisseur() throws IOException {
		Fournisseur fourni = new Fournisseur();
		boolean sortir = false;
		int numeroFournisseur=0;
		int position=0;
		base=new BaseDonnerFournisseur();
		base.open("ChocFournisseur.dat");

		do{

			do{
				System.out.println("Entrer le numero du fournisseur à modifier");
				numeroFournisseur=scan.nextInt();

				if(base.verifier(numeroFournisseur)) {
					position = base.find(numeroFournisseur);

					if (position >= 0) {
						fourni = base.read(position); //TODO Il genere EOFException
						break;
					} else {
						System.out.println("Le fournisseur n'existe pas");
					}
				} else {
					System.out.println("Le fournisseur n'existe pas");
					System.out.println("Essayer encore? (Y/N) ");
					String reponse = scan.next();
					if (reponse.equalsIgnoreCase("N")) { sortir = true; }
				}
			} while(!sortir);

			if(sortir) { break;}

			double value = 0;
			String chaine = "";

			do{

				System.out.println("Quelles informations voulez-vous modifier?");
				//System.out.println("1:montant");
				System.out.println("2:nom");
				System.out.println("3:prenom");
				System.out.println("4:ville");
				System.out.println("5:adresse");
				System.out.println("6:code de postal");
				//System.out.println("7:code de service");
				//System.out.println("8:date du service");

				int option = scan.nextInt();

				switch(option) {
				/*case 1:
					System.out.println("Entrez le montant:");
					value = scan.nextInt();
					fourni.setMontantPayer(value);
					System.out.println("Montant " + fourni.getMontantPayer() );
					base.write(position, fourni);
					break;*/
				case 1:
					System.out.println("Entrez le nom:");
					chaine = scan.next();
					fourni.setNom(chaine);
					System.out.println("nom " + fourni.getNom()  );
					base.write(position, fourni);
					break;
				case 2:
					System.out.println("Entrez le prenom:");
					chaine = scan.next();
					fourni.setPrenom(chaine);
					System.out.println("prenom " + fourni.getPrenom()  );
					base.write(position, fourni);
					break;
				case 3:
					System.out.println("Entrez la ville:");
					chaine = scan.next();
					fourni.setVille(chaine);
					System.out.println("ville " + fourni.getVille() );
					base.write(position, fourni);
					break;
				case 4:
					System.out.println("Entrez Province:");
					chaine = scan.next();
					fourni.setProvince(chaine);
					System.out.println("ville " + fourni.getProvince() );
					base.write(position, fourni);
					break;

				case 5:
					System.out.println("Entrez l'adresse:");
					chaine = scan.next();
					fourni.setAdresse(chaine);
					System.out.println("adresse" + fourni.getAdresse()  );
					base.write(position, fourni);
					break;
				case 6:
					System.out.println("Entrez le code de postal:");
					chaine = scan.next();
					fourni.setCodeDePostal(chaine);
					System.out.println("code de postal " + fourni.getCodeDePostal() );
					base.write(position, fourni);
					break;
					/*case 6:
					System.out.println("Entrez le code de service:");
					value = scan.nextDouble();
					fourni.setCodeDuService(value);
					System.out.println("code de service " + fourni.getCodeDuService()  );
					base.write(position, fourni);
					break;
				/*case 8:
					System.out.println("Entrez le date du service:");
					chaine = scan.next();
					fourni.setDateDuService(chaine);
					System.out.println("date de serive " + fourni.getDateDuService()  );
					base.write(position, fourni);
					break;*/
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
	 * mettre a jour membre
	 * @throws IOException
	 */
	public void mettreAJourMembre() throws IOException {
		boolean sortir = false;
		int numeroMembre=0;
		Membres memb = new Membres();
		int position=0;
		base1=new BaseDonnerMembre();
		base1.open("ChocMembre.dat");

		do{

			do{
				System.out.println("Entrer le numero du membre à modifier");
				numeroMembre=scan.nextInt();

				if(base1.verifier(numeroMembre)) {
					position = base1.find(numeroMembre);

					if (position >= 0) {
						memb = base1.read(position); //TODO Il genere EOFException
						break;
					} else {
						System.out.println("Le membre n'existe pas");
					}
				} else {
					System.out.println("Le fournisseur n'existe pas");
					System.out.println("Essayer encore? (Y/N) ");
					String reponse = scan.next();
					if (reponse.equalsIgnoreCase("N")) { sortir = true; }
				}
			} while(!sortir);

			if(sortir) { break;}

			double value = 0;

			String chaine = "";

			do{

				System.out.println("Quelles informations voulez-vous modifier?");
				//	System.out.println("1:montant");
				System.out.println("2:nom");
				System.out.println("3:prenom");
				System.out.println("4:ville");
				System.out.println("5:adresse");
				System.out.println("6:code de postal");
				//System.out.println("7:code de service");
				//System.out.println("8:date du service");

				int option = scan.nextInt();

				switch(option) {

				case 1:
					System.out.println("Entrez le nom:");
					chaine = scan.next();
					memb.setNom(chaine);
					base1.write(position, memb);
					System.out.println("nom " + memb.getNom()  );

					break;
				case 2:
					System.out.println("Entrez le prenom:");
					chaine = scan.next();
					memb.setPrenom(chaine);
					base1.write(position, memb);
					System.out.println("prenom " + memb.getPrenom()  );
					break;

				case 3:
					System.out.println("Entrez la ville:");
					chaine = scan.next();
					memb.setVille(chaine);
					base1.write(position, memb);
					System.out.println("ville " + memb.getVille() );
					break;

				case 4:
					System.out.println("Province du membre");
					chaine = scan.next();
					memb.setProvince(chaine);
					base1.write(position, memb);
					System.out.println("date de serive " + memb.getProvince()  );
					break;
				case 5:
					System.out.println("Entrez l'adresse:");
					chaine = scan.next();
					memb.setAddresse(chaine);
					base1.write(position, memb);
					System.out.println("adresse" + memb.getAddresse()  );
					break;
				case 6:
					System.out.println("Entrez le code de postal:");
					chaine = scan.next();
					memb.setCodePostal(chaine);
					base1.write(position, memb);
					System.out.println("code de postal " + memb.getCodePostal() );
					break;
					/*case 6:
					System.out.println("Entrez le code de service:");
					value = scan.nextDouble();
					memb.setNonDuService(chaine);
					base1.write(position, memb);
					System.out.println("code de service " + memb.getNonDuService()  );
					break;
				case 7:
					System.out.println("Entrez le date du service:");
					chaine = scan.next();
					memb.setDate(chaine);
					base1.write(position, memb);
					System.out.println("date de serive " + memb.getDate()  );
					break;*/
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
	 * ajouter un membre
	 */

	@Override
	public void AjouterDonnerMembre() throws IOException{

		base1=new BaseDonnerMembre();
		base1.open("ChocMembre.dat");

		boolean sortir = true;
		String nom, prenom, ville,province ,adresse, nonDuService, codeDePostal;
		double montant;

		boolean done = false;
		while (!done){
			System.out.println("Inscription Membre");
			int numero=genererNumeroMembre();
			System.out.println("Le numero du membre est "+ numero);

			//	montant = numeroVoulu(999.99, "Montant");
			nom = gerer.nomVoulu(12, "nom");
			prenom = gerer.nomVoulu(13, "prenom");
			ville = gerer.nomVoulu(14, "ville");
			province=gerer.nomVoulu(2, "province");
			adresse = gerer.nomVoulu(25, "adresse");
			//nonDuService = nomVoulu(20, "nom du service");
			codeDePostal = gerer.nomVoulu(5, "code de postal");

			int position = base1.find(numero);
			Membres memb;
			if (position >= 0)
			{
				memb = base1.read(position);

			}
			else // ajouter un Membre
			{

				memb=new Membres( numero, nom,prenom, adresse, ville,province,codeDePostal);

				position = base1.size();
				//System.out.println("Ajouter un nouveau membre");
			}
			base1.write(position, memb);

			System.out.print("Ajouter un nouveau membre? (Y/N) ");

			String input =scan.next();
			if (input.equalsIgnoreCase("N")) { done = true; }
		}
	}


	/**
	 * supprimer un fournisseur
	 */
	@Override
	public void supprimerDonnerFournisseur() throws IOException {
		// TODO Auto-generated method stub

		base=new BaseDonnerFournisseur();
		base.open("ChocFournisseur.dat");

		System.out.println("Entrer le numero du fournisseur");
		int numeroFournisseur=scan.nextInt();

		int position = base.find(numeroFournisseur);
		Fournisseur fourni= new Fournisseur();
		if (position >= 0)
		{
			base.write(position, fourni);
		} else {
			System.out.println("Le fournisseur n'existe pas");
		}


	}
	/**
	 * supprimer un membre
	 */
	@Override
	public void supprimerDonnerMembre() throws IOException {
		// TODO Auto-generated method stub
		base1=new BaseDonnerMembre();
		base1.open("ChocMembre.dat");

		System.out.println("Entrer le numero du membre");
		int numeroMembre=scan.nextInt();

		int position = base1.find(numeroMembre);
		Membres memb = new Membres();
		if (position >= 0)
		{
			base1.write(position, memb);
		} else {
			System.out.println("Le membre n'existe pas");
		}
	}
	/**
	 * affiche menu
	 */
	@Override
	public void AfficherOperer() throws IOException {

		System.out.println("Mettre a jour les données chocAn en choisissant un numero de 1 a 6 Svp");
		System.out.println("1:Ajouter Fournisseur");
		System.out.println("2:Ajouter Membre");
		System.out.println("3:Supprimer Fournisseur");
		System.out.println("4:Supprimer Membre");
		System.out.println("5:Mettre a jour fournisseur");
		System.out.println("6:Mettre a jour membre");

		int Entrer=scan.nextInt();
		switch(Entrer){

		case 1:
			AjouterDonnerFournisseur();
			break;
		case 2:
			AjouterDonnerMembre();
			break;
		case 3:
			supprimerDonnerFournisseur();
			break;
		case 4:
			supprimerDonnerMembre();
			break;
		case 5:
			mettreAJourFournisseur();
			break;
		case 6:
			mettreAJourMembre();
			break;
		default:
			break;

		}

	}

}