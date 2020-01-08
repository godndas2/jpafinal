# 자바 ORM 표준 JPA 프로그래밍 - 기본편
> https://www.inflearn.com/course/ORM-JPA-Basic

# Memo
```
public void changeTeam(Team team) {
        this.team = team;
        this.team.getMembers().add(this);
    }
```
