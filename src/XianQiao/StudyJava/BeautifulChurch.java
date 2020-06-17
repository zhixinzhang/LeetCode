package XianQiao.StudyJava;

/**
 * @Author: Xianqiao
 * @Date: 6/16/20 22:26
 */
public class BeautifulChurch {

    /** n churches, how many names are repeated; find the church that has the biggest capacity
     * list churches in order of capacity */

    public void emptyMethod () {
        Church churchInDavis = new Church();
        Church churchInSeattle = new Church();
        Church a = new Church("Seattle", 150);
        Church churchInSacramento = new Church("Sac", 200);
        churchInSeattle.buildChurch("Seattle", 200);
        churchInDavis.buildChurch("Davis", 100);
    }
}
