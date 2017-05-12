package fr.houssam.domain.service

import fr.houssam.domain.modele.Consommateur.ConsommateurRepository
import fr.houssam.domain.modele.Consommateur.Region
import fr.houssam.domain.modele.Producteur.ProducteurEntity
import fr.houssam.domain.modele.Producteur.entity.ProduitEntity
import fr.houssam.infrastructure.ProducteurRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

/**
 * Created by douihech on 12/05/17.
 */
@Service
open class ConsommateurService(val consommateurRepository: ConsommateurRepository,
                               val producteurRepository: ProducteurRepository) {

    public fun consulteLaListeDeProducteursParRegion(region: Region): List<ProducteurEntity> {
        return producteurRepository.findByRegion(region.codeRegion)
    }
}