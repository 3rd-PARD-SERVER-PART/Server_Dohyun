package com.pard.hw5.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw5.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/* User의 장바구니, data security 를 위해 직접 User에 다가가는 것이 아닌 DTO를 통해 들어오는 정보 관리.
    Dto 는 각 method 마다 나누어 주는 것을 추천, update, read, create 등등등
 */
public class UserDto {
    @Setter
    @Getter
    public static class Create{
        private String name;
        private String email;
    }

    @Setter
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Read{
        private Long id;
        private String name;
        private String email;
        private List<UserLoanDto.Update> books;

        public Read(User user){
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
        }

//        public Read(User user, List<BookDto.Read> books){
//            this.id = user.getId();
//            this.name = user.getName();
//            this.books = books;
//        }
    }
}
