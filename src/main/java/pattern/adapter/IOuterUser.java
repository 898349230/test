package pattern.adapter;

import java.util.Map;

public interface IOuterUser {
    public Map<String, String> getUserBaseInfo();

    public Map<String, String> getUserJobInfo();

    public Map<String, String> getUserHomeInfo();
}
