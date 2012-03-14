package flickr.analyzer.api;

public interface ApiClient {
	public String getPublicPhotos(String userId);
	public String getUserId(String username);
	public String getCommentsList(String photoId);
}
