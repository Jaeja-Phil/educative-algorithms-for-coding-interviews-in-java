package greedy;

import java.util.ArrayList;

/**
 * Given # of police officers and thieves, calculate max # of thieves that can be caught
 * - input array contains either police officer (P) or a thief (T)
 * - each police officer can catch only one thief, and a police officer can't catch a thief
 *   who is more than k units away from him
 */
public class $05_HelpThePoliceOfficersCatchTheThieves {
    public static void main(String[] args) {
        int res = solution(new char[] {'P', 'T', 'T', 'P', 'T'}, 1);
        System.out.println(res); // 2
        res = solution(new char[] {'T', 'T', 'P', 'P', 'T', 'P'}, 2);
        System.out.println(res); // 3
    }

    public static int solution(char[] policyThiefArray, int catchableDistance) {
        int maxCount = 0;
        ArrayList<Integer> thieves = new ArrayList<>();
        ArrayList<Integer> polices = new ArrayList<>();
        int n = policyThiefArray.length;

        for (int i = 0; i < n; i++) {
            if (policyThiefArray[i] == 'P') {
                polices.add(i);
            } else if (policyThiefArray[i] == 'T') {
                thieves.add(i);
            }
        }

        int policesIdx = 0, thievesIdx = 0;
        while (thievesIdx < thieves.size() && policesIdx < polices.size()) {
            // thieves can be caught
            if (Math.abs(thieves.get(thievesIdx) - polices.get(policesIdx)) <= catchableDistance) {
                maxCount++;
                policesIdx++;
                thievesIdx++;
            }
            // thief cannot be caught and thief idx is less than police idx?
            else if (thieves.get(thievesIdx) < polices.get(policesIdx)) {
                // change the target to next thief
                thievesIdx++;
            } else {
                // let next police catch the thief
                policesIdx++;
            }
        }

        // return the number of thieves caught
        return maxCount;
    }
}
