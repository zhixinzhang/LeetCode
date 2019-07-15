package company.uber;

/**
 * Created by zhang on 2018/9/18.
 */
public interface Limit {
    public void setLimit(int qps);
    public boolean canSendRequest();
}

