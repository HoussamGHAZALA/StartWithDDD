package fr.houssam.domain

import fr.houssam.domain.modele.Producteur.entity.ProduitEntity
import org.springframework.context.ApplicationEvent

/**
 * Created by hghazala on 30/04/17.
 */
open class PrixModifiedEvent(val produit: ProduitEntity,
                             sensPrix: SensPrix): ApplicationEvent(produit){

}