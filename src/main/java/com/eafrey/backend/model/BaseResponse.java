package com.eafrey.backend.model;

import com.eafrey.backend.enums.ResponseCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse<T> {
	private String code;
	private String message;
	private T data;

	public BaseResponse(ResponseCodeEnum responseCodeEnum) {
		this.setCode(responseCodeEnum.getCode());
		this.setMessage(responseCodeEnum.getMessage());
	}

	public BaseResponse(ResponseCodeEnum responseCodeEnum, T data) {
		this.setCode(responseCodeEnum.getCode());
		this.setMessage(responseCodeEnum.getMessage());
		this.setData(data);
	}
}
