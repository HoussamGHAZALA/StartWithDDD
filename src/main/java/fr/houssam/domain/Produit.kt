package fr.houssam.domain

import fr.houssam.valueObject.Prix
import fr.houssam.valueObject.ProduitId

/**
 * Created by hghazala on 30/04/17.
 */
open class Produit(val id: ProduitId, val prix: Prix, val quantite: Int) {

}
