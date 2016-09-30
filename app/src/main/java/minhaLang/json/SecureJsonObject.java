package minhaLang.json;

import org.json.JSONObject;

import java.math.BigDecimal;

public class SecureJsonObject {

    public static final SecureJsonObject NULL = new SecureJsonObject(null){

    };

    private final JSONObject job;

    public SecureJsonObject(JSONObject job) {
        this.job = job;
    }

    public String getString(String id) {
        try {
            return job.getString(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "(Não Informado)";
        }
    }

    public Double getDouble(String id) {
        try {
            return job.getDouble(id);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public SecureJsonObject getJob(String id) {
        try {
            return new SecureJsonObject(job.getJSONObject(id));
        } catch (Exception e) {
            e.printStackTrace();
            return SecureJsonObject.NULL;
        }
    }

    public BigDecimal getBigDecimal(String id) {
        return new BigDecimal(getDouble(id)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
