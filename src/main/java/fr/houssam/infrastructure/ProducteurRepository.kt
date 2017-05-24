package fr.houssam.infrastructure

import fr.houssam.domain.modele.Producteur.ProducteurEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by hghazala on 30/04/17.
 */
@Repository
open interface ProducteurRepository: JpaRepository<ProducteurEntity, Long> {
    fun findByRegion(codeRegion: Long): List<ProducteurEntity>
}