package Lab3HW;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        University upb = new University("UPB", "Romania");

        Author author1 = new Author("Alice");
        upb.addAuthor(author1);
        Author author2 = new Author("Bob");
        upb.addAuthor(author2);

        Calendar date = Calendar.getInstance();
        date.set(2023, Calendar.JANUARY, 1);

        // Journals for author1
        Publication journal1 = new Journal("Journal1", date, 2, "Nature", 5.0);
        Publication journal2 = new Journal("Journal2", date, 3, "Science", 4.0);
        author1.addPublication(journal1);
        author1.addPublication(journal2);

        // Conference Proceedings for author1
        Publication conf1 = new ConferenceProceeding("Conf1", date, 2, "Volume1", true);
        Publication conf2 = new ConferenceProceeding("Conf2", date, 3, "Volume2", false);
        author1.addPublication(conf1);
        author1.addPublication(conf2);

        // Journals for author2
        Publication journal3 = new Journal("Journal3", date, 2, "IEEE", 3.0);
        Publication journal4 = new Journal("Journal4", date, 3, "ACM", 2.5);
        author2.addPublication(journal3);
        author2.addPublication(journal4);

        // Conference Proceedings for author2
        Publication conf3 = new ConferenceProceeding("Conf3", date, 2, "Volume3", true);
        Publication conf4 = new ConferenceProceeding("Conf4", date, 3, "Volume4", false);
        author2.addPublication(conf3);
        author2.addPublication(conf4);

        double universityScore = upb.computeScore();
        System.out.println("Computed University Score: " + universityScore);

        double expectedScore =
                (5.0 * 0.5 / 2 + 4.0 * 0.5 / 3 + 0.25 / 2 + 0.2 / 3) + // Author1's publications
                        (3.0 * 0.5 / 2 + 2.5 * 0.5 / 3 + 0.25 / 2 + 0.2 / 3);  // Author2's publications
        System.out.println("Expected University Score: " + expectedScore);

        System.out.println("Scores match: " + (universityScore == expectedScore));
    }
}
