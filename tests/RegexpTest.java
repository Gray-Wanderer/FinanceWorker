import com.mishunin.db.DbWorker;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrey on 23.04.2016.
 */
@Ignore
public class RegexpTest extends TestCase {

    public void testDbExists() {
        try {
            try (Connection connection = DbWorker.getInstance().getConnection()) {
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                ResultSet resultSet = databaseMetaData.getTables(null, null, "SYS_PROPERTIES", null);
                Assert.assertTrue(resultSet.next());
            } finally {
                DbWorker.getInstance().close();
            }
        } catch (SQLException e) {
            throw new AssertionError(e);
        }
    }

    public void testRegexp() {
        Pattern p = Pattern.compile("^a*d$");

        Matcher m = p.matcher("aaaaaaaaaaaad");
        Assert.assertTrue(m.matches());
        m = p.matcher("d");
        Assert.assertTrue(m.matches());
    }

}
