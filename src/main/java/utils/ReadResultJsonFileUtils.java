package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ProblemInstanceInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadResultJsonFileUtils {

    public List<ProblemInstanceInfo> updateScores(List<ProblemInstanceInfo> problemInstanceInfoList, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AlgoResultsWrapper wrapper = mapper.readValue(new File(filePath), AlgoResultsWrapper.class);

        for (AlgoResult algoResult : wrapper.results) {
            String algorithmName = algoResult.algorithmName;
            double totalScore = algoResult.totalScore;
            Map<String, Map<String, Double>> scorePerInstance = algoResult.scorePerInstance;

            for (Map.Entry<String, Map<String, Double>> domainEntry : scorePerInstance.entrySet()) {
                String problemDomain = domainEntry.getKey();
                Map<String, Double> instances = domainEntry.getValue();

                for (Map.Entry<String, Double> instanceEntry : instances.entrySet()) {
                    String instanceRunKey = instanceEntry.getKey();
                    double instanceScore = instanceEntry.getValue();

                    for (ProblemInstanceInfo info : problemInstanceInfoList) {
//                        System.out.println("problemDomain:"+problemDomain+" instanceRunKey:"+instanceRunKey+" algorithmName:"+algorithmName);
//                        System.out.println("infoProblemDomain:"+info.getProblemDomain()+" instanceRunKey"+info.getInstance()+" infoHeuristic:"+info.getHeuristic());

                        if (algorithmName.equals(info.getHeuristic()) &&
                                problemDomain.equals(info.getProblemDomain())&& instanceRunKey.equals(info.getInstance())){
                            info.setInstanceScore(instanceScore);
                            info.setTotalScore(totalScore);
                        }
                    }
                }
            }
        }
        return problemInstanceInfoList;
    }

    private static class AlgoResultsWrapper {
        public List<AlgoResult> results;
    }

    private static class AlgoResult {
        public Map<String, Map<String, Double>> scorePerInstance;
        public String algorithmName;
        public double totalScore;
        public Map<String, Double> scorePerProblem;
    }
}