package utils;

public class HeuristicNameTranslator {
    public static String translate(String heuristicName) {
        if (heuristicName.startsWith("GIHH")) {
            return "AdapHH-GIHH";
        }

        switch (heuristicName) {
            case "ACO_HH":
                return "ACO-HH";
            case "Ant-Q Hyper Heuristic":
                return "Ant-Q";
            case "AVEG_NeptuneHyperHeuristic":
                return "AVEG-Nep";
            case "Dynamic Iterated Local Search With Non Improvement Bias":
                return "BiasILS";
            case "TestNoThreads Hyper Heuristic":
                return "Clean";
//            case "TestNoThreads Hyper Heuristic": //输出日志重复
//                return "Clean-2";
            case "Dynamic Iterated Local Search":
                return "DynILS";
            case "EPH by David M.":
                return "EPH";
            case "Example Hyper Heuristic One":
                return "ExampleHyperHeuristic1";
            case "CS-PUT Genetic Hive Hyper Heuristic":
                return "GenHive";
            case "GISS1":
                return "GISS";
            case "HAEA: Hybrid Adaptive Evolutionary Algorithm":
                return "HAEA";
            case "LehrbaumHAHA": //未知
                return "HAHA";
            case "ISEA Hyper-Heuristic":
                return "ISEA";
            case "SimSATS_HH": //未知
                return "KSATS-HH";
            case "Lean-GIHH":
                return "LeanGIHH";
            case "McClymontMCHHS":
                return "MCHH-S";
            case "LaroseML":
                return "ML";
            case "Test Hyper Heuristic (iridia.ulb.ac.be)":
                return "NAHH";
            case "Pearl Hunter 0.0.6":
                return "PHUNTER";
            case "sa_ilsHyperHeuristic":
                return "SA-ILS";
            case "0": //elomaniSS
                return "SelfSearch";
            case "HsiaoCHeSCHyperheuristic":
                return "VNS-TW";
            case "ShafiXCJ":
                return "XCJ";
            default:
                return heuristicName;
        }
    }
}