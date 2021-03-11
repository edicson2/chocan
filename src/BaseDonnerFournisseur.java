import java.io.IOException;

/**
 * 
 * @author judelin et Edicson
 *
 */
public class BaseDonnerFournisseur extends BaseDeDonnerChocAn {

	/**
	 * 
	 * @param n prendre un paramettre une cle
	 * @return retourne un fournisseur
	 * @throws IOException
	 */

	public Fournisseur read(int n)
			throws IOException

	{
		double montant=0;
		int key=0; 

		getFile().seek(n * RECORD_SIZE);


		//montant = getFile().readDouble();


		key = getFile().readInt();
		String nom=getFile().readUTF();
		String prenom=getFile().readUTF();
		String ville=getFile().readUTF();
		String province=getFile().readUTF();
		String  adresse=getFile().readUTF();
		String  codeDePostal=getFile().readUTF();
		//double codeDuService=getFile().readDouble();
		//String  dateDuService=getFile().readUTF();

		//}
		return new Fournisseur(key,nom,prenom,adresse,ville,province,
				codeDePostal);


	}

	/**
	 * 
	 * @param key verifier une clef entrée
	 * @return retourne un boolean
	 * @throws IOException
	 */

	public boolean verifier(int key)
			throws IOException
	{

		for (int i = 0; i < size(); i++)
		{
			getFile().seek(i * RECORD_SIZE);
			int a = getFile().readInt();
			if(a == key){
				return true;
			}
		}
		return false;


	}

	/**
	 * 
	 * @param en paramettre une clef
	 * @return trouver et retourne une position
	 * @throws IOException
	 */
	public int find(int key)
			throws IOException
	{

		for (int i = 0; i < size(); i++)
		{
			getFile().seek(i * RECORD_SIZE);
			int a = getFile().readInt();
			if (a == key) { return i; }
			// Found a match
		}
		return -1; // No match in the entire file
	}

	/**
	 * 
	 * @param n prend une clef en paramettre
	 * @param fourni prend en paramettre un fournisseur
	 * @throws IOException
	 */
	public void write(int n, Fournisseur fourni)
			throws IOException
	{
		getFile().seek(n * RECORD_SIZE);
		getFile().writeInt(fourni.getNumero());
		getFile().writeUTF(fourni.getNom());
		getFile().writeUTF(fourni.getPrenom());
		getFile().writeUTF(fourni.getVille());
		getFile().writeUTF(fourni.getProvince());
		getFile().writeUTF(fourni.getAdresse());
		getFile().writeUTF(fourni.getCodeDePostal());


	}

	/**
	 * 
	 * @param n cle 
	 * @param actualDate date actuelle
	 * @param serviceDate date de service
	 * @param numeroFourni numero fournisseur
	 * @param numeroMembre numero membre
	 * @param nomDuService nom du service
	 * @param codeDeService code de service
	 * @param commentaires  commentaires
	 * @param montant montant a payer
	 * @throws IOException
	 */
	public void write(int n, String actualDate, String serviceDate, int numeroFourni, 
			int numeroMembre, String nomDuService, int codeDeService, String commentaires, double montant)
					throws IOException
	{
		getFile().seek(n * RECORD_SIZE);

		getFile().writeUTF(actualDate);
		getFile().writeUTF(serviceDate);
		getFile().writeInt(numeroFourni);
		getFile().writeInt(numeroMembre);
		getFile().writeUTF(nomDuService);
		getFile().writeInt(codeDeService);
		getFile().writeUTF(commentaires);
		getFile().writeDouble(montant);

	}



	public int findFournisseurEnregistrement(int key)
			throws IOException
	{

		for (int i = 0; i < size(); i++)
		{
			getFile().seek(i * RECORD_SIZE);
			String actualDate = getFile().readUTF();
			String serviceDate = getFile().readUTF();
			int numeroFourni = Integer.parseInt(getFile().readUTF());
			if(numeroFourni == key) {
				return i;
			}
			// Found a match
		}
		return -1; // No match in the entire file
	}


	public String readDate(int n)
			throws IOException
	{

		getFile().seek(n * RECORD_SIZE);

		String actualDate = getFile().readUTF();
		String serviceDate = getFile().readUTF();

		return serviceDate;

	}


	public String readCodeDuService(int n)
			throws IOException
	{

		getFile().seek(n * RECORD_SIZE);

		String actualDate = getFile().readUTF();
		String serviceDate = getFile().readUTF();
		String numeroFourni = getFile().readUTF();
		String numeroMembre = getFile().readUTF();
		String nomDuMembre = getFile().readUTF();
		String codeDuService = getFile().readUTF();

		return codeDuService;

	}

}
