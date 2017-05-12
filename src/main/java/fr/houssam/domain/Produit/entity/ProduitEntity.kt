package fr.houssam.domain.modele.Producteur.entity

import fr.houssam.valueObject.Prix
import fr.houssam.valueObject.ProduitId
import javax.persistence.Entity

/**
 * Created by hghazala on 01/05/17.
 */
@Entity
open class ProduitEntity(val id: ProduitId, val prix: Prix, val quantite: Int) {

}