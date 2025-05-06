package utils;

import model.ProblemInstanceInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCollector {


    public static List<ProblemInstanceInfo> extractData(String filePath) {
        List<ProblemInstanceInfo> problemInstanceInfoList = new ArrayList<>();
        // 修改正则：提取HYPER HEURISTIC后面的全部内容直到数字部分
        Pattern hyperHeuristicWithResultPattern = Pattern.compile(
                "HYPER HEURISTIC (.+?)\\s+([-+]?\\d+\\.?\\d*([eE][-+]?\\d+)?)\\s+([-+]?\\d+\\.?\\d+)\\s+([-+]?\\d+\\.?\\d+)\\s+(\\d+)"
        );
        Pattern runPattern = Pattern.compile("RUN (\\d+)/(\\d+)");
        Pattern hyperHeuristicPattern = Pattern.compile("HYPER HEURISTIC\\s+(.+)");
        Pattern finalResultPattern = Pattern.compile("^\\s*([-+]?\\d+\\.?\\d*([eE][-+]?\\d+)?)\\s+([-+]?\\d+\\.?\\d+)\\s+([-+]?\\d+\\.?\\d+)\\s+(\\d+)$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String problemDomain = null;
            String instance = null;
            String run = null;
            String heuristic = null;
            Double bestValue = null;
            Double timeout = null;
            Double timeMillis = null;
            Double heuristicCallTimes = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("PROBLEM DOMAIN")) {
                    problemDomain = line.substring("PROBLEM DOMAIN".length()).trim();
                } else if (line.startsWith("INSTANCE")) {
                    instance = line.substring("INSTANCE".length()).trim();
                } else if (line.startsWith("RUN")) {
                    Matcher runMatcher = runPattern.matcher(line);
                    if (runMatcher.find()) {
                        run = runMatcher.group(1) + "/" + runMatcher.group(2);
                    }
                } else if (line.contains("HYPER HEURISTIC")) {
                    Matcher hhMatcher = hyperHeuristicWithResultPattern.matcher(line);
                    if (hhMatcher.find()) {
                        heuristic = hhMatcher.group(1).trim(); // 提取完整名称（如 HAEA: Hybrid Adaptive Evolutionary Algorithm）
                        bestValue = Double.parseDouble(hhMatcher.group(2));
                        timeout = Double.parseDouble(hhMatcher.group(4));
                        timeMillis = Double.parseDouble(hhMatcher.group(5));
                        heuristicCallTimes = Double.parseDouble(hhMatcher.group(6));
                    } else {
                        // 如果未匹配到数值，则单独提取算法名称
                        Matcher hhNameMatcher = hyperHeuristicPattern.matcher(line);
                        if (hhNameMatcher.find()) {
                            heuristic = hhNameMatcher.group(1).trim();
                            // 继续读取后续行提取数值
                            while ((line = br.readLine()) != null) {
                                line = line.trim();
                                Matcher resultMatcher = finalResultPattern.matcher(line);
                                if (resultMatcher.find()) {
                                    bestValue = Double.parseDouble(resultMatcher.group(1));
                                    timeout = Double.parseDouble(resultMatcher.group(3));
                                    timeMillis = Double.parseDouble(resultMatcher.group(4));
                                    heuristicCallTimes = Double.parseDouble(resultMatcher.group(5));
                                    break;
                                }
                            }
                        }
                    }
                }

                if (problemDomain != null && instance != null && run != null && heuristic != null
                        && bestValue != null && timeout != null && timeMillis != null && heuristicCallTimes != null) {

                    problemInstanceInfoList.add(new ProblemInstanceInfo(
                            HeuristicNameTranslator.translate(heuristic),
                            problemDomain,
                            instance,
                            run,
                            bestValue,
                            timeout,
                            timeMillis,
                            heuristicCallTimes
                    ));

                    run = null;
                    heuristic = null;
                    bestValue = null;
                    timeout = null;
                    timeMillis = null;
                    heuristicCallTimes = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return problemInstanceInfoList;
    }
}