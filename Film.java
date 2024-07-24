/***

 * 

 * Emily Wauters

 * 21141140

 * COMP503

 * Assessment B

 * 
 **/

public class Film extends DigitalContent 
{
	private String castMembers;

	public String getCastMembers() {
		return castMembers;
	}

	public void setCastMembers(String castMembers) {
		this.castMembers = castMembers;
	}

	public Film(String title, String publisher, String releaseDates, String castMembers) 
	{
		super(title, publisher, releaseDates);
		this.castMembers = castMembers;
	}
	
	/* Style to print out; Override to DigitalContent class to also include the cast members after the super toString */
	@Override
	public String toString()
	{
		return super.toString() + "\nCast members: " + this.castMembers + "\n";
	}
	
	/* match method: Override the match method in DigitalContent class. if super match is true or the cast members (in lower case) 
	   contains anything for the String query ( in lower case) return true, otherwise return false */
	@Override 
	public boolean match(String query)
	{
		if (super.match(query) || castMembers.toLowerCase().contains(query.toLowerCase()))
		{
			return true;
		}
		return false;
	}
}
