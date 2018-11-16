package airfare.mvc.dao.prototype;

import java.io.File;

/**
 * Created by Max Hluhov on 16.11.2018.
 */
public class JavaIOUtilFactory<T> {
    private JavaIOUtil javaIOUtil;

    public JavaIOUtilFactory(File file, T t) {
        javaIOUtil = new JavaIOUtil<>(file, t);
    }

    public JavaIOUtil cloneJIOU() {
        return (JavaIOUtil) javaIOUtil.copy();
    }
}
