package org.jpa.study.entity.period;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Objects;

/* @Embeddable : 값 타입을 정의하는 곳에 표시
*  @Embedded : 값 타입을 사용하는 곳에 표시
* */
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Period {

    @Column(name = "create_date")
    private LocalDateTime createDT;

    @Column(name = "modify_date")
    private LocalDateTime modifyDT;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(getCreateDT(), period.getCreateDT()) &&
                Objects.equals(getModifyDT(), period.getModifyDT());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreateDT(), getModifyDT());
    }
}
