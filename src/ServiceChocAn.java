/**
 * 
 * @author judelin et Edicson
 *
 */

public class ServiceChocAn {

	private String NomService;
	private int codeDeService;
	private double FraisDeService;
	private String dateDuService;


	public String getDateDuService() {
		return dateDuService;
	}


	public void setDateDuService(String dateDuService) {
		this.dateDuService = dateDuService;
	}


	public ServiceChocAn() {

		this.NomService ="";
		this.codeDeService = 0;
		this.FraisDeService = 0;
	}


	public ServiceChocAn(String service, int codeDeService, double fraisDeService) {

		this.NomService = service;
		this.codeDeService = codeDeService;
		this.FraisDeService = fraisDeService;
	}

	@Override
	public String toString() {
		return "ServiceChocAn [service=" + NomService + ", codeDeService=" + codeDeService + ", FraisDeService="
				+ FraisDeService + ", getService()=" + getNomService() + ", getCodeDeService()=" + getCodeDeService()
				+ ", getFraisDeService()=" + getFraisDeService() + "]";
	}
	public String getNomService() {
		return NomService;
	}
	public void setNomService(String service) {
		this.NomService = service;
	}
	public int getCodeDeService() {
		return codeDeService;
	}
	public void setCodeDeService(int codeDeService) {
		this.codeDeService = codeDeService;
	}
	public double getFraisDeService() {
		return FraisDeService;
	}

	public void setFraisDeService(double fraisDeService) {
		FraisDeService = fraisDeService;
	}


}