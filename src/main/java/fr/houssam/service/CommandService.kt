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

    
    public fun ajouteUnProduitAUnPanier(produitId: Long, consommateurId: Long) {
        val consommateur = this.consommateurRepository.findOne(consommateurId)
        val produit = this.produitRepository.findOne(produitId)
        consommateur.panier.produits.add(produit)
        consommateurRepository.save(consommateur)
    }

    public fun acheterUnProduitAUnProducteur(consommateurId: Long,
                                             produitId: Long,
                                             producteurId: Long) {
        val producteur = this.producteurRepository.findOne(producteurId)
        val consommateur = this.consommateurRepository.findOne(consommateurId)
        //TODO We can add Event of payment
        producteur.produitsEnVente.removeAll(
                consommateur.panier.produits
        )
        producteurRepository.save(producteur)
    }

}