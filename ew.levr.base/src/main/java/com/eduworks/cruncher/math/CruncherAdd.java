package com.eduworks.cruncher.math;

import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.eduworks.resolver.Context;
import com.eduworks.resolver.Cruncher;

/**
 * Adds any number of numbers or strings. Will default to returning a number if all parameters are numbers, will return string if not.
 *
 * @class add
 * @module ew.levr.base
 * @author fritz.ray@eduworks.com
 */
/**
 * @method add
 * @param [any] {Number|String} Elements to add together.
 * @param [_string=false] {boolean} Forces output as a string. Useful for parameters that could end up being numbers.
 * @param [_fancyNumber=false] {boolean} Outputs number as a locale formatted string.
 */
public class CruncherAdd extends Cruncher
{
	@Override
	public Object resolve(Context c, Map<String, String[]> parameters, Map<String, InputStream> dataStreams) throws JSONException
	{
		double result = 0.0;
		boolean fancyNumber = optAsBoolean("_fancyNumber",false,c,parameters,dataStreams);
		StringBuilder resultStr = new StringBuilder();
		Iterator<String> i = this.sortedKeys();
		boolean enforceString = optAsBoolean("_string",false,c,parameters, dataStreams);
		while (i.hasNext())
		{
			String key = i.next();
			if (isSetting(key))
				continue;
			Object o = get(key,c,parameters, dataStreams);
			if (o == null)
				continue;
			if (o instanceof String && ((String) o).length() > 0 && Character.isLetter(((String) o).charAt(0)))
				enforceString = true;
			if (resultStr.length() == 0 && !enforceString)
				try
				{
					Double value = objectToDouble(o);
					result += value;
				}
				catch (NumberFormatException ex)
				{
					if (result != 0.0)
						resultStr.append(result);
					resultStr.append(objectToString(o));
				}
			else
				resultStr.append(objectToString(o));
		}
		if (resultStr.length() > 0 || enforceString)
			return resultStr.toString();
		if (fancyNumber)
			return NumberFormat.getNumberInstance(java.util.Locale.US).format(result);
		return result;
	}

	@Override
	public String getDescription()
	{
		return "Adds any number of numbers or strings. Will default to returning a number if all parameters are numbers, will return string if not.";
	}

	@Override
	public String getReturn()
	{
		return "Number|String";
	}

	@Override
	public String getAttribution()
	{
		return ATTRIB_NONE;
	}

	@Override
	public JSONObject getParameters() throws JSONException
	{
		return jo("<any>","Number|String","_string","Boolean","_fancyNumber","Boolean");
	}
}
