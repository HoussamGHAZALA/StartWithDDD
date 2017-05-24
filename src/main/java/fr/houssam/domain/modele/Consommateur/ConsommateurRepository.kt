package fr.houssam.domain.modele.Consommateur

import fr.houssam.domain.modele.Producteur.ProducteurEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by hghazala on 12/05/17.
 */
@Repository
open interface ConsommateurRepository: JpaRepository<ConsommateurEntity, Long> {

}