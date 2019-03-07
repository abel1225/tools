package me.abel.utils.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @program: automobile_dev
 * @description:
 * @author: able.li
 * @create: 2018-07-17 17:43
 */
public class JsonTypeBuilder implements ParameterizedType {

    private final Class raw;
    private final Type[] args;

    public JsonTypeBuilder(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }
    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }
    @Override
    public Type getRawType() {
        return raw;
    }
    @Override
    public Type getOwnerType() {return null;}

}
