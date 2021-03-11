import java.io.IOException;
/**
 * 
 * @author judelin et Edicson
 *
 */

public class BaseDonnerMembre extends BaseDeDonnerChocAn {

	/**
	 * 
	 * @param n clef en paramettre
	 * @return qui retourne un fournisseur
	 * @throws IOException
	 */
	public Membres read(int n)
			throws IOException

	{
		double montant=0;
		int key=0; 

		getFile().seek(n * RECORD_SIZE);

		key = getFile().readInt();
		//montant = getFile().readDouble();

		String nom=getFile().readUTF();
		String prenom=getFile().readUTF();
		String ville=getFile().readUTF();
		String province=getFile().readUTF();
		String adresse=getFile().readUTF();
		String codeDePostal=getFile().readUTF();
		//String codeDuService=getFile().readUTF();
		//String  dateDuService=getFile().readUTF();

		//}
		return new Membres(key,nom,prenom,adresse,ville,province,
				codeDePostal);


	}
	/**
	 * 
	 * @param key une clef en paramettre
	 * @return
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
	 * @param key une clef en paramettre
	 * @return
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


	public void write(int n, Membres memb)
			throws IOException
	{
		getFile().seek(n * RECORD_SIZE);
		getFile().writeInt(memb.getNumero());
		//getFile().writeDouble(memb.getMontant());
		getFile().writeUTF(memb.getNom());
		getFile().writeUTF(memb.getPrenom());
		getFile().writeUTF(memb.getVille());
		getFile().writeUTF(memb.getProvince());
		getFile().writeUTF(memb.getAddresse());
		//getFile().writeUTF(memb.getNonDuService());
		getFile().writeUTF(memb.getCodePostal());
		// getFile().writeUTF(memb.getNomFournisseurs());
		//  getFile().writeDouble(memb.get);

	}



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


	public int findMembreEnregistrement(int key)
			throws IOException
	{

		for (int i = 0; i < size(); i++)
		{
			getFile().seek(i * RECORD_SIZE);
			String actualDate = getFile().readUTF();
			String serviceDate = getFile().readUTF();
			int numeroFourni = getFile().readInt();
			int numeroMembre = getFile().readInt();
			if(numeroMembre == key) {
				return i;
			}
			// Found a match
		}
		return -1; // No match in the entire file
	}


	public String readDateService(int n)
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
		int numeroFourni = getFile().readInt();
		int numeroMembre = getFile().readInt();
		String nomDuService = getFile().readUTF();

		return nomDuService;

	}


	public double readMontant(int n)
			throws IOException
	{

		getFile().seek(n * RECORD_SIZE);

		String actualDate = getFile().readUTF();
		String serviceDate = getFile().readUTF();
		int numeroFourni = getFile().readInt();
		int numeroMembre = getFile().readInt();
		String nomDuService = getFile().readUTF();
		String codeDeService = getFile().readUTF();
		String commentaires = getFile().readUTF();
		double montant = getFile().readDouble();

		return montant;

	}

}
