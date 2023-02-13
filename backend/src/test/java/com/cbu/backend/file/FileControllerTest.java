package com.cbu.backend.file;

import com.cbu.backend.file.dto.UploadFileResponse;
import com.cbu.backend.support.docs.RestDocumentTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentRequest;
import static com.cbu.backend.support.docs.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileController.class)
class FileControllerTest extends RestDocumentTest {
    @MockBean private FileService fileService;

    @Test
    @DisplayName("파일 업로드")
    void uploadFile() throws Exception {
        // given
        UploadFileResponse expected = new UploadFileResponse("plan.docx", "http://localhost:8080/api/v1/files?filename=plan.docx", "docx", 100L);
        given(fileService.upload(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/files")
                                .contentType(MediaType.MULTIPART_FORM_DATA)
                                .content(
                                        toRequestBody("파일을 Request시 넣어주세요")));

        // then
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("$.contentType").value(expected.getContentType()));

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "upload file",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("파일 다운")
    void downloadFile() throws Exception {
        // given
        Resource expected = new ByteArrayResource(new byte[1]);
        given(fileService.download(any())).willReturn(expected);

        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/files?filename=plan.docx")
                                .contentType(MediaType.MULTIPART_FORM_DATA));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "download file",
                                getDocumentRequest(),
                                getDocumentResponse()));

    }
}
