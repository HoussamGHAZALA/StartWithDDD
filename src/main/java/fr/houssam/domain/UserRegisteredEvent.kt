package fr.houssam.domain

import fr.houssam.domain.modele.Producteur.ProducteurEntity
import org.springframework.context.ApplicationEvent

/**
 * Created by hghazala on 30/04/17.
 */
open class UserRegisteredEvent(source: ProducteurEntity): ApplicationEvent(source)