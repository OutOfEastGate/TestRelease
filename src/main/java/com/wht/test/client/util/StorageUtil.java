package com.wht.test.client.util;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 16:16
 */
public class StorageUtil {
    public static ThreadLocal<String> threadLocal;

    static {
        threadLocal = new ThreadLocal<>();
    }

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static String get() {
        return threadLocal.get();
    }

    public static void remove() {
        if (threadLocal.get()!=null)
        threadLocal.remove();
    }
}
