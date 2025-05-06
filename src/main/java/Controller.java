import model.ProblemInstanceInfo;
import utils.DataCollector;
import utils.ExcelFileGenerator;
import utils.ReadResultJsonFileUtils;

import java.util.List;

public class Controller {

    public static void main(String[] args){

        //日志路径
        String logFilePath = "C:\\Users\\迪幻\\Desktop\\run-2025年4月30日20_23_33.log";

        //result结果路径
        String jsonResultFilePath = "C:\\Users\\迪幻\\Desktop\\unit-metric-scores.json";

        //excel生成路径
        String excelGemeratorFilePath = "C:\\Users\\迪幻\\Desktop\\output2.xlsx";

        // 收集处理日志输出数据
        List<ProblemInstanceInfo> problemInstanceInfoList = DataCollector.extractData(logFilePath);

        // 解析json文件并读取匹配相应的数据
        try {
            ReadResultJsonFileUtils readResultJsonFileUtils = new ReadResultJsonFileUtils();
            problemInstanceInfoList = readResultJsonFileUtils.updateScores(problemInstanceInfoList, jsonResultFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 输出到excel
        ExcelFileGenerator.generateExcelFile(problemInstanceInfoList,excelGemeratorFilePath);


    }

}
