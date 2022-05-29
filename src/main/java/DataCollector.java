//import java.io.File;
//
//public class DataCollector {
//
//    DataCollector() {
//        collectFiles();
//    }
//
//    private void collectFiles() {
//        String tempName;
//        Integer tempResolution;
//        String tempFormat;
//
//        File f = new File(System.getProperty("user.dir") + "/videos/");
//        String[] fileNames = f.list();
//
//        for (String fileName : fileNames) {
//            tempName = String.valueOf(fileName.split("-")[0]);
//            tempResolution = Integer.parseInt(fileName.split("-")[1].split("p.")[0]);
//            tempFormat = String.valueOf(fileName.split("[.]")[1]);
//            DataAdmin.addVideoDataAdmin(fileName, tempName, tempResolution, tempFormat);
//        }
//    }
//
//
//}
