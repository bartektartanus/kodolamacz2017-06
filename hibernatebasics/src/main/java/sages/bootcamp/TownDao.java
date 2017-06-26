package sages.bootcamp;

public interface TownDao extends AbstractDao<Town> {

    Town findByName(String name);

}
