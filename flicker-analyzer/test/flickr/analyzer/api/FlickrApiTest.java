package flickr.analyzer.api;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class FlickrApiTest {

	private FlickrApi flickrApi;
	private ApiClient apiClientMock;
	private Mockery mockery;

	@Before
	public void setUp() {
		mockery = new Mockery();
		apiClientMock = mockery.mock(ApiClient.class);
		flickrApi = new FlickrApi(apiClientMock);
	}

	@Test
	public void testGetPublicPhotos() {
		mockery.checking(new Expectations() {{
			oneOf(apiClientMock).getUserId("Mariajo2010"); will(returnValue("<xml></xml>"));
			oneOf(apiClientMock).getPublicPhotos("46992844@N08"); will(returnValue("<xml></xml>"));
		}});

		flickrApi.getPublicPhotos("Mariajo2010");
	}
}
