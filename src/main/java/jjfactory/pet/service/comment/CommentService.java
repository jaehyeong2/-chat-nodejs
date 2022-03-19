package jjfactory.pet.service.comment;

import jjfactory.pet.domain.comment.Comment;
import jjfactory.pet.domain.user.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    Comment getComment(Long id);
    List<Comment> getCommentList();
    void save(Comment comment, User user, Long boardId);
    void delete(Long id);
}
