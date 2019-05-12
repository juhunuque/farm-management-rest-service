package com.juhunuque.entity;

import com.juhunuque.dao.FieldDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FieldTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FieldDao fieldDao;

    @Test
    public void whenFindByName_thenReturnField() {
        //Given
        Field field = new Field("Costa Rica", CropTypeCategory.CROPTYPECATEGORY1,
                new BigDecimal(41.40338), new BigDecimal(2.17403));

        //When
        Field found = fieldDao.findFieldByName(field.getName());

        //Then
        assertThat(found.getName())
                .isEqualTo(field.getName());
    }




}
