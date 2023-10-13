package com.example.productapi.error;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class IdsNotFoundError {
  private final String message;
    private final List<Long> ids;
}
