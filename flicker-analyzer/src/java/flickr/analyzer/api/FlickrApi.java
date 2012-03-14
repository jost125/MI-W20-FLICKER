package flickr.analyzer.api;

import flickr.analyzer.entity.Photo;
import java.util.List;
import org.w3c.dom.NodeList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FlickrApi {

	ApiClient apiClient;

	public FlickrApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public List<Photo> getPublicPhotos(String username) {
		String userIdXml = apiClient.getUserId(username);
		String userId = extractUserIdFromXml(userIdXml);
		String photosXml = apiClient.getPublicPhotos(userId);

		NodeList nodeList = extractPhotosFromXml(photosXml);

		List<Photo> photos = mapNodeListOnPhotos(nodeList);

		return photos;
	}

	private String extractUserIdFromXml(String userIdXml) {
		throw new NotImplementedException();
	}

	private NodeList extractPhotosFromXml(String photosXml) {
		throw new NotImplementedException();
	}

	private List<Photo> mapNodeListOnPhotos(NodeList nodeList) {
		throw new NotImplementedException();
	}
}
