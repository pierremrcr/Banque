package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.BanqueLocale;
import metier.entities.Compte;

@Stateless
@Path("/")
public class BanqueRestService {
	
	@EJB
	private BanqueLocale metier;

	@POST
	@Path("/compte")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte addCompte(Compte compte) {
		return metier.addCompte(compte);
	}
	
	@GET
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam(value="code")Long code) {
		return metier.getCompte(code);
	}

	@GET
	@Path("/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> listeComptes() {
		return metier.listeComptes();
	}

	@PUT
	@Path("/comptes/verser")
	@Produces(MediaType.APPLICATION_JSON)
	public void verser(@FormParam(value="code")Long code,
			@FormParam(value="montant") double mt) {
		metier.verser(code, mt);
	}

	@PUT
	@Path("/comptes/retirer")
	@Produces(MediaType.APPLICATION_JSON)
	public void retirer(@FormParam(value="code")Long code,
			@FormParam(value="montant") double mt) {
		metier.retirer(code, mt);
	}

	@PUT
	@Path("/comptes/virement")
	@Produces(MediaType.APPLICATION_JSON)
	public void virement(
			@FormParam(value="compte1")Long code1,
			@FormParam(value="compte2")Long code2,
			@FormParam(value="montant") double mt) {
		metier.virement(code1, code2, mt);
	}
	
	

}
