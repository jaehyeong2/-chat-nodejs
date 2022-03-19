package jjfactory.pet.service.comment;

import jjfactory.pet.domain.comment.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    Comment getComment(Long id);
    List<Comment> getCommentList();
    void save(Comment comment);
    void delete(Long id);
}
