package Reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager() {

    }

    private static ThreadLocal<ExtentTest> tr = new ThreadLocal<>();

     static ExtentTest getExtentTest() {
        return tr.get();
    }

     static void setExtentTest(ExtentTest test) {

        tr.set(test);
    }

     static void unLoad() {
        tr.remove();
    }
}
