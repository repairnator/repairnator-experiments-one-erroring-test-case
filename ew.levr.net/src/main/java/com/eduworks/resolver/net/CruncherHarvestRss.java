package com.eduworks.resolver.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.eduworks.lang.EwMap;
import com.eduworks.resolver.Context;
import com.eduworks.resolver.Cruncher;
import com.eduworks.resolver.Resolvable;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class CruncherHarvestRss extends Cruncher
{

	@Override
	public Object resolve(Context c, Map<String, String[]> parameters, Map<String, InputStream> dataStreams) throws JSONException
	{
		String url = getAsString("url", c, parameters, dataStreams);
		XmlReader reader = null;
		JSONObject result = new JSONObject();
		try
		{
			reader = new XmlReader(new URL(url));
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(reader);

			System.out.println("Feed Title: " + feed.getAuthor());

			int index = 0;
			for (Iterator<SyndEntry> i = feed.getEntries().iterator(); i.hasNext();)
			{
				SyndEntry entry = i.next();
				System.out.println(entry.getTitle());
				System.out.println(entry.getLink());
				execute(result, feed, entry, index++, c, parameters, dataStreams);
			}
			feedOp(feed, c, parameters, dataStreams);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		catch (IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		catch (FeedException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (reader != null)
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		return result;
	}

	private void feedOp(SyndFeed feed, Context c, Map<String, String[]> parameters, Map<String, InputStream> dataStreams)
	{
		Resolvable operation = (Resolvable) get("feedOp");
		if (operation == null)
			return;
		final EwMap<String, String[]> newParams = new EwMap<String, String[]>(parameters);
		newParams.put("title", new String[] { feed.getTitle() });
		newParams.put("link", new String[] { feed.getLink() });
		try
		{
			resolveAChild("feedOp",c,newParams,dataStreams);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
	}

	private void execute(JSONObject results, SyndFeed feed, SyndEntry entry, int i, Context c, Map<String, String[]> parameters,
			Map<String, InputStream> dataStreams) throws JSONException
	{
		String id = entry.getLink();
		String title = entry.getTitle();
		Resolvable operation = (Resolvable) get("op");
			final EwMap<String, String[]> newParams = new EwMap<String, String[]>(parameters);
			newParams.put("documentId", new String[] { id });
			newParams.put("title", new String[] { title });
			newParams.put("link", new String[] { id });
			try
			{
				results.put(id, resolveAChild("op",c,newParams,dataStreams));
			}
			catch (JSONException e)
			{
				e.printStackTrace();
			}
	}

	@Override
	public String getDescription()
	{
		return "Retreives records from a RSS feed and performs some operation on them." + "\nop - Operation to perform. Parameters are kept:"
				+ "\n\t@documentId - Document identifier" + "\n\t@title - Title of the document" + "\n\t@link - Link to the document"
				+ "\n(Optional) feedOp - Operation to perform per feed. Perameters are kept:" + "\n\t@title - Title of the feed"
				+ "\n\t@link - Link to the feed";
	}

	@Override
	public String getReturn()
	{
		return "JSONObject";
	}

	@Override
	public String getAttribution()
	{
		return ATTRIB_UCASTER;
	}

	@Override
	public JSONObject getParameters() throws JSONException
	{
		return jo("url", "String", "op", "Resolvable", "?feedOp", "Resolvable");
	}

}
