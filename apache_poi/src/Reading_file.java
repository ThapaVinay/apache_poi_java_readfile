import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
public class Reading_file {
    public static void main(String[] args) throws IOException {
        String location = ".//datafiles//salary.xlsx";
        //String location = "/home/lonewolf/Desktop/apache_poi/datafiles/salary.xlsx";
        FileInputStream file  = new FileInputStream(location);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int row = sheet.getLastRowNum();
        int col = sheet.getRow(1).getLastCellNum();

        for(int i=0 ;i< row ;i++)
        {
            XSSFRow rows = sheet.getRow(i);

            for(int j=0; j< col ;j++)
            {
                XSSFCell cell = rows.getCell(j);
                switch(cell.getCellType())
                {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " ");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " ");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + " ");
                }
            }
            System.out.println();
        }
    }
}
