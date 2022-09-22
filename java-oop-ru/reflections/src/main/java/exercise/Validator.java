package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> validatedList = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
            if (notNullAnnotation != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        validatedList.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return validatedList;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> outMap = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
            if (notNullAnnotation != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        outMap.put(field.getName(), List.of("can not be null"));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
            if (minLengthAnnotation != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) != null) {
                        if (field.get(address).toString().length() < minLengthAnnotation.minLength()) {
                            outMap.put(field.getName(),
                                    List.of("length less than " + minLengthAnnotation.minLength()));
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return outMap;
    }
}
// END
