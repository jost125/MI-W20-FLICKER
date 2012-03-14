/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flickr.analyzer.api;

/**
 *
 * @author Jan Machala <jan.machala@email.cz>
 */
public interface ApiClient {
	public String getPublicPhotos(String userId);
	public String getUserId(String username);
	public String getCommentsList(String photoId);
}
