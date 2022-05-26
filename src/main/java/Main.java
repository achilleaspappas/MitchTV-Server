public class Main {
    public static void main(String []args) {
        LoadingWindow lw = new LoadingWindow();
        new DataAdmin();
        new DataCollector();
        DataAdmin.start();

        while (!DataAdmin.changeWindows()) {
            //do nothing
        }
        lw.loadingWindowTermination();
        new MainWindow();
    }
}
