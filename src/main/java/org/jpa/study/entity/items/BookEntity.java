package org.jpa.study.entity.items;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class BookEntity extends ItemEntity {

    private String author;
    private String isbn;
}
