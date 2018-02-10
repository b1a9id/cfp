package jjug.validator;

import jjug.submission.ActivityForm;
import jjug.submission.SpeakerForm;
import jjug.submission.SubmissionForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Component
public class SubmissionFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
 		return SubmissionForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SubmissionForm form = SubmissionForm.class.cast(target);
		validateSpeaker(form.getSpeakerForms(), errors);
	}

	void validateSpeaker(Deque<SpeakerForm> speakerForms, Errors errors) {
		for (int i = 0; i < speakerForms.size(); i++) {
			validateActivity(new ArrayList<>(speakerForms).get(i).getActivityList(), errors, i);
		}
	}

	void validateActivity(List<ActivityForm> activityList, Errors errors, int index) {
		String activityTypeMsg = "speakerForms[%s].activityList[%s].activityType";
		String urlMsg = "speakerForms[%s].activityList[%s].url";

		if (activityList.isEmpty()) {
			errors.rejectValue(format(activityTypeMsg, index, 0), "NotEmpty", new Object[]{format(activityTypeMsg, index, 0)}, null);
			errors.rejectValue(format(urlMsg, index, 0), "NotEmpty", new Object[]{format(urlMsg, index, 0)}, null);
		}

		List<ActivityForm> activityForms = new ArrayList<>(activityList).stream()
				.filter(activityForm -> Objects.nonNull(activityForm.getActivityType()) || StringUtils.hasLength(activityForm.getUrl()))
				.collect(Collectors.toList());
		for (int i = 0; i < activityForms.size(); i++) {
			if (Objects.isNull(activityForms.get(i).getActivityType())) {
				errors.rejectValue(format(activityTypeMsg, index, i), "NotEmpty", new Object[]{format(activityTypeMsg, index, i)}, null);
			}
			if (!StringUtils.hasLength(activityForms.get(i).getUrl())) {
				errors.rejectValue(format(urlMsg, index, i), "NotEmpty", new Object[]{format(urlMsg, index, i)}, null);
			}
		}
	}
}
