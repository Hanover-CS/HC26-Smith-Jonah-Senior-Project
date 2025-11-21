package web;

import org.example.hanovercollegemarketplace.message.Message;
import org.example.hanovercollegemarketplace.message.MessageRepository;
import org.example.hanovercollegemarketplace.web.HomeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Quick tests for the HomeController.
 * Makes sure blank messages are ignored, trimmed ones save,
 * and the default message loads when the database is empty.
 */
@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @Mock
    MessageRepository repo;

    @InjectMocks
    HomeController controller;

    @Test
    void ignoreBlankMessages() {
        Message msg = new Message("   ");

        String view = controller.create(msg);

        verify(repo, never()).save(any());
        assertEquals("redirect:/", view);
    }

    @Test
    void saveTrimmedMessage() {
        Message msg = new Message("  hey guys ");

        String view = controller.create(msg);

        verify(repo).save(argThat(m -> m.getContent().equals("hey guys")));
        assertEquals("redirect:/", view);
    }

    @Test
    void addDefaultMessageWhenEmpty() {
        when(repo.count()).thenReturn(0L);

        Model model = new ConcurrentModel();
        String view = controller.home(model);

        verify(repo).save(any());
        verify(repo).findAll();
        assertEquals("index", view);
    }
}
