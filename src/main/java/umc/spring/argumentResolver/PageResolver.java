package umc.spring.argumentResolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.validation.annotation.CheckPage;

@Component
public class PageResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasAnnotation = parameter.hasParameterAnnotation(CheckPage.class);
        boolean isIntegerType = Integer.class.isAssignableFrom(parameter.getParameterType());

        System.out.println("PageResolver - supportsParameter!!!!!!!!!! ");
        return hasAnnotation && isIntegerType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("PageResolver - resolveArgument!!!!!!!!!!!");
        String pageParam = webRequest.getParameter("page");
        Integer page = Integer.valueOf(pageParam);
        return page-1;
    }
}
