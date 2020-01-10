package org.jpa.study.entity.period;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/* @Embeddable : 값 타입을 정의하는 곳에 표시
*  @Embedded : 값 타입을 사용하는 곳에 표시
* */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Period {

    @Column(name = "create_date")
    private LocalDateTime createDT;

    @Column(name = "modify_date")
    private LocalDateTime modifyDT;


}
