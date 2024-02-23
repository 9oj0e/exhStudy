package shop.mtcoding.blog._core.util;

import lombok.Data;

@Data
public class ApiUtil<T> {
    private Integer status; // 200, 400, 404, 405
    private String msg; // 성공, 실패시 -> 정확한 메시지. 실패했을 때 유의미해짐
    private T body; // 내가 뉴 할 때 타입을 알고 있는데 굳이 Object를 쓸 필요가 없다. 그래서 그냥 제네릭 쓰면 됨

    public ApiUtil(T body) {
        this.status=200;
        this.msg="성공";
        this.body = body;
    }

    public ApiUtil(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
        this.body=null;
    }
}
