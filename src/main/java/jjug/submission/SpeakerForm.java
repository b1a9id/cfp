package jjug.submission;

import lombok.Data;
import org.hibernate.validator.constraints.*;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class SpeakerForm implements Serializable {
	@NotEmpty
	@Size(max = 255)
	private String name;
	@NotEmpty
	@Size(max = 255)
	private String github;
	@NotEmpty
	@Size(max = 255)
	private String companyOrCommunity;
	@NotEmpty
	@Size(max = 5120)
	private String bio;
	@NotEmpty
	@Size(max = 5120)
	private String activities;
	@NotEmpty
	@Size(max = 255)
	@URL
	private String profileUrl;
	@NotEmpty
	@Email
	@Size(max = 255)
	private String email;
	private boolean transportationAllowance = false;
	@Size(max = 255)
	private String city;
	@Size(max = 5120)
	private String note;
}
