package com.centroxy.services;
import java.util.List;

import com.centroxy.entities.JobDescription;

/**
 * @author Sumita Sethy 07-July-2022 11:59:28 am
 */

public interface JobDescriptionService {

	public JobDescription saveJd(JobDescription jobDescription);

	/**
	 * @author Subhasmita Panda 07-July-2022 11:59:28 am
	 */
	public List<JobDescription> getDemands();

	public JobDescription getDemandById(String jdId);

	/**
	 * @author Diptiranjan Balabanataray 15-July-2022 13:56:30 am
	 */
	List<JobDescription> findByApprovedResource();
	/**
	 * @author Subhasmita Panda 19-July-2022 13:56:30 am
	 */
	public List<JobDescription> findByIsApprovedTrue(Boolean isApproved);

}


