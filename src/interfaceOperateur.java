import java.io.IOException;

public interface interfaceOperateur {
	public void AjouterDonnerFournisseur() throws IOException;
	public void AjouterDonnerMembre() throws IOException;

	public void supprimerDonnerFournisseur() throws IOException;


	public void supprimerDonnerMembre() throws IOException;

	public void AfficherOperer() throws IOException;
}