package org.jpa.study.entity.items;

import org.jpa.study.entity.ItemEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ALBUM") // DTYPE 의 Value 값 지정
public class AlbumEntity extends ItemEntity {

    private String artist;
}
