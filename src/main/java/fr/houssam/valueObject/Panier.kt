package fr.houssam.valueObject

import fr.houssam.domain.modele.Producteur.entity.ProduitEntity

/**
 * Created by hghazala on 24/05/17.
 */
class Panier(val produits: MutableList<ProduitEntity>)