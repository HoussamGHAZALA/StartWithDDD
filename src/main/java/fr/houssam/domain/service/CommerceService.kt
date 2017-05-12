package fr.houssam.domain.service

import fr.houssam.domain.PrixModifiedEvent
import fr.houssam.domain.modele.Producteur.Repository.ProduitRepository
import fr.houssam.domain.modele.Producteur.entity.ProduitEntity
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

/**
 * Created by hghazala on 03/05/17.
 */
@Component
open class CommerceService(private var produitRepository: ProduitRepository) {

    @EventListener
    public fun updatePrixProduit(prixModifiedEvent: PrixModifiedEvent): ProduitEntity =
        produitRepository.save(prixModifiedEvent.produit)
}