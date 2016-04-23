import com.mishunin.currency.CurrencyWorker;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author mishunin
 * @version $Id$
 */
public class CurrencyWorkerTest extends TestCase {

    CurrencyWorker currencyWorker = new CurrencyWorker();
    String usdCode = "R01235";

    public void testConnection() throws Exception {
        Assert.assertNotNull(currencyWorker.loadCurrency(usdCode));
    }

}
