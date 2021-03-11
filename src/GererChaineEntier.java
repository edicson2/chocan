
import java.util.*;


/**
 * 
 * @author judelin Et Edicson
 *
 */
public class GererChaineEntier {

	Scanner scan=new Scanner(System.in);


	/**
	 * 
	 * @param numero
	 * @param chiffres
	 * @return qui verifie la longueur chiffre entré
	 */
	public boolean verifierChiffres (int numero, int chiffres) {
		int n=0;
		while(numero!=0) {
			numero /= 10;
			n++;
		}
		return n==chiffres;
	}
	/**
	 * 
	 * @param chaine
	 * @param caracteres
	 * @return qui verifie un string entré
	 */
	public boolean verifierString (String chaine, int caracteres) {
		return chaine.length()<=caracteres;
	}

	/**
	 * 
	 * @param max
	 * @param mot
	 * @return qui retourn un numero
	 */
	public double numeroVoulu(double max, String mot) {
		serviceComptable servi=new serviceComptable();
		double m=0;
		boolean fin = false,vrai=true;

		do{
			try {
				System.out.println(mot);
				m=scan.nextDouble();//vrai?0:servi.payerAbonnement();
				if (m > max) {
					System.out.print("Le maximum est " + max);
					if (!verifierChiffres((int) m, (int) max)) {
						System.out.println(" chiffres");
					} else {
						System.out.println();
					}
				}
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("il faut mettre une chiffre.");
			}
		}while(fin);

		return m;
	}

	/**
	 * 
	 * @param max
	 * @param mot
	 * @return qui verifie une clef et le retourne
	 */
	public int keyVoulu(int max, String mot) {
		serviceComptable servi=new serviceComptable();
		int m=0;
		boolean fin = false,vrai=true;

		do{
			try {
				System.out.println(mot);
				m=scan.nextInt();//vrai?0:servi.payerAbonnement();
				if (m > max) {
					System.out.print("Le maximum est " + max);
					if (!verifierChiffres((int) m, (int) max)) {
						System.out.println(" chiffres");
					} else {
						System.out.println();
					}
				}
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("il faut mettre une chiffre.");
			}
		}while(fin);

		return m;
	}

	/**
	 * 
	 * @param n
	 * @param mot
	 * @return qui verifie une longueur
	 */

	public String nomVoulu(int n, String mot) {

		String chaine = "";
		boolean fin = false;
		do{
			System.out.println(mot);
			chaine=scan.next();
			if ( !verifierString(chaine, 13) ) {
				System.out.println("Il faut mettre au maximum " + n + " caracteres. Reessayez");
				continue;
			}
			break;
		} while (!fin);

		return chaine;
	}

	/**
	 * 
	 * @param date
	 * @return qui verifie la date entrée
	 */

	public boolean verifierDate(String date) {


		boolean sortir = false;

		do{

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
			return false;
		}while(sortir);

		return true;

	}


}