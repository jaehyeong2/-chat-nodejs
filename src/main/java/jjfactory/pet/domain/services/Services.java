package jjfactory.pet.domain.services;

import jjfactory.pet.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Builder
public class Services extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "service_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
}
