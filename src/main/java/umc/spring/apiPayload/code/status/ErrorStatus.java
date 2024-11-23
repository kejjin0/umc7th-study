package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다,"),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403","금지된 요청입니다."),

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "CATEGORY4001", "음식 카테고리에서 찾을 수 없습니다."),

    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "지역을 찾을 수 없습니다."),

    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "음식점을 찾을 수 없습니다."),

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "미션을 찾을 수 없습니다."),

    MEMBER_MISSION_EXIST(HttpStatus.CONFLICT, "MEMBER_MISSION4002", "이미 도전 중인 미션입니다."),
    MEMBER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_MISSION4003", "도전 중이지 않은 미션입니다."),

    OUT_OF_PAGE_INDEX(HttpStatus.BAD_REQUEST, "PAGE4001", "잘못된 page 번호입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
