package m2dl.mobe.android.project.challengeandroid.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rottanaly on 3/17/17.
 */

public class Score {

    private List<Integer> points = new ArrayList<>();

    public Score() {

    }

    public void sortList(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    public void addPoint(int point) {
        points.add(point);
    }

    public List<Integer> getList() {
        return points;
    }
}
