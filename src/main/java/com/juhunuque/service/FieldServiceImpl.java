package com.juhunuque.service;

import com.juhunuque.dao.FieldDao;
import com.juhunuque.entity.CropTypeCategory;
import com.juhunuque.entity.Field;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldDao fieldDao;

    public List<Field> getAll() {
        return fieldDao.findAllByOrderByIdAsc();
    }

    public Field getById(final Long id) {
        return fieldDao.findFieldById(id);
    }

    public Field addNew(final String name, final String cropType, final BigDecimal latitude, final BigDecimal longitude) {
        CropTypeCategory cropTypeCategory = CropTypeCategory.valueOf(cropType.toUpperCase());
        Field field = new Field(name, cropTypeCategory, latitude, longitude);
        fieldDao.save(field);
        return field;
    }

    public Field deleteById(final Long id) {
        Field field = fieldDao.findFieldById(id);
        fieldDao.delete(field);
        return field;
    }

    public List<Field> find(final JSONObject jsonObject) {
        String fieldName = jsonObject.containsKey("fieldName") && !jsonObject.get("fieldName").equals("")
                ? (String) jsonObject.get("fieldName") : null;
        String fieldCropType = jsonObject.containsKey("fieldCropType") && !jsonObject.get("fieldCropType").equals("")
                ? (String) jsonObject.get("fieldCropType") : null;
        String fieldLatitude = jsonObject.containsKey("fieldLatitude") && !jsonObject.get("fieldLatitude").equals("")
                ? (String) jsonObject.get("fieldLatitude") : null;
        String fieldLongitude = jsonObject.containsKey("fieldLongitude") && !jsonObject.get("fieldLongitude").equals("")
                ? (String) jsonObject.get("fieldLongitude") : null;
        String userName = jsonObject.containsKey("userName") && !jsonObject.get("userName").equals("")
                ? (String) jsonObject.get("userName") : null;
        String userSpecialization = jsonObject.containsKey("userSpecialization") && !jsonObject.get("userSpecialization").equals("")
                ? (String) jsonObject.get("userSpecialization") : null;
        String fcCloudinessInformation = jsonObject.containsKey("fcCloudinessInformation") && !jsonObject.get("fcCloudinessInformation").equals("")
                ? (String) jsonObject.get("fcCloudinessInformation") : null;
        Integer fcTemperature = jsonObject.containsKey("fcTemperature") && !jsonObject.get("fcTemperature").equals("")
                ? (Integer) jsonObject.get("fcTemperature") : null;
        Integer fcVegetationInformation = jsonObject.containsKey("fcVegetationInformation") && !jsonObject.get("fcVegetationInformation").equals("")
                ? (Integer) jsonObject.get("fcVegetationInformation") : null;

        String fcDateFrom = jsonObject.containsKey("fcDateFrom") && !jsonObject.get("fcDateFrom").equals("")
                ? (String) jsonObject.get("fcDateFrom") : null;
        String fcDateTo = jsonObject.containsKey("fcDateTo") && !jsonObject.get("fcDateTo").equals("")
                ? (String) jsonObject.get("fcDateTo") : null;

        return fieldDao.findAllByCustomCriteria(fieldName, fieldCropType, fieldLatitude, fieldLongitude, userName,
                userSpecialization, fcCloudinessInformation, fcTemperature, fcVegetationInformation,
                fcDateFrom, fcDateTo);
    }
}
