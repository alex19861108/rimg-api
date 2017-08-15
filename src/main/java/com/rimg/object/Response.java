package com.rimg.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by alex on 2017/8/15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    public ResponseCode code;
    public String msg;
    public String errMsg;
    
    public interface ResponseCode {
        Long OK = 0L;
    }
}
