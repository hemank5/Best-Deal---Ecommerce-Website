
public class Product {

	private String name;
	private String id;
	private String prodType;

	public Product(String id, String prodType, String name) {
		this.id = id;
		this.prodType = prodType;
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the prodType
	 */
	public String getProdType() {
		return prodType;
	}

	/**
	 * @param prodType
	 *            the prodType to set
	 */
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

}
