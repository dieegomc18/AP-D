import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;

public class ServerClient {
    public void sendRequestToServer(String endpoint, String jsonPayload) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost postRequest = new HttpPost("https://api.server.com/" + endpoint);
            postRequest.setEntity(new StringEntity(jsonPayload));
            postRequest.setHeader("Content-Type", "application/json");

            httpClient.execute(postRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
