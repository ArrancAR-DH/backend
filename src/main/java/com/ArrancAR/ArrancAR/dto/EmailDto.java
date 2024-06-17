package com.ArrancAR.ArrancAR.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmailDto {

    private String toUser;
    private String fullName;
}
