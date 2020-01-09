# 자바 ORM 표준 JPA 프로그래밍 - 기본편
> https://www.inflearn.com/course/ORM-JPA-Basic

# Memo
```
public void changeTeam(Team team) {
        this.team = team;
        this.team.getMembers().add(this);
    }
```
> @ManyToOne, @OneToOne은 Default가 EAGER이다. (LAZY로 변경해주도록하자)  
@OneToMany, @ManyToMany는 반대로 Default가 LAZY
