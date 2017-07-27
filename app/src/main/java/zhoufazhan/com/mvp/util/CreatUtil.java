package zhoufazhan.com.mvp.util;

import java.lang.reflect.ParameterizedType;

/**
 * Created by zhoufazhan on 2017/7/27.
 */

public class CreatUtil {
    /**
     * 获取T类型然后自动new出对象
     * @param o
     * @param i
     * @param <T>
     * @return
     */
    public static <T> T getT(Object o, int i) {

        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
