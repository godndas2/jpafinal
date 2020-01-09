package org.jpa.study.entity.items;

import org.jpa.study.entity.ItemEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class BookEntity extends ItemEntity {

    private String author;
    private String isbn;
}
