package Ueb08;

import static Ueb08.ArrayUtils.buildOrderIndex;
import static Ueb08.ArrayUtils.filterValue;
import static Ueb08.Data.getNumberOfCandidates;
import static Ueb08.Data.isValidCandidateId;

/**
 * Kann für die Ermittlung der Ergebnisse von Wahlen verwendet werden.
 * <p>
 * Jede Methode, deren Name mit "order" beginnt, hat die selbe Signatur:
 * Der einzige Parameter ist ein Array von erhobenen Abstimmungen,
 * das Ergebnis ist ein 2D-Array, das mehrere Wertpaare enthält, die
 * als ersten Wert die ID des Kandidaten und als zweiten Wert seine erhaltenen
 * Stimmen beinhalten.
 */
public class Election {

    /**
     * Kombiniert die ID eines Kandidaten mit der Anzahl der erhaltenen Stimmen.
     * Dies ist nützlich, um ein Array in dem Format zu erstellen, das in
     * allen Methoden, deren Name mit "order" beginnt, benötigt wird.
     *
     * @param counts Die Anzahl der Stimmen, die jeder Kandidat bekommen hat.
     *               Der Index eines Wertes entspricht der ID des zugehörigen
     *               Kandidaten, jeder Wert entspricht also der Anzahl der Stimmen,
     *               die der zugehörige Kandidat erhalten hat.
     * @return Ein Array, das gemäß der Stimmen, die ein Kandidat erhalten hat,
     * absteigend sortiert ist; jedes Element ist ein Array mit zwei Werten.
     * Der Wert am ersten Index ist die ID des Kandidaten, der zweite
     * Wert seine erhaltenen Stimmen.
     */
    static public int[][] zipCandidatesAndCounts(int[] counts) {
        int[] sortedCandidatesById = buildOrderIndex(counts);
        int[][] zippedArr = new int[sortedCandidatesById.length][2];

        for (int i = 0; i < zippedArr.length; i++) {
            int currentCandidateId = sortedCandidatesById[i];
            zippedArr[i][0] = currentCandidateId;
            zippedArr[i][1] = counts[currentCandidateId];
        }
        return zippedArr;
    }

    /**
     * Berechnet die Ergebnisse einer Wahl mit Mehrheitswahlrecht.
     * Dieses System beachtet ausschließlich die Erststimmen und missachtet
     * alle anderen Stimmabgaben.
     * <p>
     * Wenn zwei Kandidaten die selbe Anzahl an Stimmen haben, wird der Kandidat
     * mit der kleineren ID vor den anderen sortiert (und somit die Wahl gewinnen).
     *
     * @param votes Die Abstimmungsergebnisse einer Wahl.
     * @return Siehe die Beschreibung im Kommentar der Klasse.
     */
    static public int[][] orderFirstPassThePost(int[][] votes) {
        int[] counts = new int[getNumberOfCandidates()];

        for (int[] vote : votes) {
            if (vote.length == 0) continue;
            int candidateIdOfPrimaryVote = vote[0];
            if (isValidCandidateId(candidateIdOfPrimaryVote)) {
                counts[candidateIdOfPrimaryVote]++;
            }
        }
        return zipCandidatesAndCounts(counts);
    }

    /**
     * Berechnet die Ergebnisse einer Wahl durch Rangfolgewahl
     * (Wahl mit sofortiger Stichwahl).
     * Eine Rangfolgewahl besteht aus mehreren Wahlrunden, die in sich ähnlich
     * der Mehrheitswahl sind. Wenn aber nach einer Runde kein Kandidat die
     * Mehrheit (> 50%) an Stimmen erhalten hat, werden alle Stimmen für den
     * Kandidaten, der die wenigsten Stimmen erhalten hat, entfernt und
     * dann erneut das Erreichen einer Mehrheit geprüft.
     *
     * @param votes Die Abstimmungsergebnisse einer Wahl.
     * @return Siehe die Beschreibung im Kommentar der Klasse.
     */
    static public int[][] orderInstantRunoff(int[][] votes) {
        boolean foundWinnerWithMajorityOfVotes = false;
        int[] counts = new int[getNumberOfCandidates()];

        while (!foundWinnerWithMajorityOfVotes) {
            int[][] firstPassResults = orderFirstPassThePost(votes);

            int sumOfVotes = 0;
            for (int[] votesForOneCandidate : firstPassResults) {
                sumOfVotes += votesForOneCandidate[1];
            }

            int votesForFirstCandidate = firstPassResults[0][1];
            int votesForSecondCandidate = firstPassResults[1][1];
            if (votesForFirstCandidate > sumOfVotes * 0.5 || votesForSecondCandidate == 0) {
                foundWinnerWithMajorityOfVotes = true;
                for (int[] firstPassResult : firstPassResults) {
                    int candidateId = firstPassResult[0];
                    int votesForCandidate = firstPassResult[1];
                    counts[candidateId] = votesForCandidate;
                }
            } else {
                for (int i = 0; i < votes.length; i++) {
                    votes[i] = filterValue(votes[i], getLastCandidate(firstPassResults));
                }
            }
        }
        return zipCandidatesAndCounts(counts);

    }

    /**
     * Helper method to get the last candidate of the passed election result.
     *
     * @param results Results of a election count
     * @return candidate with the least votes of the results
     */
    private static int getLastCandidate(int[][] results) {
        int lastIndex = results.length - 1;
        while (results[lastIndex][1] == 0) {
            lastIndex--;
        }
        return results[lastIndex][0];
    }
}
