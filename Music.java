/***

 * 

 * Emily Wauters

 * 21141140

 * COMP503

 * Assessment B

 * 
 **/

public class Music extends DigitalContent
{
	private String artistName;

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	public Music(String title, String publisher, String releaseDates, String artistName) {
		super(title, publisher, releaseDates);
		this.setArtistName(artistName);
	}
	
	/* Style to print out; Override to DigitalContent class to also include the artist name after the super toString */
	@Override
	public String toString()
	{
		return super.toString() + "\nArtist's name: " + this.artistName + "\n";
	}
	
	/* match method: Override the match method in DigitalContent class. if super match is true or the artist name (in lower case) 
	   contains anything for the String query ( in lower case) return true, otherwise return false */
	@Override 
	public boolean match(String query)
	{
		if (super.match(query) || artistName.toLowerCase().contains(query.toLowerCase()))
		{
			return true;
		}
		return false;
	}
}
