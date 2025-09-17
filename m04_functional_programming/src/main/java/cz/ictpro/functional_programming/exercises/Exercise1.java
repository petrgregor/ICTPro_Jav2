package cz.ictpro.functional_programming.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {
    public static void main(String[] args) {
        Video video = new Video("GOT1", "got1.com", VideoType.CLIP);
        Video video1 = new Video("GOT2", "got2.com", VideoType.EPISODE);
        Video video2 = new Video("GOT3", "got3.com", VideoType.PREVIEW);
        Video video3 = new Video("GOT4", "got4.com", VideoType.PREVIEW);
        Video video4 = new Video("GOT5", "got5.com", VideoType.CLIP);
        Video video5 = new Video("GOT6", "got6.com", VideoType.EPISODE);
        Episode episode = new Episode("got1", 1, Arrays.asList(video, video1));
        Episode episode1 = new Episode("got2", 2, Arrays.asList(video2, video3));
        Episode episode2 = new Episode("got3", 1, Arrays.asList(video4, video5));
        Season season = new Season("GOTS1", 1, Arrays.asList(episode, episode1));
        Season season1 = new Season("GOTS1", 2, Arrays.asList(episode2));
        List<Season> seasons = Arrays.asList(season, season1);

        //list of episodes
        List<Episode> episodes = seasons.stream()
                .flatMap(s -> season.episodes.stream())
                .collect(Collectors.toList());
        printList(episodes);

        //list of videos
        List<Video> videos = seasons.stream()
                .flatMap(s -> season.episodes.stream())
                .flatMap(e -> e.videos.stream())
                .collect(Collectors.toList());
        printList(videos);

        //list of seasons names
        List<String> seasonNames = seasons.stream()
                .map(s -> s.seasonName)
                .collect(Collectors.toList());
        printList(seasonNames);

        //list of seasons numbers
        List<Integer> seasonNumbers = seasons.stream()
                .map(s -> s.seasonNumber)
                .collect(Collectors.toList());
        printList(seasonNumbers);

        //list of episodes names
        List<String> episodeNames = seasons.stream()
                .flatMap(s -> season.episodes.stream())
                .map(e -> e.episodeName)
                .collect(Collectors.toList());
        printList(episodeNames);

        //list of episodes numbers
        List<Integer> episodeNumbers = seasons.stream()
                .flatMap(s -> season.episodes.stream())
                .map(e -> e.episodeNumber)
                .collect(Collectors.toList());
        printList(episodeNumbers);

        //list of videos names
        List<String> videoNames = seasons.stream()
                .flatMap(s -> season.episodes.stream())
                .flatMap(e -> e.videos.stream())
                .map(v -> v.title)
                .collect(Collectors.toList());
        printList(videoNames);

        //list of videos urls
        List<String> videoUrls = seasons.stream()
                .flatMap(s -> season.episodes.stream())
                .flatMap(e -> e.videos.stream())
                .map(v -> v.url)
                .collect(Collectors.toList());
        printList(videoUrls);

        //list of even episodes
        List<Episode> evenEpisodes = seasons.stream()
                .flatMap(s -> season.episodes.stream())
                .filter(e -> e.episodeNumber % 2 == 0)
                .collect(Collectors.toList());
        printList(evenEpisodes);

        //list of even seasons
        List<Season> evenSeasons = seasons.stream()
                .filter(s -> s.seasonNumber % 2 == 0)
                .collect(Collectors.toList());
        printList(evenSeasons);

        //list of even episodes and seasons
        List<Episode> evenEpisodesFromEvenSeasons =
                seasons.stream()
                        .filter(s -> s.seasonNumber % 2 == 0)
                        .flatMap(s -> season.episodes.stream())
                        .filter(e -> e.episodeNumber % 2 == 0)
                        .collect(Collectors.toList());
        printList(evenEpisodesFromEvenSeasons);

        //list of clips videos from even episodes and odd seasons
        List<Video> clipVideoFromEvenEpisodesFromOddSeasons =
                seasons.stream()
                        .filter(s -> s.seasonNumber % 2 == 0)
                        .flatMap(s -> season.episodes.stream())
                        .filter(e -> e.episodeNumber % 2 != 0)
                        .flatMap(e -> e.videos.stream())
                        .filter(v -> v.videoType == VideoType.CLIP)
                        .collect(Collectors.toList());
        printList(clipVideoFromEvenEpisodesFromOddSeasons);

        //list of preview videos from odd episodes and even seasons
        List<Video> previewVideoFromOddEpisodesFromEvenSeasons =
                seasons.stream()
                        .filter(s -> s.seasonNumber % 2 != 0)
                        .flatMap(s -> season.episodes.stream())
                        .filter(e -> e.episodeNumber % 2 == 0)
                        .flatMap(e -> e.videos.stream())
                        .filter(v -> v.videoType == VideoType.PREVIEW)
                        .collect(Collectors.toList());
        printList(previewVideoFromOddEpisodesFromEvenSeasons);
    }

    public static <T> void printList(List<T> list) {
        list.forEach(item -> System.out.println("- " + item));
    }
}


enum VideoType {
    CLIP, PREVIEW, EPISODE
}

class Video {
    public String title;
    public String url;
    public VideoType videoType;
    public Video(String title, String url, VideoType videoType) {
        this.title = title;
        this.url = url;
        this.videoType = videoType;
    }
    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", videoType=" + videoType +
                '}';
    }
}

class Episode {
    public String episodeName;
    public int episodeNumber;
    List<Video> videos;
    public Episode(String episodeName, int episodeNumber,
                   List<Video> videos) {
        this.episodeName = episodeName;
        this.episodeNumber = episodeNumber;
        this.videos = videos;
    }
    @Override
    public String toString() {
        return "Episode{" +
                "episodeName='" + episodeName + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", videos=" + videos +
                '}';
    }
}

class Season {
    public String seasonName;
    public int seasonNumber;
    List<Episode> episodes;
    public Season(String seasonName, int seasonNumber,
                  List<Episode> episodes) {
        this.seasonName = seasonName;
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
    }
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonNumber=" + seasonNumber +
                ", episodes=" + episodes +
                '}';
    }
}