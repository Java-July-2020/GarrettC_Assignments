package com.dojoOverflow.garrett.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dojoOverflow.garrett.models.Answer;
import com.dojoOverflow.garrett.models.NewQuestion;
import com.dojoOverflow.garrett.models.Question;
import com.dojoOverflow.garrett.models.Tag;
import com.dojoOverflow.garrett.repositories.AnswerRepository;
import com.dojoOverflow.garrett.repositories.QuestionRepository;
import com.dojoOverflow.garrett.repositories.TagRepository;

@Service
public class MainService {
	
	private QuestionRepository questionRepo;
	private TagRepository tagRepo;
	private AnswerRepository answerRepo;
	
	public MainService(QuestionRepository questionRepo, AnswerRepository answerRepo, TagRepository tagRepo) {
		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
		this.answerRepo = answerRepo;
	}
	
	public List<Question> getQuestions() {
		return this.questionRepo.findAll();
	}
	
	public Question getQuestion(Long id) {
		return this.questionRepo.findById(id).orElse(null);
	}
	
	public void createQuestion(NewQuestion question) {
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tagRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tagRepo.save(tag);
			}
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		this.questionRepo.save(newQuestion);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.answerRepo.save(answer);
	}
}