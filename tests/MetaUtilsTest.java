import com.mishunin.utils.MetaUtils;
import junit.framework.TestCase;
import org.junit.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 25.04.2016.
 */
public class MetaUtilsTest extends TestCase {

    public static class SimpleClass {
        private String id;
        private Integer countValues;
        private Boolean editableEntity;
        private Boolean enable;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getCountValues() {
            return countValues;
        }

        public void setEditableEntity(Boolean editableEntity) {
            this.editableEntity = editableEntity;
        }

        public Boolean isEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }
    }

    public void testMetaProperties() {
        List<Method> methodList = MetaUtils.getAllGetters(SimpleClass.class);
        List<String> methodNames = new ArrayList<>();
        methodList.forEach(method -> methodNames.add(method.getName()));
        Assert.assertTrue(methodNames.contains("getId"));
        Assert.assertTrue(methodNames.contains("getCountValues"));
        Assert.assertTrue(methodNames.contains("isEnable"));

        List<String> getterPropNames = MetaUtils.getAllGettersParamNames(SimpleClass.class);
        Assert.assertTrue(getterPropNames.contains("id"));
        Assert.assertTrue(getterPropNames.contains("countValues"));
        Assert.assertTrue(getterPropNames.contains("enable"));
        Assert.assertTrue(!getterPropNames.contains("editableEntity"));
    }

}
