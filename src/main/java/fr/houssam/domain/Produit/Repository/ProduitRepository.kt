package fr.houssam.domain.modele.Producteur.Repository

import fr.houssam.domain.modele.Producteur.entity.ProduitEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by hghazala on 03/05/17.
 */
@Repository
open interface ProduitRepository: JpaRepository<ProduitEntity, Long> {

}