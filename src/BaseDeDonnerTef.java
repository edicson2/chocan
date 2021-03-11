
import java.io.IOException;
/**
 * 
 * @author judelin et Edicson
 *
 */
public class BaseDeDonnerTef extends BaseDeDonnerChocAn {
	/**
	 * 
	 * @param n qui lit une clef et retourne un founisseur
	 * @return qui retourne un fournisseur
	 * @throws IOException
	 */
	public Fournisseur read(int n)
			throws IOException

	{
		double montant=0;
		int numero=0; 

		getFile().seek(n * RECORD_SIZE);


		numero=getFile().readInt();
		montant = getFile().readDouble();

		String nomFou=getFile().readUTF();;

		//}
		return new Fournisseur(numero,montant);
	}

	/**
	 * 
	 * @param key une cle en paramettre
	 * @return qui un boolean s'il trouve la clef sinon faux
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
	 * @param key en parametre
	 * @return qui retourn la position
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
	 * @param n qui ecrire une cle
	 * @param fourni ecrire un fournisseur
	 * @throws IOException
	 */
	public void write(int n,Fournisseur fourni )
			throws IOException
	{
		getFile().seek(n * RECORD_SIZE);
		getFile().writeInt(fourni.getNumero());
		getFile().writeDouble(fourni.getMontant());


	}

}
