import java.util.ArrayList;

public class DataAdmin {

    private static ArrayList<Video> videoList;
    private static ArrayList<String> usedNames;
    private static ArrayList<Integer> usedNamesIndex;
    private static Integer index = 0;
    private static ArrayList<Integer> prototypeResolutionList;
    private static ArrayList<String> prototypeFormatList;
    private static boolean isOver;

    DataAdmin() {
        isOver = false;
        videoList = new ArrayList<>();
        usedNames = new ArrayList<>();
        usedNamesIndex = new ArrayList<>();

        prototypeResolutionList = new ArrayList<>();
        prototypeFormatList = new ArrayList<>();
        createPrototypeResolutionList();
        createPrototypeFormatList();
    }

    private static void createPrototypeResolutionList() {
        prototypeResolutionList.add(240);
        prototypeResolutionList.add(480);
        prototypeResolutionList.add(720);
        prototypeResolutionList.add(1080);
    }

    private static void createPrototypeFormatList() {
        prototypeFormatList.add("mkv");
        prototypeFormatList.add("mp4");
        prototypeFormatList.add("avi");
    }

    public static void addVideoDataAdmin(String fullName, String name, Integer resolution, String format) {
        videoList.add(new Video(fullName, name, resolution, format));
        index++;
    }

    public static void start() {
        findBiggerResolution();
        findMissing();
        isOver = true;
    }

    private static void findBiggerResolution() {
        Integer maxRes = 0;
        boolean state = false;
        String temp1 = null;
        Integer temp2 = null;
        for (Video item : videoList) {
            if (!usedNames.contains(item.getName())) {
                for (Video item1 : videoList) {
                    if (item.getName().equals(item1.getName()) && item1.getResolution() >= maxRes) {
                        if (maxRes == 0) {
                            maxRes = item1.getResolution();
                            temp1 = item1.getName();
                            temp2 = videoList.indexOf(item1);
                            state = true;
                        } else if (item1.getResolution() > maxRes) {
                            maxRes = item1.getResolution();
                            temp1 = item1.getName();
                            temp2 = videoList.indexOf(item1);
                            state = true;
                        } else if (item1.getResolution().equals(maxRes) && item1.getFormat().equals("mkv")) {
                            maxRes = item1.getResolution();
                            temp1 = item1.getName();
                            temp2 = videoList.indexOf(item1);
                            state = true;
                        }
                    }
                }
                if (state) {
                    usedNames.add(temp1);
                    usedNamesIndex.add(temp2);
                    state = false;
                }
                maxRes = 0;
            }
        }

    }

    private static void findMissing() {
        ArrayList<String> tempFullNameList = new ArrayList<>();
        DataCreator creator = new DataCreator();
        int counter = 0;
        Integer maxRes;

        for (Video name0 : videoList) {
            tempFullNameList.add(name0.getFullName());
        }

        for (String name : usedNames) {
            maxRes = videoList.get(usedNamesIndex.get(counter)).getResolution();
            for (String format : prototypeFormatList) {
                for (Integer resolution : prototypeResolutionList) {
                    if (resolution > maxRes) {
                        continue;
                    }
                    if (!tempFullNameList.contains(name + "-" + resolution + "p." + format)) {
                        creator.createVideo(videoList.get(usedNamesIndex.get(counter)), name + "-" + resolution + "p." + format);
                    }
                }
            }
            counter++;
        }
    }

    public static boolean changeWindows() {
        return isOver;
    }

}
