package sages.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class TownDaoImpl extends AbstractDaoImpl<Town>  implements TownDao{

    public TownDaoImpl(EntityManager entityManager) {
        super(entityManager, Town.class);
    }

    @Override
    public Town findByName(String name) {
        beginTransaction();
        TypedQuery<Town> query = query("SELECT t FROM Town t WHERE t.name = :name");
        query.setParameter("name", name);
        Town town = query.getSingleResult();
        commitTransaction();
        return town;
    }
}
