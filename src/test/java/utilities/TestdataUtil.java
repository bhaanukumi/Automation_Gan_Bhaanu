package utilities;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import constants.Constants;
import webdriver_manager.DriverManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestdataUtil {

    public static LinkedHashMap<String, String> testDataMap = new LinkedHashMap<String, String>();

    static Fillo fillo = new Fillo();
    static Connection connection = null;

    //    public static void loadData(String strTestDataFilePath, String strSheetName) {
    public static Map<String, String> loadData(String strTestDataFilePath, String strSheetName) {
        try {
            connection = fillo.getConnection(strTestDataFilePath);

            System.out.println("Sheetname/App mentioned in Maven Goals is 6: "+strSheetName);

            Recordset recordset = connection.executeQuery("select * from ".concat(strSheetName));

            System.out.println("recordset is 7: "+recordset);

            while (recordset.next()) {

                String strEnv =Constants.ENV_VARIABLE_ENVIRONMENT;

                System.out.println("Column Name or Environment mentioned in Maven Goals is 8: "+strEnv);

                testDataMap.put(recordset.getField(Constants.TESTDATA_FIELDS).toUpperCase(), recordset.getField(strEnv));

                System.out.println("Test Data Key: "+Constants.TESTDATA_FIELDS);
                System.out.println("Test Data Value Pair: "+strEnv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        System.out.println("testDataMap is: "+testDataMap);
        return testDataMap;
    }


    // Update method updates password in excel for Change Password function alone
    public static void updateData(String strTestDataFilePath, String strSheetName, String strDataName, String strDataValue) {
        Fillo fillo = new Fillo();
        Connection connection = null;

        try {

            connection = fillo.getConnection(strTestDataFilePath);

            /**
             * Sample update Query
             * Update SheetName Set QA='Datavalue' where DataFields='DataName'
             **/
            //System.getProperty(Constants.ENV_VARIABLE_ENVIRONMENT)
            connection.executeUpdate("Update ".concat(strSheetName)
                    .concat(" Set ").concat("QA")
                    .concat("='").concat(strDataValue).concat("' where ")
                    .concat(Constants.TESTDATA_FIELDS).concat("='").concat(strDataName).concat("'"));

            connection.executeUpdate("Update ".concat(strSheetName)
                    .concat(" Set ").concat("PROD")
                    .concat("='").concat(strDataValue).concat("' where ")
                    .concat(Constants.TESTDATA_FIELDS).concat("='").concat(strDataName).concat("'"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public static long getRandomID() {
        long executionID = Math.round(Math.random() * 100000);
        return executionID;
    }

    public static String getValue(String strKey) {
        String strValue = strKey;
        String strRandomPattern = Constants.RANDOM_STRING;
        String strRegularExpressionPattern = "&(.*)&";
        try {
            if (strValue.matches(strRegularExpressionPattern)) {

                System.out.println("----> getValue matches regular expression is : "+strValue);
                strValue = PatternHandlerUtil.getMatchContent(strRegularExpressionPattern, strValue);
                System.out.println("----> getValue PatternHandlerUtil is : "+strValue);
                if (System.getProperties().containsKey(strValue.toUpperCase().trim())) {

                    System.out.println("----> Inside if contains key getValue is 1 : "+strValue);
                    strValue = System.getProperties().get(strValue.toUpperCase().trim()).toString();
                    System.out.println("----> Inside if contains key getValue is 2 : "+strValue);
                }
                // 'strKey' value add a Random Value(Execution ID)
                else if (strValue.contains(strRandomPattern)) {
                    strValue = strValue.split(strRandomPattern)[0];
                    strValue = testDataMap.get(strValue).toString();
                    strValue = strValue.concat(String.valueOf(DriverManager.strExecutionID));
                    System.out.println("----> getValue first else if is : "+strValue);
                } else {
                    strValue = testDataMap.get(strValue).toString();
                    System.out.println("----> getValue else is : "+strValue);
                }
            } else if (strKey.contains(strRandomPattern) && !(strValue.matches(strRegularExpressionPattern))) {
                strValue = strValue.split(strRandomPattern)[0];
                strValue = strValue.concat(String.valueOf(DriverManager.strExecutionID));
                System.out.println("----> getValue last else if is : "+strValue);
            }

            System.out.println("----> getValue value is : "+strValue);
        } catch (Exception e) {
            System.out.println("----> Exception For TestData getValue :: " + e.getMessage());
        }
        return strValue;
    }

    /*@Description: Get a list of values in Excel sheet*/
    public static List<String> getListOfValue(String strKey) {
        String strValue = strKey;
        String strRegularExpressionPattern = "&(.*)&";
        List<String> lstValue = new ArrayList<>();
        try {
            if (strValue.matches(strRegularExpressionPattern)) {
                strValue = PatternHandlerUtil.getMatchContent(strRegularExpressionPattern, strValue);
                String strActualData = testDataMap.get(strValue);
                String[] strSplits = strActualData.split(";");

                for (String strData : strSplits) {
                    lstValue.add(strData);
                }
            }
            System.out.println("----> getListOfValue value is : "+lstValue);
        } catch (Exception e) {
            System.out.println("----> Exception For TestData getValue :: " + e.getMessage());
            lstValue.add("No Data Found");
        }
        return lstValue;
    }

}

