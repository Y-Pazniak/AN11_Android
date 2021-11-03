public class Util { //создал отдельный класс, чтобы формировать строку для письма
    public static String createMessage(final Patient patient, final boolean covidTest, final int antibodiesCount) {
        String aboutTest = covidTest ? ", unfortunately test is POSITIVE. Stay at home at 7 days. " : ", fortunately, test is NEGATIVE. Enjoy your regular life. ";
        String aboutAntibodies = (antibodiesCount > 0) ? "Your antibodies count is: " + antibodiesCount : "You have no antibodies.";
        return "Dear " + //я сначала хотел сделать через StringBuilder, но Idea посоветовала просто стринг вернуть - мне кажется, она права, так лучше выглядит
                patient.getPatientName() +
                aboutTest +
                aboutAntibodies;
    }
}
