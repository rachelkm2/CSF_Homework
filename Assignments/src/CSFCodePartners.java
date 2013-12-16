import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rachelmann on 12/14/13.
 */
public class CSFCodePartners {

    public static void main(String[] args){

        CSFStudents myStudentArray = new CSFStudents();
        ArrayList<String> csfStudents = myStudentArray.createStudentArrayList();

        makeMatches(csfStudents);
    }

    public static void makeMatches(ArrayList<String> csfStudents) {

        Random randomGenerator = new Random();
        String partnerA = new String();
        String partnerB = new String();
        String partnerC = new String();
        String matchUp = new String();

        while(csfStudents.size() > 0){
            int size = csfStudents.size();
            int indexA = randomGenerator.nextInt(csfStudents.size());
            partnerA = csfStudents.get(indexA);
            csfStudents.remove(indexA);

            int indexB = randomGenerator.nextInt(csfStudents.size());
            partnerB = csfStudents.get(indexB);
            csfStudents.remove(indexB);

            if (size != 3){
                matchUp = (partnerA + " and " + partnerB);
            } else {
                int indexC = randomGenerator.nextInt(csfStudents.size());
                partnerC = csfStudents.get(indexC);
                csfStudents.remove(indexC);

                matchUp = (partnerA + " and " + partnerB + " and " + partnerC);
            }
            System.out.println(matchUp);
        }
    }

}
