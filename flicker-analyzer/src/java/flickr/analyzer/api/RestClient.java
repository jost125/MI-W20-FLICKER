package flickr.analyzer.api;

import org.springframework.web.client.RestTemplate;

public class RestClient implements ApiClient {

	private String apiKey;
	private RestTemplate restTemplate;

	public RestClient(RestTemplate restTemplate, String apiKey) {
		this.apiKey = apiKey;
		this.restTemplate = restTemplate;
	}

	public String getPublicPhotos(String userId) {

		String method = "flickr.people.getPublicPhotos";
		String parametrs = "user_id=" + userId;

		return query(method, parametrs);
	}

	public String getUserId(String username) {
		String method = "flickr.people.findByUsername";
		String parameters = "username=" + username;

		return query(method, parameters);
	}

	public String getCommentsList(String photoId) {
		String method = "flickr.photos.comments.getList";
		String parameters = "photo_id=" + photoId;

		return query(method, parameters);
	}

	private String query(String method, String parameters) {
		return restTemplate.getForObject("http://api.flickr.com/services/rest/?method=" + method + "&api_key=" + apiKey + "&" + parameters + "&format=rest", String.class);
	}
}
