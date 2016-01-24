package guru.zaidel.model;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Alexander on 24.01.2016.
 */
@Entity
public class EmployeeSimpleMap {
    @Id
    private Long nondef_id;

    /*
    @Id
    private Long id;

    @ElementCollection
    private Map<String, String> phoneNumbers;

    create table EmployeeSimpleMap_phoneNumbers (
        EmployeeSimpleMap_id bigint not null,
        phoneNumbers varchar(255),
        phoneNumbers_KEY varchar(255) not null,
        primary key (EmployeeSimpleMap_id, phoneNumbers_KEY)
    )

    default suffix  is KEY
    */


    /*
    @ElementCollection
    @CollectionTable(name = "PHONE_NUMBERS_TABLE")
    @MapKeyColumn(name="phoneN_key")
    @Column(name="column_phone_numbers")

    create table PHONE_NUMBERS_TABLE (
        EmployeeSimpleMap_nondef_id bigint not null,
        column_phone_numbers varchar(255),
        phoneN_key varchar(255) not null,
        primary key (EmployeeSimpleMap_nondef_id, phoneN_key)
    )
    */
    @ElementCollection
    @CollectionTable(name = "PHONE_NUMBERS_TABLE")
    @MapKeyColumn(name="phoneN_key")
    @Column(name="column_phone_numbers")
    private Map<String, String> phoneNumbers;

    @ElementCollection
    @CollectionTable(name = "PHONE_NUMBERS_ENUM_TABLE")
    @MapKeyColumn(name="STRING_KEY")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name="column_phone_numbers")
    private Map<PhoneType, String> phoneNumbersEnum;

    public EmployeeSimpleMap() {
    }

    public EmployeeSimpleMap(Long id) {
        this.nondef_id = id;
    }

    public Long getId() {
        return nondef_id;
    }

    public void setId(Long id) {
        this.nondef_id = id;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Map<PhoneType, String> getPhoneNumbersEnum() {
        return phoneNumbersEnum;
    }

    public void setPhoneNumbersEnum(Map<PhoneType, String> phoneNumbersEnum) {
        this.phoneNumbersEnum = phoneNumbersEnum;
    }
}
