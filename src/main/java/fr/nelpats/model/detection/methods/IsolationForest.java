package fr.nelpats.model.detection.methods;
import com.google.gson.Gson;
import fr.nelpats.model.detection.methods.response.IsolationForestResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class IsolationForest extends DetectionMethod{

    private static final String SERVER_URL = "http://localhost:5000/predict"; // Replace with your server URL

    private double[] inputData;

    public IsolationForest(double[] inputData) {
        super("IsolationForest");
        this.inputData = inputData;
    }


    private String getName() {
        return super.name;
    }



    public String sendRequest() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            String inputJson = "{\"data\":" + arrayToJson(this.inputData) + "}";

            HttpPost httpPost = new HttpPost(SERVER_URL);
            httpPost.setEntity(new StringEntity(inputJson, ContentType.APPLICATION_JSON));

            HttpResponse response = httpClient.execute(httpPost);

            return EntityUtils.toString(response.getEntity());
        } finally {
            httpClient.close();
        }
    }

    private String arrayToJson(double[] array) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            json.append(array[i]);
            if (i < array.length - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }
    @Override
    public boolean getDetection() throws Exception {
        Gson gson = new Gson();
        IsolationForestResponse response = gson.fromJson(sendRequest(), IsolationForestResponse.class);
        System.out.println("[" + super.name + "]" + "Detection percentage: " + response.anomaliesPercent + "%");

        if (response.anomaliesPercent >= 70.0D) {
            return true;
        }

        return false;

    }
}
