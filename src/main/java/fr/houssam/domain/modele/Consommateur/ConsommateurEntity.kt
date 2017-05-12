package fr.houssam.domain.modele.Consommateur

import fr.houssam.domain.PrixModifiedEvent
import org.hibernate.validator.constraints.Email
import org.springframework.context.event.EventListener
import org.springframework.data.domain.AbstractAggregateRoot
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by hghazala on 12/05/17.
 */
@Entity
open class ConsommateurEntity(@Id
                              val consommateurId: Long,
                              val consommateurAdresseEmail: Email
                              ): AbstractAggregateRoot() {

    @EventListener(condition = "#prixModifiedEvent.sensPrix == BAISSE")
    public fun notifyByMail(prixModifiedEvent: PrixModifiedEvent) {
        registerEvent(MailNotification(consommateurAdresseEmail,
                "Baisse de prix",
                "Bonjour, profitez de cette baisse de prix")
        )
    }
}

class Region(var nomRegion: String,
             var codeRegion: Long)
class MailNotification(email: Email, subject: String, text: String)