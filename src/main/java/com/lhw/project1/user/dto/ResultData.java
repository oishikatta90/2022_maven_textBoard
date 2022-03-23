package com.lhw.project1.user.dto;

import com.lhw.project1.user.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ResultData {
    private String resultCode;
    private String msg;
    private Map<String, Object> body;

    public ResultData(String resultCode, String msg, Object... args) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.body = Util.mapOf(args);
    }


    public boolean isSuccess() {
        return resultCode.startsWith("S-");
    }

    public boolean isFail() {
        return !isSuccess();
    }
}
