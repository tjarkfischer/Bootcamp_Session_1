package Ueb08;

/**
 * Enthält die Abstimmungszahlen und Kandidateninformationen aus einer Beispielwahl.
 * Es muss sichergestellt sein, dass die erhobenen Werte nicht während der
 * Laufzeit geändert werden können.
 */
public class Data {
    /**
     * Der Index in diesem Array entspricht der ID eines bestimmten Kandidaten.
     * Wenn also von "Kandidaten ID" die Rede ist, bezeichnet dies eine Zahl,
     * die ein valider Index dieses Arrays sein muss.
     */
    private static final String[] CANDIDATES = {
            "E. Herms",
            "A. Gebäudchen",
            "G. Kayak",
            "E. Cola",
            "M. Riema",
    };

    /**
     * Wahlen werden in drei Dimensionen gespeichert.
     * Die erste Dimension unterscheidet zwischen mehreren Wahlen.
     * Die zweite Dimension beschreibt einen Wähler.
     * Jeder Wähler kann mehrfach eine Stimme abgegeben haben, der erstgenannte
     * Kandidat ist hierbei die Erstwahl.
     * <p>
     * Der Zugriff auf votes[0][0][0] liefert den bevorzugten Kandidaten
     * des ersten Wählers in der ersten Wahl. votes[0][0][1] würde die Zweitwahl
     * des ersten Wählers in der ersten Wahl liefern.
     * <p>
     * Die vorhandenen Daten werden im Folgenden aufgeführt:
     */
    private static final int[][][] VOTES = {
            {
                    // 0) Niemand hat gewählt.
            },
            {
                    // 1) Jeder hat nur eine Stimme für Kandidat 0 abgegeben.
                    {0}, {0}, {0}
            },
            {
                    // 2) Jeder hat nur eine Stimme für Kandidat 3 abgegeben.
                    {3}, {3}, {3}
            },
            {
                    // 3) Nahezu jeder hat seine erste Stimme für Kandidat 0
                    //    und die zweite für Kandidat 1 abgegeben.
                    {0, 1}, {0, 1}, {0, 1}, {1}, {0}
            },
            {
                    // 4) Die Stimmen sind initial aufgeteilt zwischen Kandidat 3 und 4,
                    //    aber die Personen, die für Kandidat 2 gestimmt haben, bevorzugen 4.
                    //
                    //    Dies ist die erste Wahl in der unterschiedliche
                    //    Auswertungsvarianten zu unterschiedlichen Ergebnissen führen.
                    {3}, {3}, {3}, {3}, {3}, {4}, {4}, {4}, {4}, {4}, {2, 4}, {2, 4}
            },
            {
                    // 5) Jeder möchte Kandidat 1 in der Zweitwahl, die Erstwahlen
                    //    sind aber über alle Kandidaten verteilt.
                    {0, 1}, {2, 1}, {3, 1}, {4, 1}, {2, 1}, {3, 1}, {4, 1}, {3, 1}, {4, 1}, {4, 1},
            },
            {
                    // 6) Wenige Wähler bevorzugen Kandidat 0 und nur ihn.
                    //    Keiner der Wähler mit mehr Stimmabgaben hat Kandidat 0 gewählt.
                    {0}, {0}, {0}, {0}, {0}, {0}, {0},
                    {2, 4, 1, 3}, {3, 2, 1, 4}, {2, 3, 1, 4}, {1, 4, 3, 2}, {1, 2, 3, 4},
                    {4, 2, 3, 1}, {4, 1, 3, 2}, {2, 4, 1, 3}, {3, 2, 1, 4}, {2, 3, 1, 4},
                    {1, 4, 3, 2}, {1, 2, 3, 4}, {4, 2, 3, 1}, {4, 1, 3, 2}, {2, 4, 1, 3},
                    {3, 2, 1, 4}, {2, 3, 1, 4}, {1, 4, 3, 2}, {1, 2, 3, 4}, {4, 2, 3, 1},
                    {4, 1, 3, 2},
            }
    };

    /**
     * @return Die Anzahl der Kandidaten in diesem Datensatz.
     */
    public static int getNumberOfCandidates() {
        return CANDIDATES.length;
    }

    /**
     * @return Die Anzahl der Wahlen in diesem Datensatz.
     */
    public static int getNumberOfElections() {
        return VOTES.length;
    }

    /**
     * @param candidateId Die betreffende KandidatenID.
     * @return True, wenn getCandidateNameById() mit dieser ID arbeiten kann.
     */
    public static boolean isValidCandidateId(int candidateId) {
        return candidateId >= 0 && candidateId < getNumberOfCandidates();
    }

    /**
     * @param electionId Die betreffende ID.
     * @return True, wenn getVotes() mit dieser ID arbeiten kann.
     */
    public static boolean isValidElectionId(int electionId) {
        return electionId >= 0 && electionId < getNumberOfElections();
    }

    /**
     * Liefert den Namen des zu der ID gehörigen Kandidaten. Wenn der
     * korrespondierende Kandidat nicht existiert, wird null zurückgegeben.
     *
     * @param candidateId Die ID des Kandidaten.
     * @return Der Name des Kandidaten oder null, wenn der Kandidat nicht existiert.
     */
    public static String getCandidateNameById(int candidateId) {
        return isValidCandidateId(candidateId) ? CANDIDATES[candidateId] : null;
    }

    /**
     * Liefert alle Wählerstimmen, die zu einer Wahl mit der gegebenen ID gehören.
     * Wenn zu der ID keine Wahl existiert, wird ein leeres Array zurückgegeben.
     * Das resultierende Array muss eine <b>tiefe Kopie</b> der Stimmen sein,
     * so dass eine Änderung der Werte außerhalb keinen Einfluss auf die Werte
     * dieses Datensatzes hat.
     *
     * @param electionId Die ID der Wahl.
     * @return Eine Kopie aller Stimmen der Wahl oder null, wenn die
     * zugehörige Wahl nicht existiert.
     */
    public static int[][] getVotes(int electionId) {
        if (!isValidElectionId(electionId)) {
            return null;
        }
        int[][] vote = VOTES[electionId];
        int[][] selectedVote = new int[vote.length][];

        for (int i = 0; i < vote.length; i++) {
            selectedVote[i] = vote[i].clone();
        }
        return selectedVote;
    }
}
