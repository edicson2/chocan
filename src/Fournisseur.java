import java.util.Scanner;

/**
 * 
 * @author judelin et Edicson
 *
 */
public class Fournisseur {

	private String nom;
	private String prenom;
	private int numero;
	private String adresse;
	private String ville;
	private String province;
	private String CodeDePostal;
	private double montant;

	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Fournisseur(){

		this.numero=0;
		this.nom="";
		this.prenom="";
		this.adresse="";
		this.ville="";
		this.province="";
		this.CodeDePostal="";

	}
	public Fournisseur(int numero,double montant){
		this.numero=numero;
		this.montant=montant;
	}

	public Fournisseur(int numero,String nom,String prenom,
			String ville,String province,String adresse,String codeDePostal) {
		this.numero=numero;

		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.ville=ville;
		this.province=province;
		this.CodeDePostal=codeDePostal;


	}


	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNumero() {
		return this.numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAdresse() {

		return this.adresse;
	}

	/**
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return this.ville;
	}

	/**
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getProvince() {
		return this.province;
	}

	/**
	 * 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	public String getCodeDePostal() {
		return this.CodeDePostal;
	}

	/**
	 * 
	 * @param CodeDePostal
	 */
	public void setCodeDePostal(String CodeDePostal) {
		this.CodeDePostal=CodeDePostal;
	}



}