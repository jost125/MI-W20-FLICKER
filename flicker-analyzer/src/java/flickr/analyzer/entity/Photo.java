package flickr.analyzer.entity;

public class Photo {
	private Integer id;
	private String owner;
	private String secret;
	private Integer server;
	private Integer farm;
	private String title;
	private Boolean isPublic;
	private Boolean isFriend;
	private Boolean isFamily;

	public void setFarm(Integer farm) {
		this.farm = farm;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIsFamily(Boolean isFamily) {
		this.isFamily = isFamily;
	}

	public void setIsFriend(Boolean isFriend) {
		this.isFriend = isFriend;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public void setServer(Integer server) {
		this.server = server;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getFarm() {
		return farm;
	}

	public Integer getId() {
		return id;
	}

	public Boolean getIsFamily() {
		return isFamily;
	}

	public Boolean getIsFriend() {
		return isFriend;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public String getOwner() {
		return owner;
	}

	public String getSecret() {
		return secret;
	}

	public Integer getServer() {
		return server;
	}

	public String getTitle() {
		return title;
	}
}
