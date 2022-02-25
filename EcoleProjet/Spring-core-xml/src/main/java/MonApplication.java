import entity.Batteur;
import entity.Musicien;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MonApplication {
    public static void main(String[] args) {
        // charger le context spring depuis le fichier de configuration xml
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //récupérer un bean depuis le container
        Batteur batteur = context.getBean("unBatteur", Batteur.class);
        // appeler une méthode sur le bean
        // ... on verra cela plus tard ...
        System.out.println(batteur.joueTaPartition());
        System.out.println(batteur.getPrepa());
        // Appeler les variables dont les valeurs sont injectées en xml
        System.out.println(batteur.getEmailAddresse());
        System.out.println(batteur.getSite());
        // fermer le contexte
        context.close();
    }
}
