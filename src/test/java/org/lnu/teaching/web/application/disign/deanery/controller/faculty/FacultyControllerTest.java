package org.lnu.teaching.web.application.disign.deanery.controller.faculty;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.disign.deanery.service.faculty.FacultyService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class FacultyControllerTest {

    @Mock
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(facultyController).build();
    }

    @Test
    public void create() throws Exception {
        // Given
        String expectedResponseBody = "{\"name\":\"Faculty of Applied Mathematics and Informatics\"," +
                "\"website\":\"ami.lnu.edu.ua\"," +
                "\"email\":\"email\"," +
                "\"phone\":\"274-01-80, 239-41-86\"," +
                "\"address\":\"Universytetska Street 1, Lviv, 79000\"," +
                "\"info\":\"Faculty of Applied Mathematics and Informatics - the best of the best!\"," +
                "\"id\":17}";

        // When
        FacultyDto facultyDto = new FacultyDto() {{
            setId(17L);
            setName("Faculty of Applied Mathematics and Informatics");
            setWebsite("ami.lnu.edu.ua");
            setEmail("email");
            setPhone("274-01-80, 239-41-86");
            setAddress("Universytetska Street 1, Lviv, 79000");
            setInfo("Faculty of Applied Mathematics and Informatics - the best of the best!");
        }};

        when(facultyService.create(any(BaseFacultyDto.class))).thenReturn(facultyDto);

        String requestBody = "{\n" +
                "    \"name\": \"Faculty of Applied Mathematics and Informatics\",\n" +
                "    \"website\": \"ami.lnu.edu.ua\",\n" +
                "    \"email\": \"ami@lnu.edu.ua\",\n" +
                "    \"phone\": \"274-01-80, 239-41-86\",\n" +
                "    \"address\": \"Universytetska Street 1, Lviv, 79000\",\n" +
                "    \"info\": \"Faculty of Applied Mathematics and Informatics - the best of the best!\"\n" +
                "}";

        ResultActions resultActions = mockMvc.perform(post("/faculties")
                .characterEncoding("UTF-8")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        // Then
        String actualResponseBody = resultActions
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        assertEquals(actualResponseBody, expectedResponseBody);

        verify(facultyService).create(any(BaseFacultyDto.class));
        verifyNoMoreInteractions(facultyService);
    }
}
