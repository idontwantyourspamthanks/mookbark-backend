package uk.co.mookbark.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "favourite")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
public class DAOFavourite implements DAOBase {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private final Long ownerId;
    private final String name, url, description;
    private final LocalDate dateAdded;
    private final LocalDate dateLastAccessed;
    private final int hitCount;

}
