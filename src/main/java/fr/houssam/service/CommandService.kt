package fr.houssam.service

import fr.houssam.domain.modele.Consommateur.ConsommateurRepository
import fr.houssam.domain.modele.Producteur.Repository.ProduitRepository
import fr.houssam.infrastructure.ProducteurRepository
import org.springframework.stereotype.Service

/**
 * Created by hghazala on 30/04/17.
 */
@Service
open class CommandService(val producteurRepository: ProducteurRepository,
                          val consommateurRepository: ConsommateurRepository,
                          val produitRepository: ProduitRepository) {


    //TODO
    public fun acheteUnProduitAUnProducteur(consommateurId: Long,
                                            produitId: Long,
                                            producteurId: Long) {
        val producteur = this.producteurRepository.findOne(producteurId)
        val consommateur = this.consommateurRepository.findOne(consommateurId)
        val produit = this.produitRepository.findOne(produitId)
    }
}