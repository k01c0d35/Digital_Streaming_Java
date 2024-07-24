import java.util.ArrayList;
import java.util.Scanner;

/***

 * 

 * Emily Wauters

 * 21141140

 * COMP503

 * Assessment B

 * 
 **/

public class Client implements Play 
{
	private StreamingService streamingService;
	private DigitalContent currentlyStreamed;
	
	public Client(StreamingService streamingService)
	{
		this.streamingService = streamingService;
		this.currentlyStreamed = null;
	}
	
	public StreamingService getStreamingService()
	{
		return streamingService;
	}
	
	public DigitalContent getCurrentlyStreamed()
	{
		return currentlyStreamed;
	}
	
	/* Stream method: Takes in a query as input, tries to match it with a DigitalContent, 
	   if it does not match currently streamed is not modified*/
	public void stream(String query)
	{
		ArrayList<DigitalContent> matchedContents = streamingService.match(query);
		if (!matchedContents.isEmpty())
		{
			currentlyStreamed = matchedContents.get(0);
		}
	}
	
	/* Stop method: Sets currentlyStreamed to null, to represent that nothing is being streamed */
	public void stop()
	{
		currentlyStreamed = null;
	}
	
	public static void main(String[] args)
	{
		StreamingService streamingService = new StreamingService();
		
		streamingService.add(new Film("The Matrix", "Warner Bros", "1999", "Keanu Reeves"));
		streamingService.add(new Film("Mission Impossible", "Paramount", "1996", "Tom Cruise"));
		streamingService.add(new Film("Forrest Gump", "Paramount", "1994", "Tom Hanks"));
		streamingService.add(new Film("Attonement", "Relativity Media", "2007", "Keira Knightley"));
		streamingService.add(new Film("Alice in Wonderland", "Disney", "2010", "Mia Wasikowska"));
		streamingService.add(new Music("Mirror", "Justin Timberlake", "2013", "Justin Timberlake"));
		streamingService.add(new Music("Let It Go", "Wonderland Music Company", "2013", "Idina Menzel"));
		streamingService.add(new Music("The Chain", "Fleetwood Mac", "1977", "Fleetwood Mac"));
		streamingService.add(new Music("Beat It", "Michael Jackson", "1982", "Michael Jackson"));
		streamingService.add(new Music("Toxic", "Bloodshy and Avant", "2003", "Britney Spears"));
		
		String userInput = null;
		
		Scanner scan = new Scanner(System.in);
		
		Client client = new Client(streamingService);
		
		do
		{
			System.out.println("A. Display Digital Content Library");
			System.out.println("B. Display currently streaming DigitalContent");
			System.out.println("C. Match Digital Content to Stream");
			System.out.println("D. Stop Streaming");
			System.out.println("E. Quit Client Application");
			System.out.println("Enter your option: ");
			
			String userOption = scan.nextLine();
			
			if (userOption.equalsIgnoreCase("A"))
			{
				System.out.println("Contents of the streaming service: ");
				System.out.println(streamingService.toString());
			}
			
			if (userOption.equalsIgnoreCase("B"))
			{
				if (client.currentlyStreamed != null)
				{
					System.out.println("Currently streaming now: ");
					System.out.println(client.currentlyStreamed.toString());
				}
				
				if (client.currentlyStreamed == null)
				{
					System.out.println("Nothing is currently streaming.\n");
				}
			}
			
			if (userOption.equalsIgnoreCase("C"))
			{
				System.out.println("Enter what you would like to start streaming: ");
				userOption = scan.nextLine();
				client.stream(userOption);
				
				if (client.currentlyStreamed != null)
				{
					System.out.println("Currently streaming now: ");
					System.out.println(client.currentlyStreamed.toString());
				}
				
				if (client.currentlyStreamed == null)
				{
					System.out.println("Nothing is currently streaming.\n");
				}
			}
			
			if (userOption.equalsIgnoreCase("D"))
			{
				client.stop();
				System.out.println("Streaming has now stopped.\n");
			}
			if (userOption.equalsIgnoreCase("E"))
			{
				break;
			}
		}
		while (userInput != "E");
		
	}
}	
