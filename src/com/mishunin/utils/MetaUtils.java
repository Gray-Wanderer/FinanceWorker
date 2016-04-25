package com.mishunin.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Andrey on 25.04.2016.
 */
public class MetaUtils {

    public static List<Method> getAllGetters(Class clazz) {
        return getAllGetters(clazz, method -> true);
    }

    public static List<Method> getAllGetters(Class clazz, Predicate<Method> predicate) {
        List<Method> getters = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")
                    && predicate.test(method))) {
                getters.add(method);
            }
        }
        return getters;
    }

    public static List<Method> getAllSetters(Class clazz) {
        return getAllSetters(clazz, method -> true);
    }

    public static List<Method> getAllSetters(Class clazz, Predicate<Method> predicate) {
        List<Method> setters = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            if (method.getName().startsWith("set") && predicate.test(method)) {
                setters.add(method);
            }
        }
        return setters;
    }

    public static List<String> getAllGettersParamNames(Class clazz) {
        return getAllGettersParamNames(clazz, method -> true);
    }

    public static List<String> getAllGettersParamNames(Class clazz, Predicate<Method> predicate) {
        List<String> propNames = new ArrayList<>();
        getAllGetters(clazz, predicate).forEach(method -> {
            String name = method.getName().replaceFirst("(get)|(is)", "");
            propNames.add(Character.toLowerCase(name.charAt(0)) + name.substring(1));
        });
        return propNames;
    }

    public static List<String> getAllSettersParamNames(Class clazz, Predicate<Method> predicate) {
        List<String> propNames = new ArrayList<>();
        getAllSetters(clazz, predicate).forEach(method -> {
            String name = method.getName().replaceFirst("set", "");
            propNames.add(Character.toLowerCase(name.charAt(0)) + name.substring(1));
        });
        return propNames;
    }

    public static Method findSetter(Class clazz, String paramName) {
        String setterName = String.format("set%C%s", paramName.charAt(0), paramName.substring(1));
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(setterName)) {
                return method;
            }
        }
        return null;
    }

    public static Method findGetter(Class clazz, String paramName) {
        List<String> getterNames = new ArrayList<>();
        getterNames.add(String.format("get%C%s", paramName.charAt(0), paramName.substring(1)));
        getterNames.add(String.format("is%C%s", paramName.charAt(0), paramName.substring(1)));
        for (Method method : clazz.getMethods()) {
            if (getterNames.contains(method.getName())) {
                return method;
            }
        }
        return null;
    }

}
