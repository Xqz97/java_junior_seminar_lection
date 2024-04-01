package lection.lection_4.project;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

/*        Connector connector = new Connector();
        Session session = connector.getSession();
        Magic magic = new Magic("Волшебная стрела", 10, 0);
        session.beginTransaction();
        session.save(magic);
        magic = new Magic("Молния", 25, 0);
        session.save(magic);
        magic = new Magic("Каменная кожа", 0, 0);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6);
        session.save(magic);
        magic = new Magic("Проклятие", 0, -3);
        session.save(magic);
        magic = new Magic("Лечение", -30, 0);
        session.save(magic);
        session.getTransact ion().commit();
        session.close();*/
        Connector connector = new Connector();
         try (Session session = connector.getSession()) {
            List<Magic> books = session.createQuery("FROM Magic",
                    Magic.class).getResultList();
            books.forEach(b -> {
                System.out.println("Book of Magic : " + b);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* try (Session session = connector.getSession()) {
            String hql = "from Magic where id = :id";
            Query<Magic> query = session.createQuery( hql, Magic.class);
            query.setParameter("id", 4);
            Magic magic = query.getSingleResult();
            System.out.println(magic);
            magic.setAttBonus(12);
            magic.setName("Ярость");
            session.beginTransaction();
            session.update(magic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }*/




    }
}
