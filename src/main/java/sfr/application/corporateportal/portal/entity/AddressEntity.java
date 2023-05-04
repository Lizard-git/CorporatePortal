package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Address", schema = "dashboard")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 100, message = "Название города не может быть более 100 символов")
    @NotEmpty(message = "Город обязателен к заполнению")
    @UniqueElements(message = "Город уже существует в базе данных")
    @Column(name = "city" , nullable = false, unique = true, length = 100)
    private String city;

    @Size(max = 100, message = "Название улицы не может быть более 100 символов")
    @NotEmpty(message = "Улица обязателена к заполнению")
    @UniqueElements(message = "Улица уже существует в базе данных")
    @Column(name = "street" , nullable = false, unique = true, length = 100)
    private String street;

    @Size(max = 50, message = "Номер/Название здания не может быть более 50 символов")
    @NotEmpty(message = "Номер/Название здания обязателен к заполнению")
    @UniqueElements(message = "Номер/Название здания уже существует в базе данных")
    @Column(name = "house" , nullable = false, unique = true, length = 50)
    private String house;

    @Size(max = 20, message = "Корпус не может быть более 20 символов")
    @Column(name = "frame", length = 20)
    private String frame;
}
