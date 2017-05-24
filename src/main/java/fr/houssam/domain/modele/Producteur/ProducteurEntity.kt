package fr.houssam.domain.modele.Producteur

import fr.houssam.domain.PrixModifiedEvent
import fr.houssam.domain.SensPrix.BAISSE
import fr.houssam.domain.SensPrix.HAUSSE
import fr.houssam.domain.modele.Producteur.entity.ProduitEntity
import fr.houssam.domain.Produit.event.ProductEvent
import fr.houssam.domain.UserRegisteredEvent
import fr.houssam.valueObject.Prix
import org.springframework.data.domain.AbstractAggregateRoot
import javax.persistence.*

/**
 * Created by hghazala on 30/04/17.
 */
@Entity
open class ProducteurEntity(@Id
                            val producteurId: Long,
                            val nom: String,
                            val prenom: String,
                            val email: String,
                            val password: String,
                            val region: Long,
                            @OneToMany(mappedBy="ProduitEntity",
                                       cascade = arrayOf(CascadeType.ALL))
                            val produitsEnVente: MutableList<ProduitEntity>): AbstractAggregateRoot() {

    //Cette entité métier ne doit être couplée a aucun mécanisme technique.
    //Entities managed by repositories are aggregate roots.
    //In a Domain-Driven Design application, these aggregate roots usually
    //publish domain events. Spring Data provides an annotation @DomainEvents
    //you can use on a method of your aggregate root to make that publication
    //as easy as possible.

    //Je peux m'inscrire sur le site de mise en vente de produits
    public fun ProducteursInscritAuSitePourMettreEnVenteDesProduits(email: String,
                                                                    password: String) {
        //TODO: To be moved to a specification responsability
        if(email.contains("@") && password.length > 10) {
            registerEvent(UserRegisteredEvent(this))
        } else {
            throw UserInscriptionException("Mauvais identifiants")
        }

    }

    // Je peux mettre en vente un produit
    public fun metEnVente(produit: ProduitEntity, prix: Prix) {
        if(this.miseEnVenteAutorisee(produit)) {
            this.produitsEnVente.add(produit)
            registerEvent(ProductEvent(produit))
        } else {
            throw NonAuthorizedProduct()
        }
    }

    // Je peux changer le prix d'un produit, et envoyer une
    // notifications aux consommateurs
    // TODO : event handler dans consommateur component pour l'event PrixModifiedEvent
    // see : http://www.baeldung.com/spring-events
    public fun changeLePrix(produit: ProduitEntity, prix: Prix) {
        if(prix.montant < produit.prix.montant) {
            registerEvent(PrixModifiedEvent(produit, BAISSE))
        } else {
            if(prix.montant > produit.prix.montant) {
                registerEvent(PrixModifiedEvent(produit, HAUSSE))
            }
        }
    }

    private fun miseEnVenteAutorisee(produit: ProduitEntity): Boolean {
        //TODO implemeter le pattern Specification
        return true;
    }
}

class NonAuthorizedProduct : Throwable()

class UserInscriptionException(s: String) : Throwable()
