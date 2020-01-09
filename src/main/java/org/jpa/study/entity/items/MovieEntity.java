package org.jpa.study.entity.items;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MOVIE")
public class MovieEntity extends ItemEntity {

    private String director;
    private String actor;
}
