package de.topobyte.gradle;

import org.apache.log4j.Logger;
import org.gradle.api.internal.ConventionTask;

public abstract class AbstractDepInfoTask extends ConventionTask
{

	protected final Logger logger = Logger.getLogger(getClass());

	protected DepInfoPluginExtension configuration;

	public DepInfoPluginExtension getConfiguration()
	{
		return configuration;
	}

	public void setConfiguration(DepInfoPluginExtension configuration)
	{
		this.configuration = configuration;
	}

}