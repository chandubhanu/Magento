package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginExcel {

    @DataProvider(name = "loginData")
    public Object[][] getCredentials() throws IOException {
        List<String[]> credentialsaslist = new ArrayList<>();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Resources\\Login_Details.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            XSSFSheet sheet = wb.getSheetAt(i);

            if (sheet.getSheetName().equalsIgnoreCase("sheet1")) {
                Row headerRow = sheet.getRow(0);
                int usernameCol = -1;
                int passwordCol = -1;

                for (Cell cell : headerRow) {
                    if (cell.getStringCellValue().equalsIgnoreCase("Username")) {
                        usernameCol = cell.getColumnIndex();
                    } else if (cell.getStringCellValue().equalsIgnoreCase("Password")) {
                        passwordCol = cell.getColumnIndex();
                    }
                }

                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);

                    String Username = row.getCell(usernameCol).getStringCellValue();
                    String Password = row.getCell(passwordCol).getStringCellValue();

                    credentialsaslist.add(new String[] { Username, Password });
                }
                break;
            }
        }

        wb.close();
        fis.close();

        Object[][] data = new Object[credentialsaslist.size()][2];
        for (int i = 0; i < credentialsaslist.size(); i++) {
            data[i][0] = credentialsaslist.get(i)[0];
            data[i][1] = credentialsaslist.get(i)[1];
        }

        return data;
    }
}
