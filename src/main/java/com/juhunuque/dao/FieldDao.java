package com.juhunuque.dao;

import com.juhunuque.entity.Field;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FieldDao extends CrudRepository<Field, Long>, JpaSpecificationExecutor<Field> {

    List<Field> findAllByOrderByIdAsc();
    Field findFieldByName(final String name);
    Field findFieldById(final Long id);

    @Query(nativeQuery = true, value = "SELECT f.*" +
            "                           FROM field f" +
            "                           INNER JOIN (SELECT DISTINCT(f.id) AS fid FROM field f" +
            "                           INNER JOIN field_user fu ON fu.field_id = f.id" +
            "                           INNER JOIN user u ON fu.user_id = u.id" +
            "                           INNER JOIN field_condition_field fcf ON fcf.field_id = f.id" +
            "                           INNER JOIN field_condition fc ON fc.id = fcf.field_condition_id" +
            "                           INNER JOIN (SELECT f.id AS fid, (6371 * ACOS(COS(RADIANS(:fieldLatitude)) *" +
            "                           COS(RADIANS(f.latitude)) * COS(RADIANS(f.longitude) - " +
            "                           RADIANS(:fieldLongitude)) + SIN(RADIANS(:fieldLatitude)) * " +
            "                           SIN(RADIANS(f.latitude)))) AS distance " +
            "                           FROM field f) sqf ON sqf.fid = f.id" +
            "                           WHERE f.name LIKE %:fieldName%" +
            "                           OR f.crop_type LIKE %:fieldCropType%" +
            "                           OR sqf.distance < 5" +
            "                           OR u.name LIKE %:userName%" +
            "                           OR u.specialization LIKE %:userSpecialization%" +
            "                           OR fc.cloudiness_information LIKE %:fcCloudinessInformation%" +
            "                           OR fc.temperature = :fcTemperature" +
            "                           OR fc.vegetation_information = :fcVegetationInformation" +
            "                           OR (fc.created_timestamp BETWEEN :fcDateFrom AND :fcDateTo)) sqf ON sqf.fid = f.id")
    List<Field> findAllByCustomCriteria(@Param("fieldName") String fieldName, @Param("fieldCropType") String fieldCropType,
                                        @Param("fieldLatitude") String fieldLatitude, @Param("fieldLongitude") String fieldLongitude,
                                        @Param("userName") String userName, @Param("userSpecialization") String userSpecialization,
                                        @Param("fcCloudinessInformation") String fcCloudinessInformation,
                                        @Param("fcTemperature") Integer fcTemperature,
                                        @Param("fcVegetationInformation") Integer fcVegetationInformation,
                                        @Param("fcDateFrom") String fcDateFrom, @Param("fcDateTo") String fcDateTo);
}
