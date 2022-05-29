//import net.bramp.ffmpeg.FFmpeg;
//import net.bramp.ffmpeg.FFmpegExecutor;
//import net.bramp.ffmpeg.FFprobe;
//import net.bramp.ffmpeg.builder.FFmpegBuilder;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.IOException;
//
//public class DataCreator {
//
//    static Logger log;
//    String dir;
//    FFmpeg ffmpeg;
//    FFprobe ffprobe;
//
//    DataCreator() {
//        dir = System.getProperty("user.dir") + "/videos/";
//        log = LogManager.getLogger(DataCreator.class);
//        ffmpeg = null;
//        ffprobe = null;
//    }
//
//    public void createVideo(Video inputObj, String outputName) {
//        String inputName = inputObj.getFullName();
//        try {
//            log.debug("Initialising FFMpegClient");
//            ffmpeg = new FFmpeg("C:\\ffmpeg\\bin\\ffmpeg.exe");
//            ffprobe = new FFprobe("C:\\ffmpeg\\bin\\ffprobe.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        log.debug("Creating the transcoding");
//        FFmpegBuilder builder = new FFmpegBuilder()
//                .setInput(dir + inputName)
//                .addOutput(dir + outputName)
//                .done();
//
//        log.debug("Creating the executor");
//        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
//
//        log.debug("Starting the transcoding");
//        executor.createJob(builder).run();
//        log.debug("Transcoding finished for video " + outputName);
//    }
//
//}
