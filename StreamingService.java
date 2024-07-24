import java.util.ArrayList;
import java.util.Collections;

/***

 * 

 * Emily Wauters

 * 21141140

 * COMP503

 * Assessment B

 * 
 **/

public class StreamingService 
{
	private ArrayList<DigitalContent> content;
	
	public StreamingService()
	{
		content = new ArrayList<>();
	}
	
	/* add method: Takes digitaloContent as input, if digitalContent is not null then add the input digitalContent to the content */
	public void add(DigitalContent digitalContent)
	{
		if (digitalContent != null)
		{
			this.content.add(digitalContent);
		}
	}
	
	/* match method: Create a new array list in Digital Content,
	   for each piece of content in content, if it matches a query that was input, 
	   add that piece of content to the newly created array list */
	public ArrayList<DigitalContent> match(String query)
	{
		ArrayList<DigitalContent> matchedDigitalContent = new ArrayList<>();
		
		for (DigitalContent aContent : content)
		{
			if (aContent.match(query))
			{
				matchedDigitalContent.add(aContent);
			}
		}
		
		return matchedDigitalContent;
	}
	
	/* toString method: Style to print out; sort the content by alphabetical A-Z, 
	   then for each piece of content in the content add it to the out String with a new line */
	@Override
	public String toString()
	{
		Collections.sort(content);
		
		String out = "";
		
		for (DigitalContent aContent : content)
		{
			out += aContent + "\n";
		}
		
		return out;
	}
}
