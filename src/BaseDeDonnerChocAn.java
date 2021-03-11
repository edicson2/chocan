import java.io.*; 

/**
 * 
 * @author judelin et Edicson
 *
 */
public abstract class BaseDeDonnerChocAn implements AutoCloseable {

	private RandomAccessFile file;


	public static final int INT_SIZE = 4;
	public static final int DOUBLE_SIZE = 8;
	public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE;

	/**
	 * 
	 * @return qui retourne un fichier
	 */

	public RandomAccessFile getFile(){
		return this.file; 
	}


	public BaseDeDonnerChocAn()
	{
		file = null;
	}

	/**
	 * 
	 * @param qui ouvre un fichier
	 * @throws IOException
	 */
	public void open(String filename)
			throws IOException
	{
		if (file != null) { file.close(); }
		file = new RandomAccessFile(filename, "rw");
	}
	/**
	 * 
	 * @return retourne la longueur
	 * @throws IOException
	 */

	public int size()
			throws IOException
	{
		return (int) (file.length() / RECORD_SIZE);
	}


	public void close()
			throws IOException
	{
		if (file != null) { file.close(); }
		file = null;
	}

}
