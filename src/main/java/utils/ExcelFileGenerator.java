package utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import model.ProblemInstanceInfo;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileGenerator {
    public static void generateExcelFile(List<ProblemInstanceInfo> problemInstanceInfoList,String outputpath) {

        ExportParams exportParams = new ExportParams("问题实例信息", "数据表");

        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ProblemInstanceInfo.class, problemInstanceInfoList);

        // 写入到本地文件
        File saveFile = new File(outputpath);
        try (FileOutputStream fos = new FileOutputStream(saveFile)) {
            workbook.write(fos);
            System.out.println("Excel导出成功，保存路径: " + saveFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("导出Excel失败: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                System.err.println("关闭Workbook失败: " + e.getMessage());
            }
        }
    }
}
