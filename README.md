# 자바 ORM 표준 JPA 프로그래밍 - 기본편
> https://www.inflearn.com/course/ORM-JPA-Basic

# Memo
```
public void changeTeam(Team team) {
        this.team = team;
        this.team.getMembers().add(this);
    }
```
> @ManyToOne, @OneToOne은 Default가 EAGER이다. (LAZY로 변경해주도록하자, fetch 로 )  
@OneToMany, @ManyToMany는 반대로 Default가 LAZY  
> Cascade 는 연관관계와 관련이 없다. ( Ex : Cascade.ALL 하위 Entity 들을 따로 set 해주지 않아도 persist 된다. )  
> 값 타입은 불변으로 만들어주자 ( 무분별한 Setter는 금지, @Builder 또는 Setter를 private )
