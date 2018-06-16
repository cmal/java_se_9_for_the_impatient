package ch06.ex;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.IntFunction;
import java.lang.reflect.*;
import java.lang.annotation.*;

public class FundamentalFail {

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i ++)
            result[i] = obj;
        return result;
    }

    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            result.add(obj);
        return result;
    }

    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (T t : objs) {
                result.add(t);
            }
        }
        return result.toArray(objs);
    }

    @SafeVarargs
    public static final <T> T[] construct(int n, T... arr) {
        return Arrays.copyOf(arr, n);
    }

    public static String genericDeclaration(Method m) {
        // TYPE
        TypeVariable<Method>[] types = m.getTypeParameters();
        String typeStr = "<";
        for (TypeVariable<Method> type : types) {
            typeStr += type.getName();
            typeStr += ",";
        }
        if (types.length > 0)
            typeStr = typeStr.substring(0, typeStr.length() - 1);
        typeStr += "> ";

        // RETURN TYPE
        AnnotatedType at = m.getAnnotatedReturnType();
        typeStr += at.getType().getTypeName();
        typeStr += " ";
        typeStr += m.getName();

        // PARAM LIST
        Type[] tps = m.getGenericParameterTypes();
        typeStr += "(";
        for (Type tp : tps) {
            typeStr += tp.getTypeName();
            typeStr += ", ";
        }
        if (tps.length > 0)
            typeStr = typeStr.substring(0, typeStr.length() - 2);
        typeStr += ")";

        return typeStr;
    }

    public static void main(String[] args) {
        Integer[] ints = repeat(10, 1, Integer[]::new);
        Integer[] ints2 = repeat(3, 1, 2, 3);
        for (Integer i : ints2) {
            System.out.println(i);
        }
        List<String>[] lst =
            FundamentalFail.<List<String>>construct(10, new ArrayList<String>());
        System.out.println(lst.length);
        for (List<String> ls : lst) {
            System.out.println(ls);
        }
        try {
            Method m = FundamentalFail.class.getMethod("repeat", int.class, Object.class, IntFunction.class);
            String dec = genericDeclaration(m);
            System.out.println(dec);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



    }
}
