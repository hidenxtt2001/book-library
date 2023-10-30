package com.nxhung.common.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseDto<T> {
    @JsonIgnore
    private HttpStatus status;
    @Nullable
    private T data;
    @Builder.Default
    private Boolean success = true;

    @JsonProperty(value = "status", access = JsonProperty.Access.READ_ONLY)
    public Integer getStatus() {
        return status.value();
    }

    public ResponseEntity<BaseResponseDto<T>> toResponseEntity() {
        return ResponseEntity.status(status).body(this);
    }
}
