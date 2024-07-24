/***

 * 

 * Emily Wauters

 * 21141140

 * COMP503

 * Assessment B

 * 
 **/

public abstract class DigitalContent implements Comparable<DigitalContent>
{
	private String title;
	private String publisher;
	private String releaseDates;
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getPublisher()
	{
		return publisher;
	}
	
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	
	public String getReleaseDates()
	{
		return releaseDates;
	}
	
	public void setReleaseDates(String releaseDates)
	{
		this.releaseDates = releaseDates;
	}
	
	public DigitalContent(String title, String publisher, String releaseDates)
	{
		this.title = title;
		this.publisher = publisher;
		this.releaseDates = releaseDates;
	}
	
	/* Style to print out; return the title, publisher and release date one line after the other */
	@Override
	public String toString()
	{
		return "Title: " + this.title + "\nPublisher: " + this.publisher + "\nRelease Dates: " + this.releaseDates;
	}
	
	/* match method: Takes query as input, if the title, publisher or release date (in lower case) 
	   contains anything within the String query (in lower case) return true, otherwise return false*/
	public boolean match(String query)
	{
		if (title.toLowerCase().contains(query.toLowerCase()) || publisher.toLowerCase().contains(query.toLowerCase()) || releaseDates.toLowerCase().contains(query.toLowerCase()))
		{
			return true;
		}

		return false;
	}
	
	/* compareTo method: Takes content as input, returns the content title after it's compared to the input title*/
	@Override
	public int compareTo(DigitalContent content)
	{
		return this.title.compareTo(content.title);
	}
}
