package memberEx;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 50
)
public class MemberEx01 {

    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    ) // 고유 키값
    // 이 전략ㅇ늘 사용하면 디비에서 할당해주는 숫자만큼만 고유키값을 생성해주므로
    // 동시성 문제를 해결할수 있다
    private Long id;

    private int age;

    @Column(name = "name") // 컬럼의 이름을 정할수 있다
    private String name;

    @Enumerated(EnumType.STRING) // 어넘타입도 넣을수 있음  기본은 숫자형식
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 타임 스탬프 타입 넣는방법
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifyDate;

    // 이거로 사용 가능
//    private LocalDate localDate;
//    private LocalDateTime localDateTime;

    @Lob // varchar 을 넘어서는 무언가를 넣을때
    private String description;

    @Transient // 칼럼에 추가하지 않고 로직에서 만 사용하고 싶을때
    private int temp;

    public MemberEx01() { // 엔티티는 생성자를 무조건전적으로 필요함
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
