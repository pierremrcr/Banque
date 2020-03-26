package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.BanqueLocale;
import metier.entities.Compte;

@WebService
public class BanqueService {

	@EJB
	private BanqueLocale metier;

	@WebMethod
	public void verser(@WebParam(name="code")Long code,
					   @WebParam(name="montant") double mt) {
		metier.verser(code, mt);
	}

	@WebMethod
	public void retirer(@WebParam(name="code")Long code,
						@WebParam(name="montant") double mt) {
		metier.retirer(code, mt);
	}

	@WebMethod
	public void virement(@WebParam(name="compte1")Long code1,
						 @WebParam(name="compte2")Long code2,
						 @WebParam(name="montant") double mt) {
		metier.virement(code1, code2, mt);
	}
	
	@WebMethod
	public Compte addCompte(@WebParam(name="solde")double solde) {
		Compte compte = new Compte();
		compte.setSolde(solde);
		compte.setDateCreation(new Date());
		return metier.addCompte(compte);
	}

	@WebMethod
	public Compte getCompte(@WebParam(name="code")Long code) {
		Compte compte = metier.getCompte(code);
		return compte;
	}
	
	@WebMethod
	public List<Compte> listeComptes(){
		List<Compte> listeComptes = metier.listeComptes();
		return listeComptes;
	}
}
