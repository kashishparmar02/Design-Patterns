package behavioral.command.command;

import behavioral.command.receiver.VideoProcessingService;

/**
 * A Concrete Command that encapsulates the request to process a video.
 * It holds a reference to the receiver and the data needed for the action.
 */
public class ProcessVideoCommand implements Command {

    private final VideoProcessingService receiver;
    private final String videoFile;

    public ProcessVideoCommand(VideoProcessingService receiver, String videoFile) {
        this.receiver = receiver;
        this.videoFile = videoFile;
    }

    @Override
    public void execute() {
        // The command delegates the actual work to the receiver object.
        receiver.processVideo(videoFile);
    }
}