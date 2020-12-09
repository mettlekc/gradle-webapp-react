package com.cheol.sample.domain;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String userId;
    private String code;

}


