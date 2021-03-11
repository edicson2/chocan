

public class Membres 
{

	private int numero;
	private double Montant;
	private String nom;
	private String prenom;
	private String addresse;
	private String ville;
	private String telephone;
	private String province;
	private String codePostal;
	private String date;
	private String nomFournisseurs;
	private String nonDuService;



	public Membres(){
		this.numero=0;
		this.nom="";
		this.prenom="";
		this.addresse="";
		this.ville="";
		this.province="";
		this.codePostal="";


	}

	public Membres(int numero,String nom,String prenom,
			String addresse,String ville,String province,String codeDePostal) {
		this.numero=numero;
		this.nom=nom;
		this.prenom=prenom;
		this.addresse=addresse;
		this.ville=ville;
		this.province=province;
		this.codePostal=codeDePostal;




	}


	public String getNom() {


		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom=nom;
	}


	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {

		this.prenom=prenom;
	}

	public String getAddresse() {
		return this.addresse;
	}

	/**
	 * 
	 * @param addresse
	 */
	public void setAddresse(String addresse) {
		this.addresse=addresse;
	}

	public int getNumero() {
		return this.numero;
	}

	/**
	 * 
	 * @param Numero
	 */
	public void setNumero(int numero) {

		this.numero=numero;
	}




	public String getVille() {
		return this.ville;
	}

	/**
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {

		this.ville=ville;
	}

	public String getProvince() {
		return this.province;
	}

	/**
	 * 
	 * @param province
	 */
	public void setProvince(String province) {

		this.province=province;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	/**
	 * 
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {

		this.codePostal=codePostal;
	}





}