package com.juhunuque.entity;

import com.juhunuque.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDao userDao;

    @Test
    public void whenFindByName_thenReturnUser() {
        //given
        User user = new User("Julio", SpecialisationCategory.SPECIALISATION1);

        //when
        User found = userDao.findUserByName(user.getName());

        //then
        assertThat(found.getName())
            .isEqualTo(user.getName());
    }
}
