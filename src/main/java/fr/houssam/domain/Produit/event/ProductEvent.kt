package fr.houssam.domain.Produit.event

import fr.houssam.domain.modele.Producteur.entity.ProduitEntity
import org.springframework.context.ApplicationEvent

/**
 * Created by hghazala on 30/04/17.
 */
open class ProductEvent(source: ProduitEntity): ApplicationEvent(source)