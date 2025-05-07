package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ProblemInstanceInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonRecordsListGenerator {

    public static void generateJsonRecordsList(List<ProblemInstanceInfo> problemInstanceInfoList,String outputPath){

        try {
            List<ProblemInstanceInfo> filterList = new ArrayList<>();
            filterList=problemInstanceInfoList;
            filterList = filterList.stream().filter(item -> item.getHeuristic().equals("HAEA")).toList();
            filterList = filterList.stream().filter(item -> item.getProblemDomain().equals("SAT")).toList();
//            filterList = filterList.stream().filter(item -> item.getInstance().equals("")).toList();
            if(filterList.isEmpty()){
                filterList = problemInstanceInfoList;
            }
            File file = new File(outputPath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            try (FileWriter writer = new FileWriter(file)) {
                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(filterList);
                writer.write(json);
                System.out.println("文件已成功写入。");
            }
        } catch (IOException e) {
            System.err.println("发生错误：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
