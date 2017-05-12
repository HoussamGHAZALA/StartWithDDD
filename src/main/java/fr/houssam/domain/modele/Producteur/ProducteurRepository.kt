package fr.houssam.domain.modele.Producteur

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by hghazala on 03/05/17.
 */
@Repository
open interface ProducteurRepository: JpaRepository<ProducteurEntity, Long> {

}